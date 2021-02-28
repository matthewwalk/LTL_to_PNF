package ctl_grammar;

import formula.Formula;
import formula.UnaryFormula;

public class AlongOneFinally extends UnaryFormula {
	
	public AlongOneFinally(Formula formula) {
		super();
		this.setFormula(formula);
	}
	
	@Override
	public boolean equals(Object object) {
		if (object != null && this.getClass() == object.getClass()) {
			AlongOneFinally other = (AlongOneFinally) object;
			return this.getFormula().equals(other.getFormula());
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "EF(" + this.getFormula() + ")";
	}
	
	@Override
	public Formula dual() {
		return new AlongAllGlobally(new Not(this.getFormula()));
	}
}
