package edu.miu.cs489.lab1b;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import edu.miu.cs489.lab1b.model.Employee;
import edu.miu.cs489.lab1b.model.PensionPlan;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeePensionsMgmtApp {

    public static void main(String[] args) throws Exception {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1, "Daniel", "Agar", LocalDate.of(2018, 1, 17), new BigDecimal("105945.50")));
        employees.get(0).setPensionPlan(new PensionPlan("EX1089", LocalDate.of(2023, 1, 17), new BigDecimal("100.00")));

        Employee benard = new Employee(2, "Benard", "Shaw", LocalDate.of(2019, 4, 3), new BigDecimal("197750.00"));
        // Assuming Benard does not have a pension plan yet.
        employees.add(benard);

        employees.add(new Employee(3, "Carly", "Agar", LocalDate.of(2014, 5, 16), new BigDecimal("842000.75")));
        employees.get(2).setPensionPlan(new PensionPlan("SM2307", LocalDate.of(2019, 11, 4), new BigDecimal("1555.50")));

        Employee wesley = new Employee(4, "Wesley", "Schneider", LocalDate.of(2019, 5, 2), new BigDecimal("74500.00"));
        // Assuming Wesley does not have a pension plan yet.
        employees.add(wesley);

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String allEmployeesJson = mapper.writeValueAsString(employees
                .stream()
                .sorted(Comparator.comparing(Employee::getLastName)
                        .thenComparing(Employee::getYearlySalary).reversed())
                .collect(Collectors.toList()));

        System.out.println(allEmployeesJson);

        // For the Monthly Upcoming Enrollees report
        LocalDate nextMonth = LocalDate.now().plusMonths(1);
        String upcomingEnrolleesJson = mapper.writeValueAsString(employees
                .stream()
                .filter(e -> e.isEligibleForPension(nextMonth))
                .sorted(Comparator.comparing(Employee::getEmploymentDate))
                .collect(Collectors.toList()));

        System.out.println(upcomingEnrolleesJson);
    }
}
