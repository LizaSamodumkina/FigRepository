package by.etc.specification;

import by.etc.specification.exception.SpecificationException;

public interface Specification<T> {
    public boolean isSatisfiedBy(T obj) throws SpecificationException;
}
