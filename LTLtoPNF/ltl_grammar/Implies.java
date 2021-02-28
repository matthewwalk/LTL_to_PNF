package ltl_grammar;

import formula.BinaryFormula;
import formula.Formula;

public class Implies extends BinaryFormula {
	
	public Implies(Formula left, Formula right) {
		super();
		this.setLeft(left);
		this.setRight(right);
	}
	
	@Override
	public String toString() {
		return "(" + this.getLeft() + " -> " + this.getRight() + ")";
	}
	
	@Override
	public Formula dual() { //!(a->b) === (a && !b)
		return new And(this.getLeft(), new Not(this.getRight()));
	}
	
	
}
