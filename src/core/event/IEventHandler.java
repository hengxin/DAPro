/**
 * Any SimulationObject which can and will handle events implements interface
 * EventHandler. 
 */
package core.event;

/**
 * @author hengxin
 * @date 11-23-2011
 */
public interface IEventHandler {
	
	/**
	 * dispatch Event e to other IEventHandler or handle it directly.
	 * 
	 * @param e
	 * 		Event e to be dispatched indirectly or handled directly. 
	 */
	public abstract void dispatch(Event e);

}
