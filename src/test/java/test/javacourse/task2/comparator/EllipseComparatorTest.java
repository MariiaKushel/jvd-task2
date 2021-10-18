package test.javacourse.task2.comparator;

import java.util.Comparator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.javacourse.task2.comparator.EllipseComparator;
import by.javacourse.task2.entity.Ellipse;
import by.javacourse.task2.entity.Point;

public class EllipseComparatorTest {
	
	
	@DataProvider (name = "providerCompare")
	public Object[][] createData(){
		
		Ellipse ellipse1 = new Ellipse (new Point (3,1), new Point (4,4));
		Ellipse ellipse2 = new Ellipse (new Point (3,3), new Point (2,4));
				
		return new Object[][] {
			{EllipseComparator.ID, ellipse1, ellipse2, -1},
			{EllipseComparator.POINT_A_X, ellipse1, ellipse2, 0},
			{EllipseComparator.POINT_A_Y, ellipse1, ellipse2, -1},
			{EllipseComparator.POINT_B_X, ellipse1, ellipse2, 1},
			{EllipseComparator.POINT_B_Y, ellipse1, ellipse2, 0},
			{EllipseComparator.POINT_A_DISTANCE_FROM_ORIGIN, ellipse1, ellipse2, -1},
			{EllipseComparator.POINT_B_DISTANCE_FROM_ORIGIN, ellipse1, ellipse2, -1},
		};
	}
	
	@Test (dataProvider = "providerCompare")
	public void testCompare (Comparator<Ellipse> c, Ellipse e1, Ellipse e2, int expected) {
		int actual = c.compare(e1, e2);
		Assert.assertEquals(actual, expected);
	}

}
