package graph.apps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import graph.models.Graph;
import graph.models.Vertex;

// TODO: Auto-generated Javadoc
/**
 * The Class DFS.
 *
 * @param <T>
 *            the generic type
 */
public class SCC<T, W> {

	int time = 0;

	List<LinkedList<Vertex<T>>> sccS = new ArrayList<>();

	/**
	 * Instantiates a new dfs.
	 *
	 * @param graph
	 *            the graph
	 */
	public SCC(Graph<T, W> graph) {

		new DFS<>(graph);

		for (Vertex<T> vertex : graph.getAllVertices()) {
			System.out
					.print(vertex.getValue() + "-" + vertex.getDiscoveredTime() + "-" + vertex.getFinishedTime() + ",");
		}

		Graph<T, W> graphT = graph.transpose();
		Comparator<Vertex<T>> comparator = Comparator.comparingInt(Vertex::getFinishedTime);

		List<Vertex<T>> sortedVertices = graphT.getAllVertices().stream().sorted(comparator.reversed())
				.collect(Collectors.toList());

		for (Vertex<T> vertex : sortedVertices) {
			System.out.println("Initializing " + vertex.getValue());
			vertex.setColor("WHITE");
			vertex.setParent(null);
		}

		for (Vertex<T> vertex : sortedVertices) {
			if (vertex.getColor().equalsIgnoreCase("WHITE")) {
				LinkedList<Vertex<T>> scc = new LinkedList<>();
				visit(graphT, vertex, scc);
				sccS.add(scc);
			}
		}
	}

	/**
	 * Visit.
	 *
	 * @param graphT
	 *            the graph
	 * @param u
	 *            the vertex
	 * @param scc
	 * @param time
	 *            the time
	 */
	public void visit(Graph<T, W> graphT, Vertex<T> u, List<Vertex<T>> scc) {
		scc.add(u);
		time = time + 1;
		u.setDiscoveredTime(time);
		u.setColor("GRAY");
		for (Vertex<T> v : graphT.getAdjacentVertices(u)) {
			if (v.getColor().equalsIgnoreCase("WHITE")) {
				v.setParent(u);
				visit(graphT, v, scc);
			}
		}
		time = time + 1;
		u.setFinishedTime(time);
		u.setColor("BLACK");
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

	public List<LinkedList<Vertex<T>>> getSccS() {
		return sccS;
	}
}
