package graph.apps.demos;

import java.util.Arrays;

import graph.apps.SingleSourceDAG;
import graph.models.Graph;
import graph.models.GraphList;
import graph.models.Vertex;

public class SingleSourceDAGDemo {

	public static void main(String[] args) {
		Graph<String, Integer> graph = new GraphList<>();

		Vertex<String> s = new Vertex<String>(1, "s");
		Vertex<String> t = new Vertex<String>(2, "t");
		Vertex<String> y = new Vertex<String>(3, "y");
		Vertex<String> x = new Vertex<String>(4, "x");
		Vertex<String> z = new Vertex<String>(5, "z");

		graph.initialize(Arrays.asList(s, t, y, x, z));

		graph.addEdge(s, t, 2).addEdge(s, x, 6);
		graph.addEdge(t, y, 4).addEdge(t, z, 2).addEdge(t, x, 7);
		graph.addEdge(x, z, 1).addEdge(x, y, -1);
		graph.addEdge(y, z, -2);

		graph.print();

		SingleSourceDAG<String, Integer> ssspDAG = new SingleSourceDAG<>();
		ssspDAG.build(graph);

		graph.getAllVertices().forEach(v -> {
			System.out.println(v + ":" + v.getDistance());
		});

		ssspDAG.printPath(s, t);
		ssspDAG.printPath(s, y);
		ssspDAG.printPath(s, x);
		ssspDAG.printPath(s, z);
	}
}
