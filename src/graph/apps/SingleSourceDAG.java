package graph.apps;

import java.util.Deque;

import graph.models.Graph;
import graph.models.Vertex;

public class SingleSourceDAG<T, W> extends SingleSource<T, W> {

	public void build(Graph<T, W> graph) {

		TopologicalSort<T, W> topologicalSort = new TopologicalSort<>(graph);

		Deque<Vertex<T>> vertices = topologicalSort.getSortedVertices();
		vertices.forEach(System.out::println);

		initializeSingleSource(graph);

		for (Vertex<T> u : vertices) {
			for (Vertex<T> v : graph.getAdjacentVertices(u)) {
				relax(u, v);
			}
		}
	}
}
