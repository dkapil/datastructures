package disjointset.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DisjoinSetForest<T> implements DisjointSet<ForestElement<T>> {

	List<ForestElement<T>> sets = new ArrayList<>();

	@Override
	public void makeSet(ForestElement<T> x) {
		x.parent = x;
		x.rank = 0;
		sets.add(x);
	}

	@Override
	public void union(ForestElement<T> x, ForestElement<T> y) {
		link(findSet(x), findSet(y));
	}

	private void link(ForestElement<T> x, ForestElement<T> y) {
		if (x.rank > y.rank) {
			y.parent = x;
		} else {
			x.parent = y;
			if (x.rank == y.rank)
				y.rank = y.rank + 1;
		}
	}

	@Override
	public ForestElement<T> findSet(ForestElement<T> x) {
		if (x != x.parent)
			x.parent = findSet(x.parent);
		return x.parent;
	}

	@Override
	public void printSets() {
		Map<Object, List<ForestElement<T>>> a = sets.stream().collect(Collectors.groupingBy(p -> findSet(p)));
		a.values().forEach(System.out::println);
	}

}
