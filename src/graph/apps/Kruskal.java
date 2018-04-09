package graph.apps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import disjointset.models.DisjoinSetForest;
import disjointset.models.DisjointSet;
import disjointset.models.ForestElement;
import graph.models.Edge;
import graph.models.Graph;
import graph.models.Vertex;

public class Kruskal<T, W extends Comparable<W>> {

	Graph<T, W> graph;

	Map<Vertex<T>, ForestElement<T>> vertexForestElementMap = new HashMap<>();

	public void build(Graph<T, W> graph) {
		DisjointSet<ForestElement<T>> disjointSet = new DisjoinSetForest<>();

		for (Vertex<T> v : graph.getAllVertices()) {
			ForestElement<T> forestElement = new ForestElement<>();
			forestElement.setValue(v);
			vertexForestElementMap.put(v, forestElement);
			disjointSet.makeSet(forestElement);
		}

		List<Edge<T, W>> edges = new ArrayList<>(graph.getAllEdges());
		edges.sort((x, y) -> x.getWeight().compareTo(y.getWeight()));

		Set<Edge<T, W>> mst = new LinkedHashSet<>();
		for (Edge<T, W> edge : edges) {
			Vertex<T> u = edge.getSource();
			Vertex<T> v = edge.getDestination();
			ForestElement<T> uForestElement = vertexForestElementMap.get(u);
			ForestElement<T> vForestElement = vertexForestElementMap.get(v);
			if (disjointSet.findSet(uForestElement) != disjointSet.findSet(vForestElement)) {
				mst.add(edge);
				disjointSet.union(uForestElement, vForestElement);
			}
			System.out.println(mst);
		}
	}
}
