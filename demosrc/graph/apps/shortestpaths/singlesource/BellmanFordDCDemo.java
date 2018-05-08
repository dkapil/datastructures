package graph.apps.shortestpaths.singlesource;

import java.util.Arrays;

import graph.models.Graph;
import graph.models.GraphList;
import graph.models.Vertex;

public class BellmanFordDCDemo {

	public static void main(String[] args) {
		Graph<String, Integer> graph = new GraphList<>();

		Vertex<String> v0 = new Vertex<>(1, "v0");
		Vertex<String> v1 = new Vertex<>(2, "v1");
		Vertex<String> v2 = new Vertex<>(3, "v2");
		Vertex<String> v3 = new Vertex<>(4, "v3");
		Vertex<String> v4 = new Vertex<>(5, "v4");
		Vertex<String> v5 = new Vertex<>(6, "v5");

		graph.initialize(Arrays.asList(v0, v1, v2, v3, v4, v5));

		graph.addEdge(v0, v1, 0).addEdge(v0, v2, 0).addEdge(v0, v3, 0).addEdge(v0, v4, 0).addEdge(v0, v5, 0);
		graph.addEdge(v2, v1, 0);
		graph.addEdge(v5, v1, -1);
		graph.addEdge(v5, v2, 1);
		graph.addEdge(v1, v3, 5);
		graph.addEdge(v1, v4, 4);
		graph.addEdge(v3, v4, -1);
		graph.addEdge(v3, v5, -3);
		graph.addEdge(v4, v5, -3);

		graph.print();

		BellmanFord<String> bellmanFord = new BellmanFord<>();
		System.out.println(bellmanFord.build(graph, v0));

		graph.getAllVertices().forEach(v -> {
			System.out.println(v + ":" + v.getDistance());
		});
	}
}
