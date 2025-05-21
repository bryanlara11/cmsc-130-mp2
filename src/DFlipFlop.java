import java.util.Scanner;

public class DFlipFlop implements FlipFlop {
    private int prevD = 0, currD = 0;
    private int prevQ = 0, currQ = 0;
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void input() {
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
    }

    @Override
    public void update() {
        prevD = currD;
        prevQ = currQ;
        currQ = currD;
    }

    @Override
    public void displayState() {
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
