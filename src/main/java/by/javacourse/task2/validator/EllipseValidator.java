package by.javacourse.task2.validator;

import by.javacourse.task2.entity.Point;

public interface EllipseValidator {

	static final String STRING_AS_COORDINATES_REGEX = "(-?\\d+(\\.\\d+)?;){4}";
	static final int NUMBER_OF_COORDINATES = 4;

	boolean validateString(String stringAsCoordinates);

	boolean canEllipseExist(double aX, double aY, double bX, double bY);

	public boolean canEllipseExist(double... coordinates);

	boolean canEllipseExist(Point a, Point b);

	public boolean canEllipseExist(String aX, String aY, String bX, String bY);

	public boolean canEllipseExist(String... coordinates);

}
