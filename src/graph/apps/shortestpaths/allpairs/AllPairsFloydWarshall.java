package graph.apps.shortestpaths.allpairs;

public class AllPairsFloydWarshall extends AllPairsShortestPath {

	public Integer[][] shortestPath(Integer[][] W) {
		int n = W.length;
		Integer[][][] D = new Integer[n + 1][n][n];
		D[0] = W;
		Integer[][][] PM = initializePredecessorMatrix(D[0], n);
		printMatrix(D[0]);
		System.out.println("Predecessor Matrix 0");
		printMatrix(PM[0]);
		for (int k = 1; k <= n; k++) {
			D[k] = new Integer[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					D[k][i][j] = Math.min(D[k - 1][i][j], add(D[k - 1][i][k - 1], D[k - 1][k - 1][j]));

					if (D[k - 1][i][j] > add(D[k - 1][i][k - 1], D[k - 1][k - 1][j])) {
						PM[k][i][j] = PM[k - 1][k - 1][j];
					} else
						PM[k][i][j] = PM[k - 1][i][j];
				}
			}
			System.out.println("Weight Matrix " + k);
			printMatrix(D[k]);
			System.out.println("Predecessor Matrix " + k);
			printMatrix(PM[k]);

		}
		return D[n];
	}

	private Integer[][][] initializePredecessorMatrix(Integer[][] w, int n) {
		Integer[][][] PM = new Integer[n + 1][n][n];
		Integer[][] pm0 = new Integer[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j || w[i][j] == Integer.MAX_VALUE)
					pm0[i][j] = -1;
				else if (i != j && w[i][j] != Integer.MAX_VALUE)
					pm0[i][j] = i + 1;
			}
		}
		PM[0] = pm0;
		return PM;
	}
}
