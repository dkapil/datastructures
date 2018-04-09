package disjointset.models;

import graph.models.Vertex;

public class Element<T> {

	Vertex<T> value;

	public Vertex<T> getValue() {
		return value;
	}

	public void setValue(Vertex<T> value) {
		this.value = value;
	}

}
