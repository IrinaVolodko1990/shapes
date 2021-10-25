package by.epam.volodko.shape.repository;

import by.epam.volodko.shape.entity.Triangle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TriangleRepository {
    private List<Triangle> triangles = new ArrayList<>();

    public boolean contains(Triangle triangle) {
        return triangles.contains(triangle);

    }

    public boolean add(Triangle triangle) {
        return triangles.add(triangle);
    }

    public boolean addAll(List<Triangle> triangles) {
        return triangles.addAll(triangles);
    }

    public boolean remove(Triangle triangle) {
        return triangles.remove(triangle);
    }


    public boolean removeAll(List<Triangle> trianglesList) {
        return triangles.removeAll(trianglesList);
    }

    public void clear() {
        triangles.clear();
    }

    List<Triangle> query(TriangleSpecification specification){
        return triangles.stream()
                .filter(specification::specify)
                .collect(Collectors.toList());
    }

    List<Triangle> sort(Comparator<? super Triangle> comparator){
        List<Triangle> cloneTriangle = new ArrayList<>(triangles);
        cloneTriangle.sort(comparator);
        return cloneTriangle;
    }

}
