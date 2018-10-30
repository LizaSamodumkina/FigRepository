package by.etc.action.impl;

import by.etc.action.PlaneAction;
import by.etc.action.exception.ActionException;
import by.etc.builder.PlaneBuilder;
import by.etc.entity.Plane;
import by.etc.entity.Point;

import by.etc.repository.impl.PlaneRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class PlaneActionImpl implements PlaneAction {
    private final static int NUM_POINTS = 3;
    private final static int NUM_COORDINATE_PLANE = 3;
    private final static int RIGHT_ANGLE = 90;

    private final static Logger log = LogManager.getLogger(PlaneActionImpl.class);


    @Override
    public double[] findAngleBetweenPlaneAndCoordinatePlane(Plane plane) throws ActionException {
        double []cos;

        try {
            isValid(plane);
            double[] equationOfPlane = PlaneCoefficient.findPlaneCoefficients(plane); //уравнение прямой

            double[] equationOfOxy =
                    PlaneCoefficient.findPlaneCoefficients(new PlaneBuilder().X1(1).Y1(1).Z1(0).X2(3).Y2(1).Z2(0).X3(4).Y3(7).Z3(0).build()); //уравнение прямой Oxy

            double[] equationOfOyz =
                    PlaneCoefficient.findPlaneCoefficients( new PlaneBuilder().X1(0).Y1(1).Z1(1).X2(0).Y2(5).Z2(2).X3(0).Y3(2).Z3(5).build()); //уравнение прямой Oyz

            double[] equationOfOxz =
                    PlaneCoefficient.findPlaneCoefficients( new PlaneBuilder().X1(1).Y1(0).Z1(1).X2(5).Y2(0).Z2(1).X3(3).Y3(0).Z3(7).build()); //уравнение прямой Oxz

            cos = findAllCos(equationOfPlane, equationOfOxy, equationOfOyz, equationOfOxz);
        }
        catch(ActionException e){
            log.error("error message" + "can't use plane to find result in findAngleBetweenPlaneAndCoordinatePlane()");
            throw new ActionException("can't use plane to find result in findAngleBetweenPlaneAndCoordinatePlane()");
        }

        return findAllArcCos(cos);
    }

    @Override
    public boolean isPointsFormPlane(Point first, Point second, Point third) throws ActionException {
        if (first == null || second == null || third == null) {
            log.warn("warning message" + "points are null in isPointsFormPlane()");
            throw new ActionException("points are null in isPointsFormPlane()");
        }

        if (first.equals(second) || second.equals(third) || first.equals(third)) {
            //все точки одинаковы == не плоскость
            return false;
        }

        return isPointsDoNotFormLine(first, second, third);
    }

    @Override
    public boolean[] isPlanePerpendicularToCoordinatesPlane(Plane plane) throws ActionException {
        boolean[] result = new boolean[NUM_POINTS];
        double[] angle;
        try {
            angle = findAngleBetweenPlaneAndCoordinatePlane(plane);
            for(int i = 0; i < NUM_COORDINATE_PLANE; i++){
                if(angle[i] == RIGHT_ANGLE || angle[i] == RIGHT_ANGLE *2){
                    result[i] = true;
                }
            }
        } catch (ActionException e) {
            log.error("error message" + "plane has incorrect coordinates in isPlanePerpendicularToCoordinatesPlane()");
            throw new ActionException("plane has incorrect coordinates in isPlanePerpendicularToCoordinatesPlane()");
        }
        return result;
    }

    @Override
    public void sort(PlaneRepository planes, Comparator<Plane> compr) {
        planes.sort(compr);
    }

    private double findCos(double[] par1, double[] par2) {
        return (par1[0] * par2[0] + par1[1] * par2[1] + par1[2] * par2[2]) /
                ((Math.sqrt(Math.pow(par1[0], 2) + Math.pow(par1[1], 2) + Math.pow(par1[2], 2))) *
                        Math.sqrt(Math.pow(par2[0], 2) + Math.pow(par2[1], 2) + Math.pow(par2[2], 2)));
    }

    private double[] findAllCos(double[] mainPlane, double[] Oxy, double[] Oyz, double[] Oxz){
        double []result = new double[NUM_COORDINATE_PLANE];

        result[0] = findCos(mainPlane, Oxy);

        result[1] = findCos(mainPlane, Oyz);

        result[2] = findCos(mainPlane, Oxz);

        return result;
    }

    private double[] findAllArcCos(double[] cos){
        double result[] = new double[NUM_COORDINATE_PLANE];
        for(int i = 0; i < cos.length; i++){
            result[i] = Math.acos(cos[i]);
        }
        return result;
    }

    private void isValid(Plane plane) throws ActionException{
        if (plane == null) {
            log.error("error message" + "plane is null in findAngleBetweenPlaneAndCoordinatePlane()");
            throw new ActionException("plane is null");
        }
    }

    private boolean isPointsDoNotFormLine(Point first, Point second, Point third){
        double X = 0, Y = 0, Z = 0;
        boolean noMatterY = false, noMatterX = false, noMatterZ = false;

        X = (third.getX() - first.getX()) / (second.getX() - first.getX());
        if (Double.isInfinite(X) || Double.isNaN(X)) {
            noMatterX = true;
        }
        Y = (third.getY() - first.getY()) / (second.getY() - first.getY());
        if (Double.isInfinite(Y) || Double.isNaN(Y)) {
            noMatterY = true;
        }
        Z = (third.getZ() - first.getZ()) / (second.getZ() - first.getZ());
        if (Double.isInfinite(Z) || Double.isNaN(Z)) {
            noMatterZ = true;
        }
        if ((noMatterX && noMatterY && !noMatterZ) || (noMatterX && noMatterZ && !noMatterY) ||
                (!noMatterX && noMatterY && noMatterZ) || (noMatterX && noMatterY && noMatterZ)) {
            return false;
        } else {
            if ((noMatterX && Y == Z) || (noMatterY && X == Z) || (noMatterZ) && X == Y) {
                return false;
            } else {
                if (X == Y && Y == Z) {
                    return false;
                }
            }
        }
        return true;
    }
}

