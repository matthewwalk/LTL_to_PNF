package v;

import formula.*;
import s.*;

/**
 * This class represents the Visitor interface for LTL formulas.
 */
public interface Evaluator {
	/**
	 * Visits a generic CTL formula
	 * 
	 * @param formula the generic CTL formula to visit
	 */
    S visit(Formula formula);
    
	/**
	 * Visits a generic binary CTL formula
	 * 
	 * @param binaryFormula the generic CTL formula to visit
	 */
    S visit(BinaryFormula binaryFormula);
    
	/**
	 * Visits a generic unary CTL formula
	 * 
	 * @param unaryFormula the generic CTL formula to visit
	 */
    S visit(UnaryFormula unaryFormula);
    
	/**
	 * Visits a generic constant CTL formula
	 * 
	 * @param constantFormula the generic CTL formula to visit
	 */
    S visit(ConstantFormula constantFormula);
}
