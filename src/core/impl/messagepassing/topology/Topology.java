/**
 * Topology represents the structure of network consists of Process (es) and 
 * Link (s).
 * 
 * It maintains a HashMap of Session which consists of fromProcess, toProcess, 
 * and Link between them.
 * 
 * Topology respects Singleton design pattern.
 */
package core.impl.messagepassing.topology;

import java.util.HashMap;

import core.SimulationObject;

/**
 * @author hengxin
 * @date 11-25-2011
 * 
 * It maintains a collection of Session which consists of fromProcess, toProcess, 
 * and Link between them.
 * 
 * TODO: Topology respects Singleton design pattern.
 */
public class Topology extends SimulationObject {
	
	/**
	 * Singleton design pattern
	 */
	private static Topology instance = null;
	
	private Topology() {
	}
//	
//	public Topology(HashMap<Pair, Session> pair2Session) {
//		this.pair2Session = pair2Session;
//		
//		instance = this;
//	}
	
	public static Topology getInstance() {
		if(instance == null)
			instance = new Topology();
		
		return instance;
	}
	
	/**
	 * map of pid to Process.
	 */
	private HashMap<Long, Process> id2Process = new HashMap<Long, Process>();
	
	private HashMap<Pair, Session> pair2Session = new HashMap<Pair, Session> ();
	
	public void registerSession(Pair pair, Session session) {
		
		/**
		 * FIXME: some check work is needed
		 */
		
		
		this.pair2Session.put(pair, session);
	}
	
	/**
	 * get Session related to fromPid and toPid specified in Pair.
	 * 
	 * @param pair
	 * 		pair of fromPid and toPid.
	 * @return
	 * 		Session related to Pair.
	 */
	public Session getSession(Pair pair) {
		return this.pair2Session.get(pair);
	}
	
	public void registerProcess(long pid, Process p) {
		this.id2Process.put(pid, p);
	}
	
	public Process getProcess(long pid) {
		return this.id2Process.get(pid);
	}
}
