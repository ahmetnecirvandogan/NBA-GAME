package Matches;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import java.awt.Image;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import BOTS.ComputerBot;
import myGui.DraftPage;
import myGui.showTeam;

public class MatchScreen {
	public static void updateMatchScreen(JFrame frame, JPanel panel, ArrayList<ComputerBot> teams, JLayeredPane layeredPane) {
	    List<ComputerBot> top8Teams = SimulationControl.getTop8Teams(teams);
	    
	    Component[] components = layeredPane.getComponents();
	    for (Component component : components) {
	        if (component instanceof JLabel) {
	            // Check if the component was added by updateMatchScreen
	            if (layeredPane.getPosition(component) == Integer.valueOf(1)) {
	                layeredPane.remove(component);
	            }
	        }
	    }
	    
	    int yCoordinate = 250; // Set the initial y-coordinate for team labels
	    int xCoordinate = 10;

	    // Create a list to store the logo paths of top 8 teams
	    ArrayList<String> logoPaths = new ArrayList<>();

	    for (int i = 0; i < top8Teams.size(); i++) {
	        ComputerBot team = top8Teams.get(i);
	        String logoPath = team.determineTeamLogo();
	        System.out.println("Logo Path: " + logoPath); // Check the path

	        logoPaths.add(logoPath);
	       SimulationControl.setLogoPaths(logoPaths);// Add the logo path to the list

	        ImageIcon teamIcon = new ImageIcon(logoPath);
	        Image resizedTeamImage = teamIcon.getImage().getScaledInstance(150, 110, Image.SCALE_SMOOTH);
	        ImageIcon resizedTeamIcon = new ImageIcon(resizedTeamImage);
	        JLabel teamLabel = new JLabel(resizedTeamIcon);
	        teamLabel.setBounds(xCoordinate, yCoordinate, 150, 110);
	        layeredPane.add(teamLabel, Integer.valueOf(1));
	        
	        JLabel winloseJLabel = new JLabel("W:" + team.getWins() +" "+ "L:" + team.getLosses());
	        winloseJLabel.setBounds(xCoordinate + 140, yCoordinate+50, 4000, 40);
	        Font labelFont = winloseJLabel.getFont();
	        winloseJLabel.setFont(new Font(labelFont.getName(), Font.BOLD, 45));
	        winloseJLabel.setForeground(Color.WHITE);
	        layeredPane.add(winloseJLabel, Integer.valueOf(1));                 // Use a lower value like 1

	        // Adjust the y-coordinate for the next team label after the fourth component
	        if (i == 3) {
	            yCoordinate = 250;
	            xCoordinate += 350; // Reset x-coordinate after the fourth component
	        } else {
	            yCoordinate += 160;
	        }
	    }

	    // Now 'logoPaths' contains the logo paths of the top 8 teams in the correct order
	    System.out.println("Top 8 Teams Logo Paths: " + logoPaths);

	    frame.revalidate();
	    frame.repaint();
	    panel.revalidate();
	    panel.repaint();
	}
    public static void createMatchScreen(JFrame frame, JPanel panel, String userTeamImageName) {
        panel.removeAll();
        
        // Set background image to the content pane of the JFrame
        ImageIcon backgroundImageIcon = new ImageIcon("luka-doncic-nba-live-dj.jpg");
        Image resizedBackgroundImage = backgroundImageIcon.getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon resizedBackgroundIcon = new ImageIcon(resizedBackgroundImage);
        JLabel backgroundLabel = new JLabel(resizedBackgroundIcon);
        backgroundLabel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        

        // Use a JLayeredPane for layering components
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.add(backgroundLabel, Integer.valueOf(Integer.MIN_VALUE));
        layeredPane.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        
        frame.setContentPane(layeredPane);

        ImageIcon userTeamImageIcon = new ImageIcon(userTeamImageName);
        Image resizedUserTeamImage = userTeamImageIcon.getImage().getScaledInstance(150, 110, Image.SCALE_SMOOTH);
        ImageIcon resizedUserTeamIcon = new ImageIcon(resizedUserTeamImage);
        JLabel userTeamImageLabel = new JLabel(resizedUserTeamIcon);
        userTeamImageLabel.setBounds(10, -160, 200, 500);
        layeredPane.add(userTeamImageLabel, Integer.valueOf(1));

        
        JLabel pickTeamLabel = new JLabel("WELCOME TO NBA IN-SEASON");
        pickTeamLabel.setBounds(65, 750, 4000, 40);
        Font labelFont = pickTeamLabel.getFont();
        pickTeamLabel.setFont(new Font(labelFont.getName(), Font.BOLD, 45));
        layeredPane.add(pickTeamLabel, Integer.valueOf(1));
        
        JLabel loadingLabel = new JLabel("Loading...");
        loadingLabel.setBounds(300, 200, 200, 30);
        Font loadingFont = loadingLabel.getFont();
        loadingLabel.setFont(new Font(loadingFont.getName(), Font.BOLD, 20));
        loadingLabel.setVisible(false); // Initially set to invisible
        layeredPane.add(loadingLabel, Integer.valueOf(2));

        ImageIcon nbaimageIcon = new ImageIcon("nba-logo_2x.png");
        Image resizednbaIconImage = nbaimageIcon.getImage().getScaledInstance(150, 110, Image.SCALE_SMOOTH);
        ImageIcon nbaesizednbaIconImage = new ImageIcon(resizednbaIconImage);
        JLabel nbaimageLabel = new JLabel(nbaesizednbaIconImage);
        nbaimageLabel.setBounds(-65, 520, 200, 500);
        layeredPane.add(nbaimageLabel,Integer.valueOf(1));
        
        
        JButton simulateInSeasonButton = new JButton("SIMULATE IN-SEASON");
        simulateInSeasonButton.setBounds(200, 50, 200, 70);
        simulateInSeasonButton.addActionListener(new ActionListener() {
            private int dotCount = 0;
            private int repeatCount = 0;
            private int maxRepeats = 8; // Set the desired number of repeats
            private Timer timer;

            @Override
            public void actionPerformed(ActionEvent e) {
                loadingLabel.setVisible(true); // Show the loading label
                frame.revalidate(); // Revalidate the frame to immediately reflect changes

                // Start a Timer to update the loading label text every 500 milliseconds
                timer = new Timer(800, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent timerEvent) {
                        StringBuilder loadingText = new StringBuilder("Loading");
                        for (int i = 0; i < dotCount; i++) {
                            loadingText.append(".");
                        }
                        loadingLabel.setText(loadingText.toString());

                        // Adjust dotCount and handle the restart part
                        if (dotCount < 3) {
                            dotCount++;
                        } else {
                            dotCount = 0;
                        }

                        // Check if it's time to restart the timer
                        if (dotCount == 0) {
                            repeatCount++;

                            // Stop the timer after the specified number of repeats
                            if (repeatCount >= maxRepeats) {
                                ((Timer) timerEvent.getSource()).stop();
                                loadingLabel.setVisible(false); // Hide the loading label after stopping the timer
                                frame.revalidate(); // Revalidate the frame again
                            }
                        }
                    }
                });

                // Start the timer
                timer.start();

                // Start a new thread to simulate the in-season process
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        SimulationControl.simulateInSeason(DraftPage.getComputerBotsList(), frame, panel, layeredPane, simulateInSeasonButton, userTeamImageName);
                    }
                }).start();
                
            }
        });
        layeredPane.add(simulateInSeasonButton, Integer.valueOf(2));

        // Add teamSpecialitiesButton and its components
        JButton teamSpecialitiesButton = new JButton("Team Specialities");
        teamSpecialitiesButton.setBounds(200, 10, 200, 30);
        teamSpecialitiesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            showTeam.show((String) DraftPage.getpGBox().getSelectedItem(),
                    (String) DraftPage.getsGBox().getSelectedItem(),
                    (String) DraftPage.getsFBox().getSelectedItem(),
                    (String) DraftPage.getpFBox().getSelectedItem(),
                    (String) DraftPage.getCBox().getSelectedItem(),
                    (String) userTeamImageName);
                
            }
        });
        layeredPane.add(teamSpecialitiesButton, Integer.valueOf(2));


        // Refresh the panel to show the new components
        panel.setLayout(null);
        panel.revalidate();
        panel.repaint();
        
    }
}
