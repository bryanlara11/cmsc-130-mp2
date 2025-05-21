public interface FlipFlop {
    void input(); // gets input from user

    void update(); // updates the state

    void displayState(); // shows the state

    String getPresentState(); // returns current state

    String getInputs(); // returns current inputs

    String getNextState(); // returns next state

    String getFlipFlopInputs(); // returns flip-flop specific inputs

    void resetInputs(); // resets the input signals
}
