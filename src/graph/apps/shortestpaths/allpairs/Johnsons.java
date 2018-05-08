package graph.apps.shortestpaths.allpairs;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import graph.apps.shortestpaths.singlesource.BellmanFord;
import graph.apps.shortestpaths.singlesource.Dijkstra;
import graph.models.Edge;
import graph.models.Graph;
import graph.models.Vertex;

public class Johnsons<T> {

	public void build(Graph<T, Integer> graph, Vertex<T> source) {

		BellmanFord<T> bf = new BellmanFord<>();
		if (!bf.build(graph, source))
			System.out.println("Negative Weight Cycle Present, Solution Not Possible");
		else {

			System.out.println("Reweighted Graph");
			graph.getAllVertices().forEach(v -> {
				System.out.println(v + ":" + v.getDistance());
			});

			Map<Vertex<T>, Integer> h = graph.getAllVertices().stream()
					.collect(Collectors.toMap(Function.identity(), Vertex::getDistance));

			reweight(graph, h);
			graph.removeVertex(source);

			Integer D[][] = new Integer[graph.getAllVertices().size() + 1][graph.getAllVertices().size() + 1];

			for (Vertex<T> u : graph.getAllVertices()) {
				Dijkstra<T> dks = new Dijkstra<>();
				dks.build(graph, u);

				graph.getAllVertices().forEach(v -> {
					Integer wuvp = v.getDistance();
					D[u.getId()][v.getId()] = wuvp + h.get(v) - h.get(u);
				});

				graph.getAllVertices().forEach(v -> {
					System.out.println(v + ":" + v.getDistance() + "/" + D[u.getId()][v.getId()]);
				});
			}

			printAllPairs(D);
		}
	}

	private void printAllPairs(Integer[][] d) {
		for (int u = 1; u < d.length; u++) {
			for (int j = 1; j < d[u].length; j++) {
				System.out.print(d[u][j] + "\t");
			}
			System.out.println();
		}
	}

	private void reweight(Graph<T, Integer> graph, Map<Vertex<T>, Integer> h) {
		for (Edge<T, Integer> edge : graph.getAllEdges()) {
			Vertex<T> u = edge.getSource();
			Vertex<T> v = edge.getDestination();
			Integer wuv = graph.getEdge(u, v).getWeight();
			graph.updateEdge(u, v, wuv + h.get(u) - h.get(v));
		}
	}
}
