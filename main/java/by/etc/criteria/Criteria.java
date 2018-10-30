package by.etc.criteria;

import java.util.HashMap;
import java.util.Map;

public class Criteria <T> {

    private Class<T> groupSearchName;
    private Map<T, Object> criteria = new HashMap<T, Object>();

    public Criteria(Class<T> groupSearchName){
        this.groupSearchName = groupSearchName;
    }

    public Class<T> getGroupSearchName(){
        return groupSearchName;
    }

    public void add(T searchCriteria, Object value){
        criteria.put(searchCriteria, value);
    }

    public int size(){
        return criteria.size();
    }

    public Map<T, Object> getCriteria() {
        return criteria;
    }
}
