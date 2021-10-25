package by.epam.volodko.shape.validation;

import by.epam.volodko.shape.entity.CustomPoint;
import by.epam.volodko.shape.entity.Triangle;

public interface TriangleValidator {
    String TRIANGLE_DATA_REGEX = "-?\\d+(\\.\\d+)?(\\s+-?\\d+(\\.\\d+)?){5}";
    int NUMBER_OF_COORDINATES = 6;
    int NUMBER_OF_TRIANGLE_POINTS = 3;
    int NUMBER_OF_COORDINATES_IN_POINTS = 2;

   boolean validateString(String data);

    boolean isTrianglePossible(CustomPoint pointA, CustomPoint pointB, CustomPoint pointC);

  boolean isTrianglePossible(Triangle triangle);

}
