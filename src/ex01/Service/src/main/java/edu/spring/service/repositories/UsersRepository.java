package edu.spring.service.repositories;

import java.sql.SQLException;
import java.util.Optional;

public interface UsersRepository<T> extends CrudRepository {
    Optional<T> findByEmail(String email) throws SQLException;
}
