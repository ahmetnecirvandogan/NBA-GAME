package Matches;
import BOTS.ComputerBot;
import myGui.DraftPage;
import myGui.showTeam;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class SimulationControl {

    private static boolean isPaused = false;
    static JButton pauseButton;
    static JButton resumeButton;
    static int matchCount = 0;
    private static ArrayList<String> logoPaths = new ArrayList<>();

    public static ArrayList<String> getLogoPaths() {
        return logoPaths;
    }
    static void setLogoPaths(ArrayList<String> logoPaths) {
        SimulationControl.logoPaths = logoPaths;
        
    }
    public static void simulatePlayoffSeason(ArrayList<ComputerBot> teams, String userTeamImageName ) {

    	JFrame playoffFrame = new JFrame();
    	JPanel playoffJPanel = new JPanel();
    	playoffFrame.setSize(1600,900);
    	playoffFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	
    	playoffFrame.add(playoffJPanel);
    	playoffJPanel.setLayout(null);

    	playoffFrame.setTitle("WELCOME TO NBA PLAYOFFS");
    	playoffJPanel.setBackground(new Color(255, 240, 224));
    	
    	System.out.println(logoPaths.get(0));

        ImageIcon teamIcon = new ImageIcon(logoPaths.get(0));
        Image resizedTeamImage = teamIcon.getImage().getScaledInstance(150, 110, Image.SCALE_SMOOTH);
        ImageIcon resizedTeamIcon = new ImageIcon(resizedTeamImage);
        JLabel teamLabel = new JLabel(resizedTeamIcon);
        teamLabel.setBounds(50, 50, 150, 110);
        playoffJPanel.add(teamLabel);
        
        JLabel VSLabel = new JLabel("VS");
        VSLabel.setBounds(100, 275/2, 200, 100);
        Font labelFont5 = VSLabel.getFont();
        VSLabel.setFont(new Font(labelFont5.getName(), Font.BOLD, 25));
        playoffJPanel.add(VSLabel);
        
        
        ImageIcon teamIcon2 = new ImageIcon(logoPaths.get(1));
        Image resizedTeamImage2 = teamIcon2.getImage().getScaledInstance(150, 110, Image.SCALE_SMOOTH);
        ImageIcon resizedTeamIcon2 = new ImageIcon(resizedTeamImage2);
        JLabel teamLabel2 = new JLabel(resizedTeamIcon2);
        teamLabel2.setBounds(50, 225, 150, 110);
        playoffJPanel.add(teamLabel2);
        
        
        
        ImageIcon teamIcon3 = new ImageIcon(logoPaths.get(2));
        Image resizedTeamImage3 = teamIcon3.getImage().getScaledInstance(150, 110, Image.SCALE_SMOOTH);
        ImageIcon resizedTeamIcon3 = new ImageIcon(resizedTeamImage3);
        JLabel teamLabel3 = new JLabel(resizedTeamIcon3);
        teamLabel3.setBounds(50, 475, 150, 110);
        playoffJPanel.add(teamLabel3);
        
        JLabel VSLabel2 = new JLabel("VS");
        VSLabel2.setBounds(100, (475+675)/2, 200, 100);
        Font labelFont52 = VSLabel2.getFont();
        VSLabel2.setFont(new Font(labelFont52.getName(), Font.BOLD, 25));
        playoffJPanel.add(VSLabel2);
        
        ImageIcon teamIcon4 = new ImageIcon(logoPaths.get(3));
        Image resizedTeamImage4 = teamIcon4.getImage().getScaledInstance(150, 110, Image.SCALE_SMOOTH);
        ImageIcon resizedTeamIcon4 = new ImageIcon(resizedTeamImage4);
        JLabel teamLabel4 = new JLabel(resizedTeamIcon4);
        teamLabel4.setBounds(50, 650, 150, 110);
        playoffJPanel.add(teamLabel4);

        
        ImageIcon teamIcon5 = new ImageIcon(logoPaths.get(4));
        Image resizedTeamImage5 = teamIcon5.getImage().getScaledInstance(150, 110, Image.SCALE_SMOOTH);
        ImageIcon resizedTeamIcon5 = new ImageIcon(resizedTeamImage5);
        JLabel teamLabel5 = new JLabel(resizedTeamIcon5);
        teamLabel5.setBounds(1300, 50, 150, 110);
        playoffJPanel.add(teamLabel5);
        
        JLabel VSLabel3 = new JLabel("VS");
        VSLabel3.setBounds(1350, 275/2, 200, 100);
        Font labelFont53 = VSLabel3.getFont();
        VSLabel3.setFont(new Font(labelFont53.getName(), Font.BOLD, 25));
        playoffJPanel.add(VSLabel3);
        
        ImageIcon teamIcon6 = new ImageIcon(logoPaths.get(5));
        Image resizedTeamImage6 = teamIcon6.getImage().getScaledInstance(150, 110, Image.SCALE_SMOOTH);
        ImageIcon resizedTeamIcon6 = new ImageIcon(resizedTeamImage6);
        JLabel teamLabel6 = new JLabel(resizedTeamIcon6);
        teamLabel6.setBounds(1300, 225, 150, 110);
        playoffJPanel.add(teamLabel6);
        
        
        ImageIcon teamIcon7 = new ImageIcon(logoPaths.get(6));
        Image resizedTeamImage7 = teamIcon7.getImage().getScaledInstance(150, 110, Image.SCALE_SMOOTH);
        ImageIcon resizedTeamIcon7 = new ImageIcon(resizedTeamImage7);
        JLabel teamLabel7 = new JLabel(resizedTeamIcon7);
        teamLabel7.setBounds(1300, 475, 150, 110);
        playoffJPanel.add(teamLabel7);
        
        JLabel VSLabel4 = new JLabel("VS");
        VSLabel4.setBounds(1350, (475+675)/2, 200, 100);
        Font labelFont54 = VSLabel4.getFont();
        VSLabel4.setFont(new Font(labelFont54.getName(), Font.BOLD, 25));
        playoffJPanel.add(VSLabel4);
        
        
        ImageIcon teamIcon8 = new ImageIcon(logoPaths.get(7));
        Image resizedTeamImage8 = teamIcon8.getImage().getScaledInstance(150, 110, Image.SCALE_SMOOTH);
        ImageIcon resizedTeamIcon8 = new ImageIcon(resizedTeamImage8);
        JLabel teamLabel8 = new JLabel(resizedTeamIcon8);
        teamLabel8.setBounds(1300, 650, 150, 110);
        playoffJPanel.add(teamLabel8);
        
        ImageIcon playoffIcon = new ImageIcon("2111__nba_playoffs-primary-2018.png");
        Image resizedPlayoffLabel = playoffIcon.getImage().getScaledInstance(500, 200, Image.SCALE_SMOOTH);
        ImageIcon resizedPlayoffIcon = new ImageIcon(resizedPlayoffLabel);
        JLabel resizedPlayoffLabel2 = new JLabel(resizedPlayoffIcon);
        resizedPlayoffLabel2.setBounds(510, 40, 500, 200);
        playoffJPanel.add(resizedPlayoffLabel2);
        
        
        
        
        JButton simulatePlayoffButton = new JButton("Simulate Playoffs");
        simulatePlayoffButton.setBounds(675, 750, 200, 70);
        simulatePlayoffButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	System.out.println("Playoffs...");
            	
            	//FIRST ROUND
            	
            	ComputerBot winner1 = Matchmaking.playoffMatchDetermineWinnerTEAM(getTop8Teams(teams).get(0),getTop8Teams(teams).get(1));
            	ComputerBot winner2 = Matchmaking.playoffMatchDetermineWinnerTEAM(getTop8Teams(teams).get(2),getTop8Teams(teams).get(3));
            	ComputerBot winner3 = Matchmaking.playoffMatchDetermineWinnerTEAM(getTop8Teams(teams).get(4),getTop8Teams(teams).get(5));
            	ComputerBot winner4 = Matchmaking.playoffMatchDetermineWinnerTEAM(getTop8Teams(teams).get(6),getTop8Teams(teams).get(7));

            	
                ImageIcon teamIcon3 = new ImageIcon(winner1.getSelectedLogo());
                Image resizedTeamImage3 = teamIcon3.getImage().getScaledInstance(150, 110, Image.SCALE_SMOOTH);
                ImageIcon resizedTeamIcon3 = new ImageIcon(resizedTeamImage3);
                JLabel teamLabel3 = new JLabel(resizedTeamIcon3);
                teamLabel3.setBounds(300, 275/2 +50, 200, 100);
                playoffJPanel.add(teamLabel3);
                
                JLabel VSLabel2 = new JLabel("VS");
                VSLabel2.setBounds(375, (275/2 + (475+675)/2)/2, 200, 100);
                Font labelFont52 = VSLabel2.getFont();
                VSLabel2.setFont(new Font(labelFont52.getName(), Font.BOLD, 25));
                playoffJPanel.add(VSLabel2);
                
               
                
                ImageIcon teamIcon32 = new ImageIcon(winner2.getSelectedLogo());
                Image resizedTeamImage32 = teamIcon32.getImage().getScaledInstance(150, 110, Image.SCALE_SMOOTH);
                ImageIcon resizedTeamIcon32 = new ImageIcon(resizedTeamImage32);
                JLabel teamLabel32 = new JLabel(resizedTeamIcon32);
                teamLabel32.setBounds(300, (475+675)/2-50, 200, 100);
                playoffJPanel.add(teamLabel32);
               
                
                ImageIcon teamIcon33 = new ImageIcon(winner3.getSelectedLogo());
                Image resizedTeamImage33 = teamIcon33.getImage().getScaledInstance(150, 110, Image.SCALE_SMOOTH);
                ImageIcon resizedTeamIcon33 = new ImageIcon(resizedTeamImage33);
                JLabel teamLabel33 = new JLabel(resizedTeamIcon33);
                teamLabel33.setBounds(1050, 275/2+50, 200, 100);
                playoffJPanel.add(teamLabel33);
                
                JLabel VSLabel22 = new JLabel("VS");
                VSLabel22.setBounds(1125, (275/2 + (475+675)/2)/2, 200, 100);
                Font labelFont522 = VSLabel22.getFont();
                VSLabel22.setFont(new Font(labelFont522.getName(), Font.BOLD, 25));
                playoffJPanel.add(VSLabel22);
                
                
                ImageIcon teamIcon34 = new ImageIcon(winner4.getSelectedLogo());
                Image resizedTeamImage34 = teamIcon34.getImage().getScaledInstance(150, 110, Image.SCALE_SMOOTH);
                ImageIcon resizedTeamIcon34 = new ImageIcon(resizedTeamImage34);
                JLabel teamLabel34 = new JLabel(resizedTeamIcon34);
                teamLabel34.setBounds(1050, (475+675)/2-50, 200, 100);
                playoffJPanel.add(teamLabel34);
                
                
                //SECOND ROUND
                
            	ComputerBot winner1_2 = Matchmaking.playoffMatchDetermineWinnerTEAM(winner1,winner2);
                ImageIcon teamIcon35 = new ImageIcon(winner1_2.getSelectedLogo());
                Image resizedTeamImage35 = teamIcon35.getImage().getScaledInstance(150, 110, Image.SCALE_SMOOTH);
                ImageIcon resizedTeamIcon35 = new ImageIcon(resizedTeamImage35);
                JLabel teamLabel35 = new JLabel(resizedTeamIcon35);
                teamLabel35.setBounds(525, (275/2 + (475+675)/2)/2, 200, 100);
                playoffJPanel.add(teamLabel35);
                
                JLabel VSLabel223 = new JLabel("VS");
                VSLabel223.setBounds(750, (275/2 + (475+675)/2)/2, 200, 100);
                Font labelFont5223 = VSLabel223.getFont();
                VSLabel223.setFont(new Font(labelFont5223.getName(), Font.BOLD, 25));
                playoffJPanel.add(VSLabel223);
                
                ComputerBot winner3_4 = Matchmaking.playoffMatchDetermineWinnerTEAM(winner3,winner4);
                ImageIcon teamIcon36 = new ImageIcon(winner3_4.getSelectedLogo());
                Image resizedTeamImage36 = teamIcon36.getImage().getScaledInstance(150, 110, Image.SCALE_SMOOTH);
                ImageIcon resizedTeamIcon36 = new ImageIcon(resizedTeamImage36);
                JLabel teamLabel36 = new JLabel(resizedTeamIcon36);
                teamLabel36.setBounds(825,(275/2 + (475+675)/2)/2, 200, 100);
                playoffJPanel.add(teamLabel36);
                
                
                
                //CHAMPION
                
                ImageIcon teamIcon37 = new ImageIcon( Matchmaking.playoffMatchDetermineWinnerTEAM(winner1_2,winner3_4).getSelectedLogo());
                Image resizedTeamImage37 = teamIcon37.getImage().getScaledInstance(150, 110, Image.SCALE_SMOOTH);
                ImageIcon resizedTeamIcon37 = new ImageIcon(resizedTeamImage37);
                JLabel teamLabel37 = new JLabel(resizedTeamIcon37);
                teamLabel37.setBounds(675, (275/2 + (475+675)/2)/2 + 200, 200, 100);
                playoffJPanel.add(teamLabel37);
    
                playoffFrame.revalidate();
                playoffFrame.repaint();
                playoffJPanel.repaint();
                playoffJPanel.revalidate(); 
                
                JLabel VSLabel4 = new JLabel("NBA CHAMPION !");
                VSLabel4.setBounds(625, 670, 1000, 100);
                Font labelFont54 = VSLabel4.getFont();
                VSLabel4.setFont(new Font(labelFont54.getName(), Font.BOLD, 35));
                playoffJPanel.add(VSLabel4);
                
                playoffJPanel.remove(simulatePlayoffButton);
            }
        });
        playoffJPanel.add(simulatePlayoffButton);
        
        
        JButton teamSpecialitiesButton = new JButton("Team Specialities");
        teamSpecialitiesButton.setBounds(675, 10, 200, 30);
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
        playoffJPanel.add(teamSpecialitiesButton, Integer.valueOf(2));
      
        playoffFrame.setVisible(true);
    }
    public static List<ComputerBot> getTop8Teams(List<ComputerBot> teams) {
        // Sort the teams based on the number of wins in descending order
        Collections.sort(teams, Comparator.comparingInt(ComputerBot::getWins).reversed());

        // Get the top 8 teams
        int numTeams = Math.min(8, teams.size());
        return teams.subList(0, numTeams);
    }
    
    public static void simulateInSeason(ArrayList<ComputerBot> teams, JFrame inSeasonFrame, JPanel inSeasonJPanel, JLayeredPane layeredPane, JButton simulateInSeasonButton, String userTeamImageName) {

        inSeasonFrame.setTitle("WELCOME TO NBA IN-SEASON");

        JLabel registrationNameLabel = new JLabel("PLAYOFF QUALIFIERS");
        registrationNameLabel.setBounds(10, 200, 400, 30);
        Font labelFont = registrationNameLabel.getFont();
        registrationNameLabel.setFont(new Font(labelFont.getName(), Font.BOLD, 25));

        layeredPane.add(registrationNameLabel, Integer.valueOf(2));
        
        pauseButton = createPauseButton(layeredPane);
        resumeButton = createResumeButton(layeredPane);

        layeredPane.add(pauseButton, Integer.valueOf(2));
        layeredPane.add(resumeButton, Integer.valueOf(2));

        int numberOfUpdates = 6;
        while (matchCount < numberOfUpdates) {
            if (!isPaused) {
                Matchmaking.playRandomGames(teams);
                MatchScreen.updateMatchScreen(inSeasonFrame, inSeasonJPanel, teams, layeredPane);
                

                teamResultsLog(teams);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        JButton continuePlayoffButton = new JButton("Continue Playoff");
        continuePlayoffButton.setBounds(750, 750, 200, 70);
        continuePlayoffButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SimulationControl.simulatePlayoffSeason(teams,userTeamImageName);
            }
        });

        inSeasonFrame.add(continuePlayoffButton);

        layeredPane.remove(simulateInSeasonButton);
        // Set frame properties and make it visible
        inSeasonFrame.setLayout(null);
        inSeasonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inSeasonFrame.setVisible(true);
        inSeasonJPanel.setLayout(null);
        inSeasonJPanel.revalidate();
        inSeasonJPanel.repaint();
    }
    
    private static JButton createPauseButton(JLayeredPane layeredPane) {
        JButton pauseButton = new JButton("Pause");
        pauseButton.setBounds(200, 130, 100, 30);
        pauseButton.addActionListener(e -> {
            setPaused(true);
            layeredPane.remove(pauseButton);
            layeredPane.add(resumeButton, Integer.valueOf(2));
            layeredPane.revalidate();
            layeredPane.repaint();
        });
        return pauseButton;
    }

    private static JButton createResumeButton(JLayeredPane layeredPane) {
        JButton resumeButton = new JButton("Resume");
        resumeButton.setBounds(300, 130, 100, 30);
        resumeButton.addActionListener(e -> {
            setPaused(false);
            layeredPane.remove(resumeButton);
            layeredPane.add(pauseButton, Integer.valueOf(2));
            layeredPane.revalidate();
            layeredPane.repaint();
        });
        return resumeButton;
    }
    

    private static void teamResultsLog(List<ComputerBot> top8Teams) {
        System.out.println("Top 8 Teams:");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("team_results.txt"))) {
            for (ComputerBot team : top8Teams) {
                String teamInfo = team.getName() + " - Wins: " + team.getWins() + " - Losses: " + team.getLosses();
                System.out.println(teamInfo);
                writer.write(teamInfo);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static int getMatchCount() {
		return matchCount;
	}

	public static void setMatchCount(int matchCount) {
		SimulationControl.matchCount = matchCount;
	}

	public static void setPaused(boolean isPaused) {
		SimulationControl.isPaused = isPaused;
	}

	public static void togglePause() {
        isPaused = !isPaused;
    }

    public static boolean isPaused() {
        return isPaused;
    }

    
}
