package by.javacourse.task2.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import by.javacourse.task2.entity.Ellipse;

public class EllipseRepository {

	private static EllipseRepository instance;

	private List<Ellipse> ellipses;

	private EllipseRepository() {
		ellipses = new ArrayList<Ellipse>();
	}

	public static EllipseRepository getInstance() {
		if (instance == null) {
			instance = new EllipseRepository();
		}
		return instance;
	}

	public boolean add(Ellipse ellipse) {
		return ellipses.add(ellipse);
	}

	public boolean remove(Ellipse ellipse) {
		return ellipses.remove(ellipse);
	}

	public boolean addAll(List<Ellipse> ellipses) {
		return this.ellipses.addAll(ellipses);
	}

	public boolean removeAll(List<Ellipse> ellipses) {
		return this.ellipses.removeAll(ellipses);
	}

	public Ellipse get(int index) {
		Ellipse ellipse = null;
		if (containsIndex(index)) {
			ellipse = ellipses.get(index);
		}
		return ellipse;
	}

	public boolean set(int index, Ellipse ellipse) {
		boolean flag = true;
		if (containsIndex(index)) {
			ellipses.set(index, ellipse);
		} else {
			flag = false;
		}
		return flag;
	}

	public List<Ellipse> getRepository() {
		return Collections.unmodifiableList(ellipses);
	}

	public int size() {
		return ellipses.size();
	}

	public boolean isEmpty() {
		return ellipses.isEmpty();
	}

	public boolean containsIndex(int index) {
		return index >= 0 && index < ellipses.size();
	}

	public List<Ellipse> sort(Comparator<Ellipse> c) {
		List<Ellipse> sorted;
		sorted = ellipses.stream().sorted(c).collect(Collectors.toList());
		return sorted;
	}

	public List<Ellipse> query(Specification spesification) {
		List<Ellipse> foundEllipses = ellipses.stream().filter(e -> spesification.specify(e))
				.collect(Collectors.toList());
		return foundEllipses;
	}

	@Override
	public String toString() {
		return ellipses.toString();
	}

}
