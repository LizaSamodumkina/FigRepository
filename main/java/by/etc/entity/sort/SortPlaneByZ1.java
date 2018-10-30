package by.etc.entity.sort;

import by.etc.entity.Plane;

import java.util.Comparator;

public class SortPlaneByZ1 extends Plane implements Comparator<Plane> {

    private final static int FIRST_POINT = 0;

    @Override
    public int compare(Plane first, Plane second) {
        return (int) (first.getPoint(FIRST_POINT).getZ() - second.getPoint(FIRST_POINT).getZ());
    }
}
