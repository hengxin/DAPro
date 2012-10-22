/**
 * test case for IProcessAction.
 */
package core.impl.messagepassing;

import core.event.Event;
import core.impl.messagepassing.topology.IProcessAction;
import core.impl.messagepassing.topology.Process;

/**
 * @author hengxin
 * @date 11-25-2011
 */
public class MessageAction implements IProcessAction {

	/* (non-Javadoc)
	 * @see core.IProcessAction#execute(core.Event, core.Process)
	 * 
	 * test case for IProcessAction.
	 * 
	 */
	@Override
	public void execute(Event event, Process process) {
		assert(event.getHandler() instanceof Process);
		
		System.out.println("Event is processed by Process " + process.getPid() + 
				" at time " + event.getTriggeringClock());
	}

}
