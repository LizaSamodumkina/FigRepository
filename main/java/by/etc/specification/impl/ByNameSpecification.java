package by.etc.specification.impl;

import by.etc.entity.Plane;
import by.etc.specification.MemorySpecification;

public class ByNameSpecification implements MemorySpecification<Plane> {
    private String name;

    public ByNameSpecification(String name) {
        this.name = name;
    }

    @Override
    public boolean isSatisfiedBy(Plane obj) {
        return name == obj.getName();
    }
}
