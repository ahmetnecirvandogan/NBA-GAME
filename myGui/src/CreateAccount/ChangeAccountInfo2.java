package CreateAccount;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class ChangeAccountInfo2 {

    public static void info(JFrame infoFrame, JPanel infoPanel, String username) {
        infoPanel.removeAll();

        JTextField ageField = new JTextField();
        JLabel ageLabel = new JLabel("Change Age:");
        ageLabel.setBounds(30, 10, 150, 30);
        ageField.setBounds(180, 10, 150, 30);
        infoPanel.add(ageField);
        infoPanel.add(ageLabel);

        JLabel errorMessageLabelAge = new JLabel("");
        errorMessageLabelAge.setForeground(Color.RED);
        errorMessageLabelAge.setBounds(30, 40, 700, 13);
        infoPanel.add(errorMessageLabelAge);

        JTextField mailField = new JTextField();
        JLabel mailLabel = new JLabel("Change Mail:");
        mailLabel.setBounds(30, 60, 150, 30);
        mailField.setBounds(180, 60, 150, 30);
        infoPanel.add(mailField);
        infoPanel.add(mailLabel);

        JLabel errorMessageLabelMail = new JLabel("");
        errorMessageLabelMail.setForeground(Color.RED);
        errorMessageLabelMail.setBounds(30, 90, 700, 13);
        infoPanel.add(errorMessageLabelMail);

        JPasswordField passwordField = new JPasswordField();
        JLabel passwordLabel = new JLabel("Change Password:");
        passwordLabel.setBounds(30, 120, 150, 30);
        passwordField.setBounds(180, 120, 150, 30);
        infoPanel.add(passwordField);
        infoPanel.add(passwordLabel);

        JButton finishButton = new JButton("Finish");
        finishButton.setBounds(180, 160, 150, 40);
        infoPanel.add(finishButton);

        JLabel passwordTextLabel = new JLabel("Valid password needs: ");
        passwordTextLabel.setBounds(30, 190, 1500, 30);
        infoPanel.add(passwordTextLabel);
        JLabel passwordTextLabel2 = new JLabel("At least eight characters, including letters, numbers, and special characters.");
        passwordTextLabel2.setBounds(30, 205, 1500, 30);
        infoPanel.add(passwordTextLabel2);

        infoFrame.setVisible(true);

        finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredAge = ageField.getText();
                String enteredMail = mailField.getText();
                String enteredPassword = new String(passwordField.getPassword());

                if (validateUserData(enteredAge, enteredMail, enteredPassword)) {
                    if (updateUserData(username, enteredAge, enteredMail, enteredPassword)) {
                        // Successfully updated user data
                        JOptionPane.showMessageDialog(null, "Your Informations updated successfully!");
                        infoFrame.dispose();
                    } else {
                        // Handle update failure
                        JOptionPane.showMessageDialog(null, "Failed to update your information.");
                    }
                }
            }
        });

        infoPanel.repaint();
    }

    private static boolean validateUserData(String enteredAge, String enteredMail, String enteredPassword) {
        try {
            // Check if age is a valid integer
            int age = Integer.parseInt(enteredAge);
            if (!CreateAccountPage.isValidAge(age)) {
                JOptionPane.showMessageDialog(null, "Invalid age. Please enter a valid age.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid age format. Please enter a valid integer for age.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Check if email is in the correct format
        if (!CreateAccountPage.isValidEmail(enteredMail)) {
            JOptionPane.showMessageDialog(null, "Invalid email format. Please enter a valid email address.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Check if password meets criteria (you can modify this based on your requirements)
        if (!CreateAccountPage.isValidPassword(enteredPassword)) {
            JOptionPane.showMessageDialog(null, "Password should be at least eight characters, including letters, numbers, and special characters.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // If all validations pass, return true
        return true;
    }


    private static boolean updateUserData(String username, String newAge, String newMail, String newPassword) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        for (int i = 0; i < lines.size(); i++) {
            String[] fields = lines.get(i).split(", ");
            if (fields.length >= 5 && fields[3].equals(username)) {
                fields[2] = newAge;
                fields[4] = newMail;
                fields[5] = newPassword;

                lines.set(i, String.join(", ", fields));
                break;
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt"))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
