package ctl_grammar;

import formula.Formula;
import formula.UnaryFormula;

public class AlongAllFinally extends UnaryFormula {
	
	public AlongAllFinally(Formula formula) {
		super();
		this.setFormula(formula);
	}
	
	@Override
	public boolean equals(Object object) {
		if (object != null && this.getClass() == object.getClass()) {
			AlongAllFinally other = (AlongAllFinally) object;
			return this.getFormula().equals(other.getFormula());
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "AF("  + this.getFormula() + ")";
	}
	
	@Override
	public Formula dual() {
		return new AlongOneGlobally(new Not(this.getFormula()));
	}
}
