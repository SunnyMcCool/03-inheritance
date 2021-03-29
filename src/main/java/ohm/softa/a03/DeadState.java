package ohm.softa.a03;

public class DeadState extends State{

    // von Duration wird immer 1 abgezogen
    // Katze darf 15 mal Hunger-Status haben, bis sie stirbt
    DeadState() {
        super(-1);
    }

    @Override
    public State successor(Cat cat) {
        // wird nicht angezeigt?
        logger.info("It's over. Goodbye.");
        return this;
    }
}
