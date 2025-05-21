/**
 * Interface defining the common operations for all flip-flop types
 * A flip-flop is a basic memory element in digital circuits that can store one bit of information
 */
public interface FlipFlop {
    /**
     * Gets input from the user for the flip-flop
     * Each flip-flop type will have its specific input requirements
     */
    void input();

    /**
     * Updates the flip-flop's state based on current inputs
     * This implements the flip-flop's truth table behavior
     */
    void update();

    /**
     * Displays the current state of the flip-flop
     * Shows both previous and current inputs/outputs
     */
    void displayState();

    /**
     * @return The current state of the flip-flop (Q value)
     */
    String getPresentState();

    /**
     * @return The current input values of the flip-flop
     */
    String getInputs();

    /**
     * @return The next state of the flip-flop based on current inputs
     */
    String getNextState();

    /**
     * @return The specific input values for this type of flip-flop
     * (e.g., "R=1, S=0" for RS flip-flop)
     */
    String getFlipFlopInputs();
}
