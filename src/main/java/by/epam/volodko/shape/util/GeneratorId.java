package by.epam.volodko.shape.util;

public class GeneratorId {
    public static long counter=1;
    public static long genereteId(){
        return counter++;
    }
}
