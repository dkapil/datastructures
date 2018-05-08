package graph.apps.flownetworks;

import java.util.List;

import graph.models.Edge;
import graph.models.Graph;
import graph.models.GraphList;
import graph.models.Vertex;

public abstract class FordFulkerson<T, W> {

	public int getMaxFlow(Graph<T, W> graph, Vertex<T> source, Vertex<T> sink) {

		initializeFlow(graph);

		System.out.println("*** Flow Network ***");
		graph.print();

		Graph<T, W> residualGraph = computeResidualGraph(graph);

		int maxflow = 0;

		List<Edge<T, W>> augmentingPath = getAugmentingPath(residualGraph, source, sink);
		while (augmentingPath != null) {
			augmentFlow(graph, source, sink, augmentingPath);
			System.out.println("*** Flow Network ***");
			graph.print();
			residualGraph = computeResidualGraph(graph);
			augmentingPath = getAugmentingPath(residualGraph, source, sink);
		}

		for (Vertex<T> vertex : residualGraph.getAdjacentVertices(sink)) {
			maxflow = maxflow + graph.getEdge(vertex, sink).getFlow();
		}

		return maxflow;
	}

	private void initializeFlow(Graph<T, W> graph) {
		graph.getAllEdges().forEach(e -> {
			graph.updateEdge(e.getSource(), e.getDestination(), e.getWeight(), 0, e.getCapacity());
		});
	}

	private Graph<T, W> computeResidualGraph(Graph<T, W> graph) {
		Graph<T, W> residualGraph = new GraphList<>();
		residualGraph.initialize(graph.getAllVertices());

		for (Edge<T, W> edge : graph.getAllEdges()) {
			Vertex<T> u = edge.getSource();
			Vertex<T> v = edge.getDestination();
			int flow = edge.getFlow();
			int capacity = edge.getCapacity();
			if (flow == 0) {
				residualGraph.addEdge(u, v, capacity - flow, capacity);
			} else if (flow < capacity) {
				residualGraph.addEdge(u, v, capacity - flow, capacity);
				residualGraph.addEdge(v, u, flow, capacity);
			} else {
				residualGraph.addEdge(v, u, capacity, capacity);
			}
		}

		System.out.println("*** Residual Graph ***");
		residualGraph.print();
		return residualGraph;
	}

	abstract protected List<Edge<T, W>> getAugmentingPath(Graph<T, W> residualGraph, Vertex<T> source, Vertex<T> sink);

	abstract protected void augmentFlow(Graph<T, W> graph, Vertex<T> source, Vertex<T> sink,
			List<Edge<T, W>> augmentingPath);

}
