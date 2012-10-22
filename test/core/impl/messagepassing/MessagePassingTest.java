/**
 * test case for simulation of Asynchronous Message-Passing Model 
 */
package core.impl.messagepassing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import core.engine.Engine;
import core.engine.PQEventCollection;
import core.event.Event;
import core.impl.messagepassing.event.MessageEvent;
import core.impl.messagepassing.event.ProcessStartEvent;
import core.impl.messagepassing.topology.Connector;
import core.impl.messagepassing.topology.FixedDelayConnector;
import core.impl.messagepassing.topology.IProcessAction;
import core.impl.messagepassing.topology.Link;
import core.impl.messagepassing.topology.Pair;
import core.impl.messagepassing.topology.Process;
import core.impl.messagepassing.topology.ProcessStartAction;
import core.impl.messagepassing.topology.Session;
import core.impl.messagepassing.topology.Topology;

/**
 * @author hengxin
 * @date 11-25-2011
 * 
 * test case for simulation of Asynchronous Message-Passing Model
 */
public class MessagePassingTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		
	}

	@Test
	public void test() {
		/**
		 * (1) generate Process 1 and Process 2
		 */
		HashMap<String, IProcessAction> event2action1 = new HashMap<String, IProcessAction>();
		event2action1.put(ProcessStartEvent.class.getSimpleName(), new ProcessStartAction());
		Process p1 = new SimpleProcess(1, event2action1);
		
		HashMap<String, IProcessAction> event2action2 = new HashMap<String, IProcessAction>();
		event2action2.put(MessageEvent.class.getSimpleName(), new MessageAction());
		Process p2 = new SimpleProcess(2, event2action2);
		
		/**
		 * (2) generate Link between Process 1 and Process 2
		 */
		Connector fdConn = new FixedDelayConnector(10);
		List<Connector> connList = new ArrayList<Connector>();
		connList.add(fdConn);
		Link simpleLink = new Link(connList);
		
		/**
		 * (3) generate Topology
		 */
		Session session = new Session(simpleLink, p1, p2);
		Pair pair = new Pair(1,2);
		Topology.getInstance().registerSession(pair, session);
		
		/**
		 * (4) initialize Engine and "future event list"
		 */
		// use default implementation of "future event list"
		Engine engine = new Engine(50, new PQEventCollection());
		
		Event startP1 = new ProcessStartEvent(5, Topology.getInstance().getProcess(1));
		Engine.getInstance().scheduleEventAtOnce(startP1);
		
		Engine.getInstance().run();
	}

}
