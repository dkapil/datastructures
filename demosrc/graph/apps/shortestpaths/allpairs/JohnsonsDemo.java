package graph.apps.shortestpaths.allpairs;

import java.util.Arrays;

import graph.models.Graph;
import graph.models.GraphList;
import graph.models.Vertex;

public class JohnsonsDemo {

	public static void main(String[] args) {
		Graph<String, Integer> graph = new GraphList<>();

		Vertex<String> v0 = new Vertex<>(0, "0");
		Vertex<String> v1 = new Vertex<>(1, "1");
		Vertex<String> v2 = new Vertex<>(2, "2");
		Vertex<String> v3 = new Vertex<>(3, "3");
		Vertex<String> v4 = new Vertex<>(4, "4");
		Vertex<String> v5 = new Vertex<>(5, "5");

		graph.initialize(Arrays.asList(v0, v1, v2, v3, v4, v5));

		graph.addEdge(v0, v1, 0).addEdge(v0, v2, 0).addEdge(v0, v3, 0).addEdge(v0, v4, 0).addEdge(v0, v5, 0);
		graph.addEdge(v1, v2, 3).addEdge(v1, v3, 8).addEdge(v1, v5, -4);
		graph.addEdge(v2, v4, 1).addEdge(v2, v5, 7);
		graph.addEdge(v3, v2, 4);
		graph.addEdge(v4, v1, 2).addEdge(v4, v3, -5);
		graph.addEdge(v5, v4, 6);

		graph.print();

		Johnsons<String> johnsons = new Johnsons<>();
		johnsons.build(graph, v0);
	}
}
