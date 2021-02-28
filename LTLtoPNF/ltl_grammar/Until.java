package ltl_grammar;

import formula.BinaryFormula;
import formula.Formula;

/**
 * This class represents an LTL formula that is an until formula.
 */
public class Until extends BinaryFormula {
	
	/**
	 * Initializes this LTL formula as the until of the given left and right subformulas.
	 * 
	 * @param left the left subformula of this formula
	 * @param right the right subformula of this formula
	 */
	public Until(Formula left, Formula right) {
		this.setLeft(left);
		this.setRight(right);
	}
	
	/**
	 * Indicates whether some other object is "equal to" this one.
	 * 
	 * @return true if this object is the same as the obj argument; false otherwise.
	 */
	@Override
	public boolean equals(Object object) {
		if (object != null && this.getClass() == object.getClass()) {
			Until other = (Until) object;
			return this.getLeft().equals(other.getLeft()) && this.getRight().equals(other.getRight());
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
		return "(" + this.getLeft() + " U " + this.getRight() + ")";
	}

	/**
	 * Returns the dual of this formula (Until)
	 * 
	 * </br> In general, the dual of until is represented by the following transformation:
	 * 
	 * </br> !(f1 U f2) -&gt; ((f1 && !f2) W (!f1 && !f2))
	 * 
	 * @return a formula object, which is the dual of this formula
	 */
	@Override
	public Formula dual() {
		return new WeakUntil(new And(this.getLeft(), new Not(this.getRight())), new And(new Not(this.getLeft()), new Not(this.getRight())));
	}
	
	
}
