package by.epam.volodko.shape.observer.impl;

import by.epam.volodko.shape.action.impl.TriangleCalculateImpl;
import by.epam.volodko.shape.entity.Triangle;
import by.epam.volodko.shape.exception.CustomException;
import by.epam.volodko.shape.observer.Observer;
import by.epam.volodko.shape.observer.TriangleEvent;
import by.epam.volodko.shape.warehouse.TriangleParameters;
import by.epam.volodko.shape.warehouse.TriangleWarehouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class TriangleObserver implements Observer {
    static Logger logger= LogManager.getLogger();
    @Override
    public void parametersChange(TriangleEvent event) {
        TriangleWarehouse warehouse= TriangleWarehouse.getInstance();
        TriangleCalculateImpl calculate = new TriangleCalculateImpl();
        Triangle triangle = event.getSource();
        double perimeter = calculate.calculatePerimeter(triangle)
                .orElseThrow(()->new RuntimeException("This triangle is null"));

        double area = calculate.calculateArea(triangle)
                .orElseThrow(()-> new RuntimeException("This triangle is null"));

        TriangleParameters parameters = new TriangleParameters(perimeter,area);


    }
}
