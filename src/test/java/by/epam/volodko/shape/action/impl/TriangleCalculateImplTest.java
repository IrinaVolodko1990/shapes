package by.epam.volodko.shape.action.impl;

import by.epam.volodko.shape.entity.CustomPoint;
import by.epam.volodko.shape.entity.Triangle;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TriangleCalculateImplTest {
    TriangleCalculateImpl calculate;
    Triangle triangle;

    @BeforeClass
    public void init() {
        calculate = new TriangleCalculateImpl();
        triangle = new Triangle(new CustomPoint(1.5, 3.5),
                new CustomPoint(3.0, 4.0),
                new CustomPoint(4.8, 3.5));
    }

    @Test
    public void testCalculatePerimeter() {
        double actual = calculate.calculatePerimeter(triangle).getAsDouble();
        double expected = 6.749;
        assertEquals(actual, expected);
    }

    @Test
    public void testCalculateArea() {
        double actual = calculate.calculateArea(triangle).getAsDouble();
        double expected = 0.824;
        assertEquals(actual, expected);
    }

    @Test
    public void testIsIsoscelesTriangle() {
        Triangle triangle = new Triangle(new CustomPoint(2, 2),
                new CustomPoint(3.1, 3.8),
                new CustomPoint(4.2, 2));
        boolean actual = calculate.isIsoscelesTriangle(triangle);
        assertTrue(actual);
    }

    @Test
    public void testIsNotIsoscelesTriangle() {
        boolean actual = calculate.isIsoscelesTriangle(triangle);
        assertFalse(actual);
    }
    @Test
    public void testIsIsoscelesNullTriangle() {
        boolean actual = calculate.isIsoscelesTriangle(null);
        assertFalse(actual);
    }


    @Test
    public void testIsEquilateralTriangle() {
        Triangle triangle = new Triangle(new CustomPoint(2.2, 3.2),
                new CustomPoint(2.7, 4.066) ,
                new CustomPoint(3.2, 3.2));
        boolean actual = calculate.isEquilateralTriangle(triangle);
        assertTrue(actual);
    }

    @Test
    public void testIsNotEquilateralTriangle() {
        boolean actual = calculate.isEquilateralTriangle(triangle);
        assertFalse(actual);
    }


    @Test
    public void testIsRightTriangle() {
        Triangle triangle = new Triangle(new CustomPoint(0, 0),
                new CustomPoint(0, 3),
                new CustomPoint(4, 0));
        boolean actual = calculate.isRightTriangle(triangle);
        assertTrue(actual);
    }

    @Test
    public void testIsAcuteTriangle() {
        Triangle triangle = new Triangle(new CustomPoint(1,1),
                new CustomPoint (1.5, 2.8),
                new CustomPoint(2.2, 1.2));
        boolean actual = calculate.isAcuteTriangle(triangle);
        assertTrue(actual);
    }

    @Test
    public void testIsObtuseTriangle() {
        boolean actual = calculate.isObtuseTriangle(triangle);
        assertTrue(actual);
    }
}