package PlayerTypes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Player {

    public static void main(String[] args) {
        String path = "2022-2023 NBA Player Stats - Regular.csv";
        String line = "";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            BufferedWriter bwC = new BufferedWriter(new FileWriter("playerpositionC.txt"));
            BufferedWriter bwPF = new BufferedWriter(new FileWriter("playerpositionPF.txt"));
            BufferedWriter bwSF = new BufferedWriter(new FileWriter("playerpositionSF.txt"));
            BufferedWriter bwPG = new BufferedWriter(new FileWriter("playerpositionPG.txt"));
            BufferedWriter bwSG = new BufferedWriter(new FileWriter("playerpositionSG.txt"));
            
            Set<String> playerswithTOT = new HashSet<>();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");

                if (values.length > 4 && values[4].equals("TOT")) {
                    String playerName = values[1];

                    // Check if the player with the same name and "TOT" is not processed yet
                    if (!playerswithTOT.contains(playerName)) {
                        playerswithTOT.add(playerName);

                        // Write the line to the corresponding position file
                        if (values[2].contains("C")) {
                            bwC.write(line);
                            bwC.newLine();
                        } else if (values[2].contains("PF")) {
                            bwPF.write(line);
                            bwPF.newLine();
                        } else if (values[2].contains("SF")) {
                            bwSF.write(line);
                            bwSF.newLine();
                        } else if (values[2].contains("PG")) {
                            bwPG.write(line);
                            bwPG.newLine();
                        } else if (values[2].contains("SG")) {
                            bwSG.write(line);
                            bwSG.newLine();
                        }
                    }
					
                }
                
                else if (!playerswithTOT.contains(values[1]) && !values[4].equals("TOT")){
               	 if (values.length > 2) {
                        if (values[2].contains("C")) {
                            bwC.write(line);
                            bwC.newLine();
                        } else if (values[2].contains("PF")) {
                            bwPF.write(line);
                            bwPF.newLine();
                        } else if (values[2].contains("SF")) {
                            bwSF.write(line);
                            bwSF.newLine();
                        } else if (values[2].contains("PG")) {
                            bwPG.write(line);
                            bwPG.newLine();
                        } else if (values[2].contains("SG")) {
                            bwSG.write(line);
                            bwSG.newLine();
                        }
                    }
                }
            }

            bwC.close();
            bwPF.close();
            bwSF.close();
            bwPG.close();
            bwSG.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
