package edu.spring.service.repositories;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import edu.spring.service.models.User;
import edu.spring.service.repositories.DataSource.*;

public class UsersRepositoryJdbcImpl implements UsersRepository {

    private Connection connection;

    public UsersRepositoryJdbcImpl(DataSource dataSource) throws SQLException {
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    @Override
    public Optional findByEmail(String email) throws SQLException {
        String query = "select * from database.users where email = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            Long id = resultSet.getLong("id");
            System.out.println("  id=" + id + ",\n" +
                    "  email=" + email + ",\n");
            return Optional.of(new User(id, email));
        } catch (SQLException exception) {
            throw new SQLException(exception);
        }
    }

    @Override
    public Optional findById(Long id) throws SQLException {
        String query = "select * from database.users where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String email = resultSet.getString("email");
            System.out.println("  id=" + id + ",\n" +
                    "  email=" + email + ",\n");
            return Optional.of(new User(id, email));
        } catch (SQLException exception) {
            throw new SQLException(exception);
        }
    }

    @Override
    public List findAll() throws SQLException {
        String query = "select * from database.users";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            List <User> listOfUsers = new ArrayList<>();
            while(resultSet.next()){
                System.out.println("  id=" + resultSet.getLong("id") + ",\n" +
                        "  email=" + resultSet.getString("email") + ",\n");
                listOfUsers.add(new User(resultSet.getLong("id"), resultSet.getString("email")));
            }
            return listOfUsers;
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }
}
