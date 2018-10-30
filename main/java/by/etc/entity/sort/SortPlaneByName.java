package by.etc.entity.sort;

import by.etc.entity.Plane;

import java.util.Comparator;

public class SortPlaneByName extends Plane implements Comparator<Plane> {

    private static final long serialVersionUID = -7150556914703377349L;

    @Override
    public int compare(Plane first, Plane second) {
        return first.getName().compareToIgnoreCase(second.getName());
    }
}
