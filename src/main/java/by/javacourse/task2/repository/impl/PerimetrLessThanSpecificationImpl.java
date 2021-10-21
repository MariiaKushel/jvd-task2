package by.javacourse.task2.repository.impl;

import by.javacourse.task2.entity.Ellipse;
import by.javacourse.task2.repository.Specification;
import by.javacourse.task2.service.EllipseService;
import by.javacourse.task2.service.impl.EllipseServiceImpl;

public class PerimetrLessThanSpecificationImpl implements Specification {

	private double maxPerimeter;

	public PerimetrLessThanSpecificationImpl(double maxPerimetr) {
		this.maxPerimeter = maxPerimetr;
	}

	@Override
	public boolean specify(Ellipse ellipse) {
		EllipseService service = new EllipseServiceImpl();
		double perimeter = service.findPerimeter(ellipse);
		return perimeter < maxPerimeter;
	}

}
