package by.javacourse.task2.filler.impl;

import java.util.List;

import by.javacourse.task2.entity.Ellipse;
import by.javacourse.task2.filler.Filler;
import by.javacourse.task2.repository.EllipseRepository;

public class RepositoryFillerImpl implements Filler {

	@Override
	public void fillAll(List<Ellipse> ellipses) {

		ellipses.forEach(e -> fillOne(e));
	}

	@Override
	public void fillOne(Ellipse ellipse) {
		EllipseRepository repository = EllipseRepository.getInstance();
		Filler warehouseFiller = new WarehouseFillerImpl();

		repository.add(ellipse);
		warehouseFiller.fillOne(ellipse);
	}
}
