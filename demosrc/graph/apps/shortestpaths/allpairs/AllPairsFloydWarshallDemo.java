package graph.apps.shortestpaths.allpairs;

import graph.apps.shortestpaths.allpairs.AllPairsFloydWarshall;

public class AllPairsFloydWarshallDemo {

	public static void main(String[] args) {

		Integer[][] W = new Integer[5][5];

		W = initialize(W);

		W[0][1] = 3;
		W[0][2] = 8;
		W[0][4] = -4;

		W[1][3] = 1;
		W[1][4] = 7;

		W[2][1] = 4;

		W[3][2] = -5;
		W[3][0] = 2;

		W[4][3] = 6;

		AllPairsFloydWarshall aFW = new AllPairsFloydWarshall();
		aFW.shortestPath(W);
	}

	private static Integer[][] initialize(Integer[][] W) {
		for (int i = 0; i < W.length; i++) {
			for (int j = 0; j < W[i].length; j++) {
				if (i == j)
					W[i][j] = 0;
				else
					W[i][j] = Integer.MAX_VALUE;
			}
		}
		return W;
	}
}
