package graph.apps.shortestpaths.singlesource;

import graph.models.Graph;
import graph.models.Vertex;

// TODO: Auto-generated Javadoc
/**
 * The Class SingleSource.
 *
 * @param <T>
 *            the generic type
 * @param <W>
 *            the generic type
 */
public class SingleSourceShortestPath<T> {

	/**
	 * Initialize single source.
	 *
	 * @param graph
	 *            the graph
	 * @param source
	 *            TODO
	 */
	public void initializeSingleSource(Graph<T, ?> graph, Vertex<T> source) {
		graph.getAllVertices().forEach(v -> {
			v.setDistance(Integer.MAX_VALUE);
			v.setParent(null);
		});
		source.setDistance(0);
	}

	/**
	 * Relax.
	 *
	 * @param u
	 *            the u
	 * @param v
	 *            the v
	 */
	public void relax(Graph<T, Integer> graph, Vertex<T> u, Vertex<T> v) {
		System.out.println("Relaxing Edge " + u + "->" + v);
		Integer wuv = graph.getEdge(u, v).getWeight();
		int vd = v.getDistance();
		int ud = u.getDistance();
		if (vd > ud + wuv) {
			System.out.println("Updating " + v + " distance to " + (ud + wuv));
			v.setDistance(ud + wuv);
			v.setParent(u);
		}
	}

	public void printPath(Vertex<T> source, Vertex<T> destination) {
		System.out.println("Printing Path Between " + source + " and " + destination);
		print(source, destination);
		System.out.println();
	}

	private void print(Vertex<T> source, Vertex<T> destination) {
		if (destination == source)
			System.out.print(source + ":" + source.getDistance() + "->");
		else if (destination.getParent() == null)
			System.out.println("No Path Exist");
		else {
			print(source, destination.getParent());
			System.out.print(destination + ":" + destination.getDistance() + "->");
		}
	}
}
