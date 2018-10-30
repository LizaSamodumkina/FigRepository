package by.etc.warehouse.impl;

import java.io.Serializable;
import java.util.Arrays;

public class ResultPlaneAction implements Serializable{

    private static final long serialVersionUID = 8498607454098686541L;

    private double[] anglesBetweenPlanes;
    private boolean[] isPlanesPerpendecular;

    public ResultPlaneAction() {}

    public ResultPlaneAction(double[] angleBetweenPlanes, boolean[] isPlanesPerpendecular){
        this.anglesBetweenPlanes = angleBetweenPlanes;
        this.isPlanesPerpendecular = isPlanesPerpendecular;
    }

    public void setAnglesBetweenPlanes(double[] anglesBetweenPlanes) {
        this.anglesBetweenPlanes = anglesBetweenPlanes;
    }

    public void setIsPlanesPerpendecular(boolean[] isPlanesPerpendecular) {
        this.isPlanesPerpendecular = isPlanesPerpendecular;
    }

    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append("ResultPlaneAction{" +
                "anglesBetweenPlanes=" + Arrays.toString(anglesBetweenPlanes) +
                ", isPlanesPerpendecular=" + Arrays.toString(isPlanesPerpendecular) +
                '}');
        return buf.toString();
    }
}
