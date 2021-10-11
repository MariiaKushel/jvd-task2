package test.javacourse.task2.util;

import org.testng.Assert;
import org.testng.annotations.Test;

import by.javacourse.task2.util.GeneratorId;

public class GeneratorIDTest {

	@Test
	public void generate() {
		long actual = 0;
		long expected = 10;
		for (int i = 0; i <= expected; i++) {
			actual = GeneratorId.generete();
		}
		Assert.assertEquals(actual, expected);
	}

}
