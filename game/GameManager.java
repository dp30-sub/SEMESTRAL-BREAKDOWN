import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

class GameManager {
    private Player player;
    private Scanner scanner;
    private Random random;
    private String[] randomEvents = {
        "EXAM_WEEK", "ALLOWANCE_DELAY", "POWER_OUTAGE", "RAINY_DAY", "GOOD_DAY"
    };
    private String[] dayLog = new String[30];
    private int[] gradeHistory = new int[30];
    private int[] energyHistory = new int[30];
    private int[] stressHistory = new int[30];
    private int[] moneyHistory = new int[30];

    public GameManager() {
        scanner = new Scanner(System.in);
        random = new Random();
    }
    
    public void startGame() {
        showWelcome();
        Difficulty difficulty = selectDifficulty(); // ADDED DIFFICULTY SELECTION
        player = createPlayer(difficulty); // MODIFIED TO ACCEPT DIFFICULTY
        gameLoop();
        showGameResult();
        scanner.close();
    }
    
    private void showWelcome() {
        System.out.println("========================================");
        System.out.println("         CAMPUS SHOWDOWN");
        System.out.println("========================================");
        System.out.print("Press Enter to continue...");
        scanner.nextLine();
    }
    
    // MODIFIED TO ACCEPT DIFFICULTY PARAMETER
    public Player createPlayer(Difficulty difficulty) {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        try {
            if (name.trim().isEmpty()) {
                throw new IllegalArgumentException("Name cannot be empty!");
            }
            System.out.println("Welcome, " + name + "! (" + difficulty + " mode)");
            System.out.println("Starting with: " + difficulty.getStartingMoney() + 
                             " pesos, Energy: " + difficulty.getStartingEnergy() + "%");
            return new Player(name, difficulty);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Using 'Student' instead.");
            return new Player("Student", difficulty);
        }
    }

    // MOVED selectDifficulty METHOD TO PROPER LOCATION
    private Difficulty selectDifficulty() {
        System.out.println("\nSELECT DIFFICULTY:");
        System.out.println("1. NORMAL - Balanced challenge (₱1000, 100 Energy)");
        System.out.println("2. HARD   - Limited resources, requires strategy (₱500, 80 Energy)");
        System.out.print("Choose difficulty (1-2): ");
        
        try {
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1: 
                    System.out.println("NORMAL difficulty selected.");
                    return Difficulty.NORMAL;
                case 2: 
                    System.out.println("HARD difficulty selected. Good luck!");
                    return Difficulty.HARD;
                default: 
                    System.out.println("Invalid choice. Using NORMAL difficulty.");
                    return Difficulty.NORMAL;
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Using NORMAL difficulty.");
            scanner.nextLine();
            return Difficulty.NORMAL;
        }
    }
    
    private void gameLoop() {
        while (player.getDay() <= 30 && !isGameOver()) {
            displayGameStatus();
            showActivityMenu();
            handlePlayerChoice();
            triggerRandomEvent();
            
            // STORE HISTORY DATA
            int currentDay = player.getDay() - 1;
            if (currentDay >= 0 && currentDay < 30) {
                gradeHistory[currentDay] = player.getGrades();
                energyHistory[currentDay] = player.getEnergy();
                stressHistory[currentDay] = player.getStress();
                moneyHistory[currentDay] = player.getMoney();
            }
            
            player.setDay(player.getDay() + 1);
            
            int dayIndex = player.getDay() - 1; // since array index starts at 0

            dayLog[dayIndex] = player.getLastActionName(); // record what they did today
            gradeHistory[dayIndex] = player.getGrades();
            energyHistory[dayIndex] = player.getEnergy();
            stressHistory[dayIndex] = player.getStress();
            moneyHistory[dayIndex] = player.getMoney();

            // Add a small pause between days
            if (player.getDay() <= 30 && !isGameOver()) {
                System.out.println("\nPress Enter to continue to next day...");
                scanner.nextLine();
            }
        }
    }
    
    private void displayGameStatus() {
        System.out.println("\n========================================");
        System.out.println("Day: " + player.getDay() + "/30    Name: " + player.getName());
        System.out.println("Difficulty: " + player.getDifficulty()); // ADDED DIFFICULTY DISPLAY
        System.out.println("Money: " + player.getMoney());
        System.out.println("Energy: " + player.getEnergy() + "%");
        System.out.println("Stress: " + player.getStress() + "%");
        System.out.println("Grades: " + player.getGrades() + "% (Need: " + 
                         player.getDifficulty().getMinPassingGrade() + "%)"); // ADDED MIN GRADE
        System.out.println("========================================");
    }
    
    private void showActivityMenu() {
        System.out.println("DAILY ACTIVITIES:");
        Action[] activities = player.getActivities();
        
        for (int i = 0; i < player.getActivityCount(); i++) {
            System.out.println((i + 1) + ". " + activities[i].getName());
        }
        System.out.println((player.getActivityCount() + 1) + ". Skip to Next Day");
        System.out.print("Choose an activity: ");
    }
    
    private void handlePlayerChoice() {
        try {
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            if (choice == player.getActivityCount() + 1) {
                System.out.println("Day " + player.getDay() + " completed!");
                return;
            }
            
            if (choice > 0 && choice <= player.getActivityCount()) {
                performActivityEffects(choice - 1);
            } else {
                throw new InputMismatchException("Invalid choice!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid number!");
            scanner.nextLine();
            handlePlayerChoice();
        }
    }
    
    private void performActivityEffects(int activityIndex) {
        player.performActivity(activityIndex);
        
        // Ensure stats stay within bounds
        player.setEnergy(Math.min(100, Math.max(0, player.getEnergy())));
        player.setStress(Math.min(100, Math.max(0, player.getStress())));
        player.setGrades(Math.min(100, Math.max(0, player.getGrades())));
    }
    
    private void triggerRandomEvent() {
        // USE DIFFICULTY-BASED PROBABILITY
        double probability = player.getDifficulty().getEventProbability();
        if (random.nextDouble() < probability) {
            String event = randomEvents[random.nextInt(randomEvents.length)];
            handleRandomEvent(event);
        }
    }
    
    private void handleRandomEvent(String event) {
        System.out.println("\nRANDOM EVENT: " + event);
        
        switch (event) {
            case "EXAM_WEEK":
                player.setStress(player.getStress() + 10);
                System.out.println("Exam week is here! Stress increased by 10%.");
                break;
            case "ALLOWANCE_DELAY":
                player.setMoney(Math.max(0, player.getMoney() - 500));
                System.out.println("Your allowance is delayed! Lost 500 pesos.");
                break;
            case "POWER_OUTAGE":
                player.setEnergy(player.getEnergy() + 10);
                player.setStress(player.getStress() - 5);
                System.out.println("Power outage! No studying today. Energy +10%, Stress -5%.");
                break;
            case "RAINY_DAY":
                player.setEnergy(player.getEnergy() - 15);
                player.setStress(player.getStress() + 5);
                System.out.println("Rainy day! Can't go out. Energy -15%, Stress +5%.");
                break;
            case "GOOD_DAY":
                player.setMoney(player.getMoney() + 300);
                player.setStress(player.getStress() - 10);
                System.out.println("It's a good day! Found some money and feel less stressed. Money +300, Stress -10%.");
                break;
        }
        
        // Ensure stats stay within bounds after random event
        player.setEnergy(Math.min(100, Math.max(0, player.getEnergy())));
        player.setStress(Math.min(100, Math.max(0, player.getStress())));
        player.setGrades(Math.min(100, Math.max(0, player.getGrades())));
    }
    
    private boolean isGameOver() {
        // USE DIFFICULTY-BASED GRADE CHECK
        if (player.getEnergy() <= 0) {
            System.out.println("You collapsed from exhaustion! Game Over.");
            return true;
        }
        if (player.getMoney() <= 0) {
            System.out.println("You ran out of money! Cannot continue studies.");
            return true;
        }
        if (player.hasFailed()) {
            System.out.println("Your grades dropped too low! Academic failure.");
            return true;
        }
        return false;
    }
    
    private void showGameResult() {
        System.out.println("\n========================================");
        System.out.println("           SEMESTER COMPLETED!");
        System.out.println("========================================");
        
        if (player.getEnergy() <= 0) {
            System.out.println("RESULT: COLLAPSED FROM EXHAUSTION!");
        } else if (player.getMoney() <= 0) {
            System.out.println("RESULT: FINANCIAL CRISIS!");
        } else if (player.hasFailed()) {
            System.out.println("RESULT: ACADEMIC FAILURE!");
        } else {
            System.out.println("RESULT: SUCCESS!");
            System.out.println("Final Stats:");
            System.out.println("Money: " + player.getMoney() + " pesos");
            System.out.println("Energy: " + player.getEnergy() + "%");
            System.out.println("Stress: " + player.getStress() + "%");
            System.out.println("Grades: " + player.getGrades() + "%");
            
            // Calculate score
            int score = player.getMoney() + player.getEnergy() + (100 - player.getStress()) + player.getGrades();
            System.out.println("Total Score: " + score);
            
            // SHOW HISTORY SUMMARY (OPTIONAL)
            showHistorySummary();
        }
    }

    // ADDED METHOD TO SHOW HISTORY
    private void showHistorySummary() {
        System.out.println("\n--- SEMESTER SUMMARY ---");
        System.out.println("Starting Grades: " + gradeHistory[0] + "%");
        System.out.println("Final Grades: " + player.getGrades() + "%");
        System.out.println("Grade Improvement: " + (player.getGrades() - gradeHistory[0]) + "%");
    }
}