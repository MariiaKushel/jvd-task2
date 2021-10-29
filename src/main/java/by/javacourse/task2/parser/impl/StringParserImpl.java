package by.javacourse.task2.parser.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.javacourse.task2.entity.Point;
import by.javacourse.task2.parser.StringParser;
import by.javacourse.task2.validator.EllipseValidator;
import by.javacourse.task2.validator.impl.EllipseValidatorImpl;

public class StringParserImpl implements StringParser {

	static Logger logger = LogManager.getLogger();

	@Override
	public List<double[]> parseListToCoordinates(List<String> stringsAsCoordinates) {

		List<double[]> coordinateList = new ArrayList<double[]>();
		
		coordinateList = stringsAsCoordinates.stream()
				.peek(s -> logger.info("string before parsing " + s))
				.map(s -> parseStringToCoordinates(s))
				.filter(arr -> arr.length != 0)
				.peek(arr -> logger.info("array to collect " + Arrays.toString(arr)))
				.collect(Collectors.toList());
		

		/* Other variant without using method parseStringToCoordinates
		 * 
		 * coordinateList = stringsAsCoordinates.stream() 
		 * 				.map(s -> s.split(COORDINATE_SPLIT_REGEX)) 
		 * 				.peek(arr -> logger.info("array before validation" + Arrays.toString(arr)))
		 * 				.filter(validator::canEllipseExist) 
		 * 				.map(arr -> Stream.of(arr)
		 * 								  .mapToDouble(Double::parseDouble) 
		 * 								  .toArray()) 
		 * 				.peek(arr -> logger.info("array to collect " + Arrays.toString(arr)))
		 * 				.collect(Collectors.toList());
		 */
		
		return coordinateList;
	}

	@Override
	public List<Point[]> parseListToPoints(List<String> stringsAsCoordinates) {

		List<Point[]> pointsList = new ArrayList<Point[]>();
		
		pointsList = stringsAsCoordinates.stream()
				.peek(s -> logger.info("string before parsing " + s))
				.map(s -> parseStringToPoints(s))
				.filter(arr -> arr.length != 0)
				.peek(arr -> logger.info("array to collect " + Arrays.toString(arr)))
				.collect(Collectors.toList());

		return pointsList;
	}
	
	@Override
	public double[] parseStringToCoordinates(String stringAsCoordinates) {

		String[] coordinatesAsStingArray = stringAsCoordinates.split(COORDINATE_SPLIT_REGEX);

		EllipseValidator validator = EllipseValidatorImpl.getInstance();

		double[] coordinates;
		
		if (validator.canEllipseExist(coordinatesAsStingArray)) {
			
			coordinates = Stream.of(coordinatesAsStingArray)
					.mapToDouble(Double::parseDouble)
					.toArray();
		}else {
			coordinates = new double[] {};
		}

		return coordinates;
	}

	@Override
	public Point[] parseStringToPoints(String stringAsCoordinates) {

		double[] coordinates = parseStringToCoordinates(stringAsCoordinates);

		Point[] points;

		if (coordinates.length == EllipseValidator.NUMBER_OF_COORDINATES) {
			points = new Point[EllipseValidator.NUMBER_OF_POINTS];
			points[0] = new Point(coordinates[0], coordinates[1]);
			points[1] = new Point(coordinates[2], coordinates[3]);
		} else {
			points = new Point[] {};
		}

		return points;
	}
	
}
