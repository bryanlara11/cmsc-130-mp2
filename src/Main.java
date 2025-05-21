import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main class for the Flip-Flop Simulator
 * This program simulates different types of flip-flops (RS, D, JK, T)
 * and allows users to input signals and observe their behavior
 */
public class Main {
    // Scanner object for user input
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getMenuChoice();

            // Handle user's flip-flop selection
            switch (choice) {
                case 1:
                    runFlipFlop(new RSFlipFlop());
                    break;
                case 2:
                    runFlipFlop(new DFlipFlop());
                    break;
                case 3:
                    runFlipFlop(new JKFlipFlop());
                    break;
                case 4:
                    runFlipFlop(new TFlipFlop());
                    break;
                case 5:
                    System.out.println("\nThank you for using Flip-Flop Simulator!");
                    running = false;
                    break;
                default:
                    System.out.println("\nInvalid selection. Please try again.");
            }
        }
    }

    /**
     * Displays the main menu of available flip-flop types
     */
    private static void displayMenu() {
        System.out.println("Available Flip-Flop Types:");
        System.out.println("1. RS Flip-Flop");
        System.out.println("2. D Flip-Flop");
        System.out.println("3. JK Flip-Flop");
        System.out.println("4. T Flip-Flop");
        System.out.println("5. Exit");
        System.out.print("\nSelect flip-flop type (1-5): ");
    }

    /**
     * Gets and validates the user's menu choice
     * @return The user's selection (1-5) or -1 for invalid input
     */
    private static int getMenuChoice() {
        int choice = -1;
        try {
            String line = scanner.nextLine().trim();
            choice = Integer.parseInt(line);
        } catch (Exception e) {
            // Invalid input, return -1 to retry
        }
        return choice;
    }

    /**
     * Runs the simulation for the selected flip-flop type
     * @param flipFlop The flip-flop instance to simulate
     */
    private static void runFlipFlop(FlipFlop flipFlop) {
        boolean running = true;
        // ArrayList to store the history of states for display
        ArrayList<String> stateHistory = new ArrayList<>();

        while (running) {
            // Get input and update state
            flipFlop.input();
            flipFlop.update();

            // Format and store the current state information
            String stateRow = String.format("%-15s %-15s %-15s %-15s",
                    flipFlop.getPresentState(),
                    flipFlop.getInputs(),
                    flipFlop.getNextState(),
                    flipFlop.getFlipFlopInputs());
            stateHistory.add(stateRow);

            // Display the complete state table
            System.out.println("\nState Table:");
            System.out.println("Present State    Input          Next State     Flip-Flop Inputs");
            System.out.println("------------------------------------------------------------");
            for (String row : stateHistory) {
                System.out.println(row);
            }

            // Ask user if they want to continue with current flip-flop
            System.out.print("\nContinue with current flip-flop? (y/n): ");
            String cont = scanner.nextLine().trim().toLowerCase();
            if (!cont.equals("y"))
                running = false;
        }
    }
}
