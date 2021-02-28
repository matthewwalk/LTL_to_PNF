package s;

import java.util.ArrayList;

import ctl_grammar.AtomicProposition;
import ctl_grammar.Not;

public class State {
	//Attributes
	ArrayList<AtomicProposition> ap;
	
	public State() { //generate empty state
		super();
		this.ap = new ArrayList<AtomicProposition>();
	}
	
	public State(ArrayList<AtomicProposition> ap) {
		super();
		this.ap = ap;
	}
	
	@Override
	public boolean equals(Object object) {
		if (object != null && this.getClass() == object.getClass()) {
			State other = (State) object;
			return this.getAPs().equals(other.getAPs());
		} else {
			return false;
		}
	}
	
	public ArrayList<AtomicProposition> getAPs() {
		return ap;
	}
	
	public void addProposition(AtomicProposition ap) {
		this.ap.add(ap);
	}
	
	public boolean satisfies(ArrayList<AtomicProposition> ap) {
		return getAPs().containsAll(ap);
	}
	
	public boolean satisfies(AtomicProposition ap) {
		return getAPs().contains(ap);
	}

}
