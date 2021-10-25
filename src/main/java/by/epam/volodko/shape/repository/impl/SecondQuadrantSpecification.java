package by.epam.volodko.shape.repository.impl;

import by.epam.volodko.shape.entity.Triangle;
import by.epam.volodko.shape.repository.TriangleSpecification;

public class SecondQuadrantSpecification implements TriangleSpecification {
    @Override
    public boolean specify(Triangle triangle) {
        if (triangle == null) {
            return false;
        }
        boolean isPointAinSecondQuadrant = triangle.getPointA().getX() <= 0
                && triangle.getPointA().getY() >= 0;
        boolean isPointBinSecondQuadrant = triangle.getPointB().getX() <= 0
                && triangle.getPointB().getY() >= 0;
        boolean isPointCinSecondQuadrant = triangle.getPointC().getX() <= 0
                && triangle.getPointC().getY() >= 0;
        return isPointAinSecondQuadrant&&isPointBinSecondQuadrant&&isPointCinSecondQuadrant;
    }
}
