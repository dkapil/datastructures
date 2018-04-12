package disjointset.apps;

import java.util.HashMap;
import java.util.Map;

import disjointset.models.DisjointSet;
import disjointset.models.SetElement;
import graph.models.Graph;
import graph.models.Vertex;

public class ConnectedComponentsLinkedList<T, W> {

	Graph<T, W> graph;

	DisjointSet<SetElement<T>> disjointSet;

	Map<Vertex<T>, SetElement<T>> vertexSetElementMap = new HashMap<>();

	public ConnectedComponentsLinkedList(Graph<T, W> graph, DisjointSet<SetElement<T>> disjointSet) {
		this.graph = graph;
		this.disjointSet = disjointSet;
	}

	public void build() {

		for (Vertex<T> v : graph.getAllVertices()) {
			SetElement<T> SetElement = new SetElement<>();
			SetElement.setValue(v);
			vertexSetElementMap.put(v, SetElement);
			disjointSet.makeSet(SetElement);
		}

		for (Vertex<T> u : graph.getAllVertices()) {
			SetElement<T> uSetElement = vertexSetElementMap.get(u);
			for (Vertex<T> v : graph.getAdjacentVertices(u)) {
				SetElement<T> vSetElement = vertexSetElementMap.get(v);
				if (disjointSet.findSet(uSetElement) != disjointSet.findSet(vSetElement)) {
					disjointSet.union(uSetElement, vSetElement);
				}
			}
		}
	}

	public boolean sameComponents(Vertex<T> u, Vertex<T> v, DisjointSet<? super SetElement<T>> set) {
		SetElement<T> uSetElement = vertexSetElementMap.get(u);
		SetElement<T> vSetElement = vertexSetElementMap.get(v);
		if (set.findSet(uSetElement) == set.findSet(vSetElement))
			return true;
		else
			return false;
	}
}
