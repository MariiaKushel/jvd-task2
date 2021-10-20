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

		return ellipse.getPointA().x() != ellipse.getPointB().x()
				&& ellipse.getPointA().y() != ellipse.getPointB().y();
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

		double a2X = a.x();
		double a2Y = b.y() - (a.x() - b.y());
		Point a2 = new Point(a2X, a2Y);

		double b2X = a.x() - (b.x() - a.x());
		double b2Y = b.y();
		Point b2 = new Point(b2X, b2Y);

		int quarterA = findQuarter(a);
		int quarterB = findQuarter(b);
		int quarterA2 = findQuarter(a2);
		int quarterB2 = findQuarter(b2);

		boolean isCross = false;

		// point a, a2, b is in the same quarter; point b2 is in the other quarter
		if (quarterA != 0 && quarterA == quarterB && quarterB == quarterA2 && quarterA2 != quarterB2) {
			if (distance == Math.abs(b2.x()) || distance == Math.abs(b.x())) {
				isCross = true;
			}
		}
		// point a, b, b2 is in the same quarter; point a1 is in the other quarter
		if (quarterA != 0 && quarterA == quarterB && quarterB == quarterB2 && quarterB2 != quarterA2) {
			if (distance == Math.abs(a2.y()) || distance == Math.abs(a.y())) {
				isCross = true;
			}
		}
		// point a, a2, b2 is in the same quarter; point b is in the other quarter
		if (quarterA != 0 && quarterA == quarterA2 && quarterA2 == quarterB2 && quarterB2 != quarterB) {
			if (distance == Math.abs(b2.x()) || distance == Math.abs(b.x())) {
				isCross = true;
			}
		}
		// point a2, b, b2 is in the same quarter; point a is in the other quarter
		if (quarterB != 0 && quarterB == quarterA2 && quarterA2 == quarterB2 && quarterB != quarterA) {
			if (distance == Math.abs(a2.y()) || distance == Math.abs(a.y())) {
				isCross = true;
			}
		}

		return isCross;
	}

	private double radiusA(Ellipse ellipse) {
		return Math.abs(ellipse.getPointA().y() - ellipse.getPointB().y());
	}

	private double radiusB(Ellipse ellipse) {
		return Math.abs(ellipse.getPointA().x() - ellipse.getPointB().x());
	}

	private int findQuarter(Point point) {

		int quarter = 0;

		if (point.x() >= 0 && point.y() > 0) {
			quarter = 1;
		}
		if (point.x() < 0 && point.y() >= 0) {
			quarter = 2;
		}
		if (point.x() <= 0 && point.y() < 0) {
			quarter = 3;
		}
		if (point.x() > 0 && point.y() <= 0) {
			quarter = 4;
		}

		return quarter;
	}

}
