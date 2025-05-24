# 🏀 NBA Game Simulation - Advanced Programming Project

**Experience the thrill of managing your own NBA fantasy team! This Java Swing application allows users to sign up, draft players, simulate seasons and playoffs, and track their team's progress.**

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](https://opensource.org/licenses/MIT) ![NBA Game Simulation Demo](path/to/your/cool_nba_simulation_demo.gif)

## ✨ Project Overview

The `NBAGameSimulation` is a Java-based, GUI-driven fantasy sports game centered around the NBA. Built using Object-Oriented Programming principles and the Java Swing framework, it allows users to create accounts, draft their dream teams from a loaded player database, simulate a full NBA season followed by playoffs, and view their team's performance. The application features user management, a strategic player drafting mechanism, a simulation engine with random game outcomes, and detailed logging of all key events.

## 🚀 Key Features

* **User Management:**
    * User registration with validation for nickname, password (at least 8 characters with letters, numbers, and special characters), real name (at least 3 letters), surname (at least 3 letters), age (at least 12), and email (correct format).
    * Secure user login using credentials stored in `users.txt`.
    * Option to change personal information (excluding name and nickname).
    * GUI pages for user creation, login, and information modification.
    * Default profile photo for users without a custom one.
* **Player Database:**
    * Reads player data from a provided CSV file (`players.csv` - assumed based on the "Player" section).
    * Represents players with attributes like Name, Position (PG, SG, SF, PF, C), PTS, TRB, AST, BLK, and STL.
    * Calculates player scores based on randomly selected values within a range of their stats, weighted by position-specific importance.
    * Handles duplicate player entries by averaging their stats.
* **Team Management & Drafting:**
    * Teams have a logo and a name (user-created team and computer-controlled teams).
    * A drafting mechanism where teams pick players in a randomized, snake-draft style.
    * The user gets to pick their players through a GUI interface (likely using `JComboBox`).
    * Computer teams draft players using a basic strategy.
    * Ensures each team has a minimum of 5 and a maximum of 15 players, covering all five positions.
    * A dedicated GUI page to visualize the available players during the draft.
* **Match & Season Simulation:**
    * Matchmaking involves each team playing a set number of random games.
    * Determines game winners by comparing team scores, with a home-team advantage.
    * Simulates a playoff system for the top 8 teams based on regular season wins.
    * Presents a basic playoff bracket GUI.
    * Includes a Pause/Resume button during simulation.
    * A GUI page displays the current season standings (wins, losses, ties).
* **Logging:**
    * Detailed logging of user account creation and modification in `users.txt`.
    * Logging of drafted player information for each team in `draft_results.txt`.
    * Logging of all played games, scores, and winners during the regular season and playoffs in separate files (implementation detail in `Matchmaking.java`).
    * Logging of the final champion.
* **Graphical User Interface (GUI):**
    * Intuitive GUI design using Java Swing components (`JTextField`, `JButton`, `JComboBox`, `JOptionPane`, `JLabel`, `JPanel`, `ImageIcon`, `Timer`).
    * Welcome stage with login and signup options.
    * Drafting page allowing user player selection.
    * Team viewing page displaying user's team members and their details.
    * Match/Season screen showing game results and standings with Pause/Resume functionality.
    * Playoff bracket visualization.
    * Loading animation during match simulation.
* **Object-Oriented Design:**
    * Utilizes inheritance and type hierarchies (e.g., `Player` and position-specific subclasses).
    * Applies polymorphism through abstract classes and interfaces (though specific examples aren't detailed in the report).
    * Extensive use of Java Collections Framework (e.g., `ArrayList`, `Set`).
    * Proper exception handling and file processing for player stats and logging.
    * Comprehensive code documentation (though the report focuses on class descriptions).

## 🛠️ Getting Started - Join the League!

### Prerequisites

* Java Development Kit (JDK) installed on your system.

### Installation

1.  Clone the repository (if applicable):

    ```bash
    git clone [https://github.com/yourusername/yourrepo.git](https://github.com/yourusername/yourrepo.git)
    cd yourrepo
    ```
2.  Ensure the player data CSV file (likely named `players.csv` or similar based on the report's "Player" section) is in the project directory or a location accessible by the program.

### Usage

1.  Navigate to the project's root directory in your terminal.
2.  Compile the Java source files:

    ```bash
    javac -d bin src/myGui/*.java src/nba_simulation/*.java src/playerTypes/*.java src/matches/*.java src/createAccount/*.java src/*.java
    ```
    (Adjust the `src` directory structure if your project has a different organization).
3.  Run the main application:

    ```bash
    java -cp bin nba_simulation.NBAGAME
    ```
    (Assuming `NBAGAME` is your main class within the `nba_simulation` package).

### Demonstration Steps (as per your report)

1.  **Sign up:** Click the "create account" button on the welcome screen and fill in the required details. Ensure you create at least 3 distinct users.
2.  **Log in:** Enter the username and password of an existing user on the login screen.
3.  **Change user information:** After logging in, use the "change account info" button to modify your personal details (excluding name and nickname).
4.  **Draft players:** After logging in, navigate to the team selection and drafting process. Pick your desired players when it's your turn. Observe that only available players can be picked.
5.  **Run simulation:** After drafting, click the "continue" button to start the in-season matches. Observe the results on the match screen.
6.  **View standings:** The match screen will display the current wins/losses/ties for all teams.
7.  **Playoffs:** If your team ranks among the top 8, click the "Continue Playoffs" button to simulate the playoff tournament. Watch the playoff bracket unfold to see the champion.
8.  **Pause/Resume:** During the in-season or playoff simulation, click the "Pause" button. It should be replaced by a "Resume" button. Click "Resume" to continue the simulation.
9.  **View Team:** During the simulation (when paused), click the button to view your current team roster and player details.

## 💾 Log Files

The application generates the following log files:

* `users.txt`: Stores user account information.
* `draft_results.txt`: Records the players drafted by each team.
* Game result logs (filenames may vary based on implementation in `Matchmaking.java`): Logs of individual game scores and winners for both the regular season and playoffs.
* Team standings log (filename may vary): Records the final wins and losses for each team after the regular season.
* Playoff results log (filename may vary): Tracks the winners and losers of each playoff match, culminating in the champion.

## 📄 License

This project is licensed under the [MIT License](https://opensource.org/licenses/MIT).

-----

**Developed with a passion for basketball and object-oriented design!**
