package ohm.softa.a03;

import ohm.softa.a03.states.SleepingState;

public class DigestingState extends State{
    private final int remainingWakeTime;

    protected DigestingState(int duration, int remainingWakeTime) {
        super(duration);
        this.remainingWakeTime = remainingWakeTime;
    }

    @Override
    public State successor(Cat cat) {
        logger.info("Let's play!");
        return new PlayfulState(remainingWakeTime - cat.getDigest());
    }

}
