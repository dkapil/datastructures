package graph.models;

public class GraphListUndirected<T, W> extends GraphList<T, W> {

	@Override
	public Graph<T, W> addEdge(Vertex<T> start, Vertex<T> end) {
		map.get(end).add(start);
		return super.addEdge(start, end);
	}

	@Override
	public Graph<T, W> addEdge(Vertex<T> start, Vertex<T> end, W weight) {
		super.addEdge(end, start, weight);
		return super.addEdge(start, end, weight);
	}

	@Override
	public void removeEdge(Vertex<T> start, Vertex<T> end) {
		map.get(end.getValue()).remove(start);
		super.removeEdge(start, end);
	}
}
