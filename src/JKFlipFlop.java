import java.util.Scanner;

public class JKFlipFlop implements FlipFlop {
    private int prevJ = 0;
    private int prevK = 0;
    private int currJ = 0;
    private int currK = 0;
    private int prevQ = 0;
    private int currQ = 0;
    private int prevQprime = 1;
    private int currQprime = 1;

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void input() {
        System.out.println("Enter J input (0 or 1): ");
        String jInput = scanner.nextLine();
        if (jInput.equals("0")) {
            currJ = 0;
        } else if (jInput.equals("1")) {
            currJ = 1;
        } else {
            System.out.println("Invalid input, using 0");
            currJ = 0;
        }

        System.out.println("Enter K input (0 or 1): ");
        String kInput = scanner.nextLine();
        if (kInput.equals("0")) {
            currK = 0;
        } else if (kInput.equals("1")) {
            currK = 1;
        } else {
            System.out.println("Invalid input, using 0");
            currK = 0;
        }
    }

    @Override
    public void update() {
        prevJ = currJ;
        prevK = currK;
        prevQ = currQ;
        prevQprime = currQprime;

        if (currJ == 0 && currK == 0) {
            currQ = prevQ;
            currQprime = prevQprime;
        } else if (currJ == 0 && currK == 1) {
            currQ = 0;
            currQprime = 1;
        } else if (currJ == 1 && currK == 0) {
            currQ = 1;
            currQprime = 0;
        } else if (currJ == 1 && currK == 1) {
            if (prevQ == 0) {
                currQ = 1;
                currQprime = 0;
            } else {
                currQ = 0;
                currQprime = 1;
            }
        }
    }

    @Override
    public void displayState() {
        System.out.println("JK Flip-Flop");
        System.out.println("Previous Inputs: J=" + prevJ + ", K=" + prevK);
        System.out.println("Current Inputs : J=" + currJ + ", K=" + currK);
        System.out.println("Previous Output: Q=" + prevQ + ", Q'=" + prevQprime);
        System.out.println("Current Output : Q=" + currQ + ", Q'=" + currQprime);
    }

    @Override
    public String getPresentState() {
        return "Q=" + prevQ + ", Q'=" + prevQprime;
    }

    @Override
    public String getInputs() {
        return "J=" + currJ + ", K=" + currK;
    }

    @Override
    public String getNextState() {
        return "Q=" + currQ + ", Q'=" + currQprime;
    }

    @Override
    public String getFlipFlopInputs() {
        return "J=" + currJ + ", K=" + currK;
    }

    @Override
    public void resetInputs() {
        currJ = 0;
        currK = 0;
        System.out.println("Input signals resetting to 0 in...");
        for (int i = 3; i >= 0; i--) {
            System.out.println(i);
        }
        System.out.println("Successfully reset inputs");
    }
}
