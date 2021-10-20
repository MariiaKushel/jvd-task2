package test.javacourse.task2.filler;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.javacourse.task2.entity.Ellipse;
import by.javacourse.task2.entity.Point;
import by.javacourse.task2.filler.RepositoryFiller;
import by.javacourse.task2.filler.impl.RepositoryFillerImpl;
import by.javacourse.task2.repository.EllipseRepository;

public class RepositoryFillerTest {

	private RepositoryFiller repositoryFiller;

	@BeforeMethod
	public void initialize() {
		repositoryFiller = new RepositoryFillerImpl();
	}

	@Test
	public void testFill() {

		List<Ellipse> expected = new ArrayList<Ellipse>();
		expected.add(new Ellipse(new Point(1, 2), new Point(5, 4)));
		expected.add(new Ellipse(new Point(1, 4), new Point(3, 9)));
		expected.add(new Ellipse(new Point(1, 6), new Point(7, 10)));

		repositoryFiller.fill(expected);

		EllipseRepository repository = EllipseRepository.getInstance();
		List<Ellipse> actual = repository.getAll();

		Assert.assertEquals(actual, expected);
	}

	@AfterMethod
	public void close() {
		repositoryFiller = null;
	}

}
