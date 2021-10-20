package test.javacourse.task2.repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.javacourse.task2.comparator.EllipseComparator;
import by.javacourse.task2.entity.Ellipse;
import by.javacourse.task2.entity.Point;
import by.javacourse.task2.repository.EllipseRepository;
import by.javacourse.task2.repository.Specification;
import by.javacourse.task2.repository.impl.IdSpecificationImpl;
import by.javacourse.task2.repository.impl.PerimetrLessThanSpecificationImpl;
import by.javacourse.task2.repository.impl.PerimetrRangeSpecificationImpl;
import by.javacourse.task2.repository.impl.SquareMoreThanSpecificationImpl;
import by.javacourse.task2.repository.impl.SquareRangeSpecificationImpl;

public class EllipseRepositoryTest {

	private static EllipseRepository repository = EllipseRepository.getInstance();
	
	@BeforeClass
	public void inizialize () {
		repository.add(new Ellipse(new Point(4, 3), new Point(200, 1)));
		repository.add(new Ellipse(new Point(3, -1), new Point(20, 100)));
		repository.add(new Ellipse(new Point(-1, 10), new Point(2, 10)));
		repository.add(new Ellipse(new Point(-2, -5), new Point(8, 1)));
	}
	
	@DataProvider (name = "providerSort")
	public Object[][] createDataForSorting (){
				
		List<Ellipse> expectedAX = new ArrayList<Ellipse>();
		expectedAX.add(repository.get(3));
		expectedAX.add(repository.get(2));
		expectedAX.add(repository.get(1));
		expectedAX.add(repository.get(0));
		
		List<Ellipse> expectedAY = new ArrayList<Ellipse>();
		expectedAY.add(repository.get(3));
		expectedAY.add(repository.get(1));
		expectedAY.add(repository.get(0));
		expectedAY.add(repository.get(2));
		
		
		List<Ellipse> expectedBX = new ArrayList<Ellipse>();
		expectedBX.add(repository.get(2));
		expectedBX.add(repository.get(3));
		expectedBX.add(repository.get(1));
		expectedBX.add(repository.get(0));
		
		List<Ellipse> expectedBY = new ArrayList<Ellipse>();
		expectedBY.add(repository.get(0));
		expectedBY.add(repository.get(3));
		expectedBY.add(repository.get(2));
		expectedBY.add(repository.get(1));
		
		List<Ellipse> expectedADistanse = new ArrayList<Ellipse>();
		expectedADistanse.add(repository.get(1));
		expectedADistanse.add(repository.get(0));
		expectedADistanse.add(repository.get(3));
		expectedADistanse.add(repository.get(2));
		
		List<Ellipse> expectedBDistanse = new ArrayList<Ellipse>();
		expectedBDistanse.add(repository.get(3));
		expectedBDistanse.add(repository.get(2));
		expectedBDistanse.add(repository.get(1));
		expectedBDistanse.add(repository.get(0));
		
		List<Ellipse> expectedId = new ArrayList<Ellipse>();
		expectedId.add(repository.get(0));
		expectedId.add(repository.get(1));
		expectedId.add(repository.get(2));
		expectedId.add(repository.get(3));
		
		return new Object [][] {
			{EllipseComparator.POINT_A_X, expectedAX},
			{EllipseComparator.POINT_A_Y, expectedAY},
			{EllipseComparator.POINT_B_X, expectedBX},
			{EllipseComparator.POINT_B_Y, expectedBY},
			{EllipseComparator.POINT_A_DISTANCE_FROM_ORIGIN, expectedADistanse},
			{EllipseComparator.POINT_B_DISTANCE_FROM_ORIGIN, expectedBDistanse},
			{EllipseComparator.ID, expectedId},
		};
	}

	@Test (dataProvider = "providerSort")
	public void testSort(Comparator <Ellipse> c, List<Ellipse> expected) {
		List<Ellipse> actual = repository.sort(c);
		Assert.assertEquals(actual, expected);
	}
	
	@DataProvider (name = "providerQuery")
	public Object[][] createDataForQuery (){
		Specification s1 = new IdSpecificationImpl (3);
		Specification s2 = new PerimetrLessThanSpecificationImpl (300);
		Specification s3 = new PerimetrRangeSpecificationImpl (100, 500);
		Specification s4 = new SquareMoreThanSpecificationImpl (100);
		Specification s5 = new SquareRangeSpecificationImpl (100, 500);
		
		List<Ellipse> eList1 = new ArrayList<Ellipse> ();
		eList1.add(repository.get(3));
		
		List<Ellipse> eList2 = new ArrayList<Ellipse> ();
		eList2.add(repository.get(2));
		eList2.add(repository.get(3));
		  
		List<Ellipse> eList3 = new ArrayList<Ellipse> ();
		eList3.add(repository.get(1));
		  
		List<Ellipse> eList4 = new ArrayList<Ellipse> ();
		eList4.add(repository.get(0));
		eList4.add(repository.get(1));
		eList4.add(repository.get(3));
		 
		List<Ellipse> eList5 = new ArrayList<Ellipse> ();
		eList5.add(repository.get(3));
		 
		return new Object [][] {
			{s1, eList1},
			{s2, eList2},
			{s3, eList3},
			{s4, eList4},
			{s5, eList5},
		};
	}

	@Test (dataProvider = "providerQuery")
	public void testQuery(Specification specification, List<Ellipse> expected) {
		List<Ellipse> actual = repository.query(specification);
		Assert.assertEquals(actual, expected);
	}
	
	
	@AfterClass
	public void close () {
		repository = null;
	}

}
