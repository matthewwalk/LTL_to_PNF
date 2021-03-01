package s;

import java.util.ArrayList;

import ctl_grammar.AtomicProposition;
import ctl_grammar.Not;

public class State {
	//Attributes
	ArrayList<AtomicProposition> ap;
	int id;
	
	public State() { //generate empty state
		super();
		this.ap = new ArrayList<AtomicProposition>();
		this.id = 0;
	}
	
	public State(int id) { //generate empty state
		super();
		this.ap = new ArrayList<AtomicProposition>();
		this.id = id;
	}
	
	public State(ArrayList<AtomicProposition> ap, int id) {
		super();
		this.ap = ap;
		this.id = id;
	}
	
	public State(AtomicProposition ap, int id) {
		super();
		this.ap = new ArrayList<AtomicProposition>();
		this.ap.add(ap);
		this.id = id;
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
	
	public int getId() {
		return id;
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
	
	@Override
	public String toString() {
		return ""+this.getId();
	}

}
