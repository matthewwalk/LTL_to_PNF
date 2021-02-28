package ctl_grammar;

import formula.BinaryFormula;
import formula.Formula;

public class BidirectionalImplies extends BinaryFormula {
	
	public BidirectionalImplies(Formula left, Formula right) {
		super();
		this.setLeft(left);
		this.setRight(right);
	}
	
	@Override
	public boolean equals(Object object) {
		if (object != null && this.getClass() == object.getClass()) {
			BidirectionalImplies other = (BidirectionalImplies) object;
			return this.getLeft().equals(other.getLeft()) && this.getRight().equals(other.getRight());
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "(" + this.getLeft() + " <-> " + this.getRight() + ")";
	}
	
	@Override
	public Formula dual() { //!(a<->b) === (a && !b) || (b && !a)
		return new Or(new And(this.getLeft(), new Not(this.getRight())), new And(this.getRight(), new Not(this.getLeft())));
	}
}
