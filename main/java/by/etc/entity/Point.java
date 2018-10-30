package by.etc.entity;

import java.io.Serializable;

public class Point implements Serializable{

    private static final long serialVersionUID = -1902682220896065603L;

    private double x;
    private double y;
    private double z;

    public Point(){}
    public Point(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() { return z;}

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) { this.z = z;}

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null) {return false;}
        if (this.getClass() != o.getClass()) {return false;}
        Point temp = (Point) o;
        if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(temp.x)
                || Double.doubleToLongBits(this.y) != Double.doubleToLongBits(temp.y)
                || Double.doubleToLongBits(this.z) != Double.doubleToLongBits(temp.z)){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = result*prime + (int)x;
        result = result*prime + (int)y;
        result = result*prime + (int)z;
        return result;
    }

    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append("Point{" + "x=" + x + ", y=" + y + ", z=" + z + '}');
        return buf.toString();
    }
}
