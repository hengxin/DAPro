/**
 * IProcessAction is responsible for executing Event handling based on the state of Process. 
 */
package core.impl.messagepassing.topology;

import core.event.Event;

/**
 * @author hengxin
 * @date 11-23-2011
 */
public interface IProcessAction {
	
	public abstract void execute(Event event, Process process);

}
