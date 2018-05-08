package graph.apps;

import java.util.Deque;
import java.util.LinkedList;

import graph.models.Graph;
import graph.models.Vertex;

// TODO: Auto-generated Javadoc
/**
 * The Class DFS.
 *
 * @param <T>
 *            the generic type
 */
public class TopologicalSort<T> {

	int time = 0;

	Deque<Vertex<T>> sortedVertices = new LinkedList<>();

	/**
	 * Instantiates a new dfs.
	 *
	 * @param graph
	 *            the graph
	 */
	public TopologicalSort(Graph<T, ?> graph) {
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
	 * @param graph
	 *            the graph
	 * @param u
	 *            the vertex
	 * @param time
	 *            the time
	 */
	public void visit(Graph<T, ?> graph, Vertex<T> u) {
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
		sortedVertices.addFirst(u);
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

	public Deque<Vertex<T>> getSortedVertices() {
		return sortedVertices;
	}
}
