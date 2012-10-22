/**
 * AsynMessagePassingCom represents the communication system of distributed
 * algorithms based on the Asynchronous Message-Passing model.
 * 
 * In Asynchronous Message-Passing model, the core elements for communication system
 * are links among processes. AsynMessagePassingCom is responsible for sending and
 * delivering messages on behalf of processes.
 * 
 * Notice that AsynMessagePassingCom implement interface IEventHandler and can 
 * handles Event (s).
 * 
 * AsynMessagePassingCom respects Singleton design pattern.
 */
package core.impl.messagepassing;

import core.Communication;
import core.engine.Engine;
import core.event.Event;
import core.event.IEventHandler;
import core.impl.messagepassing.event.Message;
import core.impl.messagepassing.event.MessageEvent;
import core.impl.messagepassing.topology.Pair;
import core.impl.messagepassing.topology.Process;
import core.impl.messagepassing.topology.Session;
import core.impl.messagepassing.topology.Topology;

/**
 * @author hengxin
 * @date 11-24-2011
 * 
 * for communication.
 */
public class AsynMessagePassingCom extends Communication implements IEventHandler{

	/**
	 * Singleton design pattern
	 */
	private static AsynMessagePassingCom instance = null;
	
	private AsynMessagePassingCom() {
	}
	
	public static AsynMessagePassingCom getInstance() {
		if(instance == null)
			instance = new AsynMessagePassingCom();
		
		return instance;
	}
	/**
	 * AsynMessagePassingCom receives Message msg from the sender Process 
	 * and delivers that Message msg to the receiver toProcess on behalf of
	 * the sender.
	 * 
	 * send2 is used to achieve process-to-process communication.
	 * It first constructs MessageEvent and then schedules it.
	 * 
	 * @param msg
	 * 		Message to send.
	 * @param fromProcess
	 * 		sender of Message.
	 * @param toProcess
	 * 		receiver of Message.
	 */
	public void send2(Message msg, Process fromProcess, Process toProcess) {
		Event msgEvent = new MessageEvent(Engine.getInstance().getCurrentSimClock(), 
				this, msg, fromProcess, toProcess);
		Engine.getInstance().scheduleEventAtOnce(msgEvent);
	}
	
	/**
	 * dispatch this Event e to appropriate Session.
	 * @param e
	 * 		Event e to be dispatched or handled directly.
	 */
	@Override
	public void dispatch(Event e) {
		if(! (e instanceof MessageEvent))
			return;
		
		
		Pair pair = new Pair(((MessageEvent) e).getFromProcess().getPid(), 
				((MessageEvent) e).getToProcess().getPid());
		
		Session session = Topology.getInstance().getSession(pair);
		
		session.dispatch(e);
	}
}
