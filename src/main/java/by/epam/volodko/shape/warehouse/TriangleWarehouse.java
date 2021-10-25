package by.epam.volodko.shape.warehouse;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TriangleWarehouse {

    private static TriangleWarehouse instance;
    private Map<Long, TriangleParameters> triangleWarehouse;

    private TriangleWarehouse() {
        triangleWarehouse = new HashMap<>();
    }

    public static TriangleWarehouse getInstance() {
        if (instance == null) {
            instance = new TriangleWarehouse();
        }
        return instance;
    }

    public Map<Long, TriangleParameters> getTriangleWarehouse() {
        return Map.copyOf(triangleWarehouse);
    }

    public boolean containsId(long triangleId) {
        return triangleWarehouse.containsKey(triangleId);
    }

    public void putParameters(long triangleId, TriangleParameters triangleParameters) {
        instance.triangleWarehouse.put(triangleId, triangleParameters);
    }

//    public TriangleParameters getParameters (long triangleId){
//        return triangleWarehouse.get(triangleId);
//    }

    public Optional<TriangleParameters> getParameters(long id) {
        Optional<TriangleParameters> parameters = Optional.ofNullable(instance.triangleWarehouse.get(id));

        return parameters;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TriangleWarehouse{");
        sb.append("triangleWarehouse=").append(triangleWarehouse);
        sb.append('}');
        return sb.toString();
    }


}
