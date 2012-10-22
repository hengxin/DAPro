/**
 * FixedDelayConnector represents part of link which will introduce fixed delay.
 */
package core.impl.messagepassing.topology;

import core.engine.Engine;
import core.event.Event;

/**
 * @author hengxin
 * @date 11-25-2011
 * 
 * FixedDelayConnector represents part of link which will introduce fixed delay.
 */
public class FixedDelayConnector extends Connector {

	private long fixedDelay = 0;
	
	public FixedDelayConnector(long fixedDelay) {
		this.fixedDelay = fixedDelay;
	}
	
	/* (non-Javadoc)
	 * @see core.IEventHandler#dispatch(core.Event)
	 * 
	 * handle Event (mainly MessageEvent) directly by
	 * introducing fixed delay and schedule it. 
	 */
	@Override
	public void dispatch(Event e) {
		Engine.getInstance().scheduleEvent(e, fixedDelay);
	}

}
