package graph.models;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// TODO: Auto-generated Javadoc
/**
 * The Class Vertex.
 *
 * @param <VALUE>
 *            the generic type
 */
public class Vertex<VALUE> {

	int id;

	VALUE value;

	int distance;

	int discoveredTime;

	int finishedTime;

	Map<Vertex<VALUE>, Integer> weightsMap = new HashMap<>();

	/**
	 * Gets the discovered time.
	 *
	 * @return the discovered time
	 */
	public int getDiscoveredTime() {
		return discoveredTime;
	}

	/**
	 * Sets the discovered time.
	 *
	 * @param discoveredTime
	 *            the new discovered time
	 */
	public void setDiscoveredTime(int discoveredTime) {
		this.discoveredTime = discoveredTime;
	}

	/**
	 * Gets the finished time.
	 *
	 * @return the finished time
	 */
	public int getFinishedTime() {
		return finishedTime;
	}

	/**
	 * Sets the finished time.
	 *
	 * @param finishedTime
	 *            the new finished time
	 */
	public void setFinishedTime(int finishedTime) {
		this.finishedTime = finishedTime;
	}

	String color;

	Vertex<VALUE> parent;

	/**
	 * Instantiates a new vertex.
	 *
	 * @param id
	 *            the id
	 * @param value
	 *            the value
	 */
	public Vertex(int id, VALUE value) {
		this.id = id;
		this.value = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object other) {
		if (other instanceof Vertex<?>) {
			return ((Vertex<?>) other).getId() == id;
		}
		return false;
	}

	/**
	 * Gets the color.
	 *
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Gets the distance.
	 *
	 * @return the distance
	 */
	public int getDistance() {
		return distance;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Gets the parent.
	 *
	 * @return the parent
	 */
	public Vertex<VALUE> getParent() {
		return parent;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public VALUE getValue() {
		return value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Objects.hashCode(this.id);
	}

	/**
	 * Sets the color.
	 *
	 * @param color
	 *            the new color
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Sets the distance.
	 *
	 * @param distance
	 *            the new distance
	 */
	public void setDistance(int distance) {
		this.distance = distance;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Sets the parent.
	 *
	 * @param parent
	 *            the new parent
	 */
	public void setParent(Vertex<VALUE> parent) {
		this.parent = parent;
	}

	/**
	 * Sets the value.
	 *
	 * @param value
	 *            the new value
	 */
	public void setValue(VALUE value) {
		this.value = value;
	}

	public Map<Vertex<VALUE>, Integer> getWeightsMap() {
		return weightsMap;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.valueOf(this.value);
	}

}
