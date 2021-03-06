package Exam2020.Services;

import Exam2020.Models.Supervisor;

import java.util.List;
import java.util.Optional;

public interface CRUDService<T, ID> {
    List<T> findAll();
    List<T> findByName(String name);
    T save(T object);
    void delete(T object);
    void deleteById(ID id);
    Optional<T> findById(ID id);
}
