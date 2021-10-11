package by.javacourse.task2.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import by.javacourse.task2.entity.Ellipse;
import by.javacourse.task2.entity.Point;

public class EllipseFactory {

	public static List<Ellipse> createEllipseListFromCoordinates(List<double[]> coordinates) {
		List<Ellipse> ellipses = new ArrayList<Ellipse>();
		ellipses = coordinates.stream()
				.map(elem -> createEllipse(elem))
				.collect(Collectors.toList());

		return ellipses;
	}

	public static List<Ellipse> createEllipseListFromPoints(List<Point[]> points) {
		List<Ellipse> ellipses = new ArrayList<Ellipse>();
		ellipses = points.stream()
				.map(elem -> createEllipse(elem[0], elem[1]))
				.collect(Collectors.toList());

		return ellipses;

	}

	public static Ellipse createEllipse(double... coordinates) {
		double aX = coordinates[0];
		double aY = coordinates[1];
		double bX = coordinates[2];
		double bY = coordinates[3];

		return createEllipse(aX, aY, bX, bY);
	}

	public static Ellipse createEllipse(double aX, double aY, double bX, double bY) {
		Point pointA = new Point(aX, aY);
		Point pointB = new Point(bX, bY);

		return createEllipse(pointA, pointB);
	}

	public static Ellipse createEllipse(Point a, Point b) {
		
		return new Ellipse(a, b);
	}

}
