package graph.apps.shortestpaths.allpairs;

public class AllPairsMatrixMultiplication extends AllPairsShortestPath {

	public Integer[][] extendShortestPaths(Integer[][] L, Integer[][] w) {
		int n = L.length;
		Integer[][] Lp = new Integer[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				Lp[i][j] = Integer.MAX_VALUE;
				for (int k = 0; k < n; k++) {
					Lp[i][j] = Math.min(Lp[i][j], add(L[i][k], w[k][j]));
				}
			}
		}
		return Lp;
	}

	public Integer[][] fasterAllPairsShortestPaths(Integer[][] W) {
		printMatrix(W);
		int n = W.length;
		Integer[][][] L = new Integer[n][n][n];
		L[1] = W;
		int m = 1;
		while (m < n - 1) {
			L[2 * m] = extendShortestPaths(L[m], L[m]);
			m = 2 * m;
			printMatrix(L[m]);
		}
		return L[m];

	}

	public Integer[][] slowAllPairsShortestPaths(Integer[][] W) {
		printMatrix(W);
		int n = W.length;
		Integer[][][] L = new Integer[n][n][n];
		L[0] = W;
		for (int m = 1; m <= n - 2; m++) {
			L[m] = extendShortestPaths(L[m - 1], W);
			printMatrix(L[m]);
		}
		return L[n - 2];
	}

}
