package by.etc.warehouse.impl;

import by.etc.action.PlaneAction;
import by.etc.action.exception.ActionException;
import by.etc.action.impl.PlaneActionImpl;
import by.etc.entity.Plane;
import by.etc.warehouse.Warehouse;

import by.etc.warehouse.exception.WarehouseException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Iterator;

public class PlaneActionWarehouse implements Warehouse {
    private final static Logger log = LogManager.getLogger(PlaneActionWarehouse.class);

    private static PlaneActionWarehouse instance;
    private Map<Integer, ResultPlaneAction> warehouse;
    private Observer observer = this;

    public PlaneActionWarehouse(){
        warehouse = new HashMap<>();
    }

    public static PlaneActionWarehouse getInstance(){
        if(instance == null){
            instance = new PlaneActionWarehouse();
        }
        return instance;
    }

    public Map<Integer, ResultPlaneAction> getWarehouse(){
        return warehouse;
    }

    public Observer getObserver(){
        return observer;
    }

    @Override
    public void update(Observable o, Object arg){
        PlaneAction action = new PlaneActionImpl();

        Plane plane = (Plane) arg;
        boolean mark = false, isDeleted = false;
        try {
            if (plane.getName().equals("delete")){
                delete(plane);
            }
            else{
                mark = update(plane);
                if (!mark){
                    add(plane);
                }
            }
        }
        catch(WarehouseException e){
            log.error("error message" + "cannot change data in warehouse");
        }
    }

    private void delete(Plane plane){
        for(Iterator<Map.Entry<Integer, ResultPlaneAction> > it = this.warehouse.entrySet().iterator(); it.hasNext();) {
            Map.Entry<Integer, ResultPlaneAction> entry = it.next();
            if (entry.getKey() == plane.getId()) {
                it.remove();
            }
        }
    }

    private boolean update(Plane plane)throws WarehouseException{
        PlaneAction action = new PlaneActionImpl();
        boolean mark = false;

        try {
            for (Map.Entry<Integer, ResultPlaneAction> temp : warehouse.entrySet()) {
                if (temp.getKey() == plane.getId()) {
                    temp.getValue().setAnglesBetweenPlanes(action.findAngleBetweenPlaneAndCoordinatePlane(plane));
                    temp.getValue().setIsPlanesPerpendecular(action.isPlanePerpendicularToCoordinatesPlane(plane));
                    mark = true;
                }
            }
        }
        catch(ActionException e){
            log.error("error message" + "cannot count angles in update()");
            throw new WarehouseException("cannot count angles in update()", e);
        }
        return mark;
    }

    private void add(Plane plane) throws WarehouseException{
        PlaneAction action = new PlaneActionImpl();

        try {
            ResultPlaneAction result = new ResultPlaneAction(action.findAngleBetweenPlaneAndCoordinatePlane(plane),
                    action.isPlanePerpendicularToCoordinatesPlane(plane));
            warehouse.put(plane.getId(), result);
        }
        catch(ActionException e){
            log.error("error message" + "cannot count angles in add()");
            throw new WarehouseException("cannot count angles in add()", e);
        }
    }
}
