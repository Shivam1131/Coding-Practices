package org.example.java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8StreamPractice {

    public static void main(String[] args) {

        List<Integer> numbers =
                Arrays.asList(10, 20, 30, 20, 40, 10, 50, 15, 25);

        // =========================================================
        // 1. FILTER EVEN NUMBERS
        // =========================================================

        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(evenNumbers);

        // Answer:
        // [10, 20, 30, 20, 40, 10, 50]


        // =========================================================
        // 2. SECOND HIGHEST NUMBER
        // =========================================================

        Integer secondHighest = numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(null);

        System.out.println(secondHighest);

        // Answer:
        // 40


        // =========================================================
        // 3. FIND DUPLICATES
        // =========================================================

        Set<Integer> seen = new HashSet<>();

        Set<Integer> duplicates = numbers.stream()
                .filter(n -> !seen.add(n))
                .collect(Collectors.toSet());

        System.out.println(duplicates);

        // Answer:
        // [20, 10]


        // =========================================================
        // 4. FIND UNIQUE / REMOVE DUPLICATES
        // =========================================================

        List<Integer> unique = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println(unique);

        // Answer:
        // [10, 20, 30, 40, 50, 15, 25]


        // =========================================================
        // 5. MAXIMUM NUMBER
        // =========================================================

        Integer max = numbers.stream()
                .max(Integer::compareTo)
                .orElse(null);

        System.out.println(max);

        // Answer:
        // 50


        // =========================================================
        // 6. MINIMUM NUMBER
        // =========================================================

        Integer min = numbers.stream()
                .min(Integer::compareTo)
                .orElse(null);

        System.out.println(min);

        // Answer:
        // 10


        // =========================================================
        // 7. SUM
        // =========================================================

        int sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println(sum);

        // Answer:
        // 220


        // =========================================================
        // 8. AVERAGE
        // =========================================================

        double average = numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);

        System.out.println(average);

        // Answer:
        // 24.444444444444443


        // =========================================================
        // 9. SORT ASCENDING
        // =========================================================

        List<Integer> ascending = numbers.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(ascending);

        // Answer:
        // [10, 10, 15, 20, 20, 25, 30, 40, 50]


        // =========================================================
        // 10. SORT DESCENDING
        // =========================================================

        List<Integer> descending = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        System.out.println(descending);

        // Answer:
        // [50, 40, 30, 25, 20, 20, 15, 10, 10]


        // =========================================================
        // 11. PARTITION EVEN AND ODD
        // =========================================================

        Map<Boolean, List<Integer>> evenOdd = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        System.out.println(evenOdd);

        // Answer:
        // true  -> even numbers
        // false -> odd numbers


        // =========================================================
        // 12. NUMBERS STARTING WITH 1
        // =========================================================

        List<Integer> startsWithOne = numbers.stream()
                .filter(n -> String.valueOf(n).startsWith("1"))
                .collect(Collectors.toList());

        System.out.println(startsWithOne);

        // Answer:
        // [10, 10, 15]


        // =========================================================
        // 13. FLATTEN LIST OF LISTS
        // =========================================================

        List<List<Integer>> nested =
                Arrays.asList(
                        Arrays.asList(1, 2),
                        Arrays.asList(3, 4),
                        Arrays.asList(5, 6)
                );

        List<Integer> flattened = nested.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        System.out.println(flattened);

        // Answer:
        // [1, 2, 3, 4, 5, 6]


        // =========================================================
        // 14. MERGE TWO LISTS
        // =========================================================

        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);

        List<Integer> merged = java.util.stream.Stream
                .concat(list1.stream(), list2.stream())
                .collect(Collectors.toList());

        System.out.println(merged);

        // Answer:
        // [1, 2, 3, 4, 5, 6]


        // =========================================================
        // 15. MERGE TWO LISTS AND REMOVE DUPLICATES
        // =========================================================

        List<Integer> a = Arrays.asList(1, 2, 3, 4);
        List<Integer> b = Arrays.asList(3, 4, 5, 6);

        List<Integer> mergedUnique = java.util.stream.Stream
                .concat(a.stream(), b.stream())
                .distinct()
                .collect(Collectors.toList());

        System.out.println(mergedUnique);

        // Answer:
        // [1, 2, 3, 4, 5, 6]


        // =========================================================
        // 16. CHARACTER FREQUENCY
        // =========================================================

        String str = "programming";

        Map<Character, Long> frequency = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ));

        System.out.println(frequency);

        // Answer:
        // {p=1, r=2, o=1, g=2, a=1, m=2, i=1, n=1}


        // =========================================================
        // 17. FIRST NON-REPEATED CHARACTER
        // =========================================================

        Character firstNonRepeated = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        System.out.println(firstNonRepeated);

        // Answer:
        // p


        // =========================================================
        // 18. WORD FREQUENCY
        // =========================================================

        String sentence = "java spring java kafka spring java";

        Map<String, Long> wordFrequency =
                Arrays.stream(sentence.split(" "))
                        .collect(Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        ));

        System.out.println(wordFrequency);

        // Answer:
        // java   = 3
        // spring = 2
        // kafka  = 1


        // =========================================================
        // EMPLOYEE STREAM PROBLEMS
        // =========================================================

        List<Employee> employees = Arrays.asList(

                new Employee(1, "Amit", "IT", "Male", 90000, 30),
                new Employee(2, "Neha", "HR", "Female", 60000, 28),
                new Employee(3, "Rahul", "IT", "Male", 120000, 35),
                new Employee(4, "Priya", "HR", "Female", 70000, 32),
                new Employee(5, "John", "Finance", "Male", 80000, 40)
        );


        // =========================================================
        // 19. SORT EMPLOYEES BY NAME
        // =========================================================

        employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .forEach(System.out::println);

        // Answer order:
        // Amit
        // John
        // Neha
        // Priya
        // Rahul


        // =========================================================
        // 20. SORT EMPLOYEES BY SALARY DESCENDING
        // =========================================================

        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary)
                        .reversed())
                .forEach(System.out::println);

        // Answer order:
        // Rahul = 120000
        // Amit  = 90000
        // John  = 80000
        // Priya = 70000
        // Neha  = 60000


        // =========================================================
        // 21. GROUP EMPLOYEES BY DEPARTMENT
        // =========================================================

        Map<String, List<Employee>> byDepartment =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment
                        ));

        System.out.println(byDepartment);

        // Answer:
        // IT      -> Amit, Rahul
        // HR      -> Neha, Priya
        // Finance -> John


        // =========================================================
        // 22. AVERAGE SALARY PER DEPARTMENT
        // =========================================================

        Map<String, Double> averageSalary =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.averagingDouble(Employee::getSalary)
                        ));

        System.out.println(averageSalary);

        // Answer:
        // IT      = 105000
        // HR      = 65000
        // Finance = 80000


        // =========================================================
        // 23. HIGHEST PAID EMPLOYEE PER DEPARTMENT
        // =========================================================

        Map<String, Optional<Employee>> highestPaid =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.maxBy(
                                        Comparator.comparingDouble(
                                                Employee::getSalary
                                        )
                                )
                        ));

        System.out.println(highestPaid);

        // Answer:
        // IT      -> Rahul
        // HR      -> Priya
        // Finance -> John


        // =========================================================
        // 24. EMPLOYEES SALARY > 80000
        // =========================================================

        List<Employee> highSalaryEmployees =
                employees.stream()
                        .filter(e -> e.getSalary() > 80000)
                        .collect(Collectors.toList());

        System.out.println(highSalaryEmployees);

        // Answer:
        // Amit
        // Rahul


        // =========================================================
        // 25. YOUNGEST EMPLOYEE
        // =========================================================

        Employee youngest = employees.stream()
                .min(Comparator.comparingInt(Employee::getAge))
                .orElse(null);

        System.out.println(youngest);

        // Answer:
        // Neha - age 28


        // =========================================================
        // 26. OLDEST EMPLOYEE
        // =========================================================

        Employee oldest = employees.stream()
                .max(Comparator.comparingInt(Employee::getAge))
                .orElse(null);

        System.out.println(oldest);

        // Answer:
        // John - age 40


        // =========================================================
        // 27. LIST<Employee> TO MAP
        // =========================================================

        Map<Integer, Employee> employeeMap =
                employees.stream()
                        .collect(Collectors.toMap(
                                Employee::getId,
                                Function.identity()
                        ));

        System.out.println(employeeMap);

        // Answer:
        // Key   -> employee id
        // Value -> Employee object


        // =========================================================
        // 28. GROUP BY DEPARTMENT THEN GENDER
        // =========================================================

        Map<String, Map<String, List<Employee>>> deptGender =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.groupingBy(Employee::getGender)
                        ));

        System.out.println(deptGender);

        // Answer structure:
        //
        // IT
        //   Male -> Amit, Rahul
        //
        // HR
        //   Female -> Neha, Priya
        //
        // Finance
        //   Male -> John
    }
}


class Employee {

    private int id;
    private String name;
    private String department;
    private String gender;
    private double salary;
    private int age;

    public Employee(int id,
                    String name,
                    String department,
                    String gender,
                    double salary,
                    int age) {

        this.id = id;
        this.name = name;
        this.department = department;
        this.gender = gender;
        this.salary = salary;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getGender() {
        return gender;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + " - " + department +
                " - " + salary +
                " - age " + age;
    }
}