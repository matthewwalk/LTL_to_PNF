package s;

import java.util.ArrayList;
import java.util.Map.Entry;

import ctl_grammar.AtomicProposition;

public class S {
	
	ArrayList<State> states;
	Transition transitions;
	
	public S() {
		super();
		this.states = new ArrayList<State>();
		this.transitions = new Transition();
	}
	
	public S(ArrayList<State> states) {
		super();
		this.states = states;
	}
	
	public S(ArrayList<State> states, Transition transitions) {
		super();
		this.states = states;
		this.transitions = transitions;
	}
	
	public void addState(State s) {
		states.add(s);
	}
	
	public void removeState(State s) {
		states.remove(s);
	}
	
	public void addTransition(State s1, State s2) {
		this.transitions.addTransition(s1, s2);
	}
	
	public Transition getTransitions() {
		return this.transitions;
	}
	
	@SuppressWarnings("unchecked") // TODO might need work
	public ArrayList<AtomicProposition> L(int s) {
		return (ArrayList<AtomicProposition>) states.get(s).getAPs().clone();
	}
	
	public S And(S other) { // TODO optimize
		S result = new S(this.getStates());
		for (State s : result.getStates()) {
			if (!other.getStates().contains(s)) result.removeState(s);
		}
		return result;
	}
	
	public S Or(S other) {
		S result = new S(this.getStates());
		for (State s : other.getStates()) {
			if (!result.getStates().contains(s)) result.addState(s);
		}
		return result;
	}
	
	public S AlongAllUntil(S other) { //TODO incorrect implementation
		S result = new S(other.getStates());
		for (Entry<State, State> e : this.getTransitions().getTransitions().entrySet()) {
			if (result.getStates().contains(e.getValue())) {
				result.addState(e.getKey());
			}
		}
		return result;
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
		for (State s : this.getStates()) {
			if (states.getStates().contains(s)) result.add(s);
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
		for (State s : this.getStates()) {
			if (!states.getStates().contains(s)) result.add(s);
		}
		return new S(result);
	}
	
	@SuppressWarnings("unchecked") //TODO possibly needs work?
	private ArrayList<State> getStates() {
		return (ArrayList<State>) this.states.clone();
	}
	
	@Override
	public boolean equals(Object object) {
		if (object != null && this.getClass() == object.getClass()) {
			S other = (S) object;
			return this.getStates().containsAll(other.getStates()) && this.getStates().size() == other.getStates().size();
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		String result = "S = {";
		for (int i = 0; i < states.size(); i++)
			result += i == states.size()-1 ? states.get(i) : states.get(i) + ", ";
		result += "}\n";
		result += this.transitions + "\n";
		for (int i = 0; i < states.size(); i++) {
			result += "\tL(" + states.get(i) + ") = {" + L(i).toString() + "}\n";
		}
		return result;
	}
	
	public String statesToString() {
		String result = "S = {";
		for (int i = 0; i < states.size(); i++)
			result += i == states.size()-1 ? states.get(i) : states.get(i) + ", ";
		result += "}";
		return result;
	}

}
