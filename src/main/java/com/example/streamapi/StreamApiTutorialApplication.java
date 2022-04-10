package com.example.streamapi;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class StreamApiTutorialApplication {

	static List<Employee> employeeList=new ArrayList<>();

	static{
		employeeList.add(
				new Employee("Ankita","Singla",5500.0, Arrays.asList("Project 1","Project 3"))
		);

		employeeList.add(
				new Employee("Akhil","Singla",5000.0,Arrays.asList("Project 2", "Project 4"))
		);

		employeeList.add(
				new Employee("Rani","Singla",7000.0,Arrays.asList("Project 3", "Project 4"))
		);
	}

	public static void main(String[] args) {

		//foreach
		employeeList
				.stream()
				.forEach(System.out::println);

		//map
		//collect
		List<Employee> employeeIncrement=employeeList
				.stream()
				.map(employee -> new Employee(
						employee.getFirstName(),
						employee.getLastName(),
						employee.getSalary() * 1.10,
						employee.getProject()
				))
				.collect(Collectors.toList());

		System.out.println(employeeIncrement);

		//filter
		List<Employee> filteredList=employeeList
				.stream()
				.filter(employee -> employee.getSalary() > 5000.0)
				.map(employee -> new Employee(
						employee.getFirstName(),
						employee.getLastName(),
						employee.getSalary() * 1.10,
						employee.getProject()
				))
				.collect(Collectors.toList());

		System.out.println(filteredList);

		//findfirst
		Employee firstEmployee=employeeList
				.stream()
				.findFirst()
				.orElse(null);

		System.out.println(firstEmployee);

		//short circuit operations
		List<Employee> limitEmployee = employeeList
				.stream()
				.skip(1)
				.collect(Collectors.toList());

		System.out.println(limitEmployee);

		//finite Data
		Stream.generate(Math::random)
				.limit(5)
				.forEach(System.out::println);

		//sorting
		List<Employee> sortedList=employeeList
				.stream()
				.sorted((t1, t2) -> t1.getFirstName().compareToIgnoreCase(t2.getFirstName()))
				.collect(Collectors.toList());

		System.out.println(sortedList);

		//map
		List<List<String>> mapList=employeeList
				.stream()
				.map(Employee::getProject)
				.collect(Collectors.toList());

		System.out.println(mapList);

		//flatmap
		List<String> flatMapList=employeeList
				.stream()
				.map(Employee::getProject)
				.flatMap(Collection::stream)
				.collect(Collectors.toList());

		System.out.println(flatMapList);

		//flatmap
		String projectList=employeeList
				.stream()
				.map(Employee::getProject)
				.flatMap(Collection::stream)
				.distinct()
				.collect(Collectors.joining(","));

		System.out.println(projectList);

		//min or max
		Employee maxEmployee=employeeList
				.stream()
				.max(Comparator.comparing(Employee::getSalary))
				.orElse(null);

		System.out.println(maxEmployee);

		//reduce
		Double totalSalary=employeeList
				.stream()
				.map(Employee::getSalary)
				.reduce(0.0,Double::sum);

		System.out.println(totalSalary);
	}

}
