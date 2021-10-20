package by.javacourse.task2.warehouse;

public class EllipseParameters {
	
	private double square;
	private double perimeter;
	
	public EllipseParameters (double square, double perimeter){
		this.square = square;
		this.perimeter = perimeter;
	}

	public double getSquare() {
		return square;
	}

	public void setSquare(double square) {
		this.square = square;
	}

	public double getPerimeter() {
		return perimeter;
	}

	public void setPerimeter(double perimeter) {
		this.perimeter = perimeter;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(perimeter);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(square);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		EllipseParameters other = (EllipseParameters) obj;
		if (Double.doubleToLongBits(perimeter) != Double.doubleToLongBits(other.perimeter))
			return false;
		if (Double.doubleToLongBits(square) != Double.doubleToLongBits(other.square))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return new StringBuilder()
				.append("[EllipseParameters ")
				.append("square = ")
				.append(square)
				.append("; perimeter = ")
				.append(perimeter)
				.append("]")
				.toString();
	}

}
