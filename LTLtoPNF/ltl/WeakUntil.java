package ltl;

/**
 * This class represents an LTL formula that is a weak until formula.
 */
public class WeakUntil extends BinaryFormula {
	
	/**
	 * Initializes this LTL formula as the weak until of the given left and right subformulas.
	 * 
	 * @param left the left subformula of this formula
	 * @param right the right subformula of this formula
	 */
	public WeakUntil(Formula left, Formula right) {
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
			WeakUntil other = (WeakUntil) object;
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
		return "(" + this.getLeft() + " W " + this.getRight() + ")";
	}

	/**
	 * Returns the dual of this formula (Weak Until)
	 * 
	 * </br> In general, the dual of weak until is represented by the following transformation:
	 * 
	 * </br> !(f1 W f2) -&gt; ((f1 && !f2) U (!f1 && !f2))
	 * 
	 * @return a formula object, which is the dual of this formula
	 */
	@Override
	public Formula dual() {
		return new Until(new And(this.getLeft(), new Not(this.getRight())), new And(new Not(this.getLeft()), new Not(this.getRight())));
	}
}
