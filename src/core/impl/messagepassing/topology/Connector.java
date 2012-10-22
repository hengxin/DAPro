/**
 * Connector is a part of Link.
 * 
 * Connector is also the place where Event (mainly MessageEvent) is handled directly.
 */
package core.impl.messagepassing.topology;

import core.SimulationObject;
import core.event.IEventHandler;

/**
 * @author hengxin
 * @date 11-25-2011
 * 
 * Connector is a part of Link.
 */
public abstract class Connector extends SimulationObject implements IEventHandler {

	/* (non-Javadoc)
	 * @see core.IEventHandler#dispatch(core.Event)
	 * 
	 * Connector is responsible for handling Event (mainly MessageEvent) directly.
	 */

}
