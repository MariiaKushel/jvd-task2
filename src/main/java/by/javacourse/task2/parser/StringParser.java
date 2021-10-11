package by.javacourse.task2.parser;

import java.util.List;

import by.javacourse.task2.entity.Point;
import by.javacourse.task2.exception.CustomException;

public interface StringParser {

	static final String COORDINATE_SPLIT_REGEX = ";";

	List<double[]> parseListToCoordinates(List<String> stringsAsCoordinates) throws CustomException;
	
	List<Point[]> parseListToPoints(List<String> stringsAsCoordinates) throws CustomException;
	
	double[] parseStringToCoordinates(String stringAsCoordinates) throws CustomException;

	Point[] parseStringToPoints(String stringAsCoordinates) throws CustomException;

	
}
