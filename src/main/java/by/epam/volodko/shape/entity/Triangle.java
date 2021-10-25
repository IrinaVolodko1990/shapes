package by.epam.volodko.shape.entity;


import by.epam.volodko.shape.observer.Observable;
import by.epam.volodko.shape.observer.Observer;
import by.epam.volodko.shape.observer.TriangleEvent;
import by.epam.volodko.shape.observer.impl.TriangleObserver;
import by.epam.volodko.shape.util.GeneratorId;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Triangle implements Observable {
    static Logger logger = LogManager.getLogger();

    private final long triangleId;
    private CustomPoint pointA;
    private CustomPoint pointB;
    private CustomPoint pointC;
    private Observer observer = new TriangleObserver();


    public Triangle(CustomPoint pointA, CustomPoint pointB, CustomPoint pointC) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.triangleId = GeneratorId.genereteId();
    }

    public long getTriangleId() {
        return triangleId;
    }

    public CustomPoint getPointA() {
        return pointA;
    }

    public void setPointA(CustomPoint pointA) {
        this.pointA = pointA;
        notifyObservers();
    }

    public CustomPoint getPointB() {
        return pointB;
    }

    public void setPointB(CustomPoint pointB) {
        this.pointB = pointB;
        notifyObservers();
    }

    public CustomPoint getPointC() {
        return pointC;
    }

    public void setPointC(CustomPoint pointC) {
        this.pointC = pointC;
        notifyObservers();
    }


    @Override
    public void attach(Observer observer) {
        this.observer = observer;
    }

    @Override
    public void detach() {
        this.observer = null;
    }

    @Override
    public void notifyObservers() {
        if (observer == null) {
            logger.log(Level.INFO, "Observer is null");
            return;
        }
        TriangleEvent trianleEvent = new TriangleEvent(this);
        observer.parametersChange(trianleEvent);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (pointA != null ? !pointA.equals(triangle.pointA) : triangle.pointA != null) return false;
        if (pointB != null ? !pointB.equals(triangle.pointB) : triangle.pointB != null) return false;
        return pointC != null ? pointC.equals(triangle.pointC) : triangle.pointC == null;
    }

    @Override
    public int hashCode() {
        int result = pointA != null ? pointA.hashCode() : 0;
        result = 31 * result + (pointB != null ? pointB.hashCode() : 0);
        result = 31 * result + (pointC != null ? pointC.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Triangle{");
        sb.append("triangleId=").append(triangleId);
        sb.append(", pointA=").append(pointA);
        sb.append(", pointB=").append(pointB);
        sb.append(", pointC=").append(pointC);
        sb.append('}');
        return sb.toString();
    }


}
