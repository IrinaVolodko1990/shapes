package by.epam.volodko.shape.warehouse;

public class TriangleParameters {
    private double trianglePerimeter;
    private double triangleArea;

    public TriangleParameters(double perimeter, double area) {
        this.trianglePerimeter = perimeter;
        this.triangleArea = area;
    }

    public double getTrianglePerimeter() {
        return trianglePerimeter;
    }

    public void setTrianglePerimeter(double trianglePerimeter) {
        this.trianglePerimeter = trianglePerimeter;
    }

    public double getTriangleArea() {
        return triangleArea;
    }

    public void setTriangleArea(double triangleArea) {
        this.triangleArea = triangleArea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TriangleParameters that = (TriangleParameters) o;

        if (Double.compare(that.trianglePerimeter, trianglePerimeter) != 0) return false;
        return Double.compare(that.triangleArea, triangleArea) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(trianglePerimeter);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(triangleArea);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TriangleParameters{");
        sb.append("trianglePerimeter=").append(trianglePerimeter);
        sb.append(", triangleArea=").append(triangleArea);
        sb.append('}');
        return sb.toString();
    }
}

