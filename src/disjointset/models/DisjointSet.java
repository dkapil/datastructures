package disjointset.models;

public interface DisjointSet<T extends Element<?>> {

	void makeSet(T v);

	void union(T u, T v);

	T findSet(T u);

	void printSets();
}
