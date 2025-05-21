import java.util.Scanner;

public class RSFlipFlop implements FlipFlop {
    private int prevR = 0, prevS = 0;
    private int currR = 0, currS = 0;
    private int prevQ = 0, currQ = 0;
    private int prevQprime = 1, currQprime = 1;
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void input() {
        System.out.println("Enter R input (0 or 1): ");
        String rInput = scanner.nextLine();
        if (rInput.equals("0"))
            currR = 0;
        else if (rInput.equals("1"))
            currR = 1;
        else {
            System.out.println("Invalid input, using 0");
            currR = 0;
        }
        System.out.println("Enter S input (0 or 1): ");
        String sInput = scanner.nextLine();
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
        prevQprime = currQprime;
        if (currR == 0 && currS == 0) {
            currQ = prevQ;
            currQprime = prevQprime;
        } else if (currR == 1 && currS == 0) {
            currQ = 0;
            currQprime = 1;
        } else if (currR == 0 && currS == 1) {
            currQ = 1;
            currQprime = 0;
        } else if (currR == 1 && currS == 1) {
            System.out.println("When R and S are both 1, the output is undefined.");
            currQ = 0;
            currQprime = 1;
        }
    }

    @Override
    public void displayState() {
        System.out.println("RS Flip-Flop");
        System.out.println("Previous Inputs: R=" + prevR + ", S=" + prevS);
        System.out.println("Current Inputs : R=" + currR + ", S=" + currS);
        System.out.println("Previous Outputs: Q=" + prevQ + ", Q'=" + prevQprime);
        System.out.println("Current Outputs : Q=" + currQ + ", Q'=" + currQprime);
    }

    @Override
    public String getPresentState() {
        return "Q=" + prevQ + ", Q'=" + prevQprime;
    }

    @Override
    public String getInputs() {
        return "R=" + currR + ", S=" + currS;
    }

    @Override
    public String getNextState() {
        if (currR == 1 && currS == 1) {
            return "?";
        }
        return "Q=" + currQ + ", Q'=" + currQprime;
    }

    @Override
    public String getFlipFlopInputs() {
        return "R=" + currR + ", S=" + currS;
    }

    @Override
    public void resetInputs() {
        currR = 0;
        currS = 0;
        System.out.println("Input signals resetting to 0 in...");
        for (int i = 3; i >= 0; i--) {
            System.out.println(i);
        }
        System.out.println("Successfully reset inputs");
    }
}
