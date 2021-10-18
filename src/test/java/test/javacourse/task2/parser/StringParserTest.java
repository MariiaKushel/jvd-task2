package test.javacourse.task2.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.javacourse.task2.entity.Point;
import by.javacourse.task2.exception.CustomException;
import by.javacourse.task2.parser.StringParser;
import by.javacourse.task2.parser.impl.StringParserImpl;

public class StringParserTest {

	private StringParser parser;

	@BeforeMethod
	public void initialize() {
		parser = new StringParserImpl();
	}

	@Test
	public void testParseListToCoordinates() {
		List<String> strings = new ArrayList<String>();
		strings.add("");
		strings.add("-8;5;9;-3");
		strings.add("-8;5;-8;3");
		strings.add("-8.6;5.7;9.999;-3.1");

		List<double[]> actual = parser.parseListToCoordinates(strings);
		
		List<double[]> expected = new ArrayList<double[]>();
		expected.add(new double[] { -8, 5, 9, -3 });
		expected.add(new double[] { -8.6, 5.7, 9.999, -3.1 });

		boolean flag = true;
		
		for(int i = 0; i <actual.size(); i++) {
			double [] arr1 = actual.get(i);
			double [] arr2 = expected.get(i);
			if (!Arrays.equals(arr1, arr2)) {
				flag = false;
			}
		}
		
		Assert.assertTrue(flag);
	}
	
	@Test
	public void testParseListToPoints () {
		List<String> strings = new ArrayList<String>();
		strings.add("");
		strings.add("-8;5;9;-3");
		strings.add("-8;5;-8;3");
		strings.add("-8.6;5.7;9.999;-3.1");
		
		List<Point[]> actual = parser.parseListToPoints(strings);
		
		List<Point[]> expected = new ArrayList<Point[]>();
		expected.add(new Point[] {new Point( -8, 5 ), new Point ( 9, -3 )});
		expected.add(new Point[] {new Point( -8.6, 5.7 ), new Point ( 9.999, -3.1 ) });
		
		boolean flag = true;
		
		for(int i = 0; i <actual.size(); i++) {
			Point [] arr1 = actual.get(i);
			Point [] arr2 = expected.get(i);
			if (!Arrays.equals(arr1, arr2)) {
				flag = false;
			}
		}
		
		Assert.assertTrue(flag);
	}
	
	@DataProvider(name = "providerParseStringToCoordinates")
	public Object[][] creatStringForCoordinates() {
		return new Object[][] { 
			{ "-8;5;9;-3", new double[] { -8, 5, 9, -3 } },
			{ "-8.6;5.7;9.999;-3.1", new double[] { -8.6, 5.7, 9.999, -3.1 } },
			{ "-8;5;-8;3", new double[] {} }, 
			{ "-8;5;-7;5", new double[] {}  }, 
			{ "-8;-8;-8;-8", new double[] {}  }, 
			{ "", new double[] {} },
			};
	}

	@Test(dataProvider = "providerParseStringToCoordinates")
	public void testParseStringToCoordinates(String stringAsCoordinates, double[] expected) throws CustomException {
		double[] actual = parser.parseStringToCoordinates(stringAsCoordinates);
		Assert.assertEquals(actual, expected);
	}

	@DataProvider(name = "providerStringParseToPoints")
	public Object[][] creatStringForPoints() {
		return new Object[][] { 
			{ "-8;5;9;-3", new Point[] { new Point(-8, 5), new Point(9, -3) } },
			{ "-8.6;5.7;9.999;-3.1", new Point[] { new Point(-8.6, 5.7), new Point(9.999, -3.1) } }, 
			{ "-8;5;-8;3", new Point[] {} }, 
			{ "-8;5;-7;5", new Point[] {}  }, 
			{ "-8;-8;-8;-8", new Point[] {}  }, 
			{ "", new Point[] {} } };
	}

	@Test(dataProvider = "providerStringParseToPoints")
	public void testParseStringToPoints(String stringAsCoordinates, Point[] expected) throws CustomException {
		Point[] actual = parser.parseStringToPoints(stringAsCoordinates);
		Assert.assertEquals(actual, expected);
	}

	@AfterMethod
	public void close() {
		parser = null;
	}
}
