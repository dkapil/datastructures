package graph.apps.shortestpaths.allpairs;

public class AllPairsShortestPath {

	public void printAllPairsShortestPath(Integer[][] predecessorMatrix, Integer i, Integer j) {
		if (i == j)
			System.out.println(i);
		else if (predecessorMatrix[i][j] == null)
			System.out.println("No Path Exist from " + i + " to " + j);
		else {
			printAllPairsShortestPath(predecessorMatrix, i, predecessorMatrix[i][j]);
			System.out.println(j);
		}
	}

	public void printMatrix(Integer[][] mat) {
		for (int u = 0; u < mat.length; u++) {
			for (int j = 0; j < mat[u].length; j++) {
				if (mat[u][j] == Integer.MAX_VALUE)
					System.out.print("Inf" + "\t");
				else
					System.out.print(mat[u][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}

	public int add(Integer a, Integer b) {
		if (a == Integer.MAX_VALUE || b == Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		else
			return a + b;
	}
}
