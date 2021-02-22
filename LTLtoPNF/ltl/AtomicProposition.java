package ltl;

/**
 * This class represents the LTL formula consisting of an atomic proposition.
 */
public class AtomicProposition extends ConstantFormula {

	/**
	 * Initializes this LTL formula as an atomic proposition with the given name.
	 * 
	 * @param name the name of this atomic proposition
	 */
	public AtomicProposition(String name) {
		this.setValue(name);
	}

	/**
	 * Returns a hashcode value for the object.
	 * 
	 * @return The hashcode value associated for this object.
	 */
	@Override
	public int hashCode() {
		return this.getValue().hashCode();
	}

	/**
	 * Indicates whether some other object is "equal to" this one.
	 * 
	 * @return true if this object is the same as the obj argument; false otherwise.
	 */
	@Override
	public boolean equals(Object object) {
		if (object != null && this.getClass() == object.getClass()) {
			AtomicProposition other = (AtomicProposition) object;
			return this.getValue().equals(other.getValue());
		} else {
			return false;
		}
	}

	/**
	 * Returns a string representation of the object.
	 * 
	 * @return a string representation of the object.
	 */
	@Override
	public String toString() {
		return this.getValue().toString(); //TODO might not output actual name
	}

}
