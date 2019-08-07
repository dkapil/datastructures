package graph.models;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * GraphList.
 *
 * @param <T> the generic type
 * @param <W> the generic type
 */
public class GraphList<T, W> implements Graph<T, W> {

	Map<Vertex<T>, LinkedList<Vertex<T>>> map;

	Map<Vertex<T>, Map<Vertex<T>, W>> weights = new HashMap<>();

	Map<Vertex<T>, Map<Vertex<T>, Integer>> flows = new HashMap<>();

	Map<Vertex<T>, Map<Vertex<T>, Integer>> capacities = new HashMap<>();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void initialize(Collection<Vertex<T>> vertices) {
		map = new LinkedHashMap<>();
		vertices.forEach(v -> {
			map.put(v, new LinkedList<>());
			weights.put(v, new HashMap<>());
			flows.put(v, new HashMap<>());
			capacities.put(v, new HashMap<>());
		});
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Vertex<T>> getAllVertices() {
		return map.keySet();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Vertex<T>> getAdjacentVertices(Vertex<T> source) {
		return new LinkedHashSet<>(map.get(source));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeVertex(Vertex<T> vertex) {
		map.remove(vertex);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Graph<T, W> addEdge(Vertex<T> source, Vertex<T> destination) {
		map.get(source).add(destination);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Graph<T, W> addEdge(Vertex<T> source, Vertex<T> destination, W weight) {
		map.get(source).add(destination);
		weights.get(source).put(destination, weight);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Graph<T, W> addEdge(Vertex<T> source, Vertex<T> destination, Integer flow, Integer capacity) {
		map.get(source).add(destination);
		flows.get(source).put(destination, flow);
		capacities.get(source).put(destination, capacity);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Graph<T, W> addEdge(Vertex<T> source, Vertex<T> destination, W weight, Integer flow, Integer capacity) {
		map.get(source).add(destination);
		weights.get(source).put(destination, weight);
		flows.get(source).put(destination, flow);
		capacities.get(source).put(destination, capacity);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Edge<T, W> getEdge(Vertex<T> source, Vertex<T> destination) {
		Edge<T, W> edge = null;
		LinkedList<Vertex<T>> adjacents = map.get(source);
		if (adjacents.contains(destination)) {
			edge = new Edge<>();
			edge.setSource(source);
			edge.setDestination(destination);
			edge.setWeight(weights.get(source).get(destination));
			edge.setFlow(flows.get(source).get(destination));
			edge.setCapacity(capacities.get(source).get(destination));
		}
		return edge;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Edge<T, W>> getAllEdges() {
		Set<Edge<T, W>> edges = new LinkedHashSet<>();
		for (Vertex<T> u : getAllVertices()) {
			for (Vertex<T> v : getAdjacentVertices(u)) {
				Edge<T, W> edge = getEdge(u, v);
				edges.add(edge);
			}
		}
		return edges;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Graph<T, W> updateEdge(Vertex<T> source, Vertex<T> destination, W weight) {
		weights.get(source).put(destination, weight);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Graph<T, W> updateEdge(Vertex<T> source, Vertex<T> destination, Integer flow, Integer capacity) {
		flows.get(source).put(destination, flow);
		capacities.get(source).put(destination, capacity);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Graph<T, W> updateEdge(Vertex<T> source, Vertex<T> destination, W weight, Integer flow, Integer capacity) {
		weights.get(source).put(destination, weight);
		flows.get(source).put(destination, flow);
		capacities.get(source).put(destination, capacity);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeEdge(Vertex<T> source, Vertex<T> destination) {
		map.get(source.getValue()).remove(destination);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Graph<T, W> transpose() {
		Graph<T, W> transposedGraph = new GraphList<>();
		transposedGraph.initialize(getAllVertices());
		for (Vertex<T> vertex : getAllVertices()) {
			for (Vertex<T> adjacentVertex : getAdjacentVertices(vertex)) {
				transposedGraph.addEdge(adjacentVertex, vertex);
			}
		}
		return transposedGraph;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void print() {
		for (Entry<Vertex<T>, LinkedList<Vertex<T>>> entry : map.entrySet()) {
			System.out.print(entry.getKey() + "->");
			entry.getValue().forEach(p -> {
				Edge<T, W> edge = getEdge(entry.getKey(), p);
				StringBuilder builder = new StringBuilder("|" + p + ":{");
				if (edge.getWeight() != null)
					builder.append("W:" + edge.getWeight());
				builder.append(" F:" + edge.getFlow());
				builder.append(" C:" + edge.getCapacity());
				builder.append("}");
				System.out.print(builder + "|");
			});
			System.out.println();
		}
	}
}
