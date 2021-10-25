package by.epam.volodko.shape.comparator;


import by.epam.volodko.shape.entity.Triangle;

import java.util.Comparator;

public enum TriangleComparator implements Comparator<Triangle> {
    ID {
        @Override
        public int compare(Triangle t1, Triangle t2) {
            return Long.compare(t1.getTriangleId(), t2.getTriangleId());
        }
    },

    POINT_A_x {
        @Override
        public int compare(Triangle t1, Triangle t2) {
            return Double.compare(t1.getPointA().getX(), t2.getPointA().getX());

        }
    },
    POINT_A_y {
        @Override
        public int compare(Triangle t1, Triangle t2) {
            return Double.compare(t1.getPointA().getY(), t2.getPointA().getY());

        }
    },
    POINT_B_x {
        @Override
        public int compare(Triangle t1, Triangle t2) {
            return Double.compare(t1.getPointB().getX(), t2.getPointB().getX());

        }
    },
    POINT_B_y {
        @Override
        public int compare(Triangle t1, Triangle t2) {
            return Double.compare(t1.getPointB().getY(), t2.getPointB().getY());

        }
    },
    POINT_C_x {
        @Override
        public int compare(Triangle t1, Triangle t2) {
            return Double.compare(t1.getPointC().getX(), t2.getPointC().getX());

        }
    },
    POINT_C_y {
        @Override
        public int compare(Triangle t1, Triangle t2) {
            return Double.compare(t1.getPointC().getY(), t2.getPointC().getY());

        }
    }

}
