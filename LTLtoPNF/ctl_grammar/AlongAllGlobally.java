package ctl_grammar;

import formula.Formula;
import formula.UnaryFormula;

public class AlongAllGlobally extends UnaryFormula{
	
	public AlongAllGlobally(Formula formula) {
		super();
		this.setFormula(formula);
	}
	
	@Override
	public boolean equals(Object object) {
		if (object != null && this.getClass() == object.getClass()) {
			AlongAllGlobally other = (AlongAllGlobally) object;
			return this.getFormula().equals(other.getFormula());
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "AG(" + this.getFormula() + ")";
	}
	
	@Override
	public Formula dual() {
		return new AlongOneFinally(new Not(this.getFormula()));
	}
}
