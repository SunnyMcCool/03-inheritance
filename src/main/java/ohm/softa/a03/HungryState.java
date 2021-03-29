package ohm.softa.a03;

import ohm.softa.a03.states.DeadState;
import ohm.softa.a03.states.DigestingState;
import ohm.softa.a03.states.SleepingState;

public class HungryState extends State {

    // Duration von State holen
    protected HungryState(int duration) {
        super(duration);
    }

    // abstrakte Methode überschreiben
    // Wenn Katze nicht gefüttert wird
    @Override
    public State successor(Cat cat) {
        logger.info("I've been starving for a too long time...");
        // Katze ist tot
        return new DeadState();
    }

    // Wenn Katze gefüttert wird
    // feed kommt von Cat - wie ist da möglich?
    public State feed(Cat cat){
        logger.info("Om nom nom...");
        // zwei Parameter notwendig
        // 1: State Verdauung und Phase verdauend
        // 2: Dauer der Verdauung (10), aktuelle Zeitdauer (0)
        // Wieso werden die Parameter geholt?
        return new DigestingState(cat.getDigest(), getDuration() - getTime());
    }
}
