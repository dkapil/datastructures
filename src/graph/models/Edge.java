package graph.models;

import java.util.Objects;

/**
 * The Edge.
 *
 * @param <T> the generic type
 * @param <W> the generic type
 */
public class Edge<T, W> {

	Vertex<T> source;

	Vertex<T> destination;

	W weight;

	int flow;

	int capacity;

	public Vertex<T> getSource() {
		return source;
	}

	public void setSource(Vertex<T> source) {
		this.source = source;
	}

	public Vertex<T> getDestination() {
		return destination;
	}

	public void setDestination(Vertex<T> destination) {
		this.destination = destination;
	}

	public W getWeight() {
		return weight;
	}

	public void setWeight(W weight) {
		this.weight = weight;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setFlow(int flow) {
		this.flow = flow;
	}

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
