/**
 * @file Link.java
 * 
 * @brief Link is composed of a list of Connector (s).
 * 
 * Notice that Link is not allowed for multiplex among several Session (s).
 */
package core.impl.messagepassing.topology;

import java.util.Iterator;
import java.util.List;

import core.SimulationObject;
import core.event.Event;
import core.event.IEventHandler;
import core.impl.messagepassing.event.MessageEvent;

/**
 * @author hengxin
 * @date 11-25-2011
 * 
 * Link is composed of a list of Connector (s).
 */
public class Link extends SimulationObject implements IEventHandler {

	/**
	 * Link is composed of a list of Connector (s).
	 */
	private List<Connector> link = null;
	
	/**
	 * Iterator<Connector> for Link.
	 * 
	 * It is used to remember the next Connector which is responsible for 
	 * handling Event (mainly MessageEvent).
	 */
	private Iterator<Connector> linkIter = null;
	
	/**
	 * Connector for Link.
	 * 
	 * Notice that linkIter is initialized.
	 * 
	 * @param connList
	 * 		list of Connector (s).
	 */
	public Link(List<Connector> connList) {
		this.link = connList;
		this.linkIter = this.link.iterator();
	}
	
	/* (non-Javadoc)
	 * @see core.IEventHandler#dispatch(core.Event)
	 * 
	 * dispatch Event e to next appropriate Connector which will handle
	 * it directly.
	 * OR, if it has gone through this link (by a series of Connector (s)),
	 * Link will handle this Event (mainly MessageEvent) directly.
	 */
	@Override
	public void dispatch(Event e) {
		if(this.linkIter.hasNext()) {
			Connector conn = this.linkIter.next();
		
			// dispatch it to next Connector.
			conn.dispatch(e);
		}
		else
			/**
			 * Link handle this Event directly: invoke handler (toProcess) to execute
			 * this Event.
			 */
			((MessageEvent) e).getToProcess().dispatch(e);
	}
}
