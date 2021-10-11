package by.javacourse.task2.service;

import by.javacourse.task2.entity.Ellipse;

public interface EllipseService {

	double findSquare(Ellipse ellipse);

	double findPerimeter(Ellipse ellipse);

	boolean isEllipse(Ellipse ellipse);

	boolean isСircle(Ellipse ellipse);

	boolean isCrossCoordinateAxis(Ellipse ellipse, double distance);

}
