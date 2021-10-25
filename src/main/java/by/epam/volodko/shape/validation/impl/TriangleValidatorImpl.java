package by.epam.volodko.shape.validation.impl;

import by.epam.volodko.shape.entity.CustomPoint;
import by.epam.volodko.shape.entity.Triangle;
import by.epam.volodko.shape.validation.TriangleValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TriangleValidatorImpl implements TriangleValidator {
    private static final TriangleValidatorImpl instanse = new TriangleValidatorImpl();

    private TriangleValidatorImpl() {
    }

    public static TriangleValidatorImpl getInstance() {
        return instanse;
    }

    @Override
    public boolean validateString(String stringDataAsCoordinates) {
        Pattern pattern = Pattern.compile(TRIANGLE_DATA_REGEX);
        Matcher matcher = pattern.matcher(stringDataAsCoordinates);

        return matcher.matches();
    }


    @Override
    public boolean isTrianglePossible(CustomPoint pointA, CustomPoint pointB, CustomPoint pointC) {
        return ((pointC.getX() - pointA.getX()) * (pointB.getY() - pointA.getY()) -
                (pointC.getY()) - pointA.getY()) * (pointB.getX() - pointA.getX()) != 0;
    }

    @Override
    public boolean isTrianglePossible(Triangle triangle) {
        CustomPoint pointA = triangle.getPointA();
        CustomPoint pointB = triangle.getPointB();
        CustomPoint pointC = triangle.getPointC();
        return isTrianglePossible(pointA, pointB, pointC);

    }
}