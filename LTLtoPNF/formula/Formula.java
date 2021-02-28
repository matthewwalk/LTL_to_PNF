package formula;

import s.S;
import v.Evaluator;
import v.Visitor;

/**
 * This class represents an arbitrary LTL formula.
 */
public abstract class Formula {
	
	public abstract Formula dual();
	
	public abstract Formula accept(Visitor visitor);
	
	public abstract S accept(Evaluator evaluator);
}
