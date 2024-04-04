package edu.miu.cs489.lab1b;

import edu.miu.cs489.lab1b.model.Employee;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class EmployeePensionsMgmtApp {

    public static void main(String[] args) {
        System.out.println("Hello Maven");
        var employees = List.of(
                new Employee(1L, "Daniel", "Agar", LocalDate.of(2018,1,17), 105_945.50, "EX1089", LocalDate.of(2023,1,17), 100.00),
                new Employee(2L, "Bernard", "Shaw", LocalDate.of(2019,4,3), 197_750.50, null, null, null),
                new Employee(3L, "Carly", "Agar", LocalDate.of(2014,5,16), 842_000.75, "SM2307", LocalDate.of(2019,11,4), 1555.50),
                new Employee(4L, "Wesley", "Schneider", LocalDate.of(2019,5,2), 74_500.00, null, null, null)
        );

        printAllEmployees(employees);
        printMonthlyUpcomingEnrollees(employees);

    }

    private static void printAllEmployees(List<Employee> employees) {
        System.out.println("======== Printing All Employees ========");
        employees.stream()
                .sorted(Comparator.comparing(Employee::getLastName).thenComparing(Employee::getYearlySalary,
                        Comparator.reverseOrder()))
                .forEach(System.out::println);
    }

    private static void printMonthlyUpcomingEnrollees(List<Employee> employees) {
        System.out.println("======== Printing Upcoming Enrollees ========");
        // TODO Sort
        employees.stream().filter(Employee::isUpcomingEnrollee)
                .forEach(System.out::println);
    }
}
