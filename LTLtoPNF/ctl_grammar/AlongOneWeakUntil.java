package ctl_grammar;

import formula.BinaryFormula;
import formula.Formula;

public class AlongOneWeakUntil extends BinaryFormula { 
	
	public AlongOneWeakUntil(Formula left, Formula right) {
		super();
		this.setLeft(left);
		this.setRight(right);
	}

	@Override
	public boolean equals(Object object) {
		if (object != null && this.getClass() == object.getClass()) {
			AlongOneWeakUntil other = (AlongOneWeakUntil) object;
			return this.getLeft().equals(other.getLeft()) && this.getRight().equals(other.getRight());
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "E(" + this.getLeft() + " W " + this.getRight() + ")";
	}
	
	@Override
	public Formula dual() {
		return new AlongAllUntil(new And(this.getLeft(), new Not(this.getRight())), new And(new Not(this.getLeft()), new Not(this.getRight())));
	}
}
