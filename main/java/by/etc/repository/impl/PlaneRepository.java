package by.etc.repository.impl;

import by.etc.entity.Plane;
import by.etc.repository.Repository;
import by.etc.repository.exception.RepositoryException;
import by.etc.specification.Specification;
import by.etc.specification.exception.SpecificationException;
import by.etc.warehouse.impl.PlaneActionWarehouse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Comparator;

public class PlaneRepository extends Observable implements Repository<Plane>, Observer {
    private final static Logger log = LogManager.getLogger(PlaneActionWarehouse.class);

    private static PlaneRepository instance;

    private List<Plane> planes;

    private PlaneRepository() {
        this.planes = new ArrayList<>();
        this.addObserver(PlaneActionWarehouse.getInstance().getObserver());
    }

    public static PlaneRepository getInstance(){
        if(instance == null){
            instance = new PlaneRepository();
        }
        return instance;
    }

    public List<Plane> getRepository(){
        return this.planes;
    }

    @Override
    public void add(Plane item) {
        add(Collections.singletonList(item));
    }

    @Override
    public void add(Iterable<Plane> items) {
        for(Plane item: items){
            this.planes.add(item);
            setChanged();
            notifyObservers(item);
        }
    }

    @Override
    public void delete(Plane item) {
        Iterator<Plane> iter = planes.iterator();

        while(iter.hasNext()){
            Plane temp = iter.next();
            if (temp.equals(item)){
                iter.remove();
            }
        }

        item.setName("delete");
        //PlaneActionWarehouse.getInstance().update(item);
        setChanged();
        notifyObservers(item);
    }

    @Override
    public void delete(Specification specification) throws RepositoryException{
        Iterator<Plane> iter = planes.iterator();

        try {
            while (iter.hasNext()) {
                Plane temp = iter.next();
                if (specification.isSatisfiedBy(temp)) {
                    iter.remove();
                    temp.setName("delete");
                    setChanged();
                    notifyObservers(temp);
                }
            }
        }
        catch(SpecificationException e){
            log.error("error message" + "cannot delete by specification");
            throw new RepositoryException("cannot delete by specification", e);
        }
    }

    @Override
    public void update(Plane item) {
        Iterator<Plane> iter = planes.iterator();

        while(iter.hasNext()){
            Plane temp = iter.next();
            if (temp.getId() == item.getId()){
                iter.remove();
            }
        }
        this.planes.add(item);

        setChanged();
        notifyObservers(item);
    }

    @Override
    public List<Plane> query(Specification specification) throws RepositoryException{
        List<Plane> result = new ArrayList<>();

        try {
            for (Plane temp : planes) {
                if (specification.isSatisfiedBy(temp)) {
                    result.add(temp);
                }
            }
        }
        catch(SpecificationException e){
            log.error("error message" + "cannot query by specification");
            throw new RepositoryException("cannot query by specification", e);
        }
        return result;
    }

    public void sort(Comparator<Plane> comp) {
        this.planes.sort(comp);
    }

    @Override
    public void update(Observable o, Object arg) {
        Plane plane = (Plane) arg;

        this.update(plane);
    }
}
