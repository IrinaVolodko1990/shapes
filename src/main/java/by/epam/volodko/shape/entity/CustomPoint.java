package by.epam.volodko.shape.entity;


public class CustomPoint {


    private double x;
    private double y;

    public CustomPoint() {
    }

    public CustomPoint(CustomPoint point) {
        x = point.x;
        y = point.y;
    }

    public CustomPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }
//    public void setX(double x) {
//        this.x = x;
//    }// need?

    public double getY() {
        return y;
    }

//    public void setY(double y) {
//        this.y = y;
//    }// need?

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomPoint that = (CustomPoint) o;

        if (Double.compare(that.x, x) != 0) return false;
        return Double.compare(that.y, y) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CustomPoint{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append('}');
        return sb.toString();
    }
}
