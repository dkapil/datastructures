package graph.apps.demos;

import java.util.Arrays;

import graph.apps.Dijkstra;
import graph.models.Graph;
import graph.models.GraphList;
import graph.models.Vertex;

public class DijkstraDemo {

	public static void main(String[] args) {
		Graph<String, Integer> graph = new GraphList<>();

		Vertex<String> s = new Vertex<String>(1, "s");
		Vertex<String> t = new Vertex<String>(2, "t");
		Vertex<String> y = new Vertex<String>(3, "y");
		Vertex<String> x = new Vertex<String>(4, "x");
		Vertex<String> z = new Vertex<String>(5, "z");

		graph.initialize(Arrays.asList(s, t, y, x, z));

		graph.addEdge(s, t, 10).addEdge(s, y, 5);
		graph.addEdge(t, y, 2).addEdge(t, z, 2).addEdge(t, x, 1);
		graph.addEdge(x, z, 4);
		graph.addEdge(y, z, 2).addEdge(y, t, 3).addEdge(y, x, 9);
		graph.addEdge(z, s, 7).addEdge(z, x, 6);

		graph.print();

		Dijkstra<String, Integer> dijkstra = new Dijkstra<>();
		dijkstra.build(graph);

		graph.getAllVertices().forEach(v -> {
			System.out.println(v + ":" + v.getDistance());
		});

		dijkstra.printPath(s, t);
		dijkstra.printPath(s, y);
		dijkstra.printPath(s, x);
		dijkstra.printPath(s, z);
	}
}
