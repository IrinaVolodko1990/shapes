package by.epam.volodko.shape.repository.impl;

import by.epam.volodko.shape.entity.Triangle;
import by.epam.volodko.shape.repository.TriangleSpecification;

public class FouthQuadrantSpecification implements TriangleSpecification {
    @Override
    public boolean specify(Triangle triangle) {
        if (triangle == null) {
            return false;
        }
        boolean isPointAinFouthQuadrant = triangle.getPointA().getX() >= 0
                && triangle.getPointA().getY() >= 0;
        boolean isPointBinFouthQuadrant = triangle.getPointB().getX() >= 0
                && triangle.getPointB().getY() >= 0;
        boolean isPointCinFouthQuadrant = triangle.getPointC().getX() >= 0
                && triangle.getPointC().getY() >= 0;
        return isPointAinFouthQuadrant&&isPointBinFouthQuadrant&&isPointCinFouthQuadrant;
    }
}