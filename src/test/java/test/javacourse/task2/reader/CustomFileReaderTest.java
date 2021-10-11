package test.javacourse.task2.reader;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.javacourse.task2.exception.CustomException;
import by.javacourse.task2.reader.CustomFileReader;
import by.javacourse.task2.reader.impl.CustomFileReaderImpl;

public class CustomFileReaderTest {
	
	private CustomFileReader reader;
	
	@BeforeMethod
	public void initialize() {
		reader = new CustomFileReaderImpl();
	}

	@Test
	public void testRead() throws CustomException {
		List<String> actual = reader.read("src\\test\\resources\\testdata\\ellipses.txt");
		List<String> expected = new ArrayList<String>();
		expected.add("-2.5;0.5;7;3.5;");
		expected.add("0;0;0;0;");
		expected.add("1;5;10.5;15;");
		expected.add("-8;-6;-7;-9;");
		Assert.assertEquals(actual, expected);
	}

	@Test(expectedExceptions = CustomException.class, expectedExceptionsMessageRegExp = ".*not found.*")
	public void testReadExceptionFileNotFound() throws CustomException {
		reader.read("src\\test\\resources\\testdata\\notFoundEllipses.txt");
	}

	@AfterMethod
	public void clean() {
		reader = null;
	}

}
