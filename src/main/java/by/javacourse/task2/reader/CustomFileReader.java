package by.javacourse.task2.reader;

import java.util.List;

import by.javacourse.task2.exception.CustomException;

public interface CustomFileReader {

	List<String> read (String pathToFile) throws CustomException ;
}
