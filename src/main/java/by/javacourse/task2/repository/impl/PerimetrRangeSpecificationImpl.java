package by.javacourse.task2.repository.impl;

import by.javacourse.task2.entity.Ellipse;
import by.javacourse.task2.repository.Specification;
import by.javacourse.task2.service.EllipseService;
import by.javacourse.task2.service.impl.EllipseServiceImpl;

public class PerimetrRangeSpecificationImpl implements Specification {

	private double perimetrFrom;
	private double perimetrTo;

	public PerimetrRangeSpecificationImpl(double perimetrFrom, double perimetrTo) {
		this.perimetrFrom = perimetrFrom;
		this.perimetrTo = perimetrTo;
	}

	@Override
	public boolean specify(Ellipse ellipse) {
		EllipseService service = new EllipseServiceImpl();
		double perimeter = service.findPerimeter(ellipse);
		return perimeter > perimetrFrom && perimeter < perimetrTo;
	}

}
