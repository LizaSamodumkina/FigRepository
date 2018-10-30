package by.etc.entity.sort;

import by.etc.entity.Plane;

import java.util.Comparator;

public class SortPlaneByY1 extends Plane implements Comparator <Plane>{

    private static final long serialVersionUID = 6554283421875272456L;
    private final static int FIRST_POINT = 0;

    @Override
    public int compare(Plane first, Plane second) {
        return (int) (first.getPoint(FIRST_POINT).getY() - second.getPoint(FIRST_POINT).getY());
    }
}
