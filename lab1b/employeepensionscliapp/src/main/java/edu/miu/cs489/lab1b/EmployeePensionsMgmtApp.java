package edu.miu.cs489.lab1b;

public class EmployeePensionsMgmtApp {

    public class Main {
        public static void main(String[] args) throws Exception {
            List<Employee> employees = new ArrayList<>();  // Populate with sample data

            // Implement the JSON printing and sorting logic here
            ObjectMapper mapper = new ObjectMapper();
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
}
