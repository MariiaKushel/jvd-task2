package by.javacourse.task2.filler;

import java.util.List;

import by.javacourse.task2.entity.Ellipse;

public interface Filler {
	
	void fillAll(List<Ellipse> ellipses);

	void fillOne(Ellipse ellipse);

}
