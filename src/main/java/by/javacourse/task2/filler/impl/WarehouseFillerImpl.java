package by.javacourse.task2.filler.impl;

import java.util.List;

import by.javacourse.task2.entity.Ellipse;
import by.javacourse.task2.filler.Filler;
import by.javacourse.task2.observer.EllipseObserver;
import by.javacourse.task2.observer.impl.EllipseObserverImpl;
import by.javacourse.task2.service.EllipseService;
import by.javacourse.task2.service.impl.EllipseServiceImpl;
import by.javacourse.task2.warehouse.EllipseParameters;
import by.javacourse.task2.warehouse.EllipseWarehouse;

public class WarehouseFillerImpl implements Filler {

	@Override
	public void fillAll(List<Ellipse> ellipses) {

		ellipses.forEach(e -> fillOne(e));
	}

	public void fillOne(Ellipse ellipse) {
		EllipseWarehouse warehouse = EllipseWarehouse.getInstance();
		EllipseService service = new EllipseServiceImpl();
		EllipseObserver observer = new EllipseObserverImpl();

		ellipse.attach(observer);
		double square = service.findSquare(ellipse);
		double perimeter = service.findPerimeter(ellipse);
		EllipseParameters param = new EllipseParameters(square, perimeter);
		warehouse.putParameters(ellipse.getEllipseId(), param);
	}

}
