/**
 * Pair represents pair of fromProcess and toProcess in a Session.
 * The elements are unique ids of Process (es) and 
 * mainly used to an index for Session.
 */
package core.impl.messagepassing.topology;

/**
 * @author hengxin
 * @date 11-25-2011
 * 
 * Pair represents pair of fromProcess and toProcess in a Session.
 */
public class Pair {
	
	private long fromPid;
	private long toPid;
	
//	public Pair() {
//		this.fromPid = -1l;
//		this.toPid = -1l;
//	}
	
	public Pair(long fromPid, long toPid) {
		this.fromPid = fromPid;
		this.toPid = toPid;
	}
		
	/**
	 * @return the fromPid
	 */
	public long getFromPid() {
		return fromPid;
	}


	/**
	 * @return the toPid
	 */
	public long getToPid() {
		return toPid;
	}

	/**
	 * Are two pairs the same ?
	 * 
	 * @param anotherPair
	 * 		Pair to be compared with.
	 * @return
	 * 		true if two Pair (s) are equal; 
	 * 		false otherwise.
	 */
	@Override
	public boolean equals(Object anotherPair) {
		if(!(anotherPair instanceof Pair))
			return false;
		
		return this.fromPid == ((Pair) anotherPair).getFromPid() &&
				this.toPid == ((Pair) anotherPair).getToPid();
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		result = (int) (37 * result + this.fromPid);
		result = (int) (37 * result + this.toPid);
		
		return result;
	}
}
