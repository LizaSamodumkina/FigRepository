package by.etc.action.impl;

import by.etc.entity.Plane;
import by.etc.entity.Point;

public class PlaneCoefficient {
    public static double[] findPlaneCoefficients(Plane plane){
        Point vab = substract(plane.getPoint(1), plane.getPoint(0)); //из вектора B вычитаем вектор А
        Point vac = substract(plane.getPoint(2), plane.getPoint(0));
        Point n = cross(vab, vac);
        double d = -dot(n, plane.getPoint(0));
        return new double[]{n.getX(), n.getY(), n.getZ(), d};
    }

    private static Point substract(Point a, Point b){
        return new Point(a.getX() - b.getX(), a.getY() - b.getY(), a.getZ() - b.getZ());
    }

    private static Point cross(Point a, Point b){
        return new Point((a.getY() * b.getZ() - (a.getZ() * b.getY())),
                (a.getZ() * b.getX()) - (a.getX() * b.getZ()),
                (a.getX() * b.getY()) - (a.getY() * b.getX()));
    }

    private static double dot(Point a, Point b){
        return (a.getX() * b.getX()) + (a.getY() * b.getY()) + (a.getZ() * b.getZ());
    }
}
