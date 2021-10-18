package by.javacourse.task2.imitator;

import by.javacourse.task2.repository.EllipseRepository;
import by.javacourse.task2.service.impl.EllipseServiceImpl;
import by.javacourse.task2.warehouse.EllipseParameters;
import by.javacourse.task2.warehouse.EllipseWarehouse;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import by.javacourse.task2.entity.Ellipse;
import by.javacourse.task2.entity.Point;
import by.javacourse.task2.observer.EllipseObserver;
import by.javacourse.task2.observer.impl.EllipseObserverImpl;

public class ActionImitator {

	static Logger logger = LogManager.getLogger();

	public void imitate(List<Ellipse> ellipses) {

		EllipseRepository repository = EllipseRepository.getInstance();
		EllipseWarehouse warehouse = EllipseWarehouse.getInstance();
		EllipseObserver observer = new EllipseObserverImpl();
		EllipseServiceImpl service = new EllipseServiceImpl();

		ellipses.stream().forEach(e -> {
			repository.add(e);
			e.attach(observer);
			double square = service.findSquare(e);
			double perimeter = service.findPerimeter(e);
			EllipseParameters parameters = new EllipseParameters(square, perimeter);
			warehouse.putParameters(e.getEllipseId(), parameters);
		});

		logger.info("before " + warehouse.toSting());
		
		repository.get(0).setPointA(new Point(100, 100));

		logger.info("after " + warehouse.toSting());

	}

}
