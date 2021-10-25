package by.epam.volodko.shape.creator;

import by.epam.volodko.shape.entity.CustomPoint;
import by.epam.volodko.shape.entity.Triangle;


import java.util.List;

public interface TriangleCreator {

    List<CustomPoint> createPoint(List<Double> listCoordinetesAsDouble);

    List<Triangle> createTriangles(List<CustomPoint> listOfPoints);

    Triangle createTriangle(CustomPoint pointA, CustomPoint pointB, CustomPoint pointC);


}
