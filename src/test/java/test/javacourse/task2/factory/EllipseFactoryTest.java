package test.javacourse.task2.factory;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.javacourse.task2.entity.Ellipse;
import by.javacourse.task2.entity.Point;
import by.javacourse.task2.factory.EllipseFactory;

public class EllipseFactoryTest {

	@DataProvider(name = "providerListCoordinates")
	public Object[][] createListCoordinates() {
		
		List<double[]> list1 = new ArrayList<double[]>();
		list1.add(new double[] { 1, 1, 1, 1 });
		list1.add(new double[] { 2, 1, -1, 1 });
		list1.add(new double[] { 2, 1, -1, 10 });
		list1.add(new double[] { 2, 1, 2, 5 });
		list1.add(new double[] { -8, 5, 2, 5 });
		list1.add(new double[] { -8, -5, -2, -3 });

		List<Ellipse> expected1 = new ArrayList<Ellipse>();
		expected1.add(new Ellipse(new Point(2, 1), new Point(-1, 10)));
		expected1.add(new Ellipse(new Point(-8, -5), new Point(-2, -3)));

		List<double[]> list2 = new ArrayList<double[]>();
		list2.add(new double[] { 1, 1, 1, 1 });
		list2.add(new double[] { 2, 1, 2, 1 });
		list2.add(new double[] { -8, 5, 2, 5 });
		list2.add(new double[] { 1, 2, 3 });
		list2.add(new double[] { 1, 2, 3, 4, 5 });
		list2.add(new double[] {});

		List<Ellipse> expected2 = new ArrayList<Ellipse>();

		List<double[]> list3 = new ArrayList<double[]>();
		List<Ellipse> expected3 = new ArrayList<Ellipse>();

		return new Object[][] { 
			{ list1, expected1 }, 
			{ list2, expected2 }, 
			{ list3, expected3 } 
			};
	}

	@Test(dataProvider = "providerListCoordinates")
	public void testCreateEllipseListFromCoordinates(List<double[]> coordinates, List<Ellipse> expected) {
		List<Ellipse> actual = EllipseFactory.createEllipseListFromCoordinates(coordinates);
		boolean flag = equalsByTwoPointsList(actual, expected);
		Assert.assertTrue(flag);
	}

	@DataProvider(name = "providerListPoints")
	public Object[][] createListPoints() {
		List<Point[]> list1 = new ArrayList<Point[]>();
		list1.add(new Point[] { new Point(1, 1), new Point(1, 1) });
		list1.add(new Point[] { new Point(2, 1), new Point(-1, 1) });
		list1.add(new Point[] { new Point(2, 1), new Point(-1, 10) });
		list1.add(new Point[] { new Point(2, 1), new Point(2, 5) });
		list1.add(new Point[] { new Point(-8, 5), new Point(2, 5) });
		list1.add(new Point[] { new Point(-8, -5), new Point(-2, -3) });

		List<Ellipse> expected1 = new ArrayList<Ellipse>();
		expected1.add(new Ellipse(new Point(2, 1), new Point(-1, 10)));
		expected1.add(new Ellipse(new Point(-8, -5), new Point(-2, -3)));

		List<Point[]> list2 = new ArrayList<Point[]>();
		list2.add(new Point[] { new Point(1, 1), new Point(1, 1) });
		list2.add(new Point[] { new Point(2, 1), new Point(-1, 1) });
		list2.add(new Point[] { new Point(-8, 5), new Point(2, 5) });
		list2.add(new Point[] { new Point(-8, 5) });
		list2.add(new Point[] { new Point(-8, 5), new Point(2, 5), new Point(3, 10) });
		list2.add(new Point[] {});

		List<Ellipse> expected2 = new ArrayList<Ellipse>();

		return new Object[][] { 
			{ list1, expected1 }, 
			{ list2, expected2 } 
			};
	}

	@Test(dataProvider = "providerListPoints")
	public void testCreateEllipseListFromPoints(List<Point[]> points, List<Ellipse> expected) {
		List<Ellipse> actual = EllipseFactory.createEllipseListFromPoints(points);
		boolean flag = equalsByTwoPointsList(actual, expected);
		Assert.assertTrue(flag);
	}

	@DataProvider(name = "providerCoordinatsArrayPositive")
	public Object[][] creatrCoordinateArrayP() {
		return new Object[][] { 
			{ new Ellipse(new Point(1, 2), new Point(3, 4)), 1, 2, 3, 4 },
			{ new Ellipse(new Point(-1, -2), new Point(-3, -4)), -1, -2, -3, -4 }, 
			};
	}

	@Test(dataProvider = "providerCoordinatsArrayPositive")
	public void testCreateEllipse(Ellipse expected, double... coordinates) {
		Ellipse actual = EllipseFactory.createEllipse(coordinates);
		boolean flag = equalsByTwoPoints(actual, expected);
		Assert.assertTrue(flag);
	}

	@DataProvider(name = "providerCoordinatsArrayNegative")
	public Object[][] creatrCoordinateArrayN() {
		return new Object[][] { 
			{ 1, 2, 1, 4 }, 
			{ 3, 2, 3, 4 }, 
			{ 3, 2, 1 }, 
			{ 1, 2, 3, 4, 5 }, 
			{ new double[] {} },
			};
	}

	@Test(dataProvider = "providerCoordinatsArrayNegative")
	public void testCreateEllipse(double... coordinates) {
		Ellipse actual = EllipseFactory.createEllipse(coordinates);
		Assert.assertNull(actual);
	}

	@DataProvider(name = "providerCoordinatsPositive")
	public Object[][] creatrCoordinatesP() {
		return new Object[][] { 
			{ new Ellipse(new Point(10, 20), new Point(30, 40)), 10, 20, 30, 40 },
			{ new Ellipse(new Point(-10, -20), new Point(-30, -40)), -10, -20, -30, -40 }, 
			};
	}

	@Test(dataProvider = "providerCoordinatsPositive")
	public void testCreateEllipse(Ellipse expected, double aX, double aY, double bX, double bY) {
		Ellipse actual = EllipseFactory.createEllipse(aX, aY, bX, bY);
		boolean flag = equalsByTwoPoints(actual, expected);
		Assert.assertTrue(flag);
	}

	@DataProvider(name = "providerCoordinatsNegative")
	public Object[][] creatrCoordinatesN() {
		return new Object[][] { 
			{ 10, 20, 10, 40 }, 
			{ 30, 20, 30, 40 }, 
			{ 10, 10, 10, 10 }, 
			};
	}

	@Test(dataProvider = "providerCoordinatsNegative")
	public void testCreateEllipse(double aX, double aY, double bX, double bY) {
		Ellipse actual = EllipseFactory.createEllipse(aX, aY, bX, bY);
		Assert.assertNull(actual);
	}

	@DataProvider(name = "providerPointsPositive")
	public Object[][] creatrPointsP() {
		return new Object[][] {
				{ new Ellipse(new Point(10, 20), new Point(30, 40)), new Point(10, 20), new Point(30, 40) },
				{ new Ellipse(new Point(-10, -20), new Point(-30, -40)), new Point(-10, -20), new Point(-30, -40) }, };
	}

	@Test(dataProvider = "providerPointsPositive")
	public void testCreateEllipse(Ellipse expected, Point a, Point b) {
		Ellipse actual = EllipseFactory.createEllipse(a, b);
		boolean flag = equalsByTwoPoints(actual, expected);
		Assert.assertTrue(flag);
	}

	@DataProvider(name = "providerPointsNegative")
	public Object[][] creatrPointsN() {
		return new Object[][] { 
			{ new Point(10, 20), new Point(10, 40) }, 
			{ new Point(30, 20), new Point(30, 40) },
			{ new Point(10, 10), new Point(10, 10) }, 
			};
	}

	@Test(dataProvider = "providerPointsNegative")
	public void testCreateEllipse(Point a, Point b) {
		Ellipse actual = EllipseFactory.createEllipse(a, b);
		Assert.assertNull(actual);
	}

	private boolean equalsByTwoPoints(Ellipse e1, Ellipse e2) {
		return e1.getPointA().equals(e2.getPointA()) && e1.getPointB().equals(e2.getPointB());
	}

	private boolean equalsByTwoPointsList(List<Ellipse> list1, List<Ellipse> list2) {
		boolean flag = false;
		if (list1 != null && list1.size() == list2.size()) {
			int i = 0;
			flag = true;
			while (i < list1.size() && flag) {
				flag = equalsByTwoPoints(list1.get(i), list2.get(i));
				i++;
			}
		}
		return flag;
	}
}
