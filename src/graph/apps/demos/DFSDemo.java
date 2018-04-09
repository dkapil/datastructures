package graph.apps.demos;

import java.util.Arrays;

import graph.apps.DFS;
import graph.models.Graph;
import graph.models.GraphList;
import graph.models.Vertex;

public class DFSDemo {
	public static void main(String[] args) {
		Graph<String, Integer> graph = new GraphList<>();

		Vertex<String> u = new Vertex<String>(1, "u");
		Vertex<String> v = new Vertex<String>(2, "v");
		Vertex<String> w = new Vertex<String>(3, "w");
		Vertex<String> x = new Vertex<String>(4, "x");
		Vertex<String> y = new Vertex<String>(5, "y");
		Vertex<String> z = new Vertex<String>(6, "z");

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
