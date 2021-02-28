package formula;

import s.S;
import v.Evaluator;
import v.Visitor;

/**
 * This class represents a generic constant LTL formula type consisting of some value.
 */
public class ConstantFormula extends Formula {
	private Object value;

	/**
	 * Accepts a formula visitor
	 * 
	 * @param visitor the visitor to accept
	 * 
	 * @return the result of visitor.visit(this)
	 */
	@Override
	public Formula accept(Visitor visitor) {
		return visitor.visit(this);
	}
	
	public S accept(Evaluator evaluator) {
		return evaluator.visit(this);
	}

	/**
	 * Gets the value of this formula
	 * 
	 * </br> By default returns an Object (needs to be cast)
	 * 
	 * @return the value formula
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * Sets the value of this formula
	 * 
	 * </br> By default sets as a generic Object type
	 */
	public void setValue(Object value) {
		this.value = value;
	}

	/**
	 * Returns the dual of this constant formula.
	 * 
	 * </br> By default, there is no dual for an unspecified constant formula.
	 * 
	 * @return null 
	 */
	@Override
	public Formula dual() {
		return null;
	}
	
}
