package myGui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class showTeam {

    public static void show(String pg, String sg, String sf, String pf, String c, String userTeamImageName) {
        JFrame teamFrame = new JFrame("Your Team");
        JPanel teamPanel = new JPanel();

        teamFrame.setSize(530, 500);
        teamFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        
        

        teamFrame.add(teamPanel);
        teamPanel.setLayout(null);

        // Display information for the selected PG player
        displayPlayerInfo(teamPanel, "playerpositionPG.txt", pg, 10, 20, userTeamImageName);

        // Display information for the selected SG player
        displayPlayerInfo(teamPanel, "playerpositionSG.txt", sg, 10, 110, userTeamImageName);

        // Display information for the selected SF player
        displayPlayerInfo(teamPanel, "playerpositionSF.txt", sf, 10, 200, userTeamImageName);

        // Display information for the selected PF player
        displayPlayerInfo(teamPanel, "playerpositionPF.txt", pf, 10, 290, userTeamImageName);

        // Display information for the selected C player
        displayPlayerInfo(teamPanel, "playerpositionC.txt", c, 10, 380, userTeamImageName);

        teamFrame.setVisible(true);
    }

    private static void displayPlayerInfo(JPanel panel, String fileName, String playerName, int x, int y, String userTeamImageName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            ImageIcon teamIcon33 = new ImageIcon(userTeamImageName);
            Image resizedTeamImage33 = teamIcon33.getImage().getScaledInstance(150, 110, Image.SCALE_SMOOTH);
            ImageIcon resizedTeamIcon33 = new ImageIcon(resizedTeamImage33);
            JLabel teamLabel33 = new JLabel(resizedTeamIcon33);
            teamLabel33.setBounds(300, 300, 200, 110);
            panel.add(teamLabel33);
            
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                if (values[1].equals(playerName)) {
                    // Display player information on the panel
                    JLabel nameLabel = new JLabel("Name: " + values[1]);
                    nameLabel.setBounds(x, y, 200, 30);
                    nameLabel.setForeground(Color.red);
                    panel.add(nameLabel);

                    JLabel positionLabel = new JLabel("Position: " + values[2]);
                    positionLabel.setBounds(x, y + 15, 200, 30);
                    panel.add(positionLabel);
                    
                    JLabel ageLabel = new JLabel("Age: " + values[3]);
                    ageLabel.setBounds(x, y + 30, 200, 30);
                    panel.add(ageLabel);
                    
                    JLabel pointsLabel = new JLabel("Points Avarage: " + values[29]);
                    pointsLabel.setBounds(x, y + 45, 200, 30);
                    panel.add(pointsLabel);
                    
                    


                    // Add more labels for other player information as needed

                    break; // Stop reading file once player is found
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
