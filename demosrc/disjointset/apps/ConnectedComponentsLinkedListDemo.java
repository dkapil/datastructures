package disjointset.apps;

import java.util.Arrays;

import disjointset.models.DisjointSet;
import disjointset.models.DisjointSetLinkedList;
import disjointset.models.SetElement;
import graph.models.Graph;
import graph.models.GraphListUndirected;
import graph.models.Vertex;

public class ConnectedComponentsLinkedListDemo {
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
		Vertex<String> j = new Vertex<>(10, "j");

		graph.initialize(Arrays.asList(a, b, c, d, e, f, g, h, i, j));

		graph.addEdge(a, b).addEdge(a, c).addEdge(b, c).addEdge(b, d);

		graph.addEdge(e, f).addEdge(e, g);

		graph.addEdge(h, i);

		graph.print();

		DisjointSet<SetElement<String>> disjointSet = new DisjointSetLinkedList<>();

		ConnectedComponentsLinkedList<String, Integer> connectedComponents = new ConnectedComponentsLinkedList<>(graph,
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
