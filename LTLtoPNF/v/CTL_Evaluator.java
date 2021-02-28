package v;

import ctl_grammar.*;
import formula.*;
import s.*;

public class CTL_Evaluator implements Evaluator {
	
	private S s;
	private Transition t;
	private S result;
	
	//TODO assume these need to be set to ensure proper calculaton
	
	public CTL_Evaluator(S s, Transition t) {
		setS(s);
		setT(t);
		result = s; //Assume all states are satisfied to start
	}
	
	private void setS(S s) {
		this.s = s;
	}
	private void setT(Transition t) {
		this.t = t;
	}

	@Override
	public S visit(Formula formula) {
		return formula.accept(this);
	}

	@Override
	public S visit(BinaryFormula binaryFormula) {
		System.out.println("Visited: " + binaryFormula);
		return result;
		// TODO Auto-generated method stub
		
	}

	@Override
	public S visit(UnaryFormula unaryFormula) {
		System.out.println("Visited: " + unaryFormula);
		
		S states = visit(unaryFormula.getFormula()); //get inner states/solution
		
		if (unaryFormula instanceof Not) {
			//return all other states
			S sat = s.doNotSatisfy(states);
			System.out.println("States: " + sat + " do not satify " + states);
			return s.doNotSatisfy(states);
		}
		
		return new S();
	}

	@Override
	public S visit(ConstantFormula constantFormula) { //base cases
		System.out.println("Visited: " + constantFormula);
		
		if (constantFormula instanceof AtomicProposition) {
			//find which states satisfy this ap
			AtomicProposition ap = (AtomicProposition) constantFormula;
			S sat = s.satisfy(ap);
			System.out.println("States: " + sat + " satify the atomic proposition: " + ap);
			return sat;
		}
		
		if (constantFormula instanceof True) {
			return s;
		}
		
		if (constantFormula instanceof False) {
			return new S();
		}
		return null; //error
	}
	
	

}
