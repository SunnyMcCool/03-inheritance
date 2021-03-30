package ohm.softa.a03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class State {
    // Logger logger; erlaubt Konsolenausgaben
    protected static final Logger logger = LogManager.getLogger();

    private int t = 0;
    private final int duration;

    // Getter
    public int getTime() {
        return t;
    }
    public int getDuration() {
        return duration;
    }

    // Konstruktor
    protected State(int duration){
        this.duration = duration;
    }

    // Tick-Methode
    final State tick(Cat cat) {
        // Negative Duration
        if(duration < 0)
        	return this;

        // time goes by...
        t = t + 1;

        // Wenn t kleiner als Duration
        // z.B. Sleep hat Duration 10, Timer zeigt aber erst 5 S
        // 5 < 10
        if(t < duration) {
            // Holt sich Klasse und dessen Namen
	        logger.info("Still in {}", getClass().getSimpleName());
	        // iterativer Aufruf
	        return this;
        } else {
            // Sobald die Zeit um ist, wird die logger-Nachricht ausgegeben
            // Methode wird nicht mehr aufgerufen
            return successor(cat);
        }
    }

    public abstract State successor(Cat cat);

}

