package CreateAccount;

import javax.swing.*;

import myGui.NBAGAME;

import java.awt.Color;

public class ChangeAccountInfo1 {

    public static void info() {
        JFrame infoFrame = new JFrame("Change Account Info");
        JPanel infoPanel = new JPanel();

        infoFrame.setSize(530, 260);
        infoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        infoFrame.add(infoPanel);
        infoPanel.setLayout(null);

        JTextField usernameField = new JTextField();
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(30, 50, 150, 30);
        usernameField.setBounds(180, 50, 150, 30);
        infoPanel.add(usernameField);
        infoPanel.add(usernameLabel);

        JLabel errorMessageLabelUsername = new JLabel("");
        errorMessageLabelUsername.setForeground(Color.RED);
        errorMessageLabelUsername.setBounds(30, 10, 700, 13);
        infoPanel.add(errorMessageLabelUsername);

        JPasswordField passwordField = new JPasswordField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(30, 110, 150, 30);
        passwordField.setBounds(180, 110, 150, 30);
        infoPanel.add(passwordField);
        infoPanel.add(passwordLabel);

        JButton continueButton = new JButton("Continue");
        continueButton.setBounds(180, 150, 150, 40);
        infoPanel.add(continueButton);

        JLabel passwordTextLabel = new JLabel("Valid password needs: ");
        passwordTextLabel.setBounds(30, 180, 1500, 30);
        infoPanel.add(passwordTextLabel);
        JLabel passwordTextLabel2 = new JLabel("At least eight characters, including letters, numbers, and special characters.");
        passwordTextLabel2.setBounds(30, 195, 1500, 30);
        infoPanel.add(passwordTextLabel2);

        infoFrame.setVisible(true);

        continueButton.addActionListener(e -> {
            String enteredUsername = usernameField.getText();
            String enteredPassword = new String(passwordField.getPassword());
            if (NBAGAME.isValidLogin(enteredUsername,enteredPassword)) {
            	ChangeAccountInfo2.info(infoFrame, infoPanel,enteredUsername);
            	
			}
            else {
            	errorMessageLabelUsername.setText("This account doesn't exists.");
				
			}
           
        });

        
    }
}
