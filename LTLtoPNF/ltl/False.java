package ltl;

/**
 * This class represents the LTL state formula false.
 */
public class False extends ConstantFormula {
	
	/**
	 * Initializes this LTL formula as false.
	 */
	public False() {
		this.setValue(0);
	}
	
	/**
	 * Returns a hashcode value for the object.
	 * 
	 * @return The hashcode value associated for this object.
	 */
	@Override
	public int hashCode() {
		return (int) this.getValue(); //default val for false
	}
	
	/**
	 * Indicates whether some other object is "equal to" this one.
	 * 
	 * @return true if this object is the same as the obj argument; false otherwise.
	 */
	@Override
	public boolean equals(Object object) {
		return object instanceof False;
	}
	
	/**
	 * Returns a string representation of the object.
	 * 
	 * @return a string representation of the object.
	 */
	@Override
	public String toString() {
		return "false";
	}

	/**
	 * Returns the dual of this formula (False)
	 * 
	 * </br> In general, the dual of false is represented by the following transformation:
	 * 
	 * </br> !false -&gt; true
	 * 
	 * @return a formula object, which is the dual of this formula
	 */
	@Override
	public Formula dual() {
		return new True();
	}
}
