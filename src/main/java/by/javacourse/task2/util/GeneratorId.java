package by.javacourse.task2.util;

public class GeneratorId {

	private static long counter;

	public static long generete() {
		return counter++;
	}

}
