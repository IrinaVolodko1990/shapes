package by.epam.volodko.shape.repository.impl;

import by.epam.volodko.shape.entity.Triangle;
import by.epam.volodko.shape.repository.TriangleSpecification;

public class IdTriangleSpecification implements TriangleSpecification {
    private long fromId;
    private long toId;

    public IdTriangleSpecification(long fromId, long toId) {
        this.fromId = fromId;
        this.toId = toId;
    }

    @Override
    public boolean specify(Triangle triangle) {
        boolean result = false;
        if (triangle == null) {
            return result;
        }
        result = triangle.getTriangleId() >= fromId
                && triangle.getTriangleId() <= toId;
        return result;
    }
}