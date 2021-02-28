package ctl_grammar;

import formula.BinaryFormula;
import formula.Formula;

/**
 * This class represents an LTL formula that is a conjuction (and) of two formulas.
 */
public class And extends BinaryFormula {
	
	/**
	 * Initializes this LTL formula as the conjunction (and) of the given left and right subformulas.
	 * 
	 * @param left the left subformula of this formula
	 * @param right the right subformula of this formula
	 */
	public And(Formula left, Formula right) {
		this.setLeft(left);
		this.setRight(right);
	}
	
	@Override
	public boolean equals(Object object) {
		if (object != null && this.getClass() == object.getClass()) {
			And other = (And) object;
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
		return "(" + this.getLeft() + " && " + this.getRight() + ")";
	}

	/**
	 * Returns the dual of this formula (And)
	 * 
	 * </br> In general, the dual of And is represented by the following transformation:
	 * 
	 * </br> (f1 &amp;&amp; f2) -&gt; (!f1 || !f2)
	 * 
	 * @return a formula object, which is the dual of this formula
	 */
	@Override
	public Formula dual() {
		return new Or(new Not(this.getLeft()), new Not(this.getRight()));
	}
	
}
