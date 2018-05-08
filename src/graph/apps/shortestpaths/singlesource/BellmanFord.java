package graph.apps.shortestpaths.singlesource;

import java.util.stream.IntStream;

import graph.models.Edge;
import graph.models.Graph;
import graph.models.Vertex;

public class BellmanFord<T> extends SingleSourceShortestPath<T> {

	public boolean build(Graph<T, Integer> graph, Vertex<T> source) {

		initializeSingleSource(graph, source);

		IntStream.range(1, graph.getAllVertices().size()).forEach(ctr -> {
			System.out.println("Pass " + ctr);
			for (Edge<T, ?> edge : graph.getAllEdges()) {
				relax(graph, edge.getSource(), edge.getDestination());
			}
		});

		for (Edge<T, Integer> edge : graph.getAllEdges()) {
			Vertex<T> u = edge.getSource();
			Vertex<T> v = edge.getDestination();

			Integer wuv = graph.getEdge(u, v).getWeight();
			System.out.println("Comparing " + v + " to " + u + " with weight" + wuv);
			if (v.getDistance() > u.getDistance() + wuv) {
				return false;
			}
		}
		return true;
	}
}
