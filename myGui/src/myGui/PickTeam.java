package myGui;


import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import BOTS.ComputerBot;

public class PickTeam {
	
	private static boolean teamPicked = false;
	
	public static String imageName;


    public static void pickteam(JFrame frame, JPanel panel) {
        panel.removeAll();
        
        if (teamPicked) {
            // Team has already been picked, proceed directly to the next step
            // Add logic for the next step after team picking, e.g., DraftPage
            DraftPage.draft(frame, panel, null);
            return;
        }

        for (int i = 0; i < 30; i++) {
            int imageNumber = 8860 + i;
            String imageName = "IMG_" + imageNumber + ".PNG";
            PickTeam.imageName = imageName;

            ImageIcon teamImageIcon = new ImageIcon(imageName);
            Image originalImage = teamImageIcon.getImage();
            Image resizedImage = originalImage.getScaledInstance(150, 110, Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(resizedImage);

            CustomImageButton imageButton = new CustomImageButton(resizedIcon, imageName);
            
            ComputerBot.allteamlogos.add(imageName);
            
            // Set the action listener
            imageButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    teamPicked = true; // Set the flag to true when the team is picked
                    DraftPage.draft(frame, panel,imageName);
                }
            });

            // Set position and size
            int xPosition = 10 + (i % 7) * 200;
            int yPosition = 0 + (i / 7) * 150;
            // Set the bounds to the dimensions of the scaled image
            imageButton.setBounds(xPosition, yPosition, 150, 110);
            

            // Add the button to the panel
            panel.add(imageButton);
        }

       
        // Add the label outside the loop
        JLabel pickTeamLabel = new JLabel("PICK YOUR TEAM");
        pickTeamLabel.setBounds(760, 700, 2000, 40);
        Font labelFont = pickTeamLabel.getFont();
        pickTeamLabel.setFont(new Font(labelFont.getName(), Font.BOLD, 45));
        panel.add(pickTeamLabel);

        // Repaint the panel
        panel.repaint();
    }
    public static boolean isTeamPicked() {
        return teamPicked;
    }
    

}