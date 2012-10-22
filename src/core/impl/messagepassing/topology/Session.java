/**
 * Session consists of fromProcess, toProcess and Link between them.
 * Actual processing and sending procedures are due to Link (s).
 */
package core.impl.messagepassing.topology;

import core.SimulationObject;
import core.event.Event;
import core.event.IEventHandler;

/**
 * @author hengxin
 * @date 11-25-2011
 * 
 * Session stands for a conversation between two Process (es).
 */
public class Session extends SimulationObject implements IEventHandler {

	/**
	 * sender of Message
	 */
	private Process fromProcess = null;
	
	/**
	 * receiver of Message
	 */
	private Process toProcess = null;
	
	/**
	 * Session consists of fromProcess, toProcess and Link between them.
	 * Actual processing and sending procedures are due to Link.
	 */
	private Link link = null;
	
	
	public Session(Link link, Process fromProcess, Process toProcess) {
		this.link = link;
		this.fromProcess = fromProcess;
		this.toProcess = toProcess;
	}
	
	/* (non-Javadoc)
	 * @see core.IEventHandler#dispatch(core.Event)
	 * 
	 * dispatch Event e to Link this.link.
	 */
	@Override
	public void dispatch(Event e) {
		this.link.dispatch(e);
	}

}
