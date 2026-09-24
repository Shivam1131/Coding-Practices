import test.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Employee> empList = new ArrayList<>();
        //String name, Integer age, Double salary, String department
        empList.add(new Employee("Sadashiv", 35, 35000D, "Engineering"));
        empList.add(new Employee("Shivam", 36, 31000D, "Engineering"));
        empList.add(new Employee("Rahul", 39, 25000D, "Engineering"));

        empList.add(new Employee("Vikas", 31, 45000D, "HR"));
        empList.add(new Employee("Abhishek", 34, 35000D, "HR"));
        empList.add(new Employee("Varad", 30, 25000D, "HR"));

       // System.out.println(empList);

        System.out.print(empList.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.collectingAndThen(Collectors.toList(),
                        list->list.stream().mapToDouble(Employee::getSalary).max()))));


        System.out.print(empList.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.collectingAndThen(Collectors.toList(),
                        list -> {
                            Double secondHighestSalary = list.stream()
                                    .map(e -> e.getSalary()).sorted(Comparator.reverseOrder()).skip(1).findFirst().get();

                            return list.stream().filter(e -> e.getSalary().equals(secondHighestSalary)).collect(Collectors.toSet());
                        }))));

        // Employee ->  name, age, salary , department
        //  highest salary for each department
        //  second highest salary

        System.out.println("Hello");
    }
}
