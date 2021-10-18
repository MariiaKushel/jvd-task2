package by.javacourse.task2.repository.impl;

import by.javacourse.task2.entity.Ellipse;
import by.javacourse.task2.repository.Specification;

public class IdSpecificationImpl implements Specification {

	private long neededId;

	public IdSpecificationImpl(long neededId) {
		this.neededId = neededId;
	}

	@Override
	public boolean specify(Ellipse ellipse) {
		boolean result = ellipse.getEllipseId() == neededId;
		return result;
	}

}
