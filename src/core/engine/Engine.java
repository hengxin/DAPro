/**
 * Engine is the runtime driver for DAPro. It implements the standard logic in discrete 
 * event simulation.
 * 
 * Engine maintains simulationClock which provides unique and global time in whole
 * simulation.
 * 
 * The core data structure for Engine and scheduler algorithm is the so-called 
 * "future event list" which can be implemented in a few well-known ways. We encapsulate
 * these different ways into IEventCollection and its subclasses.
 * 
 * Engine is in Singleton design pattern.
 * TODO: How to implement Singleton design pattern when constructors with parameters
 * are needed.
 */
package core.engine;

import core.SimulationObject;
import core.event.Event;

/**
 * @author hengxin
 * @date 11-23-2011
 */
public class Engine extends SimulationObject {
	
	/**
	 * Singleton design pattern
	 * FIXME: to adapt to the situation in which constructor with parameters are needed
	 */
	private static Engine instance = null;
	
	public Engine (long maxSimulationClock, IEventCollection ec) {
		this.MAXSIMULATIONCLOCK = maxSimulationClock;
		this.ec = ec;
		
		instance = this;
	}
	
	public static Engine getInstance() {
		if(instance == null)
			instance = new Engine(Long.MAX_VALUE, new PQEventCollection());
		
		return instance;
	}
	
	/**
	 * providing unique and global time in whole simulation.
	 */
	private long simulationClock = 0;
	
	/**
	 * threshold of simulation time; the engine will stop when it is due.
	 */
	private long MAXSIMULATIONCLOCK = 0;
	
	/**
	 * ec provides different implementations of "future event list".
	 */
	private IEventCollection ec = null;

	/**
	 * Main method for scheduler algorithm in discrete-event simulation.
	 * 
	 * It consists of the following three procedures in a while loop
	 * 
	 * (1) retrieve and remove the next event (e) to be executed from "future event list".
	 * (2) advance the simulationClock to triggeringClock of e.
	 * (3) execute the event e.
	 * 
	 * until
	 * (1) the pre-defined threshold of MAXSIMULATIONCLOCK is due, OR
	 * (2) there is no any event to be executed in "future event list".
	 */
	public void run() {
		while(this.simulationClock <= this.MAXSIMULATIONCLOCK && 
				! this.ec.isEmpty()) {
			Event e = this.ec.removeNext();
			this.advanceSimClockTo(e.getTriggeringClock());
			e.action();
		}
	}
	
	/**
	 * schedule Event (e) to a new simulationClock.
	 * 
	 * @param e
	 * 		Event to be scheduled.
	 * @param latency
	 * 		latency relative to the current simulationClock.
	 */
	public void scheduleEvent(Event e, long latency) {
		long triggeringClock = e.getTriggeringClock() + latency;
		e.setTriggeringClock(triggeringClock);
		this.insert(e);
	}
	
	/**
	 * schedule Event (e) without modification of its triggeringClock.
	 * @param e
	 * 		Event to be scheduled.
	 */
	public void scheduleEventAtOnce(Event e) {
		this.insert(e);
	}
	
	/**
	 * get current simulation clock.
	 * @return
	 * 		current simulationClock.
	 */
	public long getCurrentSimClock() {
		return this.simulationClock;
	}
	
	/***********************************************************
	 *               private methods followed 
	 ***********************************************************/
	/**
	 * advance simulationClock to specified value
	 * 
	 * @param clock
	 * 		specified simulation clock
	 */
	private void advanceSimClockTo(long clock) {
		this.simulationClock = clock;
	}
	
	/**
	 * insert Event (e) to "future event list".
	 * It delegates to concrete IEventCollection.
	 * @param e
	 * 		Event to be inserted into "future event list".
	 */
	private void insert(Event e) {
		this.ec.insert(e);
	}
}
