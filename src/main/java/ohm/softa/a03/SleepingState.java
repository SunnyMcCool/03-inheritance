package ohm.softa.a03;

public class SleepingState extends State{

    // Zieht sich Duration von Vaterklasse
    protected SleepingState(int duration) {
        super(duration);
    }

    // Abstrakte Methode muss überschrieben werden
    @Override
    public State successor(Cat cat) {
        logger.info("Grumble... I am hungry!");
        // State muss zurückgegeben werden
        return new HungryState(cat.getAwake());
    }
}
