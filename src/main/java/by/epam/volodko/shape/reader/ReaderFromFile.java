package by.epam.volodko.shape.reader;

import by.epam.volodko.shape.exception.CustomException;

import java.util.List;

public interface ReaderFromFile {
    List<String> readFile(String pathToFile) throws CustomException;
}
