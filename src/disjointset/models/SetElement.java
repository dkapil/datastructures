package disjointset.models;

import java.util.Objects;

public class SetElement<T> extends Element<T> {

	Set<T> set;

	SetElement<T> next;

	public Set<T> getSet() {
		return set;
	}

	public void setSet(Set<T> set) {
		this.set = set;
	}

	public SetElement<T> getNext() {
		return next;
	}

	public void setNext(SetElement<T> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return value.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object other) {
		if (other instanceof SetElement<?>) {
			return ((SetElement<?>) other).getValue() == value;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Objects.hashCode(this.value);
	}

}
