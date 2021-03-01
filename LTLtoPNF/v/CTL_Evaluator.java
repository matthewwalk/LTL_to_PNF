package v;

import java.util.Map.Entry;

import ctl_grammar.*;
import formula.*;
import s.*;

public class CTL_Evaluator implements Evaluator {
	
	private S s;
	
	//TODO assume these need to be set to ensure proper calculaton
	
	public CTL_Evaluator(S s) {
		setS(s);
	}
	
	private void setS(S s) {
		this.s = s;
	}

	@Override
	public S visit(Formula formula) {
		return formula.accept(this);
	}

	@Override
	public S visit(BinaryFormula binaryFormula) {
		System.out.println("Visited: " + binaryFormula);
		
		S L = visit(binaryFormula.getLeft());
		S R = visit(binaryFormula.getRight());
		
		//NORMAL PROPOSITIONAL LOGIC STUFF
		if (binaryFormula instanceof And) {
			S sat = L.And(R);
			System.out.println("States: " + sat.statesToString() + " satisfy: " + binaryFormula + ", for states L = " + L.statesToString() + ", and R = " + R.statesToString());
			return sat;
		}
		if (binaryFormula instanceof Or) {
			S sat = L.Or(R);
			System.out.println("States: " + sat.statesToString() + " satisfy: " + binaryFormula + ", for states L = " + L.statesToString() + ", and R = " + R.statesToString());
			return sat;
		}
		if (binaryFormula instanceof Implies) {
			S sat = s.doNotSatisfy(L).Or(R);
			System.out.println("States: " + sat.statesToString() + " satisfy: " + binaryFormula + ", for states L = " + L.statesToString() + ", and R = " + R.statesToString());
			return sat;
		}
		if (binaryFormula instanceof BidirectionalImplies) {
			S sat = (s.doNotSatisfy(L).Or(R)).And(s.doNotSatisfy(R).Or(L));
			System.out.println("States: " + sat.statesToString() + " satisfy: " + binaryFormula + ", for states L = " + L.statesToString() + ", and R = " + R.statesToString());
			return sat;
		}
		
		//FANCY PATH SHIT
		if (binaryFormula instanceof AlongAllUntil) {
			//First get all states that satisfy R
			S Rstates = s.satisfy(R);
			//Now Find all transitions that have R as the value
			for (Entry<State, State> e : s.getTransitions().getTransitions().entrySet()) {
				
			}
		}
		if (binaryFormula instanceof AlongAllWeakUntil) {
			
		}
		if (binaryFormula instanceof AlongOneUntil) {
			
		}
		if (binaryFormula instanceof AlongOneWeakUntil) {
			
		}
		
		return new S(); //something went wrong
	}

	@Override
	public S visit(UnaryFormula unaryFormula) {
		System.out.println("Visited: " + unaryFormula);
		
		S states = visit(unaryFormula.getFormula()); //get inner states/solution
		
		if (unaryFormula instanceof Not) {
			//return all other states
			S sat = s.doNotSatisfy(states);
			System.out.println("States: " + sat.statesToString() + " satify: " + unaryFormula + ", for states: " + states.statesToString());
			return sat;
		}
		
		return new S(); //error
	}

	@Override
	public S visit(ConstantFormula constantFormula) { //base cases
		System.out.println("Visited: " + constantFormula);
		
		if (constantFormula instanceof AtomicProposition) {
			//find which states satisfy this ap
			AtomicProposition ap = (AtomicProposition) constantFormula;
			S sat = s.satisfy(ap);
			System.out.println("States: " + sat.statesToString() + " satify the atomic proposition: " + ap);
			return sat;
		}
		
		if (constantFormula instanceof True) {
			return s;
		}
		
		if (constantFormula instanceof False) {
			return new S();
		}
		return new S(); //error
	}
	
	

}
