package by.javacourse.task2.comparator;

import java.util.Comparator;

import by.javacourse.task2.entity.Ellipse;

public enum EllipseComparator implements Comparator<Ellipse> {
	ID {
		@Override
		public int compare(Ellipse e1, Ellipse e2) {
			return Long.compare(e1.getEllipseId(), e2.getEllipseId());
		}
	},

	POINT_A_X {
		@Override
		public int compare(Ellipse e1, Ellipse e2) {
			return Double.compare(e1.getPointA().getX(), e2.getPointA().getX());
		}
	},

	POINT_A_Y {
		@Override
		public int compare(Ellipse e1, Ellipse e2) {
			return Double.compare(e1.getPointA().getY(), e2.getPointA().getY());
		}
	},

	POINT_B_X {
		@Override
		public int compare(Ellipse e1, Ellipse e2) {
			return Double.compare(e1.getPointB().getX(), e2.getPointB().getX());
		}
	},

	POINT_B_Y {
		@Override
		public int compare(Ellipse e1, Ellipse e2) {
			return Double.compare(e1.getPointB().getY(), e2.getPointB().getY());
		}
	},

	POINT_A_DISTANCE_FROM_ORIGIN {
		@Override
		public int compare(Ellipse e1, Ellipse e2) {
			double aXOne = e1.getPointA().getX();
			double aYOne = e1.getPointA().getY();
			double aXOther = e2.getPointA().getX();;
			double aYOther = e2.getPointA().getY();;
			
			double distanceOne = Math.sqrt(Math.pow(aXOne, 2) + Math.pow(aYOne, 2));
			double distanceOther = Math.sqrt(Math.pow(aXOther, 2) + Math.pow(aYOther, 2));
			
			return Double.compare(distanceOne, distanceOther);
		}
	},
	
	POINT_B_DISTANCE_FROM_ORIGIN {
		@Override
		public int compare(Ellipse e1, Ellipse e2) {
			double bXOne = e1.getPointB().getX();
			double bYOne = e1.getPointB().getY();
			double bXOther = e2.getPointB().getX();;
			double bYOther = e2.getPointB().getY();;
			
			double distanceOne = Math.sqrt(Math.pow(bXOne, 2) + Math.pow(bYOne, 2));
			double distanceOther = Math.sqrt(Math.pow(bXOther, 2) + Math.pow(bYOther, 2));
			
			return Double.compare(distanceOne, distanceOther);
		}
	}
}
