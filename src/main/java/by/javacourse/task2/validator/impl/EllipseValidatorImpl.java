package by.javacourse.task2.validator.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.javacourse.task2.entity.Point;
import by.javacourse.task2.validator.EllipseValidator;

public class EllipseValidatorImpl implements EllipseValidator {

	private static final EllipseValidatorImpl instanse = new EllipseValidatorImpl();

	private EllipseValidatorImpl() {

	}

	public static EllipseValidatorImpl getInstance() {
		return instanse;
	}

	@Override
	public boolean validateString(String stringAsCoordinates) {

		Pattern pattern = Pattern.compile(STRING_AS_COORDINATES_REGEX);
		Matcher matcher = pattern.matcher(stringAsCoordinates);

		return matcher.matches();
	}

	@Override
	public boolean canEllipseExist(double aX, double aY, double bX, double bY) {

		boolean canExist = false;
		if (aX != bX && aY != bY) {
			canExist = true;
		}
		return canExist;
	}

	@Override
	public boolean canEllipseExist(double... coordinates) {

		boolean canExist = false;
		if (coordinates.length == NUMBER_OF_COORDINATES) {
			canExist = canEllipseExist(coordinates[0], coordinates[1], coordinates[2], coordinates[3]);
		}

		return canExist;
	}

	@Override
	public boolean canEllipseExist(Point a, Point b) {

		return canEllipseExist(a.x(), a.y(), b.x(), b.y());
	}

	@Override
	public boolean canEllipseExist(String aX, String aY, String bX, String bY) {

		boolean canExist = false;
		if (aX.compareTo(bX) != 0 && aY.compareTo(bY) != 0) {
			canExist = true;
		}
		return canExist;
	}

	@Override
	public boolean canEllipseExist(String... coordinates) {

		boolean canExist = false;
		if (coordinates.length == NUMBER_OF_COORDINATES) {
			canExist = canEllipseExist(coordinates[0], coordinates[1], coordinates[2], coordinates[3]);
		}
		return canExist;
	}

}
