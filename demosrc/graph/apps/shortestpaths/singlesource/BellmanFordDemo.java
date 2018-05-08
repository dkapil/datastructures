package graph.apps.shortestpaths.singlesource;

import java.util.Arrays;

import graph.models.Graph;
import graph.models.GraphList;
import graph.models.Vertex;

public class BellmanFordDemo {

	public static void main(String[] args) {
		Graph<String, Integer> graph = new GraphList<>();

		Vertex<String> s = new Vertex<>(1, "s");
		Vertex<String> t = new Vertex<>(2, "t");
		Vertex<String> y = new Vertex<>(3, "y");
		Vertex<String> x = new Vertex<>(4, "x");
		Vertex<String> z = new Vertex<>(5, "z");

		graph.initialize(Arrays.asList(s, t, y, x, z));

		graph.addEdge(s, t, 6).addEdge(s, y, 7);
		graph.addEdge(t, x, 5).addEdge(t, y, 8).addEdge(t, z, -4);
		graph.addEdge(y, x, -3).addEdge(y, z, 9);
		graph.addEdge(x, t, -2);
		graph.addEdge(z, s, 2).addEdge(z, x, 7);

		graph.print();

		BellmanFord<String> bellmanFord = new BellmanFord<>();
		System.out.println(bellmanFord.build(graph, s));

		graph.getAllVertices().forEach(v -> {
			System.out.println(v + ":" + v.getDistance());
		});

		bellmanFord.printPath(s, t);
		bellmanFord.printPath(s, y);
		bellmanFord.printPath(s, x);
		bellmanFord.printPath(s, z);
	}
}
