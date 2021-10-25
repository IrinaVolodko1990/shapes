package by.epam.volodko.shape.action.impl;

import by.epam.volodko.shape.action.TriangleCalculate;
import by.epam.volodko.shape.entity.CustomPoint;
import by.epam.volodko.shape.entity.Triangle;
import org.apache.commons.math3.util.Precision;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.Arrays;
import java.util.OptionalDouble;

public class TriangleCalculateImpl implements TriangleCalculate {
    static Logger logger = LogManager.getLogger();

    private double calculateSide(CustomPoint a, CustomPoint b) {
        double side = Precision.round(Math.hypot((b.getX() - a.getX()), (b.getY() - a.getY())), 3);
        return side;
    }

    private double[] calculateTriangleSides(Triangle triangle) {
        double sideAB = calculateSide(triangle.getPointA(), triangle.getPointB());
        double sideAC = calculateSide(triangle.getPointA(), triangle.getPointC());
        double sideCB = calculateSide(triangle.getPointB(), triangle.getPointC());
        return new double[]{sideAB, sideAC, sideCB};
    }

    @Override
    public OptionalDouble calculatePerimeter(Triangle triangle) {
        if (triangle == null) {
            logger.log(Level.WARN, "This triangle is null");
            return OptionalDouble.empty();
        }
        double[] sides = calculateTriangleSides(triangle);
        double perimeter = 0;
        for (double side : sides) {
            perimeter += side;
        }
        perimeter = Precision.round(perimeter, 3);
        logger.log(Level.INFO, "Perimeter of triangle with ID = " + triangle.getTriangleId() + " is " + perimeter);
        return OptionalDouble.of(perimeter);
    }

    @Override
    public OptionalDouble calculateArea(Triangle triangle) {
        if (triangle == null) {
            logger.log(Level.WARN, "This triangle is null");
            return OptionalDouble.empty();
        }
        double[] sides = calculateTriangleSides(triangle);
        double perimeter = 0;
        for (double side : sides) {
            perimeter += side;
        }
        double p = Precision.round(perimeter, 3) / 2;
        double area = Math.sqrt(p * (p - sides[0]) * (p - sides[1]) * (p - sides[2]));
        area = Precision.round(area, 3);
        logger.log(Level.INFO, "Area of triangle with ID = " + triangle.getTriangleId() + " is " + area);

        return OptionalDouble.of(area);
    }

    @Override
    public boolean isIsoscelesTriangle(Triangle triangle) {
        if (triangle == null) {
            logger.log(Level.WARN, "This triangle is null");
            return false;
        }
        double[] sides = calculateTriangleSides(triangle);
        boolean isIsosceles = sides[0] == sides[1] ||
                sides[1] == sides[2] ||
                sides[0] == sides[2];
        logger.log(Level.INFO,
                () -> isIsosceles
                        ? "Triangle with ID = " + triangle.getTriangleId() + " is isosceles"
                        : "Triangle with ID = " + triangle.getTriangleId() + " isn't isosceled");
        return isIsosceles;
    }

    @Override
    public boolean isEquilateralTriangle(Triangle triangle) {
        if (triangle == null) {
            logger.log(Level.WARN, "This triangle is null");
            return false;
        }
        double[] sides = calculateTriangleSides(triangle);
        boolean isEquilateral = sides[0] == sides[1] &&
                sides[0] == sides[2];
        logger.log(Level.INFO,
                () -> isEquilateral
                        ? "Triangle with ID = " + triangle.getTriangleId() + " is equilateral"
                        : "Triangle with ID = " + triangle.getTriangleId() + " isn't equilateral");
        return isEquilateral;
    }

    @Override
    public boolean isRightTriangle(Triangle triangle) {
        if (triangle == null) {
            logger.log(Level.WARN, "This triangle is null");
            return false;
        }
        double[] sides = calculateTriangleSides(triangle);
        Arrays.sort(sides);

        boolean isRight = sides[2] == Precision.round(Math.hypot(sides[0], sides[1]), 3);
        logger.log(Level.INFO,
                () -> isRight
                        ? "Triangle with ID = " + triangle.getTriangleId() + " is right"
                        : "Triangle with ID = " + triangle.getTriangleId() + " isn't right");
        return isRight;
    }

    @Override
    public boolean isAcuteTriangle(Triangle triangle) {
        if (triangle == null) {
            logger.log(Level.WARN, "This triangle is null");
            return false;
        }
        double[] sides = calculateTriangleSides(triangle);
        Arrays.sort(sides);

        boolean isAcute = sides[2] < Precision.round(Math.hypot(sides[0], sides[1]), 3);
        logger.log(Level.INFO,
                () -> isAcute
                        ? "Triangle with ID = " + triangle.getTriangleId() + " is acute"
                        : "Triangle with ID = " + triangle.getTriangleId() + " isn't acute");
        return isAcute;
    }

    @Override
    public boolean isObtuseTriangle(Triangle triangle) {
        if (triangle == null) {
            logger.log(Level.WARN, "This triangle is null");
            return false;
        }
        double[] sides = calculateTriangleSides(triangle);
        Arrays.sort(sides);

        boolean isObtuse = sides[2] > Precision.round(Math.hypot(sides[0], sides[1]), 3);
        logger.log(Level.INFO,
                () -> isObtuse
                        ? "Triangle with ID = " + triangle.getTriangleId() + " is obtuse"
                        : "Triangle with ID = " + triangle.getTriangleId() + " isn't obtuse");
        return isObtuse;
    }
}