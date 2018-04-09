package graph.models;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// TODO: Auto-generated Javadoc
/**
 * The Class GraphList.
 *
 * @param <T>
 *            the generic type
 */
public class GraphList<T> implements Graph<T, Integer> {

	Map<Vertex<T>, LinkedList<Vertex<T>>> map;

	GraphType graphType;

	Vertex<T> rootVertex;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.graph.model.Graph#initialize(int)
	 */
	@Override
	public void initialize(Collection<Vertex<T>> vertices) {
		map = new LinkedHashMap<>();
		vertices.forEach(v -> map.put(v, new LinkedList<>()));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.graph.model.Graph#getAllVertices()
	 */
	@Override
	public Set<Vertex<T>> getAllVertices() {
		return map.keySet();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.graph.model.Graph#getAdjacentVertices(com.graph.model.Vertex)
	 */
	@Override
	public Set<Vertex<T>> getAdjacentVertices(Vertex<T> start) {
		return new LinkedHashSet<>(map.get(start));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.graph.model.Graph#addEdge(java.lang.Object, java.lang.Object, int)
	 */
	@Override
	public Graph<T, Integer> addEdge(Vertex<T> start, Vertex<T> end, Integer weight) {
		map.get(start).add(end);
		start.getWeightsMap().put(end, weight);
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.graph.model.Graph#addEdge(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Graph<T, Integer> addEdge(Vertex<T> start, Vertex<T> end) {
		map.get(start).add(end);
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.graph.model.Graph#removeEdge(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void removeEdge(Vertex<T> start, Vertex<T> end) {
		map.get(start.getValue()).remove(end);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.graph.model.Graph#print()
	 */
	@Override
	public void print() {
		for (Entry<Vertex<T>, LinkedList<Vertex<T>>> entry : map.entrySet()) {
			System.out.print(entry.getKey() + "->");
			entry.getValue()
					.forEach(p -> System.out.print("|" + p + ":" + entry.getKey().getWeightsMap().get(p) + "|"));
			System.out.println();
		}
	}

	@Override
	public Graph<T, Integer> transpose() {
		Graph<T, Integer> transposedGraph = new GraphList<>();
		transposedGraph.initialize(getAllVertices());
		for (Vertex<T> vertex : getAllVertices()) {
			for (Vertex<T> adjacentVertex : getAdjacentVertices(vertex)) {
				transposedGraph.addEdge(adjacentVertex, vertex);
			}
		}
		return transposedGraph;
	}

	public Graph<T, Integer> setType(GraphType graphType) {
		this.graphType = graphType;
		return this;
	}

	@Override
	public Set<Edge<T, Integer>> getAllEdges() {
		Set<Edge<T, Integer>> edges = new LinkedHashSet<>();
		for (Vertex<T> u : getAllVertices()) {
			for (Vertex<T> v : getAdjacentVertices(u)) {
				Edge<T, Integer> edge = new Edge<>();
				edge.setSource(u);
				edge.setDestination(v);
				edge.setWeight(u.getWeightsMap().get(v));
				edges.add(edge);
			}
		}
		return edges;
	}
}
