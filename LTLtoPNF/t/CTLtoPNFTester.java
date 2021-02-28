package t;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import ctl_grammar.*;
import formula.*;
import v.CTLtoPNFVisitor;

class CTLtoPNFTester {
	static Formula formula, formula2, formula3, formula4, formula5;
	static Formula formula_sol, formula2_sol, formula3_sol, formula4_sol;

	static CTLtoPNFVisitor normalizer;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Beginning setup...");
		
		normalizer = new CTLtoPNFVisitor();
		
		formula = new Not(new AlongAllFinally(new AtomicProposition("a")));
		
		formula2 = new Not(new AlongAllUntil(new Not(new AtomicProposition("a")), new And(new AlongOneFinally(new AtomicProposition("b")), new AtomicProposition("c"))));
		
		formula_sol = new AlongOneGlobally(new Not(new AtomicProposition("a")));
		
		System.out.println("Finished setup!");
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test_formula() {
		System.out.println("==================================================");
		System.out.println("Initial Formula: " + formula.toString());

		Formula PNF = formula.accept(normalizer);

		System.out.println("Solution: " + PNF.toString());

		assertEquals(PNF, formula_sol);
		assertEquals(PNF.toString(), formula_sol.toString());
	}
	
	@Test
	void test_formula2() {
		System.out.println("==================================================");
		System.out.println("Initial Formula: " + formula2.toString());

		Formula PNF = formula2.accept(normalizer);

		System.out.println("Solution: " + PNF.toString());

		//assertEquals(PNF, formula2_sol);
		assertEquals(PNF.toString(), "E((! a && (AG(! b) || ! c)) W (a && (AG(! b) || ! c)))");
	}

}
