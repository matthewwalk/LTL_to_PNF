package ctl_grammar;

import formula.BinaryFormula;
import formula.Formula;

public class AlongOneUntil extends BinaryFormula {
	
	public AlongOneUntil(Formula left, Formula right) {
		super();
		this.setLeft(left);
		this.setRight(right);
	}
	
	@Override
	public boolean equals(Object object) {
		if (object != null && this.getClass() == object.getClass()) {
			AlongOneUntil other = (AlongOneUntil) object;
			return this.getLeft().equals(other.getLeft()) && this.getRight().equals(other.getRight());
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "E(" + this.getLeft() + " U " + this.getRight() + ")";
	}
	
	@Override
	public Formula dual() {
		return new AlongAllWeakUntil(new And(this.getLeft(), new Not(this.getRight())), new And(new Not(this.getLeft()), new Not(this.getRight()))); // TODO fix this with the answer
	}
}
