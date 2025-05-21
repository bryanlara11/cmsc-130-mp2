import java.util.Scanner;

/**
 * Implementation of a D-type flip-flop
 * The D flip-flop (Data flip-flop) has a single input D and stores its value
 * at the next clock edge. It follows the truth table:
 * D | Q(next)
 * 0 | 0
 * 1 | 1
 */
public class DFlipFlop implements FlipFlop {
    // Previous and current values for input D
    private int prevD = 0, currD = 0;
    // Previous and current values for output Q
    private int prevQ = 0, currQ = 0;
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void input() {
        // Get D input from user (0 or 1)
        System.out.println("Enter D input (0 or 1): ");
        String dInput = scanner.nextLine().trim();
        if (dInput.equals("0"))
            currD = 0;
        else if (dInput.equals("1"))
            currD = 1;
        else {
            System.out.println("Invalid input, using 0");
            currD = 0;
        }
        
        // Display a countdown for 3 seconds before resetting input
        System.out.println("\nInput will reset in 3 seconds...");
        for (int i = 3; i > 0; i--) {
            try {
                Thread.sleep(1000);
                System.out.println(i + "...");
            } catch (InterruptedException e) {
                // Ignore interruption
            }
        }
        currD = 0;
        System.out.println("Input reset to 0");
    }

    @Override
    public void update() {
        // Store previous values
        prevD = currD;
        prevQ = currQ;
        // D flip-flop simply copies input D to output Q
        currQ = currD;
    }

    @Override
    public void displayState() {
        // Display the current state of the flip-flop
        System.out.println("D Flip-Flop");
        System.out.println("Previous Input: D=" + prevD);
        System.out.println("Current Input : D=" + currD);
        System.out.println("Previous Output: Q=" + prevQ);
        System.out.println("Current Output : Q=" + currQ);
    }

    @Override
    public String getPresentState() {
        return "Q=" + prevQ;
    }

    @Override
    public String getInputs() {
        return "D=" + currD;
    }

    @Override
    public String getNextState() {
        return "Q=" + currQ;
    }

    @Override
    public String getFlipFlopInputs() {
        return "D=" + currD;
    }
}
