package by.etc.action;

import by.etc.action.exception.ActionException;
import by.etc.entity.Plane;
import by.etc.entity.Point;
import by.etc.repository.impl.PlaneRepository;

import java.util.Comparator;

public interface PlaneAction {
    public double[] findAngleBetweenPlaneAndCoordinatePlane(Plane plane) throws ActionException;
    public boolean isPointsFormPlane(Point first, Point second, Point third) throws ActionException;
    public boolean[] isPlanePerpendicularToCoordinatesPlane(Plane plane) throws ActionException;
    public void sort(PlaneRepository planes, Comparator<Plane> compr);
}
