package by.javacourse.task2.filler.impl;

import java.util.List;

import by.javacourse.task2.entity.Ellipse;
import by.javacourse.task2.filler.RepositoryFiller;
import by.javacourse.task2.filler.WarehouseFiller;
import by.javacourse.task2.repository.EllipseRepository;

public class RepositoryFillerImpl implements RepositoryFiller {

	@Override
	public void fill(List<Ellipse> ellipses) {
		EllipseRepository repository = EllipseRepository.getInstance();
		WarehouseFiller warehouseFiller = new WarehouseFillerImpl();
		
		repository.addAll(ellipses);
		warehouseFiller.fill(ellipses);
	}
}
