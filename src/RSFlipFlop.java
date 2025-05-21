import java.util.Scanner;

public class RSFlipFlop implements FlipFlop {
    private int prevR = 0, prevS = 0;
    private int currR = 0, currS = 0;
    private int prevQ = 0, currQ = 0;
    private int prevQnot = 1, currQnot = 1;
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void input() {
        System.out.println("Enter R input (0 or 1): ");
        String rInput = scanner.nextLine().trim();
        if (rInput.equals("0"))
            currR = 0;
        else if (rInput.equals("1"))
            currR = 1;
        else {
            System.out.println("Invalid input, using 0");
            currR = 0;
        }
        System.out.println("Enter S input (0 or 1): ");
        String sInput = scanner.nextLine().trim();
        if (sInput.equals("0"))
            currS = 0;
        else if (sInput.equals("1"))
            currS = 1;
        else {
            System.out.println("Invalid input, using 0");
            currS = 0;
        }
    }

    @Override
    public void update() {
        prevR = currR;
        prevS = currS;
        prevQ = currQ;
        prevQnot = currQnot;
        if (currR == 0 && currS == 0) {
            currQ = prevQ;
            currQnot = prevQnot;
        } else if (currR == 0 && currS == 1) {
            currQ = 1;
            currQnot = 0;
        } else if (currR == 1 && currS == 0) {
            currQ = 0;
            currQnot = 1;
        } else {
            System.out.println("Invalid input (R=1 and S=1). Output is undefined.");
            currQ = 0;
            currQnot = 0;
        }
    }

    @Override
    public void displayState() {
        System.out.println("RS Flip-Flop");
        System.out.println("Previous Inputs: R=" + prevR + ", S=" + prevS);
        System.out.println("Current Inputs : R=" + currR + ", S=" + currS);
        System.out.println("Previous Outputs: Q=" + prevQ + ", Q'=" + prevQnot);
        System.out.println("Current Outputs : Q=" + currQ + ", Q'=" + currQnot);
    }

    @Override
    public String getPresentState() {
        return "Q=" + prevQ + ", Q'=" + prevQnot;
    }

    @Override
    public String getInputs() {
        return "R=" + currR + ", S=" + currS;
    }

    @Override
    public String getNextState() {
        return "Q=" + currQ + ", Q'=" + currQnot;
    }

    @Override
    public String getFlipFlopInputs() {
        return "R=" + currR + ", S=" + currS;
    }
}
