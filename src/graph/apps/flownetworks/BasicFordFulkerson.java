package graph.apps.flownetworks;

import java.util.List;

import graph.models.Edge;
import graph.models.Graph;
import graph.models.Vertex;

public abstract class BasicFordFulkerson<T, W> extends FordFulkerson<T, W> {

	@Override
	protected void augmentFlow(Graph<T, W> graph, Vertex<T> source, Vertex<T> sink, List<Edge<T, W>> augmentingPath) {
		Integer minResidualCapacity = getResidualCapacity(augmentingPath);
		for (Edge<T, W> uvGf : augmentingPath) {
			Edge<T, W> uvG = graph.getEdge(uvGf.getSource(), uvGf.getDestination());
			if (uvG != null) {
				graph.updateEdge(uvG.getSource(), uvG.getDestination(), uvG.getWeight(),
						uvG.getFlow() + minResidualCapacity, uvG.getCapacity());
				System.out.println("Updating Edge : " + uvG.getSource() + "->" + uvG.getDestination() + "with W="
						+ uvG.getWeight() + " F=" + (uvG.getFlow() + minResidualCapacity) + " C=" + uvG.getCapacity());
			} else {
				Edge<T, W> vuG = graph.getEdge(uvGf.getDestination(), uvGf.getSource());
				graph.updateEdge(vuG.getSource(), vuG.getDestination(), vuG.getWeight(),
						vuG.getFlow() - minResidualCapacity, vuG.getCapacity());
				System.out.println("Updating Edge : " + vuG.getSource() + "->" + vuG.getDestination() + "with W="
						+ vuG.getWeight() + " F=" + (vuG.getFlow() - minResidualCapacity) + " C=" + vuG.getCapacity());
			}
		}
	}

	private Integer getResidualCapacity(List<Edge<T, W>> p) {
		return p.stream().map(Edge::getFlow).reduce(Integer::min).get();
	}

}
