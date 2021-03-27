package ohm.softa.a03;

import ohm.softa.a03.states.SleepingState;

public class PlayfulState extends State{

    protected PlayfulState(int duration) {
        super(duration);
    }

    @Override
    public State successor(Cat cat) {
        logger.info("Yoan... getting tired!");
        return new SleepingState(cat.getSleeping());
    }
}
