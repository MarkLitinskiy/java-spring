package edu.spring.service.repositories;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface CrudRepository<T> {
    Optional<T> findById(Long id) throws SQLException;
    List<T> findAll() throws SQLException;

}
