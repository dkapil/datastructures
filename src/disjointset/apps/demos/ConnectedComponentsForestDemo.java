package disjointset.apps.demos;

import java.util.Arrays;

import disjointset.apps.ConnectedComponentsForest;
import disjointset.models.DisjoinSetForest;
import disjointset.models.DisjointSet;
import disjointset.models.ForestElement;
import graph.models.Graph;
import graph.models.GraphListUndirected;
import graph.models.Vertex;

public class ConnectedComponentsForestDemo {
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
		Vertex<String> j = new Vertex<String>(10, "j");

		graph.initialize(Arrays.asList(a, b, c, d, e, f, g, h, i, j));

		graph.addEdge(a, b).addEdge(a, c).addEdge(b, c).addEdge(b, d);

		graph.addEdge(e, f).addEdge(e, g);

		graph.addEdge(h, i);

		graph.print();

		DisjointSet<ForestElement<String>> disjointSet = new DisjoinSetForest<>();

		ConnectedComponentsForest<String, Integer> connectedComponents = new ConnectedComponentsForest<>(graph,
				disjointSet);
		connectedComponents.build();
		disjointSet.printSets();

		for (Vertex<String> u : graph.getAllVertices()) {
			for (Vertex<String> v : graph.getAllVertices()) {
				if (connectedComponents.sameComponents(u, v, disjointSet))
					System.out.println(u + " and " + v + " belong to same set");
				else
					System.out.println(u + " and " + v + " do not belong to same set");
			}
		}
	}
}
