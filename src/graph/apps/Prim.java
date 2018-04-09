package graph.apps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import graph.models.Graph;
import graph.models.Vertex;

public class Prim<T, W> {

	public void build(Graph<T, W> graph) {
		for (Vertex<T> vertex : graph.getAllVertices()) {
			vertex.setParent(null);
			vertex.setDistance(Integer.MAX_VALUE);
		}

		Vertex<T> root = graph.getAllVertices().iterator().next();
		root.setDistance(0);

		List<Vertex<T>> minPriorityQueue = new ArrayList<>();
		minPriorityQueue.sort(Comparator.comparingInt(Vertex::getDistance));

		minPriorityQueue.addAll(graph.getAllVertices());

		System.out.println(minPriorityQueue);

		while (!minPriorityQueue.isEmpty()) {
			Vertex<T> u = minPriorityQueue.get(0);
			minPriorityQueue.remove(u);
			System.out.println("Adding to mst " + u);
			for (Vertex<T> v : graph.getAdjacentVertices(u)) {
				if (minPriorityQueue.contains(v) && weight(u, v) < v.getDistance()) {
					// System.out.println("Updating " + v);
					v.setParent(u);
					v.setDistance(weight(u, v));
					minPriorityQueue.sort(Comparator.comparingInt(Vertex::getDistance));
					// System.out.println(minPriorityQueue);
				}
			}
		}
	}

	private int weight(Vertex<T> u, Vertex<T> v) {
		return u.getWeightsMap().get(v);
	}
}