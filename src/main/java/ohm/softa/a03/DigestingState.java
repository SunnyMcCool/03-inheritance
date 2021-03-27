package ohm.softa.a03;

import ohm.softa.a03.states.SleepingState;

public class DigestingState extends State{
    private final int remainingWakeTime;

    // Why do we need a remaining WakeTime here but not in other states??
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
