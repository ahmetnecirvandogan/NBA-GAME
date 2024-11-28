package myGui;

public class Comments {

}


// DRAFTPAGE CASE
/*

for (int i = 0; i < 32; i++) {
	
	System.out.println(computerBotsList.get(i).getName() );
	if (!computerBotsList.get(i).getName().equals("User")) {
		
//		NBAGAME.ComputerDraftforPg();  
		NBAGAME.computerDraft();
	}
	else {

        
        pGBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(pGBox.getSelectedItem());
				isPGSelected = true;
				ComputerBot.pGBoxArrayList.remove(pGBox.getSelectedItem());
//				pGBox.removeItem(pGBox.getSelectedItem());
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

		
	}
	
	
}


for (int i = computerBotsList.size() - 1; i >= 0; i--) {
	if (!computerBotsList.get(i).getName().equals("User")) {
		
//		NBAGAME.ComputerDraftforSg();    
		NBAGAME.computerDraft();
	}
	else {

        
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

		
	}
	
	
}

for (int i = 0; i < 32; i++) {
	if (!computerBotsList.get(i).getName().equals("User")) {
		
//		NBAGAME.ComputerDraftforSf();        
		NBAGAME.computerDraft();
	}
	else {

        
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

		
	}
	
	
}

for (int i = computerBotsList.size() - 1; i >= 0; i--) {
	if (!computerBotsList.get(i).getName().equals("User")) {
		
//		NBAGAME.ComputerDraftforPf();    
		NBAGAME.computerDraft();
	}
	else {

        
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

		
	}
	
	
}



for (int i = 0; i < 32; i++) {
	if (!computerBotsList.get(i).getName().equals("User")) {
		
//	NBAGAME.ComputerDraftforC();
		NBAGAME.computerDraft();
		
	}
	else {

        
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
	
	
} */



//END OF THE NBAGAME CLASS

/*
private static boolean isPGplayeradded(String pgPlayer) {
	
	if (ComputerBot.pickedList.contains(pgPlayer)) {
		return true;
	}
	else {
		return false;
	}

}
private static boolean isSGplayeradded(String sgPlayer) {
	
	if (ComputerBot.pickedList.contains(sgPlayer)) {
		return true;
	}
	else {
		return false;
	}

}
private static boolean isSFplayeradded(String sfPlayer) {
	
	if (ComputerBot.pickedList.contains(sfPlayer)) {
		return true;
	}
	else {
		return false;
	}

}
private static boolean isPFplayeradded(String pfPlayer) {
	
	if (ComputerBot.pickedList.contains(pfPlayer)) {
		return true;
	}
	else {
		return false;
	}

}
private static boolean isCplayeradded(String cPlayer) {
	
	if (ComputerBot.pickedList.contains(cPlayer)) {
		return true;
	}
	else {
		return false;
	}

}


*/




//COMPUTER DRAFT


/*
static boolean ComputerDraftforPg() {
	
	System.out.println(ComputerBot.allteamlogos != null && !ComputerBot.allteamlogos.isEmpty());
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
        
        System.out.println("seçti");
        ComputerBot.pGBoxArrayList.remove(pgPlayer);
        System.out.println("\n\n  -------------------");

        System.out.println("SIZE \t"+ComputerBot.pGBoxArrayList.size());
        System.out.println("\n\n  -------------------");

//        DraftPage.pGBox.removeItem(pgPlayer);



        }
	return true;
	
}
        
        
        static boolean ComputerDraftforSg() {
            // Ensure that teamlogos and other lists are properly initialized
            if (ComputerBot.allteamlogos != null && !ComputerBot.allteamlogos.isEmpty()
                    && ComputerBot.pGBoxArrayList != null && ComputerBot.sGBoxArrayList != null
                    && ComputerBot.sFBoxArrayList != null && ComputerBot.pFBoxArrayList != null
                    && ComputerBot.cBoxArrayList != null) {

                if (ComputerDraftforPg()) {
                    String sgPlayer = getRandomElement(ComputerBot.sGBoxArrayList);
                    System.out.println(sgPlayer);
                    ComputerBot.pickedList.add(sgPlayer);
                    ComputerBot.sGBoxArrayList.remove(sgPlayer);
//                    DraftPage.sGBox.removeItem(sgPlayer);
                    



                }
                return true;
            }
			return false;
        }
                
                
        static boolean ComputerDraftforSf() {
            // Ensure that teamlogos and other lists are properly initialized
            if (ComputerBot.allteamlogos != null && !ComputerBot.allteamlogos.isEmpty()
                    && ComputerBot.pGBoxArrayList != null && ComputerBot.sGBoxArrayList != null
                    && ComputerBot.sFBoxArrayList != null && ComputerBot.pFBoxArrayList != null
                    && ComputerBot.cBoxArrayList != null) {


                    if (ComputerDraftforSg()) {
                        String sfPlayer = getRandomElement(ComputerBot.sFBoxArrayList);
                        System.out.println(sfPlayer);
                        ComputerBot.pickedList.add(sfPlayer);
                        ComputerBot.sFBoxArrayList.remove(sfPlayer);
                        
//                        DraftPage.sFBox.removeItem(sfPlayer);
                        
                        


                    }
                    return true;
                    
                }
			return false;
            
        }
            
            
            
            static boolean ComputerDraftforPf() {
                // Ensure that teamlogos and other lists are properly initialized
                if (ComputerBot.allteamlogos != null && !ComputerBot.allteamlogos.isEmpty()
                        && ComputerBot.pGBoxArrayList != null && ComputerBot.sGBoxArrayList != null
                        && ComputerBot.sFBoxArrayList != null && ComputerBot.pFBoxArrayList != null
                        && ComputerBot.cBoxArrayList != null) {


                            if (ComputerDraftforSf()) {
                                String pfPlayer = getRandomElement(ComputerBot.pFBoxArrayList);
                                System.out.println(pfPlayer);
                                ComputerBot.pickedList.add(pfPlayer);
                                ComputerBot.pFBoxArrayList.remove(pfPlayer);
//                                DraftPage.pFBox.removeItem(pfPlayer);
                                
                            }
                            return true;
                        }
				return false;
                
                    } 
                
                
                
                static boolean ComputerDraftforC() {
                    // Ensure that teamlogos and other lists are properly initialized
                    if (ComputerBot.allteamlogos != null && !ComputerBot.allteamlogos.isEmpty()
                            && ComputerBot.pGBoxArrayList != null && ComputerBot.sGBoxArrayList != null
                            && ComputerBot.sFBoxArrayList != null && ComputerBot.pFBoxArrayList != null
                            && ComputerBot.cBoxArrayList != null) {

                                    if (ComputerDraftforPf()) {
                                        String cPlayer = getRandomElement(ComputerBot.cBoxArrayList);
                                        System.out.println(cPlayer);
                                        ComputerBot.pickedList.add(cPlayer);
                                        ComputerBot.cBoxArrayList.remove(cPlayer);
//                                        DraftPage.CBox.removeItem(cPlayer);
                                        


                                        if (isCplayeradded(cPlayer)) {
                                            System.out.println("DRAFT DONE!");
                                        }
                                    }
                                    return true;
                                }
					return false;
                    
                    
                }*/



//BUFFERREADERS IN DRAFTPAGE


/*
        try (BufferedReader br = new BufferedReader(new FileReader("playerpositionPG.txt"))) {
        	
        	while ((line = br.readLine()) != null) {
				
                String[] values = line.split(";");
                
                pGBox.addItem(values[1]);	
                ComputerBot.pGBoxArrayList.add(values[1]);
			}
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        pGBox.setBounds(50, 500, 200, 30);
        panel.add(pGBox);
        
        JLabel pickPGLabel = new JLabel("PG");
        pickPGLabel.setBounds(100, 550, 200, 100);
        Font labelFont = pickPGLabel.getFont();
        pickPGLabel.setFont(new Font(labelFont.getName(), Font.BOLD, 45));
        panel.add(pickPGLabel);
        

        try (BufferedReader br = new BufferedReader(new FileReader("playerpositionSG.txt"))) {
        	
        	while ((line = br.readLine()) != null) {
				
                String[] values = line.split(";");
                
                sGBox.addItem(values[1]);	
                ComputerBot.sGBoxArrayList.add(values[1]);	
			}
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        sGBox.setBounds(350, 500, 200, 30);
        panel.add(sGBox);
        
        JLabel pickSGLabel = new JLabel("SG");
        pickSGLabel.setBounds(400, 550, 200, 100);
        Font labelFont2 = pickSGLabel.getFont();
        pickSGLabel.setFont(new Font(labelFont2.getName(), Font.BOLD, 45));
        panel.add(pickSGLabel);
        

        try (BufferedReader br = new BufferedReader(new FileReader("playerpositionSF.txt"))) {
        	
        	while ((line = br.readLine()) != null) {
				
                String[] values = line.split(";");
                
                sFBox.addItem(values[1]);
                ComputerBot.sFBoxArrayList.add(values[1]);
			}
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        sFBox.setBounds(650, 500, 200, 30);
        panel.add(sFBox);
        
        JLabel pickSFLabel = new JLabel("SF");
        pickSFLabel.setBounds(700, 550, 200, 100);
        Font labelFont3 = pickSFLabel.getFont();
        pickSFLabel.setFont(new Font(labelFont3.getName(), Font.BOLD, 45));
        panel.add(pickSFLabel);
        
        
        try (BufferedReader br = new BufferedReader(new FileReader("playerpositionPF.txt"))) {
        	
        	while ((line = br.readLine()) != null) {
				
                String[] values = line.split(";");
                
                pFBox.addItem(values[1]);
                ComputerBot.pFBoxArrayList.add(values[1]);
			}
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        pFBox.setBounds(960, 500, 200, 30);
        panel.add(pFBox);
        
        JLabel pickPFLabel = new JLabel("PF");
        pickPFLabel.setBounds(1010, 550, 200, 100);
        Font labelFont4 = pickPFLabel.getFont();
        pickPFLabel.setFont(new Font(labelFont4.getName(), Font.BOLD, 45));
        panel.add(pickPFLabel);
        
        
        try (BufferedReader br = new BufferedReader(new FileReader("playerpositionC.txt"))) {
        	
        	while ((line = br.readLine()) != null) {
				
                String[] values = line.split(";");
                
                CBox.addItem(values[1]);
                ComputerBot.cBoxArrayList.add(values[1]);
			}
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        CBox.setBounds(1260, 500, 200, 30);
        panel.add(CBox);
        
        JLabel pickCLabel = new JLabel("C");
        pickCLabel.setBounds(1310, 550, 200, 100);
        Font labelFont5 = pickCLabel.getFont();
        pickCLabel.setFont(new Font(labelFont5.getName(), Font.BOLD, 45));
        panel.add(pickCLabel);
        */


// ADD ITEMS TO ARRAYLISTS


/*
for (int in = 0; in < pGBox.getItemCount(); in++) {
    String element = (String) pGBox.getItemAt(in);
   ComputerBot.pGBoxArrayList.add(element);
}





for (int in = 0; in < sGBox.getItemCount(); in++) {
    String element = (String) sGBox.getItemAt(in);
   ComputerBot.sGBoxArrayList.add(element);
}




for (int in = 0; in < sFBox.getItemCount(); in++) {
    String element = (String) sFBox.getItemAt(in);
   ComputerBot.sFBoxArrayList.add(element);
}



for (int in = 0; in < pFBox.getItemCount(); in++) {
    String element = (String) pFBox.getItemAt(in);
   ComputerBot.pFBoxArrayList.add(element);
}


for (int in = 0; in < CBox.getItemCount(); in++) {
    String element = (String) CBox.getItemAt(in);
   ComputerBot.cBoxArrayList.add(element);
}
*/





// END OF THE MATCHMAKING CLASS



/*
private static long calculateTeamScore(ComputerBot team, Random random) {
    long totalPower = 0;
    String line = "";
    long playerPowerPG = 0;
    long playerPowerSG = 0;
    long playerPowerSF = 0;
    long playerPowerPF = 0;
    long playerPowerC = 0;
    
    // Calculate the total power of all players in the team
    for (String player : team.getPickedList()) {
    	
        BufferedReader brPG;
		try {
			brPG = new BufferedReader(new FileReader("powersOfPG.txt"));
            while ((line = brPG.readLine()) != null) {
            	 String[] values = line.split(", ");
            	 if (values[0].equals(player)) {
					String playerPower1String = values[1];
					playerPowerPG = Long.parseLong(playerPower1String);
					
 
				}
            	 else {
					continue;
				}

            }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        BufferedReader brSG;
		try {
			brSG = new BufferedReader(new FileReader("powersOfSG.txt"));
            while ((line = brSG.readLine()) != null) {
              	 String[] values = line.split(", ");
              	 if (values[0].equals(player)) {
   					String playerPower2String = values[1];
   					playerPowerSG = Long.parseLong(playerPower2String);

   				}
              	 else {
              		continue;
   				}

              }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        BufferedReader brSF;
		try {
			brSF = new BufferedReader(new FileReader("powersOfSF.txt"));
            while ((line = brSF.readLine()) != null) {
              	 String[] values = line.split(", ");
              	 if (values[0].equals(player)) {
   					String playerPower3String = values[1];
   					playerPowerSF = Long.parseLong(playerPower3String);

   				}
              	 else {
              		continue;
   				}

              }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        BufferedReader brPF;
		try {
			brPF = new BufferedReader(new FileReader("powersOfPF.txt"));
            while ((line = brPF.readLine()) != null) {
             	 String[] values = line.split(", ");
             	 if (values[0].equals(player)) {
  					String playerPower4String = values[1];
  					playerPowerPF = Long.parseLong(playerPower4String);
  					

  				}
             	 else {
             		continue;
  				}

             }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        BufferedReader brC;
		try {
			brC = new BufferedReader(new FileReader("powersOfC.txt"));
            while ((line = brC.readLine()) != null) {
            	 String[] values = line.split(", ");
            	 if (values[0].equals(player)) {
 					String playerPower5String = values[1];
 					playerPowerC = Long.parseLong(playerPower5String);

 				}
            	 else {
            		continue;
 				}

            }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        totalPower += playerPowerPG;
        totalPower += playerPowerSG;
        totalPower += playerPowerSF;
        totalPower += playerPowerPF;
        totalPower += playerPowerC;
    }

    // You can add more factors or adjust the formula as needed
    // For example, you might want to consider the team's overall chemistry, strategy, etc.

    // Add some randomness to simulate variations in team performance
    double randomness = (random.nextDouble() * 0.1) - 0.05; // Random number between -0.05 and 0.05
    // Random number between -0.05 and 0.05

    // Calculate the final team score
    long teamScore = Math.round(totalPower * (1 + randomness));

    return teamScore;
}
*/
