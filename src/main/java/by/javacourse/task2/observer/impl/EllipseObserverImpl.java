package by.javacourse.task2.observer.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.javacourse.task2.entity.Ellipse;
import by.javacourse.task2.observer.EllipseEvent;
import by.javacourse.task2.observer.EllipseObserver;
import by.javacourse.task2.service.EllipseService;
import by.javacourse.task2.service.impl.EllipseServiceImpl;
import by.javacourse.task2.warehouse.EllipseParameters;
import by.javacourse.task2.warehouse.EllipseWarehouse;

public class EllipseObserverImpl implements EllipseObserver {

	static Logger logger = LogManager.getLogger();

	@Override
	public void updateParamrters(EllipseEvent event) {

		EllipseWarehouse warehouse = EllipseWarehouse.getInstance();
		EllipseService service = new EllipseServiceImpl();
		Ellipse ellipse = event.getSource();

		double square = service.findSquare(ellipse);
		double perimeter = service.findPerimeter(ellipse);

		EllipseParameters param = new EllipseParameters(square, perimeter);

		logger.info(warehouse.putParameters(ellipse.getEllipseId(), param)
				? "Parameters " + param + " for id " + ellipse.getEllipseId() + " have been updated."
				: "Id " + ellipse.getEllipseId() + " was not found.");
	}

}
