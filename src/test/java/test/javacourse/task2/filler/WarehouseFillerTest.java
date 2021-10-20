package test.javacourse.task2.filler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.javacourse.task2.entity.Ellipse;
import by.javacourse.task2.entity.Point;
import by.javacourse.task2.filler.WarehouseFiller;
import by.javacourse.task2.filler.impl.WarehouseFillerImpl;
import by.javacourse.task2.warehouse.EllipseParameters;
import by.javacourse.task2.warehouse.EllipseWarehouse;

public class WarehouseFillerTest {

	private WarehouseFiller warehouseFiller;

	@BeforeMethod
	public void initialize() {
		warehouseFiller = new WarehouseFillerImpl();
	}

	@Test
	public void testFill() {

		List<Ellipse> ellipses = new ArrayList<Ellipse>();
		ellipses.add(new Ellipse(new Point(1, 2), new Point(5, 4)));
		ellipses.add(new Ellipse(new Point(1, 4), new Point(3, 9)));
		ellipses.add(new Ellipse(new Point(1, 6), new Point(7, 10)));

		warehouseFiller.fill(ellipses);

		EllipseWarehouse warehouse = EllipseWarehouse.getInstance();
		Map<Long, EllipseParameters> actual = warehouse.getWarehouse();

		Map<Long, EllipseParameters> expected = new HashMap<Long, EllipseParameters>();
		expected.put(0L, new EllipseParameters(25.132741228718345, 19.42182748581223));
		expected.put(1L, new EllipseParameters(31.41592653589793, 23.094815163370246));
		expected.put(2L, new EllipseParameters(75.39822368615503, 31.759289474462015));
		
		Assert.assertEqualsDeep(actual, expected);
	}

	@AfterMethod
	public void close() {
		warehouseFiller = null;
	}

}
