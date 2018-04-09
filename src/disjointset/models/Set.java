package disjointset.models;

// TODO: Auto-generated Javadoc
/**
 * The Class Set.
 *
 * @param <VERTEX>
 *            the generic type
 */
public class Set<VERTEX> {

	SetElement<VERTEX> head;

	SetElement<VERTEX> tail;

	/**
	 * Gets the head.
	 *
	 * @return the head
	 */
	public SetElement<VERTEX> getHead() {
		return head;
	}

	/**
	 * Sets the head.
	 *
	 * @param head
	 *            the new head
	 */
	public void setHead(SetElement<VERTEX> head) {
		this.head = head;
	}

	/**
	 * Gets the tail.
	 *
	 * @return the tail
	 */
	public SetElement<VERTEX> getTail() {
		return tail;
	}

	/**
	 * Sets the tail.
	 *
	 * @param tail
	 *            the new tail
	 */
	public void setTail(SetElement<VERTEX> tail) {
		this.tail = tail;
	}

	public void printSet() {
		SetElement<VERTEX> h = this.head;
		System.out.print("[");
		while (h != null) {
			System.out.print(h + ",");
			h = h.next;
		}
		System.out.print("]");
		System.out.println();
	}
}
