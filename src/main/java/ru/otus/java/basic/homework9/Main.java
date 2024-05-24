package ru.otus.java.basic.homework9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Main {
  public static void main(String[] args) {
    ArrayList<Integer> arrayList = arrayListMinMax(5, 7);

    System.out.println(arrayList);
    System.out.println(sumListElementsMoreFive(arrayList));
    fillListNumber(23, arrayList);
    System.out.println(arrayList);
    addNumberList(14, arrayList);
    System.out.println(arrayList);

    List<Employee> employees = Arrays.asList(
            new Employee("Ivan", 34),
            new Employee("Igor", 29),
            new Employee("Mariya", 22),
            new Employee("Anton", 25)
    );

    System.out.println(listEmployeeNames(employees));
    System.out.println(listEmployeesMoreAge(employees, 26));
    System.out.println(isEmployeesAgeMoreAverage(employees, 26));
    System.out.println(youngEmployee(employees));
  }

  private static ArrayList<Integer> arrayListMinMax(int min, int max) {
    ArrayList<Integer> list = new ArrayList<>();

    for (int i = min; i <= max; i++) {
      list.add(i);
    }

    return list;
  }

  private static int sumListElementsMoreFive(List<Integer> list) {
    int sum = 0;

    for (int valueElement : list) {
      if (valueElement > 5) {
        sum += valueElement;
      }
    }

    return sum;
  }

  private static void fillListNumber(Integer number, List<Integer> list) {
    for (int i = 0; i < list.size(); i++) {
      list.set(i, number);
    }
  }

  private static void addNumberList(Integer number, List<Integer> list) {
    for (int i = 0; i < list.size(); i++) {
      list.set(i, list.get(i) + number);
    }
  }

  private static List<String> listEmployeeNames(List<Employee> list) {
    List<String> names = new ArrayList<>();

    for (Employee employee : list) {
      names.add(employee.getName());
    }

    return names;
  }

  private static List<Employee> listEmployeesMoreAge(List<Employee> list, int minAge) {
    List<Employee> employees = new ArrayList<>();

    for (Employee employee : list) {
      if (employee.getAge() >= minAge) {
        employees.add(employee);
      }
    }

    return employees;
  }

  private static boolean isEmployeesAgeMoreAverage(List<Employee> list, int averageAge) {
    int generalAge = 0;

    for (Employee employee : list) {
      generalAge += employee.getAge();
    }

    return generalAge / list.size() > averageAge;
  }

  private static Employee youngEmployee(List<Employee> list) {
    Employee emp = list.get(0);
    int age = list.get(0).getAge();

    for (Employee employee : list) {
      if (employee.getAge() < age) {
        age = employee.getAge();
        emp = employee;
      }
    }

    return emp;
  }
}
