package ohm.softa.a03;

import ohm.softa.a03.DeadState;
import ohm.softa.a03.DigestingState;
import ohm.softa.a03.HungryState;
import ohm.softa.a03.PlayfulState;
import ohm.softa.a03.SleepingState;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Cat {
	private static final Logger logger = LogManager.getLogger();

	private State state;

	// state durations (set via constructor), ie. the number of ticks in each state
	private final int sleep;
	private final int awake;
	private final int digest;

	// Die neun Leben einer Katze
	private int lifes = 9;

	private final String name;

	public Cat(String name, int sleep, int awake, int digest) {
		this.name = name;
		this.sleep = sleep;
		this.awake = awake;
		this.digest = digest;

		// initially, cats are (you guessed it) sleeping
		state = new SleepingState(sleep);
	}

	public void tick(){
		this.state = state.tick(this);
	}

	/**
	 * This would be a user interaction: feed the cat to change its state!
	 */
	public void feed(){
		if (!isHungry())
			throw new IllegalStateException("Not every cat is Garfield...");

		logger.info("You feed the cat...");
		this.state = ((HungryState) state).feed(this);
	}

	@Override
	public String toString() {
		logger.info("Your cats name is "+ name + ".");
		return name;
	}

	public int getLifes(){
		logger.info("Your cat has " + lifes + " lifes.");
		return lifes;
	}

	public int lifeCounter(){
		lifes = lifes-1;
		logger.info("Your cat has " + lifes + " lifes left.");
		return lifes;
	}

	public int getSleeping() {
		return sleep;
	}

	public int getAwake(){
		return awake;
	}

	public int getDigest(){
		return digest;
	}

	public boolean isAsleep() {
		return state instanceof SleepingState;
	}

	public boolean isPlayful() {
		return state instanceof PlayfulState;
	}

	public boolean isHungry() {
		return state instanceof HungryState;
	}

	public boolean isDigesting() {
		return state instanceof DigestingState;
	}

	public boolean isDead() {
		return state instanceof DeadState;
	}
}
