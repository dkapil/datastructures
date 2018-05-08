package graph.apps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import graph.models.Graph;
import graph.models.Vertex;

public class Prim<T> {

	public void build(Graph<T, Integer> graph) {
		for (Vertex<T> vertex : graph.getAllVertices()) {
			vertex.setParent(null);
			vertex.setDistance(Integer.MAX_VALUE);
		}

		Vertex<T> root = graph.getAllVertices().iterator().next();
		root.setDistance(0);

		List<Vertex<T>> minPriorityQueue = new ArrayList<>();
		minPriorityQueue.addAll(graph.getAllVertices());
		minPriorityQueue.sort(Comparator.comparingInt(Vertex::getDistance));

		System.out.println(minPriorityQueue);

		while (!minPriorityQueue.isEmpty()) {
			Vertex<T> u = minPriorityQueue.get(0);
			minPriorityQueue.remove(u);
			System.out.println("Adding to mst " + u);
			for (Vertex<T> v : graph.getAdjacentVertices(u)) {
				if (minPriorityQueue.contains(v) && weight(graph, u, v) < v.getDistance()) {
					// System.out.println("Updating " + v);
					v.setParent(u);
					v.setDistance(weight(graph, u, v));
					minPriorityQueue.sort(Comparator.comparingInt(Vertex::getDistance));
					// System.out.println(minPriorityQueue);
				}
			}
		}
	}

	private int weight(Graph<T, Integer> graph, Vertex<T> u, Vertex<T> v) {
		return graph.getEdge(u, v).getWeight();
	}
}
