import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("SEMESTER SHOWDOWN STARTING...");
        GameManager game = new GameManager();
        game.startGame();
        game.createPlayer();
    }
}

public class GameManager {
    private Scanner scanner;
    
    public GameManager() {
        scanner = new Scanner(System.in);
    }
    
    public void startGame() {
        System.out.println("Welcome to Campus Showdown!");
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
            return new Player(name);  
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Using 'Student' instead.");
            return new Player("Student"); 
        }
    }
}