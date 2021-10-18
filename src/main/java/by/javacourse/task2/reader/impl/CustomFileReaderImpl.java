package by.javacourse.task2.reader.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.javacourse.task2.exception.CustomException;
import by.javacourse.task2.reader.CustomFileReader;
import by.javacourse.task2.validator.EllipseValidator;
import by.javacourse.task2.validator.impl.EllipseValidatorImpl;

public class CustomFileReaderImpl implements CustomFileReader {

	static Logger logger = LogManager.getLogger();

	public List<String> read(String pathToFile) throws CustomException {
		Path path = Paths.get(pathToFile);
		
		if (!Files.exists(path)) {
			logger.error("File " + pathToFile + " was not found or is not available.");
			throw new CustomException("File " + pathToFile + " was not found or is not available.");
		}
		
		List<String> lines = new ArrayList<String>();
		logger.info("Start reading file " + pathToFile);
		
		try (Stream<String> streamFromFile = Files.lines(path)) {
			EllipseValidator validator = EllipseValidatorImpl.getInstance();

			lines =  streamFromFile
					.filter(s -> validator.validateString(s))
					.collect(Collectors.toList());
			
			logger.info("End reading file " + pathToFile);
		} catch (IOException e) {
			logger.error("IO Exception while working on the file " + pathToFile + ".");
			throw new CustomException("Failed or interrupted I/O operations while working on the file " + pathToFile + ".", e);
		}

		return lines;

	}

}
