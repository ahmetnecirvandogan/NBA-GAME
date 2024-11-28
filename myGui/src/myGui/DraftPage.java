package myGui;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import BOTS.ComputerBot;
import Matches.MatchScreen;

public class DraftPage {	
    private static boolean isPGSelected = false;
    private static boolean isSGSelected = false;
    private static boolean isSFSelected = false;
    private static boolean isPFSelected = false;
    private static boolean isCSelected = false;
    
    static ArrayList<ComputerBot> computerBotsList = new ArrayList<ComputerBot>();
    static JComboBox<String> pGBox = new JComboBox<String>();
    static JComboBox<String> sGBox = new JComboBox<String>();
	static JComboBox<String> sFBox = new JComboBox<String>();
    static JComboBox<String> pFBox = new JComboBox<String>();
    static JComboBox<String> CBox = new JComboBox<String>();

	public static void draft(JFrame frame, JPanel panel, String userTeamImageName) {
        
        panel.removeAll();
       
        ImageIcon teamImageIcon = new ImageIcon(userTeamImageName);
        Image resizedImage = teamImageIcon.getImage().getScaledInstance(150, 110, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        JLabel imageLabel = new JLabel(resizedIcon);
        imageLabel.setBounds(650, -160, 200, 500);
        panel.add(imageLabel);
        
        
        ImageIcon playerimageIconPG = new ImageIcon("Subject 3 copy.png");
        Image originalPG = playerimageIconPG.getImage();
        Image resizedPG = originalPG.getScaledInstance(250, 270, Image.SCALE_SMOOTH);
        ImageIcon resizedIconPG = new ImageIcon(resizedPG);
        JLabel playerimageLabelPG = new JLabel(resizedIconPG);
        playerimageLabelPG.setBounds(-200, -150, 700, 900);
        panel.add(playerimageLabelPG);
        
        ImageIcon playerimageIconSG = new ImageIcon("Subject 3.png");
        Image originalSG = playerimageIconSG.getImage();
        Image resizedSG = originalSG.getScaledInstance(250, 270, Image.SCALE_SMOOTH);
        ImageIcon resizedIconSG = new ImageIcon(resizedSG);
        JLabel playerimageLabelSG = new JLabel(resizedIconSG);
        playerimageLabelSG.setBounds(100, -150, 700, 900);
        panel.add(playerimageLabelSG);
        
        ImageIcon playerimageIconSF = new ImageIcon("Subject 3 copy 2.png");
        Image originalSF = playerimageIconSF.getImage();
        Image resizedSF = originalSF.getScaledInstance(250, 270, Image.SCALE_SMOOTH);
        ImageIcon resizedIconSF = new ImageIcon(resizedSF);
        JLabel playerimageLabelSF = new JLabel(resizedIconSF);
        playerimageLabelSF.setBounds(400, -150, 700, 900);
        panel.add(playerimageLabelSF);
        
        ImageIcon playerimageIconPF = new ImageIcon("Subject 4.png");
        Image originalPF = playerimageIconPF.getImage();
        Image resizedPF = originalPF.getScaledInstance(250, 270, Image.SCALE_SMOOTH);
        ImageIcon resizedIconPF = new ImageIcon(resizedPF);
        JLabel playerimageLabelPF = new JLabel(resizedIconPF);
        playerimageLabelPF.setBounds(700, -150, 700, 900);
        panel.add(playerimageLabelPF);
        
        ImageIcon playerimageIconC = new ImageIcon("Subject 3 copy 3.png");
        Image originalC = playerimageIconC.getImage();
        Image resizedC = originalC.getScaledInstance(250, 270, Image.SCALE_SMOOTH);
        ImageIcon resizedIconC = new ImageIcon(resizedC);
        JLabel playerimageLabelC = new JLabel(resizedIconC);
        playerimageLabelC.setBounds(1000, -150, 700, 900);
        panel.add(playerimageLabelC);
       
        JLabel pgJLabel = new JLabel("PG");
        pgJLabel.setBounds(100, 600, 200, 100);
        Font labelFont = pgJLabel.getFont();
        pgJLabel.setFont(new Font(labelFont.getName(), Font.BOLD, 45));
        panel.add(pgJLabel);
        
        JLabel sgJLabel = new JLabel("SG");
        sgJLabel.setBounds(400, 600, 500, 100);
        Font labelFont2 = sgJLabel.getFont();
        sgJLabel.setFont(new Font(labelFont2.getName(), Font.BOLD, 45));
        panel.add(sgJLabel);
        
        JLabel sfJLabel = new JLabel("SF");
        sfJLabel.setBounds(700, 600, 500, 100);
        Font labelFont3 = sfJLabel.getFont();
        sfJLabel.setFont(new Font(labelFont3.getName(), Font.BOLD, 45));
        panel.add(sfJLabel);
        
        JLabel pfJLabel = new JLabel("PF");
        pfJLabel.setBounds(1010, 600, 500, 100);
        Font labelFont4 = pfJLabel.getFont();
        pfJLabel.setFont(new Font(labelFont4.getName(), Font.BOLD, 45));
        panel.add(pfJLabel);
        
        JLabel cJLabel = new JLabel("C");
        cJLabel.setBounds(1310, 600, 500, 100);
        Font labelFont5 = cJLabel.getFont();
        cJLabel.setFont(new Font(labelFont5.getName(), Font.BOLD, 45));
        panel.add(cJLabel);
        
        
    	// CREATING A "User" named string and user bot named computer bot to represent the user itself.
		
    	String user = "User";
        ComputerBot userBot = new ComputerBot(user);
        computerBotsList.add(userBot);
        for (int i = 0; i < 29; i++) {
            String botName = Integer.toString(i +1);
            ComputerBot computerBot = new ComputerBot(botName);
            computerBotsList.add(computerBot);
        }
        Collections.shuffle(computerBotsList);
        
        
        //BOXES AND ARRAYLISTS RELATIONSHIPS
        readPlayerPositions("playerpositionPG.txt", pGBox, ComputerBot.pGBoxArrayList, 50, panel);
        readPlayerPositions("playerpositionSG.txt", sGBox, ComputerBot.sGBoxArrayList, 350, panel);
        readPlayerPositions("playerpositionSF.txt", sFBox, ComputerBot.sFBoxArrayList, 650, panel);
        readPlayerPositions("playerpositionPF.txt", pFBox, ComputerBot.pFBoxArrayList, 960, panel);
        readPlayerPositions("playerpositionC.txt", CBox, ComputerBot.cBoxArrayList, 1260, panel);

        for (int i = 0; i < 30; i++) {
        	
            if (!computerBotsList.get(i).getName().equals("User")) {
            	System.out.println("\n\nNOT USER");
            	System.out.println(computerBotsList.size());
            	System.out.println("TEAM NAME IS \t " + computerBotsList.get(i).getName());
           	    NBAGAME.computerDraft();
           	
            } else {
            	System.out.println("USER PICKING\n");
                // ActionListener for user draft
                        pGBox.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                System.out.println(pGBox.getSelectedItem());
                                isPGSelected = true;
                                ComputerBot.pGBoxArrayList.remove(pGBox.getSelectedItem());
                                
                                
                                JLabel pGboxdraftJLabel = new JLabel("You picked " + pGBox.getSelectedItem());
                                pGboxdraftJLabel.setBounds(50, 500, 200, 100);
                                Font labelFont2 = pGboxdraftJLabel.getFont();
                                pGboxdraftJLabel.setFont(new Font(labelFont2.getName(), Font.BOLD, 15));
                                panel.add(pGboxdraftJLabel);

                                panel.remove(pGBox);
                                panel.revalidate();
                                panel.repaint();
                            }
                        });
                        sGBox.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                System.out.println(sGBox.getSelectedItem());
                                isSGSelected = true;
                                JLabel sGboxdraftJLabel = new JLabel("You picked " + sGBox.getSelectedItem());
                                sGboxdraftJLabel.setBounds(350, 500, 500, 100);
                                Font labelFont2 = sGboxdraftJLabel.getFont();
                                sGboxdraftJLabel.setFont(new Font(labelFont2.getName(), Font.BOLD, 15));
                                panel.add(sGboxdraftJLabel);

                                panel.remove(sGBox);
                                panel.revalidate();
                                panel.repaint();
                            }
                        });
                        sFBox.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                System.out.println(sFBox.getSelectedItem());
                                isSFSelected = true;
                                JLabel sFboxdraftJLabel = new JLabel("You picked " + sFBox.getSelectedItem());
                                sFboxdraftJLabel.setBounds(650, 500, 500, 100);
                                Font labelFont2 = sFboxdraftJLabel.getFont();
                                sFboxdraftJLabel.setFont(new Font(labelFont2.getName(), Font.BOLD, 15));
                                panel.add(sFboxdraftJLabel);

                                panel.remove(sFBox);
                                panel.revalidate();
                                panel.repaint();
                            }
                        });
                        pFBox.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                System.out.println(pFBox.getSelectedItem());
                                isPFSelected = true;
                                JLabel pFboxdraftJLabel = new JLabel("You picked " + pFBox.getSelectedItem());
                                pFboxdraftJLabel.setBounds(960, 500, 500, 100);
                                Font labelFont2 = pFboxdraftJLabel.getFont();
                                pFboxdraftJLabel.setFont(new Font(labelFont2.getName(), Font.BOLD, 15));
                                panel.add(pFboxdraftJLabel);

                                panel.remove(pFBox);
                                panel.revalidate();
                                panel.repaint();
                            }
                        });
                        CBox.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                System.out.println(CBox.getSelectedItem());
                                isCSelected = true;
                                JLabel CboxdraftJLabel = new JLabel("You picked " + CBox.getSelectedItem());
                                CboxdraftJLabel.setBounds(1260, 500, 500, 100);
                                Font labelFont2 = CboxdraftJLabel.getFont();
                                CboxdraftJLabel.setFont(new Font(labelFont2.getName(), Font.BOLD, 15));
                                panel.add(CboxdraftJLabel);

                                panel.remove(CBox);
                                panel.revalidate();
                                panel.repaint();
                            }
                        });  
                }

            }
        JButton teamSpecialitiesButton = new JButton("Team Specialities");
        teamSpecialitiesButton.setBounds(1300, 10, 200, 30);
        teamSpecialitiesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if (isPGSelected && isSGSelected && isSFSelected && isPFSelected && isCSelected) {
					
                    showTeam.show((String) pGBox.getSelectedItem(),
                            (String) sGBox.getSelectedItem(),
                            (String) sFBox.getSelectedItem(),
                            (String) pFBox.getSelectedItem(),
                            (String) CBox.getSelectedItem(),
                    		(String) userTeamImageName);
				}
				 
            }
        });
        panel.add(teamSpecialitiesButton);
        

            JButton continueButton  = new JButton("CONTINUE");
            continueButton.setBounds(650, 750, 200, 70);
            continueButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	if (isPGSelected && isSGSelected && isSFSelected && isPFSelected && isCSelected) {
                		draftCompletedLog();
                        MatchScreen.createMatchScreen(frame,panel,userTeamImageName);
                		
                		
    				}
    				 
                }
            });
            panel.add(continueButton);


        // Refresh the panel to show the new components
        panel.revalidate();
        panel.repaint();
		

    }
    private static void readPlayerPositions(String fileName, JComboBox<String> comboBox, ArrayList<String> arrayList, int xCoordinate, JPanel panel) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                comboBox.addItem(values[1]);
                arrayList.add(values[1]);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        comboBox.setBounds(xCoordinate, 500, 200, 30);
        panel.add(comboBox);
    }
	
	
    public static JComboBox<String> getsGBox() {
		return sGBox;
	}


	public static void setsGBox(JComboBox<String> sGBox) {
		DraftPage.sGBox = sGBox;
	}


	public static JComboBox<String> getsFBox() {
		return sFBox;
	}


	public static void setsFBox(JComboBox<String> sFBox) {
		DraftPage.sFBox = sFBox;
	}


	public static JComboBox<String> getpFBox() {
		return pFBox;
	}


	public static void setpFBox(JComboBox<String> pFBox) {
		DraftPage.pFBox = pFBox;
	}


	public static JComboBox<String> getCBox() {
		return CBox;
	}


	public static void setCBox(JComboBox<String> cBox) {
		CBox = cBox;
	}

    public static boolean isPGSelected() {
		return isPGSelected;
	}


	public static void setPGSelected(boolean isPGSelected) {
		DraftPage.isPGSelected = isPGSelected;
	}


	public static boolean isSGSelected() {
		return isSGSelected;
	}


	public static void setSGSelected(boolean isSGSelected) {
		DraftPage.isSGSelected = isSGSelected;
	}


	public static boolean isSFSelected() {
		return isSFSelected;
	}


	public static void setSFSelected(boolean isSFSelected) {
		DraftPage.isSFSelected = isSFSelected;
	}


	public static JComboBox<String> getpGBox() {
		return pGBox;
	}


	public static void setpGBox(JComboBox<String> pGBox) {
		DraftPage.pGBox = pGBox;
	}


	public static boolean isPFSelected() {
		return isPFSelected;
	}


	public static void setPFSelected(boolean isPFSelected) {
		DraftPage.isPFSelected = isPFSelected;
	}


	public static boolean isCSelected() {
		return isCSelected;
	}


	public static void setCSelected(boolean isCSelected) {
		DraftPage.isCSelected = isCSelected;
	}


	public static ArrayList<ComputerBot> getComputerBotsList() {
		return computerBotsList;
	}


	public static void setComputerBotsList(ArrayList<ComputerBot> computerBotsList) {
		DraftPage.computerBotsList = computerBotsList;
	}
	
    public static void draftCompletedLog() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("draft_results.txt"))) {
            writer.write("User Team:\n");
            writer.write("PG: " + pGBox.getSelectedItem() + "\n");
            writer.write("SG: " + sGBox.getSelectedItem() + "\n");
            writer.write("SF: " + sFBox.getSelectedItem() + "\n");
            writer.write("PF: " + pFBox.getSelectedItem() + "\n");
            writer.write("C: " + CBox.getSelectedItem() + "\n\n");

            for (int i = 1; i< computerBotsList.size();i++) {
            	if(!computerBotsList.get(i).getName().equals("User")) {
                writer.write(computerBotsList.get(i).getName() + " Team:\n");
                writer.write("PG: " + computerBotsList.get(i).getPickedList().get(1) + "\n");
                writer.write("SG: " + computerBotsList.get(i).getPickedList().get(2) + "\n");
                writer.write("SF: " + computerBotsList.get(i).getPickedList().get(3) + "\n");
                writer.write("PF: " + computerBotsList.get(i).getPickedList().get(4) + "\n");
                writer.write("C:  " + computerBotsList.get(i).getPickedList().get(5) + "\n");
                writer.write("\n");
            }
            	}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	

}
