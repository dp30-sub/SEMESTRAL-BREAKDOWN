class GameManager {
    private Player player;
    private Scanner scanner;
    private Random random;
    private String[] randomEvents = {
        "EXAM_WEEK", "ALLOWANCE_DELAY", "POWER_OUTAGE", "RAINY_DAY", "GOOD_DAY"
    };
    
    public GameManager() {
        scanner = new Scanner(System.in);
        random = new Random();
    }
    
    public void startGame() {
        showWelcome();
        player = createPlayer();
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
    
    public Player createPlayer() {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        try {
            if (name.trim().isEmpty()) {
                throw new IllegalArgumentException("Name cannot be empty!");
            }
            System.out.println("Welcome, " + name + "! Your semester begins...");
            return new Player(name);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Using 'Student' instead.");
            return new Player("Student");
        }
    }
    
    private void gameLoop() {
        while (player.getDay() <= 30 && !isGameOver()) {
            displayGameStatus();
            showActivityMenu();
            handlePlayerChoice();
            triggerRandomEvent();
            player.setDay(player.getDay() + 1);
            
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
        System.out.println("Money: " + player.getMoney());
        System.out.println("Energy: " + player.getEnergy() + "%");
        System.out.println("Stress: " + player.getStress() + "%");
        System.out.println("Grades: " + player.getGrades() + "%");
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
        if (random.nextDouble() < 0.3) {
            String event = randomEvents[random.nextInt(randomEvents.length)];
            handleRandomEvent(event);
        }
    }

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