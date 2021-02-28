package formula;

import ctl_grammar.And;
import ctl_grammar.Not;
import v.Visitor;

/**
 * This class represents a generic unary LTL formula type consisting of one sub formula.
 */
public class UnaryFormula extends Formula {

	private Formula formula;
	
	@Override
	public Formula dual() {
		return this;
	}

	/**
	 * Gets the subformula of this unary formula
	 * 
	 * @return the left subformula of this unary formula
	 */
	public Formula getFormula() {
		return formula;
	}

	/**
	 * Sets the subformula of this unary formula
	 * 
	 * @param formula the formula to be set as the subformula
	 */
	public void setFormula(Formula formula) {
		this.formula = formula;
	}

	/**
	 * Accepts a formula visitor
	 * 
	 * @param visitor the visitor to accept
	 * 
	 * @return the result of visitor.visit(this)
	 */
	@Override
	public Formula accept(Visitor visitor) {
		return visitor.visit(this);
	}

}
