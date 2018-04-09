package graph.models;

import java.util.Objects;

// TODO: Auto-generated Javadoc
/**
 * The Class Edge.
 *
 * @param <T>
 *            the generic type
 * @param <W>
 *            the generic type
 */
public class Edge<T, W> {

	Vertex<T> source;

	Vertex<T> destination;

	W weight;

	/**
	 * Gets the source.
	 *
	 * @return the source
	 */
	public Vertex<T> getSource() {
		return source;
	}

	/**
	 * Sets the source.
	 *
	 * @param source
	 *            the new source
	 */
	public void setSource(Vertex<T> source) {
		this.source = source;
	}

	/**
	 * Gets the destination.
	 *
	 * @return the destination
	 */
	public Vertex<T> getDestination() {
		return destination;
	}

	/**
	 * Sets the destination.
	 *
	 * @param destination
	 *            the new destination
	 */
	public void setDestination(Vertex<T> destination) {
		this.destination = destination;
	}

	/**
	 * Gets the weight.
	 *
	 * @return the weight
	 */
	public W getWeight() {
		return weight;
	}

	/**
	 * Sets the weight.
	 *
	 * @param weight
	 *            the new weight
	 */
	public void setWeight(W weight) {
		this.weight = weight;
	}

	@Override
	public boolean equals(Object arg0) {
		if (arg0 instanceof Edge<?, ?>) {
			Edge<?, ?> other = (Edge<?, ?>) arg0;
			return (other.getSource().equals(this.getSource()) && other.getDestination().equals(this.destination))
					|| (other.getSource().equals(this.getDestination()) && other.getDestination().equals(this.source));
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.getSource(), this.getDestination());
	}

	@Override
	public String toString() {
		return source.toString() + "-" + weight.toString() + "->" + destination.toString();
	}

}
