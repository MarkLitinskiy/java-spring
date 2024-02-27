package edu.spring.service.application;

import edu.spring.service.repositories.UsersRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
            UsersRepository usersRepository = context.getBean("usersRepositoryJdbc", UsersRepository.class);
            System.out.println(usersRepository.findById(2L));
        usersRepository = context.getBean("usersRepositoryJdbcTemplate", UsersRepository.class);
        System.out.println(usersRepository.findById(2L));
        } catch (SQLException exception){
            System.err.println(exception.getErrorCode());
        }
    }
}