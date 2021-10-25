package by.epam.volodko.shape.repository.impl;

import by.epam.volodko.shape.action.impl.TriangleCalculateImpl;
import by.epam.volodko.shape.entity.Triangle;
import by.epam.volodko.shape.repository.TriangleSpecification;

public class TriangleAreaSpecification implements TriangleSpecification {
    private static final double NULL_AREA =0;
    private double fromArea;
    private double toArea;

    public TriangleAreaSpecification(double fromArea, double toArea) {
        this.fromArea = fromArea;
        this.toArea = toArea;
    }

    @Override
    public boolean specify(Triangle triangle) {
        TriangleCalculateImpl calculate= new TriangleCalculateImpl();
        boolean triangleArea = calculate.calculateArea(triangle).orElse(NULL_AREA)>=fromArea
                &&calculate.calculateArea(triangle).orElse(NULL_AREA)<=toArea;
        return triangleArea;
    }
}
