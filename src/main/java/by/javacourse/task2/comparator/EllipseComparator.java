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
			return Double.compare(e1.getPointA().x(), e2.getPointA().x());
		}
	},

	POINT_A_Y {
		@Override
		public int compare(Ellipse e1, Ellipse e2) {
			return Double.compare(e1.getPointA().y(), e2.getPointA().y());
		}
	},

	POINT_B_X {
		@Override
		public int compare(Ellipse e1, Ellipse e2) {
			return Double.compare(e1.getPointB().x(), e2.getPointB().x());
		}
	},

	POINT_B_Y {
		@Override
		public int compare(Ellipse e1, Ellipse e2) {
			return Double.compare(e1.getPointB().y(), e2.getPointB().y());
		}
	},

	POINT_A_DISTANCE_FROM_ORIGIN {
		@Override
		public int compare(Ellipse e1, Ellipse e2) {
			double aXOne = e1.getPointA().x();
			double aYOne = e1.getPointA().y();
			double aXOther = e2.getPointA().x();;
			double aYOther = e2.getPointA().y();;
			
			double distanceOne = Math.sqrt(Math.pow(aXOne, 2) + Math.pow(aYOne, 2));
			double distanceOther = Math.sqrt(Math.pow(aXOther, 2) + Math.pow(aYOther, 2));
			
			return Double.compare(distanceOne, distanceOther);
		}
	},
	
	POINT_B_DISTANCE_FROM_ORIGIN {
		@Override
		public int compare(Ellipse e1, Ellipse e2) {
			double bXOne = e1.getPointB().x();
			double bYOne = e1.getPointB().y();
			double bXOther = e2.getPointB().x();;
			double bYOther = e2.getPointB().y();;
			
			double distanceOne = Math.sqrt(Math.pow(bXOne, 2) + Math.pow(bYOne, 2));
			double distanceOther = Math.sqrt(Math.pow(bXOther, 2) + Math.pow(bYOther, 2));
			
			return Double.compare(distanceOne, distanceOther);
		}
	}
}
