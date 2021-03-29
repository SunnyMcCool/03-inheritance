package ohm.softa.a03.states;

import ohm.softa.a03.Cat;
import ohm.softa.a03.State;

/**
 * @author Peter Kurfer
 * Created on 10/13/17.
 */
public class DeadState extends State {

    public DeadState() {
        super(-1);
    }

    @Override
    public State successor(Cat cat) {
        // no lives left...
        return this;
    }
}