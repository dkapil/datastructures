package graph.apps.shortestpaths.singlesource;

import java.util.Deque;

import graph.apps.TopologicalSort;
import graph.models.Graph;
import graph.models.Vertex;

public class SingleSourceDAG<T> extends SingleSourceShortestPath<T> {

	public void build(Graph<T, Integer> graph, Vertex<T> source) {

		TopologicalSort<T> topologicalSort = new TopologicalSort<>(graph);

		Deque<Vertex<T>> vertices = topologicalSort.getSortedVertices();
		vertices.forEach(System.out::println);

		initializeSingleSource(graph, source);

		for (Vertex<T> u : vertices) {
			for (Vertex<T> v : graph.getAdjacentVertices(u)) {
				relax(graph, u, v);
			}
		}
	}
}
