package by.etc.repository;

import by.etc.repository.exception.RepositoryException;
import by.etc.specification.Specification;

import java.util.List;

public interface Repository <T> {
    void add(T item);
    void add(Iterable<T> items);
    void delete(T item);
    void delete(Specification specification) throws RepositoryException;
    void update(T item);
    List<T> query(Specification specification) throws RepositoryException;
}
