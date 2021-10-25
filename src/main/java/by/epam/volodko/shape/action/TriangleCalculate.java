package by.epam.volodko.shape.action;

import by.epam.volodko.shape.entity.Triangle;

import java.util.OptionalDouble;

public interface TriangleCalculate {

    OptionalDouble calculatePerimeter(Triangle triangle);

    OptionalDouble calculateArea(Triangle triangle);

    boolean isIsoscelesTriangle(Triangle triangle);

    boolean isEquilateralTriangle(Triangle triangle);

    boolean isRightTriangle(Triangle triangle);

    boolean isAcuteTriangle(Triangle triangle);

    boolean isObtuseTriangle(Triangle triangle);

}
