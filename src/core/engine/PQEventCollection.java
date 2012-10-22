/**
 * PQEventCollection is an implementation of "future event list" based on 
 * PriorityQueue.
 */
package core.engine;

import java.util.PriorityQueue;

import core.event.Event;

/**
 * @author hengxin
 * @date 11-23-2011
 */
public class PQEventCollection implements IEventCollection {

	/**
	 * using PriorityQueue as underlying data structure for "future event list"
	 */
	private PriorityQueue<Event> pqEC = new PriorityQueue<Event>();
	
	/* (non-Javadoc)
	 * @see core.IEventCollection#insert(core.Event)
	 */
	@Override
	public void insert(Event e) {
		pqEC.add(e);
	}

	/* (non-Javadoc)
	 * @see core.IEventCollection#removeNext()
	 */
	@Override
	public Event removeNext() {
		return pqEC.poll();
	}

	/* (non-Javadoc)
	 * @see core.IEventCollection#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return pqEC.isEmpty();
	}

}
