package test.javacourse.task2.imitator;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.javacourse.task2.entity.Ellipse;
import by.javacourse.task2.factory.EllipseFactory;
import by.javacourse.task2.imitator.ActionImitator;

public class ActionImitatorTest {

	private ActionImitator imitator;

	@BeforeMethod
	public void initialize() {
		imitator = new ActionImitator();
	}

	@Test
	public void testImitate() {

		List<Ellipse> ellipses = new ArrayList<Ellipse>();
		ellipses.add(EllipseFactory.createEllipse(1, 2, 3, 4));
		ellipses.add(EllipseFactory.createEllipse(5, 6, 7, 8));
		ellipses.add(EllipseFactory.createEllipse(9, 10, 11, 12));

		imitator.imitate(ellipses);
	}
	
	@AfterMethod
	public void close() {
		imitator = null;
	}

}
