package graph.apps;

import java.util.stream.IntStream;

import graph.models.Edge;
import graph.models.Graph;
import graph.models.Vertex;

public class BellmanFord<T, W> extends SingleSource<T, W> {

	public boolean build(Graph<T, W> graph) {

		initializeSingleSource(graph);

		IntStream.range(1, graph.getAllVertices().size()).forEach(ctr -> {
			System.out.println("Pass " + ctr);
			for (Edge<T, W> edge : graph.getAllEdges()) {
				relax(edge.getSource(), edge.getDestination());
			}
		});

		for (Edge<T, W> edge : graph.getAllEdges()) {
			Vertex<T> u = edge.getSource();
			Vertex<T> v = edge.getDestination();

			System.out.println("Comparing " + v + " to " + u + " with weight" + u.getWeightsMap().get(v));
			if (v.getDistance() > u.getDistance() + u.getWeightsMap().get(v)) {
				return false;
			}
		}
		return true;
	}
}
