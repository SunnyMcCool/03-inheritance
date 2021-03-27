package ohm.softa.a03;

public class DeathState extends State{

    DeathState() {
        super(-1);
    }

    @Override
    public State successor(Cat cat) {
        logger.info("It's over. Goodbye.");
        return this;
    }
}
