/**
 * Event represents the simulation object being scheduled by the Engine.
 * In discrete event simulation, event is the first class citizen. 
 * 
 * Event consists of triggeringClock, reference to EventHandler instance.
 * 
 * Events can be compared with each other according to their triggeringClock.
 */
package core.event;

import core.SimulationObject;


/**
 * @author hengxin
 * @date 11-23-2011
 * 
 * Event represents the simulation object being scheduled by the Engine. 
 */
public abstract class Event extends SimulationObject implements Comparable<Event>{
	
	/**
	 * the Event is triggered at the instant of triggeringClock.
	 * 
	 * triggeringClock synchronizes with simulationClock which provides
	 * unique and global simulationClock.
	 */
	private long triggeringClock = 0;
	
	/**
	 * corresponding event handler
	 */
	private IEventHandler handler = null;
	
	/**
	 * Constructor 
	 * 
	 * @param triggeringClock
	 * 		in which simulation clock the event should be triggered.
	 * @param handler
	 * 		who is responsible for handling this event when it is triggered.
	 */
	public Event (long triggeringClock, IEventHandler handler) {
		this.triggeringClock = triggeringClock;
		this.handler = handler;
	}
	
	/**
	 * dispatch events to corresponding handler
	 */
	public final void action() {
		handler.dispatch(this);
	}
	
	public long getTriggeringClock() {
		return this.triggeringClock;
	}

	/**
	 * set new triggeringClock to this Event.
	 * It is mainly used to schedule this Event by Engine.
	 * 
	 * @param simClock
	 * 		new triggeringTime
	 */
	public void setTriggeringClock(long simClock) {
		this.triggeringClock = simClock;
	}
	
	public IEventHandler getHandler() {
		return this.handler;
	}
	
	/**
	 * compare two Event(s) according to their triggeringClock(s)
	 */
	public int compareTo(Event e) {
		int result = 0;
		
		if (this.triggeringClock < e.triggeringClock)
			result = -1;
		else if (this.triggeringClock == e.triggeringClock)
			result = 0;
		else
			result = 1;
		
		return result;
	}
	
}
