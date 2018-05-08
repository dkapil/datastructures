package graph.apps.shortestpaths.singlesource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import graph.models.Graph;
import graph.models.Vertex;

public class Dijkstra<T> extends SingleSourceShortestPath<T> {

	public void build(Graph<T, Integer> graph, Vertex<T> source) {

		System.out.println("Running Dijkstra");
		initializeSingleSource(graph, source);

		Set<Vertex<T>> s = new HashSet<>();

		List<Vertex<T>> q = new ArrayList<>();
		q.addAll(graph.getAllVertices());
		q.sort(Comparator.comparingInt(Vertex::getDistance));

		while (!q.isEmpty()) {
			Vertex<T> u = q.get(0);
			q.remove(0);
			s.add(u);
			for (Vertex<T> v : graph.getAdjacentVertices(u)) {
				relax(graph, u, v);
			}
			q.sort(Comparator.comparingInt(Vertex::getDistance));
		}
	}
}
