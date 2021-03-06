package graph.apps;

import graph.models.Graph;
import graph.models.Vertex;

/**
 * The DFS.
 *
 * @param <T> the generic type
 */
public class DFS<T, W> {

	int time = 0;

	/**
	 * Instantiates a new dfs.
	 *
	 * @param graph the graph
	 */
	public DFS(Graph<T, W> graph) {
		for (Vertex<T> vertex : graph.getAllVertices()) {
			System.out.println("Initializing " + vertex.getValue());
			vertex.setColor("WHITE");
			vertex.setParent(null);
		}

		for (Vertex<T> vertex : graph.getAllVertices()) {
			if (vertex.getColor().equalsIgnoreCase("WHITE")) {
				visit(graph, vertex);
			}
		}
	}

	/**
	 * Visit.
	 *
	 * @param graph the graph
	 * @param u     the vertex
	 * @param time  the time
	 */
	public void visit(Graph<T, W> graph, Vertex<T> u) {
		time = time + 1;
		u.setDiscoveredTime(time);
		u.setColor("GRAY");
		System.out.println("Visiting " + u.getValue());
		for (Vertex<T> v : graph.getAdjacentVertices(u)) {
			System.out.println("Explorting Edge " + u.getValue() + "->" + v.getValue());
			if (v.getColor().equalsIgnoreCase("WHITE")) {
				v.setParent(u);
				visit(graph, v);
			}
		}
		u.setColor("BLACK");
		time = time + 1;
		u.setFinishedTime(time);
	}

	public void printPath(Vertex<T> source, Vertex<T> target) {
		System.out.println("Printing Path Between " + source + " and " + target);
		print(source, target);
		System.out.println();
	}

	private void print(Vertex<T> source, Vertex<T> target) {
		if (target == source) {
			System.out.print(source + "->");
		} else if (target.getParent() == null) {
			System.out.println("No Path Exist Between " + source + " and " + target);
		} else {
			print(source, target.getParent());
			System.out.print(target + "->");
		}
	}
}
