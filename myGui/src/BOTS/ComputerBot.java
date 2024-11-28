package BOTS;
import java.util.ArrayList;
import java.util.Random;


public class ComputerBot{
	public static String line = "";
	public static ArrayList<String> pGBoxArrayList = new ArrayList<String>();
    public static ArrayList<String> sGBoxArrayList = new ArrayList<String>();
    public static ArrayList<String> sFBoxArrayList = new ArrayList<String>();
    public static ArrayList<String> pFBoxArrayList = new ArrayList<String>();
    public static ArrayList<String> cBoxArrayList  = new ArrayList<String>();
    public static ArrayList<String> allteamlogos = new ArrayList<String>();
    
    public static ArrayList<String> pickedList = new ArrayList<String>();
	private String teamName;
	private String SelectedLogo;
	
	
    private static int score;
    
    public ComputerBot(String teamName) {
        pGBoxArrayList = new ArrayList<String>();
        sGBoxArrayList = new ArrayList<String>();
        sFBoxArrayList = new ArrayList<String>();
        pFBoxArrayList = new ArrayList<String>();
        cBoxArrayList = new ArrayList<String>();
        pickedList = new ArrayList<String>();
        this.teamName = teamName;
   }
    public String determineTeamLogo() {
        // Check if there are logos available
        if (!allteamlogos.isEmpty()) {
            // Randomly select a logo index
            Random random = new Random();
            int logoIndex = random.nextInt(allteamlogos.size());

            // Get the selected logo
            SelectedLogo = allteamlogos.get(logoIndex);

            // Remove the selected logo from allteamlogos
            allteamlogos.remove(logoIndex);

            // Return the selected logo
            return SelectedLogo;
        } else {
            // Logos list is empty
            System.out.println("No more logos available.");
            return null; // or throw an exception or handle as needed
        }
    }
    public static ArrayList<String> getAllteamlogos() {
		return allteamlogos;
	}
	public static void setAllteamlogos(ArrayList<String> allteamlogos) {
		ComputerBot.allteamlogos = allteamlogos;
	}
	public String getSelectedLogo() {
		return SelectedLogo;
	}
	public void setSelectedLogo(String selectedLogo) {
		SelectedLogo = selectedLogo;
	}
	public int getScore() {

        return score;
    }

    public static ArrayList<String> getPickedList() {
		return pickedList;
	}

	public static void setPickedList(ArrayList<String> pickedList) {
		ComputerBot.pickedList = pickedList;
	}
	public static void setScore(int score) {
		ComputerBot.score = score;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}

	public void incrementScore(int points) {
        score += points;
    }
    
    
    private int wins;
    private int losses;

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public void incrementWins() {
        wins++;
    }

    public void incrementLosses() {
        losses++;
    }
 public static String getLine() {
		return line;
	}

	public static void setLine(String line) {
		ComputerBot.line = line;
	}

	public static ArrayList<String> getpGBoxArrayList() {
		return pGBoxArrayList;
	}

	public static void setpGBoxArrayList(ArrayList<String> pGBoxArrayList) {
		ComputerBot.pGBoxArrayList = pGBoxArrayList;
	}

	public static ArrayList<String> getsGBoxArrayList() {
		return sGBoxArrayList;
	}

	public static void setsGBoxArrayList(ArrayList<String> sGBoxArrayList) {
		ComputerBot.sGBoxArrayList = sGBoxArrayList;
	}

	public static ArrayList<String> getsFBoxArrayList() {
		return sFBoxArrayList;
	}

	public static void setsFBoxArrayList(ArrayList<String> sFBoxArrayList) {
		ComputerBot.sFBoxArrayList = sFBoxArrayList;
	}

	public static ArrayList<String> getpFBoxArrayList() {
		return pFBoxArrayList;
	}

	public static void setpFBoxArrayList(ArrayList<String> pFBoxArrayList) {
		ComputerBot.pFBoxArrayList = pFBoxArrayList;
	}

	public static ArrayList<String> getcBoxArrayList() {
		return cBoxArrayList;
	}

	public static void setcBoxArrayList(ArrayList<String> cBoxArrayList) {
		ComputerBot.cBoxArrayList = cBoxArrayList;
	}

	public static ArrayList<String> getTeamlogos() {
		return allteamlogos;
	}

	public static void setTeamlogos(ArrayList<String> teamlogos) {
		ComputerBot.allteamlogos = teamlogos;
	}

	public String getName() {
		return teamName;
	}

	public void setName(String teamName) {
		this.teamName = teamName;
	}

}

