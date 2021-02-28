package v;

import formula.*;
import ctl_grammar.*;

/**
 * This class is a formula visior class which implements the methods defined in Visitor.
 * </br> Moreover, it traverses the structure of a generic CTL formula and creates a new LTL formula which represents the PNF of the formula that accepts it.
 */
public class CTLtoPNFVisitor implements Visitor {
	/**
	 * Visits a generic CTL formula
	 * 
	 * @param formula the generic formula to visit
	 */
	@Override
	public Formula visit(Formula formula) {
		return formula.accept(this);
	}

	/**
	 * Visits a Binary CTL formula
	 * 
	 * </br> Firstly, the left and right subformulas are visited and then on the traversal back up a new Formula is generated consisting of the type of Binary formula this formula is and it's left and right subformulas
	 * 
	 * @param binaryFormula the generic binary formula to visit
	 * 
	 * @return And(L, R), Or(L, R), Until(L, R), WeakUntil(L, R) depending on the type of binary formula supplied in the parameter
	 * </br> null if something goes wrong
	 */
	@Override
	public Formula visit(BinaryFormula binaryFormula) {
		System.out.println("Visited: " + binaryFormula);
		
		//visit and process left and right subformulas
		Formula L = visit(binaryFormula.getLeft());
		Formula R = visit(binaryFormula.getRight());
		
		//generate and return appropriate formula type
		if (binaryFormula instanceof And) return new And(L, R);
		if (binaryFormula instanceof Or) return new Or(L, R);
		if (binaryFormula instanceof Implies) return new Implies(L, R);
		if (binaryFormula instanceof BidirectionalImplies) return new BidirectionalImplies(L, R);
		if (binaryFormula instanceof AlongAllUntil) return new AlongAllUntil(L, R);
		if (binaryFormula instanceof AlongAllWeakUntil) return new AlongAllWeakUntil(L, R);
		if (binaryFormula instanceof AlongOneUntil) return new AlongOneUntil(L, R);
		if (binaryFormula instanceof AlongOneWeakUntil) return new AlongOneWeakUntil(L, R);
		
		return null; //something went wrong
	}

	/**
	 * Visits a unary CTL formula
	 * 
	 * </br> Firstly, it is determined whether the unary formula is of type Not and if so, distributes the Not into the subformula by applying the correct dual transformation. Ultimately, a new Formula object is returned.
	 * 
	 * @param unaryFormula the generic unary formula to visit
	 * 
	 * @return Next(C), C, or Not(C) depending on the type of unary formula supplied in the parameter and the type of dual transformation required to achieve PNF
	 * </br> null if something goes wrong
	 */
	@Override
	public Formula visit(UnaryFormula unaryFormula) {
		System.out.println("Visited: " + unaryFormula); //TODO can be removed
		boolean swapped = false; //reset the swapping mechanism
		
		//check if the unary formula is of type Not and if it's subformula is not an Atomic Proposition
		if (unaryFormula instanceof Not && !(unaryFormula.getFormula() instanceof AtomicProposition)) {
			//check if the subformula is of type Not (double negation)
			if (unaryFormula.getFormula() instanceof Not) {
				//Cast the subformula to the appropriate type
				Not tmp = (Not) unaryFormula.getFormula();
				System.out.println("\tswapped: " + unaryFormula.toString() + " with: " + tmp.getFormula()); //TODO can be removed
				unaryFormula.setFormula(tmp.getFormula()); // remove the double negation
			} else { //Not a double negation -> need to swap with dual
				System.out.println("\tswapped: " + unaryFormula.toString() + " with: " + unaryFormula.dual()); //TODO can be removed
				unaryFormula.setFormula(unaryFormula.dual()); //replaces the next subtree not the root
			}
			swapped = true; // set the swapping mechanism to true
		}
		
		//visit and process all subformulas
		Formula C = visit(unaryFormula.getFormula()); 
		
		//generate and return appropriate formula type
		if (unaryFormula instanceof Not) return swapped ? C : new Not(C);
		if (unaryFormula instanceof AlongAllFinally) return new AlongAllFinally(C);
		if (unaryFormula instanceof AlongAllGlobally) return new AlongAllGlobally(C);
		if (unaryFormula instanceof AlongAllNext) return new AlongAllNext(C);
		if (unaryFormula instanceof AlongOneFinally) return new AlongOneFinally(C);
		if (unaryFormula instanceof AlongOneGlobally) return new AlongOneGlobally(C);
		if (unaryFormula instanceof AlongOneNext) return new AlongOneNext(C);
		
		return null; //something went wrong
	}
	
	
	/**
	 * Visits a constant CTL formula
	 * 
	 * </br> Generally, a constant is a leaf in an expression tree and this signifies the end of a particular branch of the formula.
	 * 
	 * @param constantFormula the generic constant formula to visit
	 * 
	 * @return constantFormula
	 */
	@Override
	public Formula visit(ConstantFormula constantFormula) {
		System.out.println("Visited: " + constantFormula);
		return constantFormula;
	}

}
