package by.javacourse.task2.filler.impl;

import java.util.List;

import by.javacourse.task2.entity.Ellipse;
import by.javacourse.task2.filler.WarehouseFiller;
import by.javacourse.task2.observer.EllipseObserver;
import by.javacourse.task2.observer.impl.EllipseObserverImpl;
import by.javacourse.task2.service.EllipseService;
import by.javacourse.task2.service.impl.EllipseServiceImpl;
import by.javacourse.task2.warehouse.EllipseParameters;
import by.javacourse.task2.warehouse.EllipseWarehouse;

public class WarehouseFillerImpl implements WarehouseFiller {

	@Override
	public void fill(List<Ellipse> ellipses) {
		EllipseWarehouse warehouse = EllipseWarehouse.getInstance();
		EllipseService service = new EllipseServiceImpl();
		EllipseObserver observer = new EllipseObserverImpl();

		ellipses.forEach(e -> {
			e.attach(observer);
			double square = service.findSquare(e);
			double perimeter = service.findPerimeter(e);
			EllipseParameters param = new EllipseParameters(square, perimeter);
			warehouse.putParameters(e.getEllipseId(), param);
		});
	}

}
