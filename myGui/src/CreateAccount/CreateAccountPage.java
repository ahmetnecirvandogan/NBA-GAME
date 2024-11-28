package CreateAccount;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;

public class CreateAccountPage{

    public static void openRegistrationPage() {
        JFrame registrationFrame = new JFrame("Registration");
        JPanel registrationPanel = new JPanel();

        registrationFrame.setSize(530, 500);
        registrationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        registrationFrame.add(registrationPanel);
        registrationPanel.setLayout(null);

        JTextField registrationnameField = new JTextField();
        JLabel registrationNameLabel = new JLabel("Name:");
        registrationNameLabel.setBounds(30, 50, 150, 30);
        registrationnameField.setBounds(180, 50, 150, 30);
        registrationPanel.add(registrationnameField);
        registrationPanel.add(registrationNameLabel);
        
        JLabel errorMessageLabelname = new JLabel("");
        errorMessageLabelname.setForeground(Color.RED);
        errorMessageLabelname.setBounds(30, 80, 700, 13);
        registrationPanel.add(errorMessageLabelname);
        

        JTextField registrationSurnameField = new JTextField();
        JLabel registrationSurnameLabel = new JLabel("Surname:");
        registrationSurnameLabel.setBounds(30, 90, 150, 30);
        registrationSurnameField.setBounds(180, 90, 150, 30);
        registrationPanel.add(registrationSurnameField);
        registrationPanel.add(registrationSurnameLabel);
        
        JLabel errorMessageLabelsurname = new JLabel("");
        errorMessageLabelsurname.setForeground(Color.RED);
        errorMessageLabelsurname.setBounds(30, 120, 700, 13);
        registrationPanel.add(errorMessageLabelsurname);


        JTextField registrationAgeField = new JTextField();
        JLabel registrationAgeLabel = new JLabel("Age:");
        registrationAgeLabel.setBounds(30, 130, 150, 30);
        registrationAgeField.setBounds(180, 130, 150, 30);
        registrationPanel.add(registrationAgeField);
        registrationPanel.add(registrationAgeLabel);
        
        JLabel errorMessageLabelage = new JLabel("");
        errorMessageLabelage.setForeground(Color.RED);
        errorMessageLabelage.setBounds(30, 160, 700, 13);
        registrationPanel.add(errorMessageLabelage);
        

        JTextField registrationUserNameField = new JTextField();
        JLabel registrationUserNameLabel = new JLabel("Username:");
        registrationUserNameLabel.setBounds(30, 170, 150, 30);
        registrationUserNameField.setBounds(180, 170, 150, 30);
        registrationPanel.add(registrationUserNameField);
        registrationPanel.add(registrationUserNameLabel);
        
        JLabel errorMessageLabelUsername = new JLabel("");
        errorMessageLabelUsername.setForeground(Color.RED);
        errorMessageLabelUsername.setBounds(30, 200, 700, 13);
        registrationPanel.add(errorMessageLabelUsername);

        JTextField registrationUserMailField = new JTextField();
        JLabel registrationUserMailLabel = new JLabel("Email:");
        registrationUserMailLabel.setBounds(30, 210, 150, 30);
        registrationUserMailField.setBounds(180, 210, 150, 30);
        registrationPanel.add(registrationUserMailField);
        registrationPanel.add(registrationUserMailLabel);
        
        JLabel errorMessageLabelmail = new JLabel("");
        errorMessageLabelmail.setForeground(Color.RED);
        errorMessageLabelmail.setBounds(30, 240, 700, 13);
        registrationPanel.add(errorMessageLabelmail);
        

        JPasswordField registrationUserPASSWORDField = new JPasswordField();
        JLabel registrationUserPASSWORDLabel = new JLabel("Password:");
 
        JLabel errorMessageLabelpassword = new JLabel("");
        errorMessageLabelpassword.setForeground(Color.RED);
        errorMessageLabelpassword.setBounds(30, 280, 700, 13);
        registrationPanel.add(errorMessageLabelpassword);

        registrationUserPASSWORDLabel.setBounds(30, 250, 150, 30);
        registrationUserPASSWORDField.setBounds(180, 250, 150, 30);
        registrationPanel.add(registrationUserPASSWORDField);
        registrationPanel.add(registrationUserPASSWORDLabel);

        JLabel passwordtextlabel = new JLabel("Valid password needs: ");
        passwordtextlabel.setBounds(30, 400, 1500, 30);
        registrationPanel.add(passwordtextlabel);
        JLabel passwordtextlabel2 = new JLabel("At least eight characters, including letters, numbers, and special characters.");
        passwordtextlabel2.setBounds(30, 415, 1500, 30);
        registrationPanel.add(passwordtextlabel2);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(120, 320, 150, 40);
        registrationPanel.add(registerButton);
        
        
        

        registrationFrame.setVisible(true);
        
        

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform registration logic here
                String name = registrationnameField.getText();
                
                String surname = registrationSurnameField.getText();
                
                String age = registrationAgeField.getText();
                
                String username = registrationUserNameField.getText();
                
                String mail = registrationUserMailField.getText();
                
                String password = new String(registrationUserPASSWORDField.getPassword());

                // Retrieve other fields

                if (!isValidName(name)) {
                	errorMessageLabelname.setText("Name must have at least three letters and contain only letters.");
                    return;
                }
                if (!isValidName(surname)) {
					errorMessageLabelsurname.setText("Surname must have at least three letters and contain only letters.");
					return;
				}
                if (!isValidAge(Integer.parseInt(age))) {
                	
					errorMessageLabelage.setText("Grow and come back. This beautiful game is for people at least 12.");
					return;
				}
                if (!isValidUsername(username)) {
					errorMessageLabelUsername.setText("Username can only include letter and number characters.");
					return;
				}
           
                if (!isValidEmail(mail)) {
                	errorMessageLabelmail.setText("The email address should be in the correct format. (e.g., name@domain.com)");
					return;
				}
                if (!isValidPassword(password)) {
                    errorMessageLabelpassword.setText("Password should be at least eight characters, including letters, numbers, and special characters.");
                    return;
                }
                                
                writeUserToFile(name, surname, age, username, mail, password);
                registrationFrame.dispose();
                showSuccessMessage("You registered successfully!");

            }
        });
    }
    static void writeUserToFile(String name, String surname, String age, String username, String email, String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true))) {
            
            writer.write(name + ", " + surname + ", " + age +
                    ", " + username + ", " + email + ", " + password);
            writer.newLine();  // Add a newline for the next entry
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    

    static boolean isValidName(String name) {
    	if(name.contains(" ")) {
    		String[] nameParts = name.split("\\s+");

            for (String part : nameParts) {
                if (part.length() < 3 || !part.matches("[a-zA-ZçÇğĞıİöÖşŞüÜ]+")) {
                    return false;
                }
            }

            return true;
    	}
    	else {
    		return name.matches("[a-zA-ZçÇğĞıİöÖşŞüÜ]{3,}");
		}
    	
    }
    static boolean isValidAge(int age) {
    	return age >=12;
    	
	}
    
    static boolean isValidPassword(String password) {
        // Check if the password is at least eight characters long
        if (password.length() < 8) {
            return false;
        }

        // Check if the password contains at least one letter, one number, and one special character
        String regex = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@#$%^&+=!.,-_&/()?><]).{8,}$";
        return Pattern.matches(regex, password);
    }


	
    private static boolean isValidUsername(String username) {
        return username.matches("[a-zA-Z0-9]+");
    }
    static boolean isValidEmail(String email) {
        return email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
    }
    
    private static void showSuccessMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }
    

    
}
