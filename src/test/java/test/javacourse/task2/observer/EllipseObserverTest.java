package test.javacourse.task2.observer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.javacourse.task2.entity.Ellipse;
import by.javacourse.task2.entity.Point;
import by.javacourse.task2.observer.EllipseEvent;
import by.javacourse.task2.observer.EllipseObserver;
import by.javacourse.task2.observer.impl.EllipseObserverImpl;
import by.javacourse.task2.warehouse.EllipseParameters;
import by.javacourse.task2.warehouse.EllipseWarehouse;

public class EllipseObserverTest {

	private EllipseObserver observer;
	private Ellipse ellipse;
	private EllipseEvent event;
	private EllipseWarehouse warehouse;

	@BeforeMethod
	public void initialize() {
		observer = new EllipseObserverImpl();
		ellipse = new Ellipse(new Point(2, 2), new Point(-2, -2));
		ellipse.attach(observer);
		event = new EllipseEvent(ellipse);
		warehouse = EllipseWarehouse.getInstance();
		warehouse.putParameters(ellipse.getEllipseId(), new EllipseParameters(5, 5));
	}

	@Test
	public void testUpdateParamrters() {
		observer.updateParamrters(event);
		EllipseParameters actual = warehouse.getParameters(ellipse.getEllipseId());
		EllipseParameters expected = new EllipseParameters(50.26548245743669, 25.132741228718345);
		Assert.assertEquals(actual, expected);
	}

	@AfterMethod
	public void close() {
		observer = null;
		ellipse = null;
		event = null;
		warehouse = null;
	}

}
