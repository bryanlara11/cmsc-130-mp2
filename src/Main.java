import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getMenuChoice();

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

    private static void displayMenu() {
        System.out.println("Available Flip-Flop Types:");
        System.out.println("1. RS Flip-Flop");
        System.out.println("2. D Flip-Flop");
        System.out.println("3. JK Flip-Flop");
        System.out.println("4. T Flip-Flop");
        System.out.println("5. Exit");
        System.out.print("\nSelect flip-flop type (1-5): ");
    }

    private static int getMenuChoice() {
        int choice = -1;
        try {
            String line = scanner.nextLine().trim();
            choice = Integer.parseInt(line);
        } catch (Exception e) {
            // invalid input, return -1 to retry
        }
        return choice;
    }

    private static void runFlipFlop(FlipFlop flipFlop) {
        boolean running = true;
        ArrayList<String> stateHistory = new ArrayList<>();

        while (running) {
            // Get input and update state
            flipFlop.input();
            flipFlop.update();

            // Add current state to history
            String stateRow = String.format("%-15s %-15s %-15s %-15s",
                    flipFlop.getPresentState(),
                    flipFlop.getInputs(),
                    flipFlop.getNextState(),
                    flipFlop.getFlipFlopInputs());
            stateHistory.add(stateRow);

            // Display complete state table
            System.out.println("\nState Table:");
            System.out.println("Present State    Input          Next State     Flip-Flop Inputs");
            System.out.println("------------------------------------------------------------");
            for (String row : stateHistory) {
                System.out.println(row);
            }

            System.out.print("\nContinue with current flip-flop? (y/n): ");
            String cont = scanner.nextLine().trim().toLowerCase();
            if (!cont.equals("y"))
                running = false;
        }
    }
}
