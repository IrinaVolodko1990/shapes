package by.epam.volodko.shape.reader.impl;

import by.epam.volodko.shape.exception.CustomException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class TriangleReaderImplTest {
    TriangleReaderImpl reader;
    @BeforeClass
    public void init(){
        reader = new TriangleReaderImpl();
    }

    @Test
    public void testReadFile() throws CustomException {
        List<String> expected = List.of (
                "2.5 3.4 2.5 6.4 6.5 3.4",
                "-3.8 1.2 -2.3 3.2 -0.8 1.2",
                "2.25 2.25 4.1"
        );
        String path = "src\\test\\resources\\test_data.txt";
        List<String> actual = reader.readFile(path);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testReadNullFileException() throws CustomException{
        reader.readFile(null);
    }
}