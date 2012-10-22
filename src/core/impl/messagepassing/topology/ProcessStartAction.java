/**
 * start Process
 */
package core.impl.messagepassing.topology;

import core.event.Event;

/**
 * @author hengxin
 *
 */
public class ProcessStartAction implements IProcessAction {

	/* (non-Javadoc)
	 * @see core.IProcessAction#execute(core.Event, core.Process)
	 * 
	 * just to start Process
	 */
	@Override
	public void execute(Event event, Process process) {
		process.run();
	}

}
