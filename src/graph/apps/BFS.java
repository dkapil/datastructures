package graph.apps;

import java.util.LinkedList;
import java.util.Queue;

import graph.models.Graph;
import graph.models.Vertex;

// TODO: Auto-generated Javadoc
/**
 * The Class BFS.
 *
 * @param <T>
 *            the generic type
 */
public class BFS<T, W> {

	/**
	 * Search.
	 *
	 * @param graph
	 *            the graph
	 */
	public BFS(Graph<T, W> graph) {
		for (Vertex<T> vertex : graph.getAllVertices()) {
			vertex.setColor("WHITE");
			vertex.setDistance(Integer.MAX_VALUE);
			vertex.setParent(null);
		}

		Vertex<T> rootVertex = graph.getAllVertices().iterator().next();
		rootVertex.setColor("GRAY");
		rootVertex.setDistance(0);
		rootVertex.setParent(null);

		Queue<Vertex<T>> queue = new LinkedList<>();
		queue.add(rootVertex);

		while (!queue.isEmpty()) {
			System.out.println(queue);
			Vertex<T> u = queue.poll();
			for (Vertex<T> v : graph.getAdjacentVertices(u)) {
				if (v.getColor().equalsIgnoreCase("WHITE")) {
					v.setColor("GRAY");
					v.setDistance(u.getDistance() + 1);
					v.setParent(u);
					queue.add(v);
				}
			}
			u.setColor("BLACK");
		}
	}

	/**
	 * Prints the path.
	 *
	 * @param source
	 *            the source
	 * @param target
	 *            the target
	 */
	public void printPath(Vertex<T> source, Vertex<T> target) {
		System.out.println("Printing Path Between " + source + " and " + target);
		print(source, target);
		System.out.println();
	}

	/**
	 * Prints the.
	 *
	 * @param source
	 *            the source
	 * @param target
	 *            the target
	 */
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
