package test.javacourse.task2.repository;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.javacourse.task2.entity.Ellipse;
import by.javacourse.task2.entity.Point;
import by.javacourse.task2.repository.Specification;
import by.javacourse.task2.repository.impl.IdSpecificationImpl;
import by.javacourse.task2.repository.impl.PerimetrLessThanSpecificationImpl;
import by.javacourse.task2.repository.impl.PerimetrRangeSpecificationImpl;
import by.javacourse.task2.repository.impl.SquareMoreThanSpecificationImpl;
import by.javacourse.task2.repository.impl.SquareRangeSpecificationImpl;

public class SpecificationTest {

	private Ellipse ellipse;

	@BeforeClass
	public void initialize() {
		ellipse = new Ellipse(new Point(2, 5), new Point(10, 13));
	}

	@DataProvider(name = "providerSpecification")
	public Object[][] createdata() {
		return new Object[][] { 
				{ new IdSpecificationImpl(2), ellipse, false },
				{ new PerimetrLessThanSpecificationImpl(100), ellipse, true },
				{ new PerimetrRangeSpecificationImpl(50, 70), ellipse, true },
				{ new SquareMoreThanSpecificationImpl(50), ellipse, true },
				{ new SquareRangeSpecificationImpl(80, 100), ellipse, false }, };
	}

	@Test(dataProvider = "providerSpecification")
	public void testSpecify(Specification specification, Ellipse ellipse, boolean expected) {
		boolean actual = specification.specify(ellipse);
		Assert.assertEquals(actual, expected);
	}

	@AfterClass
	public void close() {
		ellipse = null;
	}

}
