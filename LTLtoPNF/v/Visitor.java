package v;

import formula.*;

/**
 * This class represents the Visitor interface for LTL formulas.
 */
public interface Visitor {
	/**
	 * Visits a generic LTL formula
	 * 
	 * @param formula the generic LTL formula to visit
	 */
    Formula visit(Formula formula);
    
	/**
	 * Visits a generic binary LTL formula
	 * 
	 * @param binaryFormula the generic LTL formula to visit
	 */
    Formula visit(BinaryFormula binaryFormula);
    
	/**
	 * Visits a generic unary LTL formula
	 * 
	 * @param unaryFormula the generic LTL formula to visit
	 */
    Formula visit(UnaryFormula unaryFormula);
    
	/**
	 * Visits a generic constant LTL formula
	 * 
	 * @param constantFormula the generic LTL formula to visit
	 */
    Formula visit(ConstantFormula constantFormula);
}
