package by.epam.volodko.shape.repository.impl;

import by.epam.volodko.shape.entity.Triangle;
import by.epam.volodko.shape.repository.TriangleSpecification;

public class FirstQuadrantSpecification implements TriangleSpecification {
    @Override
    public boolean specify(Triangle triangle) {
        if (triangle == null) {
            return false;
        }
        boolean isPointAinFirstQuadrant = triangle.getPointA().getX() >= 0
                          && triangle.getPointA().getY() >= 0;
        boolean isPointBinFirstQuadrant = triangle.getPointB().getX() >= 0
                && triangle.getPointB().getY() >= 0;
        boolean isPointCinFirstQuadrant = triangle.getPointC().getX() >= 0
                && triangle.getPointC().getY() >= 0;
        return isPointAinFirstQuadrant&&isPointBinFirstQuadrant&&isPointCinFirstQuadrant;
    }
}
