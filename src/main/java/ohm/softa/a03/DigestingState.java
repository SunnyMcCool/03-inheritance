package ohm.softa.a03;

import ohm.softa.a03.states.SleepingState;

public class DigestingState extends State{
    // verbleibende Zeit bis Katze aufwacht
    private final int remainingWakeTime;

    // Why do we need a remaining WakeTime here but not in other states??
    protected DigestingState(int duration, int remainingWakeTime) {
        super(duration);
        this.remainingWakeTime = remainingWakeTime;
    }

    // Abstrakte Methode überschreiben
    @Override
    public State successor(Cat cat) {
        logger.info("Let's play!");
        // remainingWakeTime?
        return new PlayfulState(remainingWakeTime - cat.getDigest());
    }

}
