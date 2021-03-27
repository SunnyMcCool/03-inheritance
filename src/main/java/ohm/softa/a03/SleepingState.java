package ohm.softa.a03;

public class SleepingState extends State{

    protected SleepingState(int duration) {
        super(duration);
    }

    @Override
    public State successor(Cat cat) {
        logger.info("Grumble... I am hungry!");
        return new HungryState(cat.getAwake());
    }
}
