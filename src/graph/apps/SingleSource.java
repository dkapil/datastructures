package graph.apps;

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
public class SingleSource<T, W> {

	/**
	 * Initialize single source.
	 *
	 * @param graph
	 *            the graph
	 */
	public void initializeSingleSource(Graph<T, W> graph) {
		graph.getAllVertices().forEach(v -> {
			v.setDistance(Integer.MAX_VALUE);
			v.setParent(null);
		});
		graph.getAllVertices().iterator().next().setDistance(0);
	}

	/**
	 * Relax.
	 *
	 * @param u
	 *            the u
	 * @param v
	 *            the v
	 */
	public void relax(Vertex<T> u, Vertex<T> v) {
		System.out.println("Relaxing Edge " + u + "->" + v);
		if (v.getDistance() > u.getDistance() + u.getWeightsMap().get(v)) {
			System.out.println("Updating " + v + " distance to " + (u.getDistance() + u.getWeightsMap().get(v)));
			v.setDistance(u.getDistance() + u.getWeightsMap().get(v));
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
