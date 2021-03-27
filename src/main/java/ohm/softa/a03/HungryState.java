package ohm.softa.a03;

import ohm.softa.a03.states.DeadState;
import ohm.softa.a03.states.DigestingState;
import ohm.softa.a03.states.SleepingState;

public class HungryState extends State {

    protected HungryState(int duration) {
        super(duration);
    }

    @Override
    public State successor(Cat cat) {
        logger.info("I've been starving for a too long time...");
        return new DeathState();
    }

    public State feed(Cat cat){
        logger.info("Om nom nom...");
        return new DigestingState(cat.getDigest(), getDuration() - getTime());
    }
}
