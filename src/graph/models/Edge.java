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

	int flow;

	int capacity;

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

	/**
	 * Sets the capacity.
	 *
	 * @param capacity
	 *            the new capacity
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * Gets the capacity.
	 *
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * Sets the flow.
	 *
	 * @param flow
	 *            the new flow
	 */
	public void setFlow(int flow) {
		this.flow = flow;
	}

	/**
	 * Gets the flow.
	 *
	 * @return the flow
	 */
	public int getFlow() {
		return flow;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object arg0) {
		if (arg0 instanceof Edge<?, ?>) {
			Edge<?, ?> other = (Edge<?, ?>) arg0;
			return (other.getSource().equals(this.getSource()) && other.getDestination().equals(this.destination))
					|| (other.getSource().equals(this.getDestination()) && other.getDestination().equals(this.source));
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
		return Objects.hash(this.getSource(), this.getDestination());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return source.toString() + "->" + destination.toString();
	}

}
