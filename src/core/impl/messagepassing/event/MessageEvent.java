/**
 * 
 */
package core.impl.messagepassing.event;

import core.event.Event;
import core.event.IEventHandler;
import core.impl.messagepassing.topology.Process;

/**
 * @author hengxin
 * @date 11-25-2011
 */
public class MessageEvent extends Event {

	/**
	 * inherited constructor from superclass Event.
	 * 
	 * @param triggeringClock
	 * 		in which simulation clock the event should be triggered.
	 * @param handler
	 * 		who is responsible for handling this event when it is triggered.
	 */
	public MessageEvent(long triggeringClock, IEventHandler handler) {
		super(triggeringClock, handler);
	}
	
	/**
	 * Message to send.
	 */
	private Message msg = null;
	
	/**
	 * sender of Message.
	 */
	private Process fromProcess = null;
	
	/**
	 * receiver of Message.
	 */
	private Process toProcess = null;
	
	public MessageEvent(long triggeringClock, IEventHandler handler,
			Message msg, Process fromProcess, Process toProcess) {
		super(triggeringClock, handler);
		this.msg = msg;
		this.fromProcess = fromProcess;
		this.toProcess = toProcess;
	}

	/**
	 * @return the msg
	 */
	public Message getMsg() {
		return msg;
	}

	/**
	 * @return the fromProcess
	 */
	public Process getFromProcess() {
		return fromProcess;
	}

	/**
	 * @return the toProcess
	 */
	public Process getToProcess() {
		return toProcess;
	}
	
	
}
