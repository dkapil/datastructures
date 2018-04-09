package graph.models;

public class GraphListUndirected<T> extends GraphList<T> {

	@Override
	public Graph<T, Integer> addEdge(Vertex<T> start, Vertex<T> end) {
		map.get(end).add(start);
		return super.addEdge(start, end);
	}

	@Override
	public Graph<T, Integer> addEdge(Vertex<T> start, Vertex<T> end, Integer weight) {
		map.get(end).add(start);
		end.getWeightsMap().put(start, weight);
		return super.addEdge(start, end, weight);
	}

	@Override
	public void removeEdge(Vertex<T> start, Vertex<T> end) {
		map.get(end.getValue()).remove(start);
		super.removeEdge(start, end);
	}
}
