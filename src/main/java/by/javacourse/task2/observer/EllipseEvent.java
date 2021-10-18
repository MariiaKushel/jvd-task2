package by.javacourse.task2.observer;

import java.util.EventObject;

import by.javacourse.task2.entity.Ellipse;

public class EllipseEvent extends EventObject {
	
	public EllipseEvent (Ellipse sourse) {
		super (sourse);
	}

	@Override
	public Ellipse getSource () {
		return (Ellipse) super.getSource();
	}
}
