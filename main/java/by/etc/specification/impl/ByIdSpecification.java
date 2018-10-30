package by.etc.specification.impl;

import by.etc.entity.Plane;
import by.etc.specification.MemorySpecification;

public class ByIdSpecification implements MemorySpecification<Plane> {
    private int id;

    public ByIdSpecification(int id) {
        this.id = id;
    }

    @Override
    public boolean isSatisfiedBy(Plane obj) {
        return id == obj.getId();
    }
}
