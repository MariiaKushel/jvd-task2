package by.javacourse.task2.factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.javacourse.task2.entity.Ellipse;
import by.javacourse.task2.entity.Point;
import by.javacourse.task2.validator.EllipseValidator;
import by.javacourse.task2.validator.impl.EllipseValidatorImpl;

public class EllipseFactory {

	static Logger logger = LogManager.getLogger();

	private static EllipseValidator validator = EllipseValidatorImpl.getInstance();

	public static List<Ellipse> createEllipseListFromCoordinates(List<double[]> coordinates) {
		List<Ellipse> ellipses = new ArrayList<Ellipse>();
		ellipses = coordinates.stream()
				.map(arr -> createEllipse(arr))
				.filter(o -> o != null)
				.peek(o -> logger.info("ellipse to collect " + o))
				.collect(Collectors.toList());

		return ellipses;
	}

	public static List<Ellipse> createEllipseListFromPoints(List<Point[]> points) {
		List<Ellipse> ellipses = new ArrayList<Ellipse>();
		ellipses = points.stream()
				.peek(arr -> logger.info ((arr.length != EllipseValidator.NUMBER_OF_POINTS) ? 
										"Ellipse can not be create. Wrong data " + Arrays.toString(arr) : 
										"Number of points is correct" + Arrays.toString(arr)))
				.filter(arr -> arr.length == EllipseValidator.NUMBER_OF_POINTS)
				.map(arr -> createEllipse(arr[0], arr[1]))
				.filter(o -> o != null)
				.peek(o -> logger.info("ellipse to collect " + o))
				.collect(Collectors.toList());
		
		return ellipses;

	}

	public static Ellipse createEllipse(double... coordinates) {
		
		Ellipse newEllipse = null;
		
		if  (coordinates.length == EllipseValidator.NUMBER_OF_COORDINATES) {
				double aX = coordinates[0];
				double aY = coordinates[1];
				double bX = coordinates[2];
				double bY = coordinates[3];
				newEllipse = createEllipse(aX, aY, bX, bY);
		}else {
			logger.info("Ellipse can not be create. Wrong data " + Arrays.toString(coordinates));
		}
		
		return newEllipse;
	}

	public static Ellipse createEllipse(double aX, double aY, double bX, double bY) {
		Point pointA = new Point(aX, aY);
		Point pointB = new Point(bX, bY);

		return createEllipse(pointA, pointB);
	}

	public static Ellipse createEllipse(Point a, Point b) {

		Ellipse newEllipse = null;

		if (validator.canEllipseExist(a, b)) {
			newEllipse = new Ellipse(a, b);
		} else {
			logger.info("Ellipse can not be create by points " + a + "; " + b);
		}

		return newEllipse;
	}

}
