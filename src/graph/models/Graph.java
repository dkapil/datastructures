package graph.models;

import java.util.Collection;
import java.util.Set;

public interface Graph<T, W> {

	void initialize(Collection<Vertex<T>> vertices);

	Set<Vertex<T>> getAllVertices();

	Set<Edge<T, W>> getAllEdges();

	Set<Vertex<T>> getAdjacentVertices(Vertex<T> start);

	Graph<T, W> addEdge(Vertex<T> start, Vertex<T> end, W weight);

	Graph<T, W> addEdge(Vertex<T> start, Vertex<T> end);

	void removeEdge(Vertex<T> start, Vertex<T> end);

	Graph<T, W> transpose();

	void print();

}
