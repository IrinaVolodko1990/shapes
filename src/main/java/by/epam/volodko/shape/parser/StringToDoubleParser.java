package by.epam.volodko.shape.parser;



import java.util.List;

public interface StringToDoubleParser {
    String SPACE_DELIMETER_REGEX = "\\s+";
    List<Double> parseStringListToDoubleList(List<String> stringListAsCoordinates);

}
