package by.javacourse.task2.service.impl;

import by.javacourse.task2.entity.Ellipse;
import by.javacourse.task2.entity.Point;
import by.javacourse.task2.service.EllipseService;

public class EllipseServiceImpl implements EllipseService {

	@Override
	public double findSquare(Ellipse ellipse) {

		double a = radiusA(ellipse);
		double b = radiusB(ellipse);

		double square;
		square = Math.PI * a * b;

		return square;
	}

	@Override
	public double findPerimeter(Ellipse ellipse) {

		double a = radiusA(ellipse);
		double b = radiusB(ellipse);

		if (a < b) {
			double temp = a;
			a = b;
			b = temp;
		}

		double perimeter;
		perimeter = 4 * ((Math.PI * a * b + Math.pow((a - b), 2)) / (a + b));

		return perimeter;
	}

	@Override
	public boolean isEllipse(Ellipse ellipse) {

		return ellipse.getPointA().getX() != ellipse.getPointB().getX()
				&& ellipse.getPointA().getY() != ellipse.getPointB().getY();
	}

	@Override
	public boolean isСircle(Ellipse ellipse) {

		boolean isCircle = false;

		if (isEllipse(ellipse)) {
			isCircle = radiusA(ellipse) == radiusB(ellipse);
		}
		return isCircle;
	}

	@Override
	public boolean isCrossCoordinateAxis(Ellipse ellipse, double distance) {

		Point a = ellipse.getPointA();
		Point b = ellipse.getPointB();

		double a2X = a.getX();
		double a2Y = b.getY() - (a.getY() - b.getY());
		Point a2 = new Point(a2X, a2Y);

		double b2X = a.getX() - (b.getX() - a.getX());
		double b2Y = b.getY();
		Point b2 = new Point(b2X, b2Y);

		int quarterA = findQuarter(a);
		int quarterB = findQuarter(b);
		int quarterA2 = findQuarter(a2);
		int quarterB2 = findQuarter(b2);

		boolean isCross = false;

		// b2
		if (quarterA != 0 && quarterA == quarterB && quarterB == quarterA2 && quarterA2 != quarterB2) {
			if (distance == Math.abs(b2.getX()) || distance == Math.abs(b.getX())) {
				isCross = true;
			}
		}
		// a2
		if (quarterA != 0 && quarterA == quarterB && quarterB == quarterB2 && quarterB2 != quarterA2) {
			if (distance == Math.abs(a2.getY()) || distance == Math.abs(a.getY())) {
				isCross = true;
			}
		}
		// b
		if (quarterA != 0 && quarterA == quarterA2 && quarterA2 == quarterB2 && quarterB2 != quarterB) {
			if (distance == Math.abs(b2.getX()) || distance == Math.abs(b.getX())) {
				isCross = true;
			}
		}
		// a
		if (quarterB != 0 && quarterB == quarterA2 && quarterA2 == quarterB2 && quarterB != quarterA) {
			if (distance == Math.abs(a2.getY()) || distance == Math.abs(a.getY())) {
				isCross = true;
			}
		}

		return isCross;
	}

	private double radiusA(Ellipse ellipse) {
		return Math.abs(ellipse.getPointA().getY() - ellipse.getPointB().getY());
	}

	private double radiusB(Ellipse ellipse) {
		return Math.abs(ellipse.getPointA().getX() - ellipse.getPointB().getX());
	}

	private int findQuarter(Point point) {

		int quarter = 0;

		if (point.getX() >= 0 && point.getY() >= 0) {
			quarter = 1;
		}
		if (point.getX() <= 0 && point.getY() > 0) {
			quarter = 2;
		}
		if (point.getX() < 0 && point.getY() <= 0) {
			quarter = 3;
		}
		if (point.getX() >= 0 && point.getY() < 0) {
			quarter = 4;
		}

		return quarter;
	}

}
