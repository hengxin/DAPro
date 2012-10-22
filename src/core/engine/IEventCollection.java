/**
 * IEventCollection encapsulates the different implementation of "future event list" 
 * data structure in Engine.
 * 
 * Every implementation of "future event list" is responsible for implements the 
 * interface.
 */
package core.engine;

import core.event.Event;

/**
 * @author hengxin
 * @date 11-23-2011
 */
public interface IEventCollection {

	/**
	 * insert new Event into "future event list".
	 * 
	 * @param e
	 * 		new event
	 */
	public abstract void insert(Event e);
	
	/**
	 * retrieve and remove the event which should be executed next.
	 *  
	 * @return
	 *   the next Event to be executed.
	 */
	public abstract Event removeNext();
	
	/**
	 * if the "future event list" empty ?
	 * 
	 * @return
	 * 		true if the "future event list" is empty; 
	 * 		false otherwise.
	 */
	public abstract boolean isEmpty();
}
