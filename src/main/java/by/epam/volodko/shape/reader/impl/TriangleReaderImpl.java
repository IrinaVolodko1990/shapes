package by.epam.volodko.shape.reader.impl;

import by.epam.volodko.shape.exception.CustomException;
import by.epam.volodko.shape.reader.ReaderFromFile;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TriangleReaderImpl implements ReaderFromFile {
    static Logger logger = LogManager.getLogger();


    @Override
    public List<String> readFile(String pathToFile) throws CustomException {
        List<String> stringList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(new File(pathToFile)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringList.add(line);

            }
        } catch (FileNotFoundException e) {
            logger.log(Level.ERROR, "File " + pathToFile + " not found", e);
            throw new CustomException("File " + pathToFile + " not found" + e);

        } catch (IOException e) {
            logger.log(Level.ERROR, "IO Exception: ", e);
            throw new CustomException("IO Exception: " + e);
        }

        return stringList;
    }

}