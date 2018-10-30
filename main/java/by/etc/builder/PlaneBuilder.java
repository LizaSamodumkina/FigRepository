package by.etc.builder;

import by.etc.entity.Plane;

public class PlaneBuilder {
    private int x1, x2, x3, y1, y2, y3, z1, z2, z3;

    public PlaneBuilder() {}

    public Plane build(){
        return new Plane(x1, y1, z1, x2, y2, z2, x3, y3, z3);
    }

    public PlaneBuilder X1(int x1) {
        this.x1 = x1;
        return this;
    }

    public PlaneBuilder X2(int x2) {
        this.x2 = x2;
        return this;
    }

    public PlaneBuilder X3(int x3) {
        this.x3 = x3;
        return this;
    }

    public PlaneBuilder Y1(int y1) {
        this.y1 = y1;
        return this;
    }

    public PlaneBuilder Y2(int y2) {
        this.y2 = y2;
        return this;
    }

    public PlaneBuilder Y3(int y3) {
        this.y3 = y3;
        return this;
    }

    public PlaneBuilder Z1(int z1) {
        this.z1 = z1;
        return this;
    }

    public PlaneBuilder Z2(int z2) {
        this.z2 = z2;
        return this;
    }

    public PlaneBuilder Z3(int z3) {
        this.z3 = z3;
        return this;
    }
}
