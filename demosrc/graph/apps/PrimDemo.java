package graph.apps;

import java.util.Arrays;

import graph.models.Graph;
import graph.models.GraphListUndirected;
import graph.models.Vertex;

public class PrimDemo {

	public static void main(String[] args) {
		Graph<String, Integer> graph = new GraphListUndirected<>();

		Vertex<String> a = new Vertex<>(1, "a");
		Vertex<String> b = new Vertex<>(2, "b");
		Vertex<String> c = new Vertex<>(3, "c");
		Vertex<String> d = new Vertex<>(4, "d");
		Vertex<String> e = new Vertex<>(5, "e");
		Vertex<String> f = new Vertex<>(6, "f");
		Vertex<String> g = new Vertex<>(7, "g");
		Vertex<String> h = new Vertex<>(8, "h");
		Vertex<String> i = new Vertex<>(9, "i");

		graph.initialize(Arrays.asList(a, b, c, d, e, f, g, h, i));

		graph.addEdge(a, b, 4).addEdge(a, h, 8);
		graph.addEdge(b, c, 8).addEdge(b, h, 11);
		graph.addEdge(c, d, 7).addEdge(c, f, 4).addEdge(c, i, 2);
		graph.addEdge(d, e, 9).addEdge(d, f, 14);
		graph.addEdge(e, f, 10);
		graph.addEdge(f, g, 2);
		graph.addEdge(g, h, 1).addEdge(g, i, 6);
		graph.addEdge(h, i, 7);

		graph.print();

		Prim<String> prim = new Prim<>();
		prim.build(graph);

	}
}
