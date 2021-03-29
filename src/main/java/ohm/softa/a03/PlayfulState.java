package ohm.softa.a03;

import ohm.softa.a03.SleepingState;

public class PlayfulState extends State{

    // Holt sich Duration von State
    protected PlayfulState(int duration) {
        super(duration);
    }

    // abstrakte Methode überschreiben
    @Override
    public State successor(Cat cat) {
        logger.info("Yoan... getting tired!");
        // Status = Sleeping, wechselt zu Schlafmodus
        return new SleepingState(cat.getSleeping());
    }
}
