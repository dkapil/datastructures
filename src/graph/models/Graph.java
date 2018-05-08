package graph.models;

import java.util.Collection;
import java.util.Set;

public interface Graph<T, W> {

	void initialize(Collection<Vertex<T>> vertices);

	Set<Vertex<T>> getAllVertices();

	Set<Vertex<T>> getAdjacentVertices(Vertex<T> source);

	void removeVertex(Vertex<T> vertex);

	Graph<T, W> addEdge(Vertex<T> source, Vertex<T> destination);

	Graph<T, W> addEdge(Vertex<T> source, Vertex<T> destination, W weight);

	Graph<T, W> addEdge(Vertex<T> source, Vertex<T> destination, Integer flow, Integer capacity);

	Graph<T, W> addEdge(Vertex<T> source, Vertex<T> destination, W weight, Integer flow, Integer capacity);

	Edge<T, W> getEdge(Vertex<T> source, Vertex<T> target);

	Set<Edge<T, W>> getAllEdges();

	Graph<T, W> updateEdge(Vertex<T> source, Vertex<T> destination, W weight);

	Graph<T, W> updateEdge(Vertex<T> source, Vertex<T> destination, Integer flow, Integer capacity);

	Graph<T, W> updateEdge(Vertex<T> source, Vertex<T> destination, W weight, Integer flow, Integer capacity);

	void removeEdge(Vertex<T> source, Vertex<T> destination);

	Graph<T, W> transpose();

	void print();

}
