package by.javacourse.task2.repository.impl;

import by.javacourse.task2.entity.Ellipse;
import by.javacourse.task2.repository.Specification;
import by.javacourse.task2.service.EllipseService;
import by.javacourse.task2.service.impl.EllipseServiceImpl;

public class PerimetrLessThanSpecificationImpl implements Specification {

	private EllipseService service = new EllipseServiceImpl();
	
	private double maxPerimetr;

	public PerimetrLessThanSpecificationImpl(double maxPerimetr) {
		this.maxPerimetr = maxPerimetr;
	}

	@Override
	public boolean specify(Ellipse ellipse) {
		
		double perimetr = service.findPerimeter(ellipse);
		return perimetr <= maxPerimetr;
	}

}
