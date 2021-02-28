package s;

import java.util.ArrayList;

import ctl_grammar.AtomicProposition;
import ctl_grammar.False;
import ctl_grammar.Not;

public class S {
	
	ArrayList<State> states;
	
	public S() {
		super();
		this.states = new ArrayList<State>();
	}
	
	public S(ArrayList<State> states) {
		super();
		this.states = states;
	}
	
	public void addState(State s) {
		states.add(s);
	}
	
	public ArrayList<AtomicProposition> L(int s) {
		return states.get(s).getAPs();
	}
	
	public S satisfy(AtomicProposition ap) {
		ArrayList<State> result = new ArrayList<State>();
		for (State s : this.states) {
			if (s.satisfies(ap)) result.add(s);
		}
		return new S(result);
	}
	
	public S satisfy(S states) {
		ArrayList<State> result = new ArrayList<State>();
		for (State r : states.getStates()) {
			for (State s : this.states) {
				if (r.equals(s)) result.add(s);
			}
		}
		return new S(result);
	}
	
	
	public S doNotSatisfy(AtomicProposition ap) {
		ArrayList<State> result = new ArrayList<State>();
		for (State s : this.states) {
			if (!s.satisfies(ap)) result.add(s);
		}
		return new S(result);
	}
	
	public S doNotSatisfy(S states) {
		ArrayList<State> result = new ArrayList<State>();
		for (State r : states.getStates()) {
			for (State s : this.states) {
				if (!r.equals(s)) result.add(s);
			}
		}
		return new S(result);
	}
	
	private ArrayList<State> getStates() {
		return this.states;
	}
	
	@Override
	public boolean equals(Object object) {
		if (object != null && this.getClass() == object.getClass()) {
			S other = (S) object;
			return this.getStates().equals(other.getStates());
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		String result = "S = {";
		for (int i = 0; i < states.size(); i++)
			result += i == states.size()-1 ? i : i + ", ";
		result += "}\n";
		for (int i = 0; i < states.size(); i++) {
			result += "\tL(" + i + ") = {" + L(i).toString() + "}\n";
		}
		return result;
	}

}
