package ltl;

import v.Visitor;

/**
 * This class represents an arbitrary LTL formula.
 */
public abstract class Formula {
	
	public abstract Formula dual();
	
	public abstract Formula accept(Visitor visitor);
}
