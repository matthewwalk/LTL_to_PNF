package t;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ctl_grammar.*;
import formula.*;
import s.*;
import v.*;

class CTLEvaluatorTester {
	static Formula f1, f2;
	static S f1_S, f1_sol, f2_sol;
	static State s1, s2, s3;
	static AtomicProposition p1, p2, p3;
	static Transition t;
	
	static CTL_Evaluator eval;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		//ATOMIC PROPOSITIONS
		p1 = new AtomicProposition("p1");
		p2 = new AtomicProposition("p2");
		p3 = new AtomicProposition("p3");
		
		//FORMULAS
		f1 = new AtomicProposition("p1");
		f2 = new Not(new AtomicProposition("p1"));
		
		//STATES
		s1 = new State();
		s1.addProposition(p1);
		s1.addProposition(p2);
		s1.addProposition(p3);
		
		s2 = new State();
		s2.addProposition(p1);
		
		s3 = new State();
		s3.addProposition(p3);
		
		//SET OF STATES
		f1_S = new S();
		f1_S.addState(s1);
		f1_S.addState(s2);
		f1_S.addState(s3);
		
		//TRANSITIONS
		t = new Transition();
		t.addTransition(s1, s2);
		
		//SOLUTIONS
		f1_sol = new S();
		f1_sol.addState(s1);
		f1_sol.addState(s2);
		
		f2_sol = new S();
		f2_sol.addState(s3);
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("====================================================");
		eval = new CTL_Evaluator(f1_S, t); //setup with f1's set of states and transitions
	}

	@Test
	void test() {
		
		System.out.println("Formula: " + f1);
		System.out.println("States: " + f1_S);
		System.out.println("Transitions: " + t);
		
		S testResult = f1.accept(eval);
		
		System.out.println("Solution: " + testResult);
		
		assertEquals(testResult, f1_sol);
	}
	
	@Test
	void test2() {
		
		System.out.println("Formula: " + f2);
		System.out.println("States: " + f1_S);
		System.out.println("Transitions: " + t);
		
		S testResult = f2.accept(eval);
		
		System.out.println("Solution: " + testResult);
		
		assertEquals(testResult, f2_sol);
	}

}
