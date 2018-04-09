package disjointset.models;

// TODO: Auto-generated Javadoc
/**
 * The Class ForestElement.
 *
 * @param <T>
 *            the generic type
 */
public class ForestElement<T> extends Element<T> {

	ForestElement<T> parent;

	int rank;

	/**
	 * Gets the parent.
	 *
	 * @return the parent
	 */
	public ForestElement<T> getParent() {
		return parent;
	}

	/**
	 * Sets the parent.
	 *
	 * @param parent
	 *            the new parent
	 */
	public void setParent(ForestElement<T> parent) {
		this.parent = parent;
	}

	/**
	 * Gets the rank.
	 *
	 * @return the rank
	 */
	public int getRank() {
		return rank;
	}

	/**
	 * Sets the rank.
	 *
	 * @param rank
	 *            the new rank
	 */
	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return value.toString();
	}
}
