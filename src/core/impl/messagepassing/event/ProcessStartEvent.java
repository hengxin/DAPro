/**
 * ProcessStartEvent represents starting process.
 */
package core.impl.messagepassing.event;

import core.event.Event;
import core.event.IEventHandler;

/**
 * @author hengxin
 * @date 11-25-2011
 */
public class ProcessStartEvent extends Event {

	/**
	 * @param triggeringClock
	 * @param handler
	 */
	public ProcessStartEvent(long triggeringClock, IEventHandler handler) {
		super(triggeringClock, handler);
	}

}
