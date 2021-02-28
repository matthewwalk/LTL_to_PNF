package ctl_grammar;

import formula.Formula;
import formula.UnaryFormula;

public class AlongAllNext extends UnaryFormula {
	
	public AlongAllNext(Formula formula) {
		super();
		this.setFormula(formula);
	}
	
	@Override
	public boolean equals(Object object) {
		if (object != null && this.getClass() == object.getClass()) {
			AlongAllNext other = (AlongAllNext) object;
			return this.getFormula().equals(other.getFormula());
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "AX(" + this.getFormula() + ")";
	}
	
	@Override
	public Formula dual() {
		return new AlongOneNext(new Not(this.getFormula()));
	}
}
