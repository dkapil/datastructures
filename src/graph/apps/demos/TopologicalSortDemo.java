package graph.apps.demos;

import java.util.Arrays;

import graph.apps.TopologicalSort;
import graph.models.Graph;
import graph.models.GraphList;
import graph.models.Vertex;

// TODO: Auto-generated Javadoc
/**
 * The Class TopologicalSortRunner.
 */
public class TopologicalSortDemo {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {

		Graph<String, Integer> graph = new GraphList<>();

		Vertex<String> shirt = new Vertex<String>(1, "shirt");
		Vertex<String> tie = new Vertex<String>(2, "tie");
		Vertex<String> jacket = new Vertex<String>(3, "jacket");
		Vertex<String> belt = new Vertex<String>(4, "belt");

		Vertex<String> watch = new Vertex<String>(5, "watch");

		Vertex<String> undershorts = new Vertex<String>(6, "undershorts");
		Vertex<String> pants = new Vertex<String>(7, "pants");
		Vertex<String> shoes = new Vertex<String>(8, "shoes");

		Vertex<String> socks = new Vertex<String>(9, "socks");

		graph.initialize(Arrays.asList(shirt, tie, jacket, belt, watch, undershorts, pants, shoes, socks));

		graph.addEdge(shirt, tie).addEdge(tie, jacket).addEdge(shirt, belt).addEdge(belt, jacket);

		graph.addEdge(undershorts, pants).addEdge(pants, belt).addEdge(pants, shoes).addEdge(undershorts, shoes);

		graph.addEdge(socks, shoes);

		graph.print();

		TopologicalSort<String, Integer> dfs = new TopologicalSort<>(graph);

		for (Vertex<String> vertex : graph.getAllVertices()) {
			System.out.println(vertex.getValue() + "-" + vertex.getDiscoveredTime() + "-" + vertex.getFinishedTime());
		}

		for (Vertex<String> vertex : dfs.getSortedVertices()) {
			System.out
					.print(vertex.getValue() + "-" + vertex.getDiscoveredTime() + "-" + vertex.getFinishedTime() + ",");
		}

	}
}
