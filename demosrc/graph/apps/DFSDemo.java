package graph.apps;

import java.util.Arrays;

import graph.models.Graph;
import graph.models.GraphList;
import graph.models.Vertex;

public class DFSDemo {
	public static void main(String[] args) {
		Graph<String, Integer> graph = new GraphList<>();

		Vertex<String> u = new Vertex<>(1, "u");
		Vertex<String> v = new Vertex<>(2, "v");
		Vertex<String> w = new Vertex<>(3, "w");
		Vertex<String> x = new Vertex<>(4, "x");
		Vertex<String> y = new Vertex<>(5, "y");
		Vertex<String> z = new Vertex<>(6, "z");

		graph.initialize(Arrays.asList(u, v, w, x, y, z));

		graph.addEdge(u, v).addEdge(u, x);
		graph.addEdge(v, y);
		graph.addEdge(w, y).addEdge(w, z);
		graph.addEdge(x, v);
		graph.addEdge(y, x);
		graph.addEdge(z, z);

		DFS<String, Integer> dfs = new DFS<>(graph);

		for (Vertex<String> vertex : graph.getAllVertices()) {
			System.out.println(vertex.getValue() + "-" + vertex.getDiscoveredTime() + "-" + vertex.getFinishedTime());
		}

		dfs.printPath(u, v);
		dfs.printPath(u, y);
		dfs.printPath(u, x);
		dfs.printPath(w, z);
		dfs.printPath(u, w);
	}
}
