package ctl_grammar;

import formula.Formula;
import formula.UnaryFormula;

public class AlongOneGlobally extends UnaryFormula {
	
	public AlongOneGlobally(Formula formula) {
		super();
		this.setFormula(formula);
	}
	
	@Override
	public boolean equals(Object object) {
		if (object != null && this.getClass() == object.getClass()) {
			AlongOneGlobally other = (AlongOneGlobally) object;
			return this.getFormula().equals(other.getFormula());
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "EG(" + this.getFormula() + ")";
	}
	
	@Override
	public Formula dual() {
		return new AlongAllFinally(new Not(this.getFormula()));
	}
}
