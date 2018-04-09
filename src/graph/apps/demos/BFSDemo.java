package graph.apps.demos;

import java.util.Arrays;

import graph.apps.BFS;
import graph.models.Graph;
import graph.models.GraphList;
import graph.models.Vertex;

public class BFSDemo {
	public static void main(String[] args) {
		Graph<String, Integer> graph = new GraphList<>();

		Vertex<String> r = new Vertex<String>(0, "r");
		Vertex<String> s = new Vertex<String>(1, "s");
		Vertex<String> t = new Vertex<String>(2, "t");
		Vertex<String> u = new Vertex<String>(3, "u");
		Vertex<String> v = new Vertex<String>(4, "v");
		Vertex<String> w = new Vertex<String>(5, "w");
		Vertex<String> x = new Vertex<String>(6, "x");
		Vertex<String> y = new Vertex<String>(7, "y");

		graph.initialize(Arrays.asList(r, s, t, u, v, w, x, y));
		graph.addEdge(s, r).addEdge(s, w);
		graph.addEdge(r, s).addEdge(r, v);
		graph.addEdge(t, u).addEdge(t, w).addEdge(t, x);
		graph.addEdge(u, t).addEdge(u, y).addEdge(u, x);
		graph.addEdge(v, r);
		graph.addEdge(w, s).addEdge(w, t).addEdge(w, x);
		graph.addEdge(x, t).addEdge(x, u).addEdge(x, w).addEdge(x, y);
		graph.addEdge(y, x).addEdge(y, u);
		graph.print();

		BFS<String, Integer> bfs = new BFS<>(graph);

		for (Vertex<String> vertex : graph.getAllVertices()) {
			System.out.println(vertex.getValue() + "-" + vertex.getDistance() + "-" + vertex.getParent());
		}

		bfs.printPath(s, r);
		bfs.printPath(s, t);
		bfs.printPath(s, u);
		bfs.printPath(s, v);
		bfs.printPath(s, w);
		bfs.printPath(s, x);
		bfs.printPath(s, y);
	}
}
