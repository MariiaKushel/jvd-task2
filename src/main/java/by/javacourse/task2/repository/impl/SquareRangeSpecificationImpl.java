package by.javacourse.task2.repository.impl;

import by.javacourse.task2.entity.Ellipse;
import by.javacourse.task2.repository.Specification;
import by.javacourse.task2.service.EllipseService;
import by.javacourse.task2.service.impl.EllipseServiceImpl;

public class SquareRangeSpecificationImpl implements Specification {

	private double squareFrom;
	private double squareTo;

	public SquareRangeSpecificationImpl(double squareFrom, double squareTo) {
		this.squareFrom = squareFrom;
		this.squareTo = squareTo;
	}

	@Override
	public boolean specify(Ellipse ellipse) {
		EllipseService service = new EllipseServiceImpl();
		double square = service.findSquare(ellipse);
		return Double.compare(square, squareFrom) >= 0 && Double.compare(square, squareTo) <= 0;
	}

}
