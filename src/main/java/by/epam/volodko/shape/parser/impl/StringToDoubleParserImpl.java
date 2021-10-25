package by.epam.volodko.shape.parser.impl;

import by.epam.volodko.shape.entity.CustomPoint;
import by.epam.volodko.shape.exception.CustomException;
import by.epam.volodko.shape.parser.StringToDoubleParser;
import by.epam.volodko.shape.validation.TriangleValidator;
import by.epam.volodko.shape.validation.impl.TriangleValidatorImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringToDoubleParserImpl implements StringToDoubleParser {
    static Logger logger = LogManager.getLogger();

    @Override
    public List<Double> parseStringListToDoubleList(List<String> stringListAsCoordinates) {
        List<Double> doubleListAsCoordinates = new ArrayList<>();
        TriangleValidatorImpl validator = TriangleValidatorImpl.getInstance();
        if (!stringListAsCoordinates.isEmpty()) {
            for (String line : stringListAsCoordinates) {
                if (validator.validateString(line)) {
                    String[] coordinatesLine = line.split(SPACE_DELIMETER_REGEX);
                    for (int i = 0; i < coordinatesLine.length; i++) {
                        double coordinate = Double.parseDouble(coordinatesLine[i]);
                        doubleListAsCoordinates.add(coordinate);

                    }

                    logger.log(Level.INFO,  line+ " added.");}
                else {
                    logger.log(Level.WARN, "Validation was failed in line: " + line);
                }
            }
        } else {
            logger.log(Level.WARN, "File is empty");
        }

        return doubleListAsCoordinates;
    }

//    @Override
//    public List<double[]> parseStringListToDoubleList(List<String> stringListAsCoordinates) {
//        List<double[]> doubleListAsCoordinates;
//        doubleListAsCoordinates = stringListAsCoordinates.stream()
//                .map(String::trim)
//                .filter(TriangleValidatorImpl::validateString)
//                .peek(line -> logger.log(Level.INFO, line + " added"))
//                .map(line -> line.split(SPACE_DELIMETER_REGEX))
//                .map(arr -> Stream.of(arr)
//                        .mapToDouble(Double::parseDouble)
//                        .toArray())
//                .collect(Collectors.toList());
//
//        return doubleListAsCoordinates;
//    }




}
