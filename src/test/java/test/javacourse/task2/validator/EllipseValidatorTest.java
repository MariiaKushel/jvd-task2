package test.javacourse.task2.validator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.javacourse.task2.entity.Point;
import by.javacourse.task2.validator.EllipseValidator;
import by.javacourse.task2.validator.impl.EllipseValidatorImpl;

public class EllipseValidatorTest {

	public EllipseValidator validator = EllipseValidatorImpl.getInstance();

	@DataProvider(name = "providerValidateString")
	public Object[][] createData() {
		return new Object[][] { 
			{ "-2.5;0.5;7;3.5;", true }, 
			{ "0;0;0;0;", true }, 
			{ "1;5;10.5;15;", true },
			{ "-8;-6;-7;-9;", true }, 
			{ "1.3;2.5;6.7;", false }, 
			{ "13;8f;5.5;7;", false },
			{ "3;2.5.5;4;8;", false }, };
	}

	@Test(dataProvider = "providerValidateString")
	public void testValidateString(String str, boolean expected) {
		boolean actual = validator.validateString(str);
		Assert.assertEquals(actual, expected);
	}

	@DataProvider(name = "providerCoordinateDouble")
	public Object[][] createCoordinateDouble() {
		return new Object[][] { 
			{ 2, 5, 2, 10, false }, 
			{ 8, 6, 8, 24, false }, 
			{ 0, 0, 0, 0, false },
			{ 1, 1, 2, 2, true }, };
	}

	@Test(dataProvider = "providerCoordinateDouble")
	public void testCanEllipseExist(double aX, double aY, double bX, double bY, boolean expected) {
		boolean actual = validator.canEllipseExist(aX, aY, bX, bY);
		Assert.assertEquals(actual, expected);
	}
	
	@DataProvider(name = "providerCoordinateDoubleArray")
	public Object[][] createCoordinateDoubleArray() {
		return new Object[][] { 
			{ false, 2, 5, 2, 10 }, 
			{ false, 8, 6, 8, 24 }, 
			{ false, 0, 0, 0, 0 },
			{ true, 1, 1, 2, 2 }, 
			{ false, 1, 1, 2, },
			{ false, 1, 1, 2, 5, 8 },};
	}
	
	@Test(dataProvider = "providerCoordinateDoubleArray")
	public void testCanEllipseExist(boolean expected, double... coordinates) {
		boolean actual = validator.canEllipseExist(coordinates);
		Assert.assertEquals(actual, expected);
	}

	@DataProvider(name = "providerPoint")
	public Object[][] createPoint() {
		return new Object[][] { 
			{ new Point(2, 5), new Point(2, 10), false },
			{ new Point(8, 6), new Point(8, 24), false }, 
			{ new Point(0, 0), new Point(0, 0), false },
			{ new Point(1, 1), new Point(2, 2), true }, };
	}

	@Test(dataProvider = "providerPoint")
	public void testCanEllipseExist(Point a, Point b, boolean expected) {
		boolean actual = validator.canEllipseExist(a, b);
		Assert.assertEquals(actual, expected);
	}
	
	@DataProvider(name = "providerCoordinateString")
	public Object[][] createCoordinateString() {
		return new Object[][] { 
			{ "2", "5", "2", "10", false }, 
			{ "8", "6", "8", "24", false }, 
			{ "0", "0", "0", "0", false },
			{ "1", "1", "2", "2", true }, };
	}

	@Test(dataProvider = "providerCoordinateString")
	public void testCanEllipseExist(String aX, String aY, String bX, String bY, boolean expected) {
		boolean actual = validator.canEllipseExist(aX, aY, bX, bY);
		Assert.assertEquals(actual, expected);
	}
	
	@DataProvider(name = "providerCoordinateStringArray")
	public Object[][] createCoordinateStringArray() {
		return new Object[][] { 
			{ false, "2", "5", "2", "10" }, 
			{ false, "8", "6", "8", "24" }, 
			{ false, "0", "0", "0", "0" },
			{ true, "1", "1", "2", "2" },
			{ false, "1", "1", "2", },
			{ false, "1", "1", "2", "5", "8" },};
	}

	
	@Test(dataProvider = "providerCoordinateStringArray")
	public void testCanEllipseExist(boolean expected, String... coordinates) {
		boolean actual = validator.canEllipseExist(coordinates);
		Assert.assertEquals(actual, expected);
	}	
	
}
