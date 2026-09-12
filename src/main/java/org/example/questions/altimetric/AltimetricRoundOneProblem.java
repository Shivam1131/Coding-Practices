package org.example.questions.altimetric;


import java.util.*;
import java.util.stream.Collectors;

public class AltimetricRoundOneProblem {

    static class Employee {
        int id;
        String name;
        String department;
        double salary;
        public Employee(int id, String name, String department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }
        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", department='" + department + '\'' +
                    ", salary=" + salary +
                    '}';
        }

    }
    public static void main(String[] args) {


            List<Map<String, Object>> employees = Arrays.asList(
                    Map.of("id", 1, "name", "A", "department", "IT", "salary", 50000.0),
                    Map.of("id", 2, "name", "B", "department", "IT", "salary", 60000.0),
                    Map.of("id", 3, "name", "C", "department", "HR", "salary", 40000.0),
                    Map.of("id", 4, "name", "D", "department", "HR", "salary", 45000.0),
                    Map.of("id", 5, "name", "E", "department", "Finance", "salary", 70000.0)
            );

            Map<String, DoubleSummaryStatistics> result = employees.stream()
                    .collect(Collectors.groupingBy(
                            e -> (String) e.get("department"),
                            Collectors.summarizingDouble(
                                    e -> (Double) e.get("salary")
                            )
                    ));
        result.forEach((k,v) ->System.out.println(k+" =>  "+result.get(k)));
            /*result.forEach((department, stats) -> {
                System.out.println(
                        department +
                                " -> totalEmployees=" + stats.getCount() +
                                ", totalSalary=" + stats.getSum() +
                                ", avgSalary=" + stats.getAverage()
                );
            });
*/


/*
// 3 departments // findout
        output : {
            Finance={totalEmployees=1.0, totalSalary=70000.0, avgSalary=70000.0},
                    IT={totalEmployees=2.0, totalSalary=110000.0, avgSalary=55000.0},
                    HR={totalEmployees=2.0, totalSalary=85000.0, avgSalary=42500.0}
        }

*/

        List<Integer> numbers =
                Arrays.asList(10, 20, 30, 40, 50, 40, 30);

        System.out.println(numbers.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().get());
        HashSet<Integer> elements = new HashSet<>();
        HashSet<Integer> duplicateElements = new HashSet<>();

        numbers.forEach(number -> {
            if (!elements.add(number)) {
                duplicateElements.add(number);
            }
        });

        System.out.println(duplicateElements);
        String str = "programming";

        System.out.println(Arrays.stream(str.split("")).collect(Collectors.groupingBy(c-> c, Collectors.counting())));


        List<Employee> emps = Arrays.asList(
                new Employee(1, "A", "IT", 50000),
                new Employee(2, "B", "IT", 60000),
                new Employee(3, "C", "HR", 40000),
                new Employee(4, "D", "HR", 45000),
                new Employee(5, "E", "Finance", 70000)
        );

        Map<String, List<Employee>> empMap = emps.stream()
                .collect(Collectors.groupingBy(e->e.department));
        for(Map.Entry<String, List<Employee>> entry : empMap.entrySet()) {
            System.out.println(
                entry
            );
        }



















    }
}
