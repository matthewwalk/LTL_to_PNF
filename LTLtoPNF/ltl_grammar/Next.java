package ltl_grammar;

import formula.Formula;
import formula.UnaryFormula;

/**
 * This class represents an LTL formula that is a next formula. 
 */
public class Next extends UnaryFormula {

	/**
	 * Initializes this LTL formula as the next of the given formula.
	 * 
	 * @param formula the subformula of this formula
	 */
	public Next(Formula formula) {
		this.setFormula(formula);
	}

	/**
	 * Returns a hashcode value for the object.
	 * 
	 * @return The hashcode value associated for this object.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.getFormula().hashCode();
		return result;
	}

	/**
	 * Indicates whether some other object is "equal to" this one.
	 * 
	 * @return true if this object is the same as the obj argument; false otherwise.
	 */
	@Override
	public boolean equals(Object object) {
		if (object != null && this.getClass() == object.getClass()) {
			Next other = (Next) object;
			return this.getFormula().equals(other.getFormula());
		} else {
			return false;
		}
	}

	/**
	 * Returns a string representation of the object.
	 * 
	 * @return a string representation of the object.
	 */
	@Override
	public String toString() {
		return "X " + this.getFormula();
	}

	/**
	 * Returns the dual of this formula (Next)
	 * 
	 * </br> In general, the dual of next is represented by the following transformation:
	 * 
	 * </br> !Xf -&gt; X!f
	 * 
	 * @return a formula object, which is the dual of this formula
	 */
	@Override
	public Formula dual() {
		return new Next(new Not(getFormula()));
	}
}