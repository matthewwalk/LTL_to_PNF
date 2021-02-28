package ltl_grammar;

import formula.BinaryFormula;
import formula.Formula;

public class BidirectionalImplies extends BinaryFormula {
	
	BidirectionalImplies(Formula left, Formula right) {
		super();
		this.setLeft(left);
		this.setRight(right);
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
