package by.javacourse.task2.repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.javacourse.task2.entity.Ellipse;

public class EllipseRepository {
	
	static Logger logger = LogManager.getLogger();

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
		return ellipses.get(index);
	}

	public Ellipse set(int index, Ellipse ellipse) {
		return ellipses.set(index, ellipse);
	}

	public int size () {
		return ellipses.size();
	}
	
	public boolean isEmpty() {
		return ellipses.isEmpty();
	}
	
	public List<Ellipse> sort(Comparator<Ellipse> c) {
		List<Ellipse> sorted;
		sorted =  ellipses.stream()
				.sorted(c)
				.collect(Collectors.toList());		
		return  sorted;
	}

	public List<Ellipse> query(Specification spesification) {
		List<Ellipse> foundEllipses = ellipses.stream()
				.filter(e -> spesification.specify(e))
				.collect(Collectors.toList());
		return foundEllipses;
	}
	
	@Override
	public String toString () {
		return ellipses.toString();
	}

}
