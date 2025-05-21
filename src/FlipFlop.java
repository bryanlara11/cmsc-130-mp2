public interface FlipFlop {
    void input();

    void update();

    void displayState();

    String getPresentState();

    String getInputs();

    String getNextState();

    String getFlipFlopInputs();

    void resetInputs();
}
