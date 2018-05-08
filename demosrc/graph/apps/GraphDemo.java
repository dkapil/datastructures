package graph.apps;

import java.util.Arrays;

import graph.models.Graph;
import graph.models.GraphList;
import graph.models.GraphMatrix;
import graph.models.Vertex;

public class GraphDemo {

	public static void main(String[] args) {

		Graph<Integer, Integer> graphMatrix = new GraphMatrix<>();

		Vertex<Integer> zero = new Vertex<>(0, 0);
		Vertex<Integer> one = new Vertex<>(1, 1);
		Vertex<Integer> two = new Vertex<>(2, 2);
		Vertex<Integer> three = new Vertex<>(3, 3);
		Vertex<Integer> four = new Vertex<>(4, 4);

		graphMatrix.initialize(Arrays.asList(zero, one, two, three, four));
		graphMatrix.addEdge(zero, one).addEdge(zero, four).addEdge(one, zero).addEdge(one, two).addEdge(one, three)
				.addEdge(one, four).addEdge(two, one).addEdge(two, three).addEdge(three, one).addEdge(three, two)
				.addEdge(three, four).addEdge(four, zero).addEdge(four, one).addEdge(four, three);

		graphMatrix.print();

		Graph<Integer, Integer> graphList = new GraphList<>();
		graphList.initialize(Arrays.asList(zero, one, two, three, four));

		graphList.addEdge(zero, one).addEdge(zero, four).addEdge(one, zero).addEdge(one, two).addEdge(one, three)
				.addEdge(one, four).addEdge(two, one).addEdge(two, three).addEdge(three, one).addEdge(three, two)
				.addEdge(three, four).addEdge(four, zero).addEdge(four, one).addEdge(four, three);

		graphList.print();

		graphMatrix.removeEdge(zero, four);
		graphMatrix.print();

		graphList.removeEdge(one, two);
		graphList.print();
	}
}
