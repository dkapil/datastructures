package disjointset.apps;

import java.util.HashMap;
import java.util.Map;

import disjointset.models.DisjointSet;
import disjointset.models.ForestElement;
import graph.models.Graph;
import graph.models.Vertex;

public class ConnectedComponentsForest<T, W> {

	Graph<T, W> graph;

	DisjointSet<ForestElement<T>> disjointSet;

	Map<Vertex<T>, ForestElement<T>> vertexForestElementMap = new HashMap<>();

	public ConnectedComponentsForest(Graph<T, W> graph, DisjointSet<ForestElement<T>> disjointSet) {
		this.graph = graph;
		this.disjointSet = disjointSet;
	}

	public void build() {

		for (Vertex<T> v : graph.getAllVertices()) {
			ForestElement<T> ForestElement = new ForestElement<>();
			ForestElement.setValue(v);
			vertexForestElementMap.put(v, ForestElement);
			disjointSet.makeSet(ForestElement);
		}

		for (Vertex<T> u : graph.getAllVertices()) {
			ForestElement<T> uForestElement = vertexForestElementMap.get(u);
			for (Vertex<T> v : graph.getAdjacentVertices(u)) {
				ForestElement<T> vForestElement = vertexForestElementMap.get(v);
				if (disjointSet.findSet(uForestElement) != disjointSet.findSet(vForestElement)) {
					disjointSet.union(uForestElement, vForestElement);
				}
			}
		}
	}

	public boolean sameComponents(Vertex<T> u, Vertex<T> v, DisjointSet<? super ForestElement<T>> set) {
		ForestElement<T> uForestElement = vertexForestElementMap.get(u);
		ForestElement<T> vForestElement = vertexForestElementMap.get(v);
		if (set.findSet(uForestElement) == set.findSet(vForestElement))
			return true;
		else
			return false;
	}
}
