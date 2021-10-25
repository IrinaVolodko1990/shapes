package by.epam.volodko.shape.creator.impl;

import by.epam.volodko.shape.creator.TriangleCreator;
import by.epam.volodko.shape.entity.CustomPoint;
import by.epam.volodko.shape.entity.Triangle;
import by.epam.volodko.shape.validation.TriangleValidator;
import by.epam.volodko.shape.validation.impl.TriangleValidatorImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class TriangleCreatorImpl implements TriangleCreator {
    static Logger logger = LogManager.getLogger();

    @Override
    public List<CustomPoint> createPoint(List<Double> listCoordinetesAsDouble) {
        List<CustomPoint> points = new ArrayList<>();

        if (listCoordinetesAsDouble.isEmpty() || listCoordinetesAsDouble == null) {
            logger.log(Level.WARN, "List is empty or null");
        }


        for (int i = 0; i < listCoordinetesAsDouble.size(); i += TriangleValidator.NUMBER_OF_COORDINATES_IN_POINTS) {
            double x = listCoordinetesAsDouble.get(i);
            double y = listCoordinetesAsDouble.get(i + 1);
            CustomPoint point = new CustomPoint(x, y);
            points.add(point);
        }
        return points;
    }

    @Override
    public List<Triangle> createTriangles(List<CustomPoint> listOfPoints) {
        TriangleValidator validate = TriangleValidatorImpl.getInstance();
        List<Triangle> triangles = new ArrayList<>();
        CustomPoint pointA;
        CustomPoint pointB;
        CustomPoint pointC;
        for (int i = 0; i < listOfPoints.size(); i += TriangleValidator.NUMBER_OF_TRIANGLE_POINTS) {
            pointA = listOfPoints.get(i);
            pointB = listOfPoints.get(i + 1);
            pointC = listOfPoints.get(i + 2);
            Triangle triangle = createTriangle(pointA, pointB, pointC);
            triangles.add(triangle);
        }
        return triangles;
    }

    @Override
    public Triangle createTriangle(CustomPoint pointA, CustomPoint pointB, CustomPoint pointC) {
        TriangleValidator validate = TriangleValidatorImpl.getInstance();
        Triangle triangle = null;
        if (validate.isTrianglePossible(pointA, pointB, pointC)) {
            triangle = new Triangle(pointA, pointB, pointC);
            logger.log(Level.INFO, "Triangle " + triangle + " is created");
        } else {
            logger.log(Level.WARN, "Triangle with points  " + pointA
                    + "; " + pointB + "; " + pointC + "; "
                    + " isn't created. Wrong data");
        }
        return triangle;
    }

}

