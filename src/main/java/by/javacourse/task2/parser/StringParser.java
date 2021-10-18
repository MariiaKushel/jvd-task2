package by.javacourse.task2.parser;

import java.util.List;

import by.javacourse.task2.entity.Point;

public interface StringParser {

	static final String COORDINATE_SPLIT_REGEX = ";";

	List<double[]> parseListToCoordinates(List<String> stringsAsCoordinates);
	
	List<Point[]> parseListToPoints(List<String> stringsAsCoordinates);
	
	double[] parseStringToCoordinates(String stringAsCoordinates);

	Point[] parseStringToPoints(String stringAsCoordinates);

	
}
