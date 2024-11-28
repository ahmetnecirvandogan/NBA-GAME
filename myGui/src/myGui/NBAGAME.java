/************** Pledge of Honor ******************************************
I hereby certify that I have completed this programming project on my own without any help from anyone else. The effort in the project thus belongs completely to me. I did not search for a solution, or I did not consult any program written by others or did not copy any program from other sources. I read and followed the guidelines provided in the project description.
READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
SIGNATURE: <AHMET NEÇİRVAN DOĞAN, 0083833>
*************************************************************************/
package myGui;


import javax.swing.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import BOTS.ComputerBot;
import CreateAccount.ChangeAccountInfo1;
import CreateAccount.CreateAccountPage;

import java.io.IOException;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

public class NBAGAME {
	
	private static Clip backgroundMusic;

    public static void main(String[] args) {
    	
        JFrame frame = new JFrame("NBA SIMULATION");
        JPanel panel = new JPanel();
        
        frame.setSize(1600, 900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(panel);
        panel.setLayout(null);
        
        playBackgroundMusic() ;

        JTextField usertextField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        panel.setBackground(new Color(255, 240, 224));

        ImageIcon nbaimageIcon = new ImageIcon("nba-logo_2x.png");
        JLabel nbaimageLabel = new JLabel(nbaimageIcon);
        nbaimageLabel.setBounds(150, 100, 200, 500);
        panel.add(nbaimageLabel);

        ImageIcon playerimageIcon = new ImageIcon("Subject.png");
        JLabel playerimageLabel = new JLabel(playerimageIcon);
        playerimageLabel.setBounds(840, 100, 700, 900);
        panel.add(playerimageLabel);

        ImageIcon ballimageIcon = new ImageIcon("Subject 2.png");
        Image originalImage = ballimageIcon.getImage();
        Image resizedBallImage = originalImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon resizedBallIcon = new ImageIcon(resizedBallImage);
        JLabel imageLabelBALL = new JLabel(resizedBallIcon);
        imageLabelBALL.setBounds(710, 200, 100, 100);
        panel.add(imageLabelBALL);

        JLabel userlabel = new JLabel("Username:");
        userlabel.setBounds(576, 325, 100, 80);
        panel.add(userlabel);

        JLabel passwordJLabel = new JLabel("Password:");
        passwordJLabel.setBounds(580, 365, 100, 80);
        panel.add(passwordJLabel);

        usertextField.setBounds(660, 350, 200, 30);
        panel.add(usertextField);

        passwordField.setBounds(660, 390, 200, 30);
        panel.add(passwordField);

        JButton playButton = new JButton("PLAY");
        playButton.setBounds(710, 440, 100, 40);
        panel.add(playButton);

        JButton createAccountButton = new JButton("Create Account");
        createAccountButton.setBounds(10, 800, 150, 20);
        panel.add(createAccountButton);
        
        JButton changeAccountInfoButton = new JButton("Change Account Info");
        changeAccountInfoButton.setBounds(10, 770, 150, 20);
        panel.add(changeAccountInfoButton);
        
        // Add ActionListener to open the registration page
        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateAccountPage.openRegistrationPage();
            }});
        
        changeAccountInfoButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ChangeAccountInfo1.info();

			}});
        
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredUsername = usertextField.getText();
                String enteredPassword = new String(passwordField.getPassword());

                // Check login credentials
                if (isValidLogin(enteredUsername, enteredPassword)) {
                    System.out.println("Login successful! Welcome, " + enteredUsername);

                    // IF USER ALREADY PICKED HIS/HER TEAM PASS THE PICKTEAM PAGE.
                    
                    if (PickTeam.isTeamPicked()) {
                        // Team has already been picked, proceed directly to the next step (e.g., DraftPage)
                        DraftPage.draft(frame, panel, null);
                    } else {
                        // Team has not been picked, proceed with team picking logic
                        PickTeam.pickteam(frame, panel);
                    }
                } else {
                    JLabel errorMessageLabelUSER = new JLabel("");
                    errorMessageLabelUSER.setForeground(Color.RED);
                    errorMessageLabelUSER.setBounds(610, 330, 400, 400);
                    panel.add(errorMessageLabelUSER);
                    errorMessageLabelUSER.setText("Login failed. Invalid username or password.");
                }}});
        frame.setVisible(true);
    }
    public static boolean isValidLogin(String enteredUsername, String enteredPassword) {
        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(", ");

                if (fields.length >=5 && fields[3].equals(enteredUsername) && fields[5].equals(enteredPassword)) {
                    return true; // Login successful
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false; // Login failed
    }
    
    private static void playBackgroundMusic() {
        try {
        	File file = new File("Travis-Scott-MY-EYES-(JustNaija.com).wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            backgroundMusic = AudioSystem.getClip();
            backgroundMusic.open(audioInputStream);
            backgroundMusic.start();
            backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    
    static boolean computerDraft() {
        // Ensure that teamlogos and other lists are properly initialized
        if (ComputerBot.allteamlogos != null && !ComputerBot.allteamlogos.isEmpty()
                && ComputerBot.pGBoxArrayList != null && ComputerBot.sGBoxArrayList != null
                && ComputerBot.sFBoxArrayList != null && ComputerBot.pFBoxArrayList != null
                && ComputerBot.cBoxArrayList != null) {

            for (int i = 0; i < 30; i++) {
                int imageNumber = 8860 + i;
                String imageName = "IMG_" + imageNumber + ".PNG";
                ComputerBot.allteamlogos.add(imageName);
            }

            String teamlogo = getRandomElement(ComputerBot.allteamlogos);
            ComputerBot.pickedList.add(teamlogo);

            String pgPlayer = getRandomElement(ComputerBot.pGBoxArrayList);
            System.out.println(pgPlayer);
            ComputerBot.pickedList.add(pgPlayer);
            ComputerBot.pGBoxArrayList.remove(pgPlayer);
            
            DraftPage.pGBox.removeItem(pgPlayer);
            
            System.out.println("\n\n  -------------------");
            System.out.println("SIZE OF THE PG LIST \t" + ComputerBot.pGBoxArrayList.size());
            System.out.println("-------------------");

            if (computerDraftPlayer(ComputerBot.sGBoxArrayList, DraftPage.sGBox)) {
                if (computerDraftPlayer(ComputerBot.sFBoxArrayList, DraftPage.sFBox)) {
                    if (computerDraftPlayer(ComputerBot.pFBoxArrayList, DraftPage.pFBox)) {
                        if (computerDraftPlayer(ComputerBot.cBoxArrayList, DraftPage.CBox)) {
                            System.out.println("DRAFT DONE!");
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    static boolean computerDraftPlayer(ArrayList<String> playerList, JComboBox<String> box) {
        if (!playerList.isEmpty()) {
            String player = getRandomElement(playerList);
            System.out.println(player);
            ComputerBot.pickedList.add(player);
            playerList.remove(player);
            box.removeItem(player);
            return true;
        }
        return false;
    }
            


    private static String getRandomElement(ArrayList<String> list) {
       try {
    	   if (list != null && !list.isEmpty()) {
               Random rand = new Random();
               int randomIndex = rand.nextInt(list.size());
               return list.get(randomIndex);
           } else {
               throw new IllegalArgumentException("The list is either null or empty.");
           }
       }
       catch (IllegalArgumentException e) {
    	   
    	   System.err.print(e);
		// TODO: handle
    	   return "";
	}
    }

}