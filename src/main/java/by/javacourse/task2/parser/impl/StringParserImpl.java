package by.javacourse.task2.parser.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.javacourse.task2.entity.Point;
import by.javacourse.task2.exception.CustomException;
import by.javacourse.task2.parser.StringParser;
import by.javacourse.task2.validator.EllipseValidator;
import by.javacourse.task2.validator.impl.EllipseValidatorImpl;

public class StringParserImpl implements StringParser {

	static Logger logger = LogManager.getLogger();

	@Override
	public List<double[]> parseListToCoordinates(List<String> stringsAsCoordinates) throws CustomException {

		EllipseValidator validator = EllipseValidatorImpl.getInstance();

		List<double[]> coordinateList = new ArrayList<double[]>();

		coordinateList = stringsAsCoordinates.stream()
				.map(elem -> elem.split(COORDINATE_SPLIT_REGEX))
				.peek(arr -> logger.info("array before validation" + Arrays.toString(arr)))
				.filter(validator::canEllipseExist)
				.map(arr -> Stream.of(arr)
						.mapToDouble(Double::parseDouble)
						.toArray())
				.peek(arr -> logger.info("array to collect " + Arrays.toString(arr)))
				.collect(Collectors.toList());

		if (coordinateList.isEmpty()) {
			logger.error("Nothing to parse.");
			throw new CustomException("Nothing to parse.");
		}

		return coordinateList;
	}

	@Override
	public List<Point[]> parseListToPoints(List<String> stringsAsCoordinates) throws CustomException {

		List<Point[]> pointsList = new ArrayList<Point[]>();
		List<double[]> coordinateList = parseListToCoordinates(stringsAsCoordinates);

		pointsList = coordinateList.stream()
				.map(arr -> {
					Point[] points = new Point[2];
					points[0] = new Point(arr[0], arr[1]);
					points[1] = new Point(arr[2], arr[3]);
					return points;})
				.collect(Collectors.toList());

		return pointsList;
	}
	
	@Override
	public double[] parseStringToCoordinates(String stringAsCoordinates) throws CustomException {

		String[] coordinatesAsStingArray = stringAsCoordinates.split(COORDINATE_SPLIT_REGEX);

		EllipseValidator validator = EllipseValidatorImpl.getInstance();

		if (!validator.canEllipseExist(coordinatesAsStingArray)) {
			logger.error("String " + stringAsCoordinates + "  could not be parse.");
			throw new CustomException("String " + stringAsCoordinates + "  could not be parse.");
		}

		double[] coordinates;
		coordinates = Stream.of(coordinatesAsStingArray)
				.mapToDouble(Double::parseDouble)
				.toArray();

		return coordinates;
	}

	@Override
	public Point[] parseStringToPoints(String stringAsCoordinates) throws CustomException {

		double[] coordinates = parseStringToCoordinates(stringAsCoordinates);

		Point[] points = new Point[2];
		points[0] = new Point(coordinates[0], coordinates[1]);
		points[1] = new Point(coordinates[2], coordinates[3]);

		return points;
	}
	
}
