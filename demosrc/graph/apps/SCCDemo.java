package graph.apps;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import graph.models.Graph;
import graph.models.GraphList;
import graph.models.Vertex;

public class SCCDemo {
	public static void main(String[] args) {

		Graph<String, Integer> graph = new GraphList<>();

		Vertex<String> a = new Vertex<>(1, "a");
		Vertex<String> b = new Vertex<>(2, "b");
		Vertex<String> c = new Vertex<>(3, "c");
		Vertex<String> d = new Vertex<>(4, "d");
		Vertex<String> e = new Vertex<>(5, "e");
		Vertex<String> f = new Vertex<>(6, "f");
		Vertex<String> g = new Vertex<>(7, "g");
		Vertex<String> h = new Vertex<>(8, "h");

		graph.initialize(Arrays.asList(c, g, f, h, d, b, e, a));

		graph.addEdge(a, b);
		graph.addEdge(b, c).addEdge(b, e).addEdge(b, f);
		graph.addEdge(c, g).addEdge(c, d);
		graph.addEdge(d, c).addEdge(d, h);
		graph.addEdge(e, a).addEdge(e, f);
		graph.addEdge(f, g);
		graph.addEdge(g, f).addEdge(g, h);
		graph.addEdge(h, h);

		graph.print();

		SCC<String, Integer> dfsScc = new SCC<>(graph);
		List<LinkedList<Vertex<String>>> sccS = dfsScc.getSccS();
		for (LinkedList<Vertex<String>> scc : sccS) {
			System.out.println(scc);
		}

		for (Vertex<String> vertex : graph.getAllVertices()) {
			System.out
					.print(vertex.getValue() + "-" + vertex.getDiscoveredTime() + "-" + vertex.getFinishedTime() + ",");
		}

	}

}
