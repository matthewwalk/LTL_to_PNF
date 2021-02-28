package s;

import java.util.HashMap;
import java.util.Map.Entry;

public class Transition {
	
	HashMap<State, State> t;
	
	public Transition() {
		super();
		this.t = new HashMap<State, State>();
	}
	
	public void addTransition(State s1, State s2) {
		t.put(s1, s2);
	}
	
	@Override
	public String toString() {
		String result = "-> = {";
		for (Entry<State, State> e : t.entrySet()) {
			result += "(" + e.getKey().toString() + ", " + e.getValue().toString() + ")";
		}
		return result;
	}

}
