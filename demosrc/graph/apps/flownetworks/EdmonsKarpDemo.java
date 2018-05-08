package graph.apps.flownetworks;

import java.util.Arrays;

import graph.models.Graph;
import graph.models.GraphList;
import graph.models.Vertex;

/**
 * The Class EdmonsKarpDemo.
 */
public class EdmonsKarpDemo {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		Graph<String, Integer> graph = new GraphList<>();

		Vertex<String> s = new Vertex<>(1, "s");
		Vertex<String> v1 = new Vertex<>(2, "v1");
		Vertex<String> v2 = new Vertex<>(3, "v2");
		Vertex<String> v3 = new Vertex<>(4, "v3");
		Vertex<String> v4 = new Vertex<>(5, "v4");
		Vertex<String> t = new Vertex<>(6, "t");

		graph.initialize(Arrays.asList(s, v1, v2, v3, v4, t));

		graph.addEdge(s, v1, 1, 11, 16).addEdge(s, v2, 1, 8, 13);
		graph.addEdge(v1, v3, 1, 12, 12);
		graph.addEdge(v2, v1, 1, 1, 4).addEdge(v2, v4, 1, 11, 14);
		graph.addEdge(v3, v2, 1, 4, 9).addEdge(v3, t, 1, 15, 20);
		graph.addEdge(v4, v3, 1, 7, 7).addEdge(v4, t, 1, 4, 4);

		graph.print();

		EdmondsKarp<String, Integer> edmondsKarp = new EdmondsKarp<>();
		int maxflow = edmondsKarp.getMaxFlow(graph, s, t);
		System.out.println("Max Flow " + maxflow);

	}
}
