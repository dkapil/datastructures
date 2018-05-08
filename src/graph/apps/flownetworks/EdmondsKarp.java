package graph.apps.flownetworks;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import graph.models.Edge;
import graph.models.Graph;
import graph.models.Vertex;

public class EdmondsKarp<T, W> extends BasicFordFulkerson<T, W> {

	@Override
	protected List<Edge<T, W>> getAugmentingPath(Graph<T, W> residualGraph, Vertex<T> source, Vertex<T> sink) {
		residualGraph.getAllVertices().forEach(v -> {
			v.setColor("WHITE");
			v.setDistance(Integer.MAX_VALUE);
			v.setParent(null);
		});

		source.setColor("GRAY");
		source.setDistance(0);

		Queue<Vertex<T>> queue = new LinkedList<>();
		queue.add(source);

		boolean pathExist = false;

		while (!queue.isEmpty() && !pathExist) {
			Vertex<T> u = queue.poll();
			for (Vertex<T> v : residualGraph.getAdjacentVertices(u)) {
				if (v.getColor().equalsIgnoreCase("WHITE")) {
					v.setColor("GRAY");
					v.setParent(u);
					v.setDistance(u.getDistance() + 1);
					queue.add(v);
					if (v == sink) {
						pathExist = true;
						break;
					}
				}
			}
			u.setColor("BLACK");
		}

		List<Edge<T, W>> path = null;

		if (pathExist) {
			path = new LinkedList<>();
			Vertex<T> v = sink;
			while (v.getParent() != null) {
				path.add(residualGraph.getEdge(v.getParent(), v));
				v = v.getParent();
			}
			System.out.println("*** Augmenting Path ***");
			System.out.println(path);
		}

		return path;
	}
}
