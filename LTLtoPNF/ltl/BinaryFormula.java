package ltl;

import v.Visitor;

/**
 * This class represents a generic binary LTL formula type consisting of two sub formulas.
 */
public class BinaryFormula extends Formula {

	private Formula left;
	private Formula right;
	
	/**
	 * Returns a hashcode value for the object.
	 * 
	 * @return The hashcode value associated for this object.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int hashCode = 1;
		hashCode = prime * hashCode + this.getLeft().hashCode();
		hashCode = prime * hashCode + this.getRight().hashCode();
		return hashCode;
	}

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

	/**
	 * Gets the left subformula of this binary formula
	 * 
	 * @return the left subformula of this binary formula
	 */
	public Formula getLeft() {
		return left;
	}

	/**
	 * Sets the left subformula of this binary formula
	 * 
	 * @param left the formula to be set as the left formula
	 */
	public void setLeft(Formula left) {
		this.left = left;
	}

	/**
	 * Gets the right subformula of this binary formula
	 * 
	 * @return the right subformula of this binary formula
	 */
	public Formula getRight() {
		return right;
	}
	
	/**
	 * Sets the left subformula of this binary formula
	 * 
	 * @param right the formula to be set as the right formula
	 */
	public void setRight(Formula right) {
		this.right = right;
	}

	/**
	 * Returns the dual of this binary formula.
	 * 
	 * </br> By default, there is no dual for an unspecified binary formula.
	 * 
	 * @return null 
	 */
	@Override
	public Formula dual() {
		// TODO Auto-generated method stub
		return null;
	}

}
