package ohm.softa.a03.states;

import ohm.softa.a03.Cat;
import ohm.softa.a03.State;

/**
 * @author Peter Kurfer
 * Created on 10/13/17.
 */
public class HungryState extends State {

    public HungryState(boolean duration) {
        super(duration);
    }

    @Override
    public State successor(Cat cat) {
        logger.info("I've been starving for a too long time...");
        return new DeadState();
    }

    public State feed(Cat cat){
        logger.info("Om nom nom...");
        return new DigestingState(cat.getDigest(), getDuration() - getTime());
    }
}
