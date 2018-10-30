package by.etc.specification.impl;

import by.etc.action.PlaneAction;
import by.etc.action.exception.ActionException;
import by.etc.action.impl.PlaneActionImpl;
import by.etc.criteria.PlaneCriteria;
import by.etc.criteria.SearchCriteria;
import by.etc.entity.Plane;
import by.etc.specification.MemorySpecification;
import by.etc.specification.exception.SpecificationException;

import java.util.Map;

public class ByCriteriaSpecification implements MemorySpecification<Plane> {
    private final static int OXY_ANGLE = 0;
    private final static int OYZ_ANGLE = 1;
    private final static int OXZ_ANGLE = 2;

    private PlaneCriteria criteria;

    public ByCriteriaSpecification(PlaneCriteria criteria){
        this.criteria = criteria;
    }

    @Override
    public boolean isSatisfiedBy(Plane obj) throws SpecificationException{
        PlaneAction action = new PlaneActionImpl();
        Map <SearchCriteria.Plane, Object> criterias = criteria.getCriteria();

        try{
            Object value = criterias.get(SearchCriteria.Plane.ID);
            if (value != null && obj.getId() != (Integer)value){
                return false;
            }
            value = criterias.get(SearchCriteria.Plane.NAME);
            if(value != null && obj.getName().equals((String)value)){
                return false;
            }

            double []angles = action.findAngleBetweenPlaneAndCoordinatePlane(obj);
            value = criterias.get(SearchCriteria.Plane.ANGLE_WITH_OXY);
            if(value != null && angles[OXY_ANGLE] < (Double)value){
                return false;
            }
            value = criterias.get(SearchCriteria.Plane.ANGLE_WITH_OYZ);
            if(value != null && angles[OYZ_ANGLE] < (Double)value){
                return false;
            }
            value = criterias.get(SearchCriteria.Plane.ANGLE_WITH_OXZ);
            if(value != null && angles[OXZ_ANGLE] < (Double)value){
                return false;
            }
        }
        catch(ActionException e){
            throw new SpecificationException("cannot compare criterias in isSatisfiedBy()", e);
        }

        return true;
    }
}
