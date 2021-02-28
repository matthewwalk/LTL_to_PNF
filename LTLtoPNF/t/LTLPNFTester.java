package t;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import ltl_grammar.*;
import formula.*;
import v.LTLtoPNFVisitor;

class LTLPNFTester {

	static Formula formula, formula2, formula3, formula4, formula5;
	static Formula formula_sol, formula2_sol, formula3_sol, formula4_sol;

	static LTLtoPNFVisitor normalizer;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Beginning setup...");
		normalizer = new LTLtoPNFVisitor();
		formula = new Not(new Next(new Until(new AtomicProposition("a"), new Not(new AtomicProposition("b")))));
		formula2 = new Not(new WeakUntil(new AtomicProposition("a"), new Not(new AtomicProposition("b"))));
		formula3 = new Until(new Not(new Not(new Not(new True()))),
				new And(new AtomicProposition("a"), new AtomicProposition("b")));
		formula4 = new Until(new Not(new AtomicProposition("a")),
				new Until(new AtomicProposition("b"), new Not(new AtomicProposition("c")))); // should not change
		formula5 = new And(new And(new And(new Not(new And(new And(new AtomicProposition("p2"), new AtomicProposition("p3")), new True())), new True()), new AtomicProposition("p1")), new True());

		
		formula_sol = new Next(new WeakUntil(new And(new AtomicProposition("a"), new AtomicProposition("b")),
				new And(new Not(new AtomicProposition("a")), new AtomicProposition("b"))));
		formula2_sol = new Until(new And(new AtomicProposition("a"), new AtomicProposition("b")),
				new And(new Not(new AtomicProposition("a")), new AtomicProposition("b")));
		formula3_sol = new Until(new False(),
				new And(new AtomicProposition("a"), new AtomicProposition("b")));
		formula4_sol = new Until(new Not(new AtomicProposition("a")),
				new Until(new AtomicProposition("b"), new Not(new AtomicProposition("c"))));
		
		
		System.out.println("Finished setup!");
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test_formula() {
		System.out.println("==================================================");
		System.out.println(formula.toString());

		Formula PNF = formula.accept(normalizer);

		System.out.println(PNF.toString());

		assertEquals(PNF, formula_sol);
		assertEquals(PNF.toString(), formula_sol.toString());
	}

	@Test
	void test_formula2() {
		System.out.println("==================================================");
		System.out.println(formula2.toString());

		Formula PNF = formula2.accept(normalizer);

		System.out.println(PNF.toString());

		assertEquals(PNF, formula2_sol);
		assertEquals(PNF.toString(), formula2_sol.toString());
	}

	@Test
	void test_formula3() {
		System.out.println("==================================================");
		System.out.println(formula3.toString());

		Formula PNF = formula3.accept(normalizer);

		System.out.println(PNF.toString());

		assertEquals(PNF, formula3_sol);
		assertEquals(PNF.toString(), formula3_sol.toString());
	}

	@Test
	void test_formula4() {
		System.out.println("==================================================");
		System.out.println(formula4.toString());

		Formula PNF = formula4.accept(normalizer);

		System.out.println(PNF.toString());

		assertEquals(PNF, formula4_sol);
		assertEquals(PNF.toString(), formula4_sol.toString());
	}

	@Test
	void test_formula5() {
		System.out.println("==================================================");
		System.out.println(formula5.toString());

		Formula PNF = formula5.accept(normalizer);

		System.out.println(PNF.toString());

		//assertEquals(PNF, formula4_sol);
		assertEquals(PNF.toString(), "(((((! p2 || ! p3) || false) && true) && p1) && true)");
	}
}
