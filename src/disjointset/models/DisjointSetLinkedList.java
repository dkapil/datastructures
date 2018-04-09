package disjointset.models;

import java.util.ArrayList;
import java.util.List;

public class DisjointSetLinkedList<T> implements DisjointSet<SetElement<T>> {

	List<Set<T>> sets = new ArrayList<>();

	@Override
	public void makeSet(SetElement<T> v) {
		Set<T> set = new Set<>();
		v.setSet(set);
		set.setHead(v);
		set.setTail(v);
		sets.add(set);
	}

	@Override
	public void union(SetElement<T> u, SetElement<T> v) {
		Set<T> setU = u.getSet();
		Set<T> setV = v.getSet();

		setU.getTail().setNext(setV.getHead());

		SetElement<T> head = setV.head;

		while (head != null) {
			head.setSet(setU);
			head = head.next;
		}

		setU.setTail(setV.getTail());
		sets.remove(setV);
	}

	@Override
	public SetElement<T> findSet(SetElement<T> u) {
		return u.getSet().getHead();
	}

	@Override
	public void printSets() {
		sets.forEach(Set::printSet);
	}
}
