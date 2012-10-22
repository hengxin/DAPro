/**
 * Process represents the individual participant or component in the distributed 
 * system which is under simulation. It mainly aims to store information, such as
 * data structure, state of process, and file resources, to serve the handler of
 * events.
 * 
 * Process consists of a HashMap of pairs of IEventType and IProcessAction.
 * You are responsible for registering these event types and corresponding handler method
 * at the initialization of process. 
 */
package core.impl.messagepassing.topology;

import java.util.HashMap;

import core.SimulationObject;
import core.event.Event;
import core.event.IEventHandler;


/**
 * @author hengxin
 * @date 11-23-2011
 */
public abstract class Process extends SimulationObject implements IEventHandler {
	
	/**
	 * unique id for Process.
	 */
	private long pid = -1;
	
	/**
	 * collection of Event and corresponding IProcessAction.
	 */
	private HashMap<String, IProcessAction> event2action = new HashMap<String, IProcessAction>();
	
	public Process(long pid, HashMap<String, IProcessAction> event2action) {
		this.init();
		
		this.pid = pid;
		this.event2action = event2action;
		
		/**
		 * register to Topology
		 */
		Topology.getInstance().registerProcess(pid, this);
	}
	
	/**
	 * Dispatch Event according to its type and call corresponding handler method IProcessAction.
	 * 
	 * Notice that the override method from interface EventHandler is final.
	 */
	@Override
	public final void dispatch(Event e) {
		System.out.println(e.getClass().getSimpleName());
		
		/**
		 * FIXME: some check work is needed.
		 */
		
		IProcessAction action = event2action.get(e.getClass().getSimpleName());
		action.execute(e, this);
	}

	public long getPid() {
		return this.pid;
	}

	/**
	 * put init code here.
	 */
	public void init() {
		
	}
	
	/**
	 * put run code here. (main application logic)
	 */
	public abstract void run();
	
	/**
	 * put destroy code here.
	 */
	public void destroy() {
		
	}
}
