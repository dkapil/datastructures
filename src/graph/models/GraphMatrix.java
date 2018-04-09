package graph.models;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class GraphMatrix<T, W extends Object> implements Graph<T, W> {

	Object[][] arr2d;

	Set<Vertex<T>> vertices;

	@Override
	public void initialize(Collection<Vertex<T>> vertices) {
		vertices = new HashSet<>(vertices);
		arr2d = new Object[vertices.size()][vertices.size()];
	}

	@Override
	public Set<Vertex<T>> getAllVertices() {
		return vertices;
	}

	@Override
	public Set<Vertex<T>> getAdjacentVertices(Vertex<T> start) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Graph<T, W> addEdge(Vertex<T> start, Vertex<T> end) {
		arr2d[start.getId()][end.getId()] = 1;
		return this;
	}

	@Override
	public void removeEdge(Vertex<T> start, Vertex<T> end) {
		arr2d[start.getId()][end.getId()] = 0;
	}

	@Override
	public Graph<T, W> addEdge(Vertex<T> start, Vertex<T> end, W weight) {
		arr2d[start.getId()][end.getId()] = weight;
		return this;
	}

	@Override
	public void print() {
		for (int row = 0; row < arr2d.length; row++) {
			for (int col = 0; col < arr2d.length; col++) {
				System.out.print("|" + arr2d[row][col] + "|");
			}
			System.out.println();
		}
	}

	@Override
	public Graph<T, W> transpose() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Edge<T, W>> getAllEdges() {
		// TODO Auto-generated method stub
		return null;
	}
}
