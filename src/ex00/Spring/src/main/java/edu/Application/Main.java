package edu.Application;

import edu.Printer.Printer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Printer printer = context.getBean("printerWithDataTimeImpl", Printer.class);
        printer.print("Hello!");
    }
}