package by.etc.specification.impl;

import by.etc.action.PlaneAction;
import by.etc.action.exception.ActionException;
import by.etc.action.impl.PlaneActionImpl;
import by.etc.entity.Plane;
import by.etc.specification.MemorySpecification;
import by.etc.specification.exception.SpecificationException;

public class ByOYZAngleSpecification implements MemorySpecification<Plane> {
    private final static int OyzAngle = 1;
    private double angle;

    public ByOYZAngleSpecification(double angle) {
        this.angle = angle;
    }

    @Override
    public boolean isSatisfiedBy(Plane obj) throws SpecificationException{
        boolean answer = false;

        PlaneAction action = new PlaneActionImpl();
        try {
            double []angles = action.findAngleBetweenPlaneAndCoordinatePlane(obj);
            if (this.angle >= angles[OyzAngle]){
                answer = true;
            }
        }
        catch(ActionException e){
            throw new SpecificationException("cannot compare angles in isSatisfiedBy()", e);
        }
        return answer;
    }
}
