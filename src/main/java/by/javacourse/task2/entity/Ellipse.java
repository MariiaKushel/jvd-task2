package by.javacourse.task2.entity;

import by.javacourse.task2.util.GeneratorId;

public class Ellipse {

	private final long ellipseId;
	private Point pointA;
	private Point pointB;

	public Ellipse(Point pointA, Point pointB) {
		this.ellipseId = GeneratorId.generete();
		this.pointA = pointA.clone();
		this.pointB = pointB.clone();
	}

	public Point getPointA() {
		return pointA.clone();
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA.clone();
	}

	public Point getPointB() {
		return pointB.clone();
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB.clone();
	}

	public long getEllipseId() {
		return ellipseId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (ellipseId ^ (ellipseId >>> 32));
		result = prime * result + ((pointA == null) ? 0 : pointA.hashCode());
		result = prime * result + ((pointB == null) ? 0 : pointB.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ellipse other = (Ellipse) obj;
		if (ellipseId != other.ellipseId)
			return false;
		if (pointA == null) {
			if (other.pointA != null)
				return false;
		} else if (!pointA.equals(other.pointA))
			return false;
		if (pointB == null) {
			if (other.pointB != null)
				return false;
		} else if (!pointB.equals(other.pointB))
			return false;
		return true;
	}

	@Override
	public String toString() {

		return new StringBuilder()
				.append("Ellipse ellipseId=")
				.append(ellipseId)
				.append(", pointA=")
				.append(pointA)
				.append(", pointB=")
				.append(pointB)
				.toString();
	}

}
