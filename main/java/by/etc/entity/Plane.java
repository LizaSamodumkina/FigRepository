package by.etc.entity;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

public class Plane extends Observable implements Serializable, Comparable<Plane> {

    private final static long serialVersionUID = 4715629771960870658L;
    private final static int numPoints = 3;

    private final int id;
    private String name = "figure";
    private Point[] points;

    public Plane() {
        points = new Point[numPoints];
        id = 1;
    }
    public Plane(double x1, double y1, double z1, double x2, double y2, double z2, double x3, double y3, double z3) {
        points = new Point[]{new Point(x1, y1, z1), new Point(x2, y2, z2), new Point(x3, y3, z3)};
        id = 1;
    }
    public Plane(double x1, double y1, double z1, double x2, double y2, double z2, double x3, double y3, double z3, int id, String name) {
        points = new Point[]{new Point(x1, y1, z1), new Point(x2, y2, z2), new Point(x3, y3, z3)};
        this.id = id;
        this.name = name;
    }
    public Plane(Point first, Point second, Point third) {
        points = new Point[]{first, second, third};
        id = 1;
    }
    public Plane(Point first, Point second, Point third, int id, String name) {
        points = new Point[]{first, second, third};
        this.id = id;
        this.name = name;
    }

    public Point[] getPoints() {
        return points;
    }
    public Point getPoint(int index){
        return points[index];
    }
    public int getId(){ return id;}
    public String getName(){return name;}

    public void setPoints(Point[] points) {
        this.points = points;
        setChanged();
        notifyObservers(this);
    }
    public void setPoint(Point newPoint, int index){
        points[index] = newPoint;
        setChanged();
        notifyObservers(this);
    }
    public void setName(String name) {
        this.name = name;
        setChanged();
        notifyObservers(this);
    }

    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append("Plane{" + "points=\n");
        for (Point point: points){
            buf.append("\t" + point.toString() + "\n");
        }
        buf.append("ID = ").append(this.id);
        buf.append("\nName = ").append(this.name);
        buf.append('}');
        return buf.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null) {return false;}
        if (this.getClass() != o.getClass()) return false;
        Plane temp = (Plane) o;
        if (temp.getPoints().length != points.length){
            return false;
        }
        if (this.id != temp.id){
            return false;
        }
        if (this.name != null && this.name.equals(temp.name)) {
            for (int i = 0; i < points.length; i++) {
                if (temp.getPoint(i).equals(this.points[i]) == false) {
                    return false;
                }
            }
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        if (points == null){
            return prime*result; //что конкретно нужно сделать
        }
        for (int i = 0; i < points.length; i++){
            result = result*prime + this.points[i].hashCode();
        }
        result = result*prime + this.id;
        for (int i = 0; i < this.name.length(); i++){
            result = result*prime + name.charAt(i);
        }
        return result;
    }

    @Override
    public int compareTo(Plane plane) {
        return this.getId() - plane.getId();
    }

}