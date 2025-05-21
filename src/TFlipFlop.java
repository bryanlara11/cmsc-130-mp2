import java.util.Scanner;

public class TFlipFlop implements FlipFlop {
    private int prevT = 0, currT = 0;
    private int prevQ = 0, currQ = 0;
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void input() {
        System.out.println("Enter T input (0 or 1): ");
        String tInput = scanner.nextLine().trim();
        if (tInput.equals("0"))
            currT = 0;
        else if (tInput.equals("1"))
            currT = 1;
        else {
            System.out.println("Invalid input, using 0");
            currT = 0;
        }
    }

    @Override
    public void update() {
        prevT = currT;
        prevQ = currQ;
        if (currT == 0)
            currQ = prevQ;
        else
            currQ = (prevQ == 0) ? 1 : 0;
    }

    @Override
    public void displayState() {
        System.out.println("T Flip-Flop");
        System.out.println("Previous Input: T=" + prevT);
        System.out.println("Current Input : T=" + currT);
        System.out.println("Previous Output: Q=" + prevQ);
        System.out.println("Current Output : Q=" + currQ);
    }

    @Override
    public String getPresentState() {
        return "Q=" + prevQ;
    }

    @Override
    public String getInputs() {
        return "T=" + currT;
    }

    @Override
    public String getNextState() {
        return "Q=" + currQ;
    }

    @Override
    public String getFlipFlopInputs() {
        return "T=" + currT;
    }
}
