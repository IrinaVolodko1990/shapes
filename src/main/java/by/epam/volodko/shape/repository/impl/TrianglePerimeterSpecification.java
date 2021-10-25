package by.epam.volodko.shape.repository.impl;

import by.epam.volodko.shape.action.impl.TriangleCalculateImpl;
import by.epam.volodko.shape.entity.Triangle;
import by.epam.volodko.shape.repository.TriangleSpecification;

public class TrianglePerimeterSpecification implements TriangleSpecification {
    private static final double NULL_PERIMETER = 0;
    private double fromPerimeter;
    private double toPerimeter;

    public TrianglePerimeterSpecification(double fromPerimeter, double toPerimeter) {
        this.fromPerimeter = fromPerimeter;
        this.toPerimeter = toPerimeter;
    }

    @Override
    public boolean specify(Triangle triangle) {
        TriangleCalculateImpl calculate = new TriangleCalculateImpl();
        boolean perimeter = (calculate.calculatePerimeter(triangle).orElse(NULL_PERIMETER) >= fromPerimeter
                && calculate.calculatePerimeter(triangle).orElse(NULL_PERIMETER) <= toPerimeter);
        return perimeter;
    }
}
