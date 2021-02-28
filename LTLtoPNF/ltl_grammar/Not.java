package ltl_grammar;

import formula.Formula;
import formula.UnaryFormula;

/**
 * This class represents an LTL formula that is the negation (not) of a formula. 
 */
public class Not extends UnaryFormula {

	/**
	 * Initializes this LTL formula as the negation of the given formula.
	 * 
	 * @param formula the subformula of this formula
	 */
	public Not(Formula formula) {
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
			Not other = (Not) object;
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
		return "! " + this.getFormula();
	}

	/**
	 * Returns the dual of this formula (Not)
	 * 
	 * </br> In general, the dual of not is the dual of it's subformula 
	 * 
	 * @return a formula object, which is the dual of this formula
	 */
	@Override
	public Formula dual() {
		return this.getFormula().dual();
	}
	
}