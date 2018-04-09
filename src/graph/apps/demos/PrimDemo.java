package graph.apps.demos;

import java.util.Arrays;

import graph.apps.Prim;
import graph.models.Graph;
import graph.models.GraphListUndirected;
import graph.models.Vertex;

public class PrimDemo {

	public static void main(String[] args) {
		Graph<String, Integer> graph = new GraphListUndirected<>();

		Vertex<String> a = new Vertex<String>(1, "a");
		Vertex<String> b = new Vertex<String>(2, "b");
		Vertex<String> c = new Vertex<String>(3, "c");
		Vertex<String> d = new Vertex<String>(4, "d");
		Vertex<String> e = new Vertex<String>(5, "e");
		Vertex<String> f = new Vertex<String>(6, "f");
		Vertex<String> g = new Vertex<String>(7, "g");
		Vertex<String> h = new Vertex<String>(8, "h");
		Vertex<String> i = new Vertex<String>(9, "i");

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

		Prim<String, Integer> prim = new Prim<>();
		prim.build(graph);

	}
}
