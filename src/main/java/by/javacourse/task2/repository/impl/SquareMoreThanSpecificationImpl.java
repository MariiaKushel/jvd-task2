package by.javacourse.task2.repository.impl;

import by.javacourse.task2.entity.Ellipse;
import by.javacourse.task2.repository.Specification;
import by.javacourse.task2.service.EllipseService;
import by.javacourse.task2.service.impl.EllipseServiceImpl;

public class SquareMoreThanSpecificationImpl implements Specification {

	private EllipseService service = new EllipseServiceImpl();

	private double minSquare;

	public SquareMoreThanSpecificationImpl(double minSquare) {
		this.minSquare = minSquare;
	}

	@Override
	public boolean specify(Ellipse ellipse) {

		double square = service.findSquare(ellipse);

		return square >= minSquare;
	}

}
