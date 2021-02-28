package ltl_grammar;

import formula.ConstantFormula;
import formula.Formula;

/**
 * This class represents the LTL state formula true.
 */
public class True extends ConstantFormula {

	/**
	 * Initializes this LTL formula as true.
	 */
	public True() {
		this.setValue(1);
	}
	
	/**
	 * Returns a hashcode value for the object.
	 * 
	 * @return The hashcode value associated for this object.
	 */
	@Override
	public int hashCode() {
		return (int) this.getValue();
	}
	
	/**
	 * Indicates whether some other object is "equal to" this one.
	 * 
	 * @return true if this object is the same as the obj argument; false otherwise.
	 */
	@Override
	public boolean equals(Object object) {
		return object instanceof True;
	}
	
	/**
	 * Returns a string representation of the object.
	 * 
	 * @return a string representation of the object.
	 */
	@Override
	public String toString() {
		return "true";
	}

	/**
	 * Returns the dual of this formula (True)
	 * 
	 * </br> In general, the dual of true is represented by the following transformation:
	 * 
	 * </br> !true -&gt; false
	 * 
	 * @return a formula object, which is the dual of this formula
	 */
	@Override
	public Formula dual() {
		return new False();
	}
}