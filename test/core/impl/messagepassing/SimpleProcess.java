/**
 * SimpleProcess : test case for Process with pid = 1.
 */
package core.impl.messagepassing;

import java.util.HashMap;

import core.impl.messagepassing.event.Message;
import core.impl.messagepassing.topology.IProcessAction;
import core.impl.messagepassing.topology.Process;
import core.impl.messagepassing.topology.Topology;

/**
 * @author hengxin
 * @date 11-25-2011
 */
public class SimpleProcess extends Process {

	/**
	 * @param pid
	 * 		pid of Process
	 * @param event2action
	 * 		map of event type and action
	 */
	public SimpleProcess(long pid, HashMap<String, IProcessAction> event2action) {
		super(pid, event2action);
	}

	/* (non-Javadoc)
	 * @see core.Process#run()
	 * 
	 * test case for Process
	 * just to create and send a Message.
	 */
	@Override
	public void run() {
		Message msg = new Message();
		AsynMessagePassingCom.getInstance().send2(msg, this, Topology.getInstance().getProcess(2));
	}

}
