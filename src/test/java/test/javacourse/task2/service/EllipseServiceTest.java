package test.javacourse.task2.service;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.javacourse.task2.entity.Ellipse;
import by.javacourse.task2.entity.Point;
import by.javacourse.task2.service.EllipseService;
import by.javacourse.task2.service.impl.EllipseServiceImpl;

public class EllipseServiceTest {

	private EllipseService service;

	@BeforeMethod
	public void initialize() {
		service = new EllipseServiceImpl();
	}

	@Test
	public void testFindSquare() {
		double actual = service.findSquare(new Ellipse(new Point(1, 1), new Point(-1, -2)));
		double expected = 18.84;
		Assert.assertEquals(actual, expected, 0.01);
	}

	@Test
	public void testFindPerimeter() {
		double actual = service.findPerimeter(new Ellipse(new Point(1, 1), new Point(-1, -2)));
		double expected = 15.87;
		Assert.assertEquals(actual, expected, 0.01);
	}

	@DataProvider(name = "providerIsEllipse")
	public Object[][] creatDataIsEllipse() {
		return new Object[][] { { new Ellipse(new Point(1, 1), new Point(-1, -2)), true },
				{ new Ellipse(new Point(1, 1), new Point(1, 1)), false },
				{ new Ellipse(new Point(1, 1), new Point(-1, 1)), false },
				{ new Ellipse(new Point(-1, 1), new Point(-1, -2)), false }, };
	}

	@Test(dataProvider = "providerIsEllipse")
	public void testIsEllipse(Ellipse ellipse, boolean expected) {
		boolean actual = service.isEllipse(ellipse);
		Assert.assertEquals(actual, expected);
	}

	@DataProvider(name = "providerIsСircle")
	public Object[][] creatDataIsСircle() {
		return new Object[][] { { new Ellipse(new Point(1, 1), new Point(-1, -2)), false },
				{ new Ellipse(new Point(1, 1), new Point(-1, -1)), true },
				{ new Ellipse(new Point(1, 1), new Point(1, 1)), false },
				{ new Ellipse(new Point(2, 2), new Point(10, 10)), true }, };
	}

	@Test(dataProvider = "providerIsСircle")
	public void testIsСircle(Ellipse ellipse, boolean expected) {
		boolean actual = service.isСircle(ellipse);
		Assert.assertEquals(actual, expected);
	}

	@DataProvider(name = "providerIsCross")
	public Object[][] creatDataIsCross() {
		return new Object[][] {
				{ new Ellipse(new Point(2, -4), new Point(5, 2)), 2, false },
				{ new Ellipse(new Point(0, -4), new Point(-3, 0)), 2, false },
				{ new Ellipse(new Point(-1, 5), new Point(-5, 2)), 2, false },
				{ new Ellipse(new Point(-1, 8), new Point(2, 2)), 2, false },
				{ new Ellipse(new Point(6, 1), new Point(2, 8)), 2, false },
				{ new Ellipse(new Point(0, 0), new Point(3, 3)), 3, false },

				{ new Ellipse(new Point(5, 5), new Point(4, 0)), 5, true },
				{ new Ellipse(new Point(5, 5), new Point(4, 1)), 3, true },
				{ new Ellipse(new Point(5, 2), new Point(6, -2)), 6, true },

				{ new Ellipse(new Point(2, 8), new Point(-2, 6)), 2, true },
				{ new Ellipse(new Point(0, 8), new Point(2, 6)), 2, true },
				{ new Ellipse(new Point(-2, 8), new Point(-5, 6)), 1, true },

				{ new Ellipse(new Point(-8, -8), new Point(-10, -3)), 2, true },
				{ new Ellipse(new Point(-8, 8), new Point(-5, 1)), 6, true },
				{ new Ellipse(new Point(-8, 2), new Point(-1, 0)), 2, true },

				{ new Ellipse(new Point(-1, -1), new Point(-5, -3)), 3, true },
				{ new Ellipse(new Point(-8, 8), new Point(-5, 1)), 6, true },
				{ new Ellipse(new Point(2, -8), new Point(6, -5)), 6, true }, };
	}

	@Test(dataProvider = "providerIsCross")
	public void testIsCrossCoordinateAxis(Ellipse ellipse, double distance, boolean expected) {
		boolean actual = service.isCrossCoordinateAxis(ellipse, distance);
		Assert.assertEquals(actual, expected);
	}

	@AfterMethod
	public void clean() {
		service = null;
	}

}
