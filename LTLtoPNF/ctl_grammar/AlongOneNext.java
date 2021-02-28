package ctl_grammar;

import formula.Formula;
import formula.UnaryFormula;

public class AlongOneNext extends UnaryFormula {
	
	public AlongOneNext(Formula formula) {
		this.setFormula(formula);
	}
	
	@Override
	public boolean equals(Object object) {
		if (object != null && this.getClass() == object.getClass()) {
			AlongOneNext other = (AlongOneNext) object;
			return this.getFormula().equals(other.getFormula());
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "EX(" + this.getFormula() + ")";
	}
	
	@Override
	public Formula dual() {
		return new AlongAllNext(new Not(this.getFormula()));
	}
}
