package Matches;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import BOTS.ComputerBot;

public class Matchmaking {

    static void determineGameWinner(ComputerBot team1, ComputerBot team2) {
        Random random = new Random();
        
        long team1Score = calculateTeamScore(team1, random);
        long team2Score = calculateTeamScore(team2, random);

        // Multiply the home team's score by 1.05
        boolean team1IsHome = random.nextBoolean();
        if (team1IsHome) {
            team1Score *= 1.05;
        } else {
            team2Score *= 1.05;
        }
        String gameResult;
        // Determine the winner
        if (team1Score > team2Score) {
        	gameResult = "Game: " + "Team1 Name: "+team1.getName() + " vs " + "Team2 Name: "+team2.getName() + " - Winner: " + team1.getName();
            // Team 1 wins
            updateTeamStats(team1, team2);
        } else if (team2Score > team1Score) {
            // Team 2 wins
        	gameResult = "Game: " + "Team1 Name: "+team1.getName() + " vs " + "Team2 Name: "+team2.getName() + " - Winner: " + team2.getName();
            updateTeamStats(team2, team1);
        } else {
            // It's a tie - randomly pick a winner and increment their score
            boolean randomWinnerIsTeam1 = random.nextBoolean();
            if (randomWinnerIsTeam1) {
            	gameResult =  "Game: " + "Team1 Name: "+team1.getName() + " vs " + "Team2 Name: "+team2.getName() + " - Winner: " + team1.getName();
                updateTeamStats(team1, team2);
            } else {
            	gameResult =  "Game: " + "Team1 Name: "+team1.getName() + " vs " + "Team2 Name: "+team2.getName() + " - Winner: " + team2.getName();
                updateTeamStats(team2, team1);
            }
            // Increment the winning team's score with a random number between 1 and 10
            ComputerBot winningTeam = randomWinnerIsTeam1 ? team1 : team2;
            winningTeam.incrementScore(random.nextInt(10) + 1);
        }
        System.out.println(gameResult);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("game_results.txt", true))) {
            writer.write(gameResult);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void playRandomGames(ArrayList<ComputerBot> teams) {
    	SimulationControl.matchCount++;

        Random random = new Random();
        int numTeams = teams.size();
        

        for (int i = 0; i < 2 * numTeams; i++) {
            int team1Index = random.nextInt(numTeams);
            int team2Index;
            do {
                team2Index = random.nextInt(numTeams);
            } while (team2Index == team1Index);
            
            determineGameWinner(teams.get(team1Index), teams.get(team2Index));
        }
    }
    
    private static void updateTeamStats(ComputerBot winner, ComputerBot loser) {
        // Update the stats of the winning and losing teams
        // For example, you can increment the wins for the winner and losses for the loser
        winner.incrementWins();
        loser.incrementLosses();
    }

    private static long readPlayerPower(String fileName, String playerName) {
        long playerPower = 0;
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(", ");
                if (values[0].equals(playerName)) {
                    playerPower = Long.parseLong(values[1]);
                    break; // Stop reading once the player is found
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }

        return playerPower;
    }

    private static long calculateTeamScore(ComputerBot team, Random random) {
        long totalPower = 0;
        String playerName;

        for (String player : team.getPickedList()) {
            playerName = player;

            totalPower += readPlayerPower("powersOfPG.txt", playerName);
            totalPower += readPlayerPower("powersOfSG.txt", playerName);
            totalPower += readPlayerPower("powersOfSF.txt", playerName);
            totalPower += readPlayerPower("powersOfPF.txt", playerName);
            totalPower += readPlayerPower("powersOfC.txt", playerName);
        }

        double randomness = (random.nextDouble() * 0.1) - 0.05;
        long teamScore = Math.round(totalPower * (1 + randomness));

        return teamScore;
    }
    
    static ComputerBot playoffMatchDetermineWinnerTEAM(ComputerBot team1, ComputerBot team2) {
        Random random = new Random();
        long team1Score = calculateTeamScore(team1, random);
        long team2Score = calculateTeamScore(team2, random);
        
        String gameResult;

        // Multiply the home team's score by 1.05
        boolean team1IsHome = random.nextBoolean();
        if (team1IsHome) {
            team1Score *= 1.05;
        } else {
            team2Score *= 1.05;
        }

        // Determine the winner
        if (team1Score > team2Score) {
        	gameResult = "Game: " + "Team1 Name: "+team1.getName() + " vs " + "Team2 Name: "+team2.getName() + " - Winner: " + team1.getName();
        	writeGameResultToFile(gameResult);
        	return team1;

        } else if (team2Score > team1Score) {
        	gameResult = "Game: " + "Team1 Name: "+team1.getName() + " vs " + "Team2 Name: "+team2.getName() + " - Winner: " + team2.getName();
        	writeGameResultToFile(gameResult);
        	return team2;

        } else {
            // It's a tie - randomly pick a winner and increment their score
            boolean randomWinnerIsTeam1 = random.nextBoolean();
            if (randomWinnerIsTeam1) {
            	gameResult = "Game: " + "Team1 Name: "+team1.getName() + " vs " + "Team2 Name: "+team2.getName() + " - Winner: " + team1.getName();
            	writeGameResultToFile(gameResult);
                return team1;
            } else {
            	gameResult = "Game: " + "Team1 Name: "+team1.getName() + " vs " + "Team2 Name: "+team2.getName() + " - Winner: " + team2.getName();
            	writeGameResultToFile(gameResult);

                return team2;
            }
        }
        

     }
    
    private static void writeGameResultToFile(String gameResult) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("playoff_results.txt", true))) {
            writer.write(gameResult);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
