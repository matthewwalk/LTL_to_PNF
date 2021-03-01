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
	static Formula f1, f2, f3, f4, f5, f6;
	static S f1_S, f1_sol, f2_sol, f3_sol, f4_sol, f5_sol, f6_sol;
	static State s1, s2, s3;
	static AtomicProposition p1, p2, p3;
	
	static CTL_Evaluator eval;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		//ATOMIC PROPOSITIONS
		p1 = new AtomicProposition("p1");
		p2 = new AtomicProposition("p2");
		p3 = new AtomicProposition("p3");
		
		//FORMULAS
		f1 = p1;
		f2 = new Not(p1);
		f3 = new And(p1, p3);
		f4 = new Or(p1, p3);
		f5 = new Implies(p1, p3);
		f6 = new BidirectionalImplies(p1, p3);
		
		//STATES
		s1 = new State(1);
		s1.addProposition(p1);
		s1.addProposition(p2);
		s1.addProposition(p3);
		
		s2 = new State(p1, 2);
		
		s3 = new State(p3, 3);
		
		//SET OF STATES
		f1_S = new S();
		f1_S.addState(s1);
		f1_S.addState(s2);
		f1_S.addState(s3);
		
		//TRANSITIONS
		f1_S.addTransition(s1, s2);
		
		//SOLUTIONS
		f1_sol = new S();
		f1_sol.addState(s1);
		f1_sol.addState(s2);
		
		f2_sol = new S();
		f2_sol.addState(s3);
		
		f3_sol = new S();
		f3_sol.addState(s1);
		
		f4_sol = new S();
		f4_sol.addState(s1);
		f4_sol.addState(s2);
		f4_sol.addState(s3);
		
		f5_sol = new S();
		f5_sol.addState(s1);
		f5_sol.addState(s3);
		
		f6_sol = new S();
		f6_sol.addState(s1);
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("====================================================");
		eval = new CTL_Evaluator(f1_S); //setup with f1's set of states and transitions
	}

	@Test
	void test() {
		
		System.out.println("Formula: " + f1);
		System.out.println("System: " + f1_S);
		
		S testResult = f1.accept(eval);
		
		System.out.println("Solution: " + testResult);
		
		assertEquals(testResult, f1_sol);
	}
	
	@Test
	void test2() {
		
		System.out.println("Formula: " + f2);
		System.out.println("System: " + f1_S);
		
		S testResult = f2.accept(eval);
		
		System.out.println("Solution: " + testResult);
		
		assertEquals(testResult, f2_sol);
	}
	
	@Test
	void test3() {
		
		System.out.println("Formula: " + f3);
		System.out.println("System: " + f1_S);
		
		S testResult = f3.accept(eval);
		
		System.out.println("Solution: " + testResult);
		
		assertEquals(testResult, f3_sol);
	}
	
	@Test
	void test4() {
		
		System.out.println("Formula: " + f4);
		System.out.println("System: " + f1_S);
		
		S testResult = f4.accept(eval);
		
		System.out.println("Solution: " + testResult);
		
		assertEquals(testResult, f4_sol);
	}
	
	@Test
	void test5() {
		
		System.out.println("Formula: " + f5);
		System.out.println("System: " + f1_S);
		
		S testResult = f5.accept(eval);
		
		System.out.println("Solution: " + testResult);
		
		assertEquals(testResult, f5_sol);
	}
	
	@Test
	void test6() {
		
		System.out.println("Formula: " + f6);
		System.out.println("System: " + f1_S);
		
		S testResult = f6.accept(eval);
		
		System.out.println("Solution: " + testResult);
		
		assertEquals(testResult, f6_sol);
	}

}
