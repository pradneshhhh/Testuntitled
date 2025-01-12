package org.example.streams;

import java.util.*;
import java.util.stream.Collectors;

public class Employee {
    private int id;

    private String name;

    private int age;

    private String gender;

    private String department;

    private int yearOfJoining;

    private double salary;

    public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary)
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    public String getGender()
    {
        return gender;
    }

    public String getDepartment()
    {
        return department;
    }

    public int getYearOfJoining()
    {
        return yearOfJoining;
    }

    public double getSalary()
    {
        return salary;
    }

    @Override
    public String toString()
    {
        return "Id : "+id
                +", Name : "+name
                +", age : "+age
                +", Gender : "+gender
                +", Department : "+department
                +", Year Of Joining : "+yearOfJoining
                +", Salary : "+salary;
    }

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

        //How many male and female employees are there in the organization?
        Map<String, Long> countOfMaleAndFemale = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("How many male and female employees are there in the organization? "+countOfMaleAndFemale.toString());

        //Print the name of all departments in the organization?
        System.out.println("Print the name of all departments in the organization?");
        employeeList.stream().map(Employee::getDepartment).collect(Collectors.toSet()).forEach(System.out::println);

        //What is the average age of male and female employees?
        Map<String, Double> avgAgeOfMaleAndFemale = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        System.out.println("What is the average age of male and female employees? "+avgAgeOfMaleAndFemale.toString());

        //Get the details of highest paid employee in the organization?
        Optional<Employee> employeeMaxSalary = employeeList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
        System.out.println("Get the details of highest paid employee in the organization? "+employeeMaxSalary.get().toString());

        //Get the names of all employees who have joined after 2015?
        List<String> employeesWhoJoinedAfter2k15 = employeeList.stream().filter(employee -> employee.getYearOfJoining() > 2015).map(Employee::getName).collect(Collectors.toList());
        System.out.println("Get the names of all employees who have joined after 2015? "+employeesWhoJoinedAfter2k15.toString());

        //Count the number of employees in each department?
        Map<String, Long> countOfEmpInDept = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println("Count the number of employees in each department? "+countOfEmpInDept.toString());

        //What is the average salary of each department?
        Map<String, Double> avgSalaryByDept = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("What is the average salary of each department? "+avgSalaryByDept.toString());
        
        //Get the details of youngest male employee in the product development department?
        Optional<Employee> productDevelopmentMinAge = employeeList.stream().filter(employee -> employee.getDepartment().equals("Product Development") && employee.getGender().equals("Male")).collect(Collectors.minBy(Comparator.comparingInt(Employee::getAge)));
        System.out.println("Get the details of youngest male employee in the product development department? "+productDevelopmentMinAge.get().toString());

        //Who has the most working experience in the organization?
        Optional<Employee> employeeWithMaxExp = employeeList.stream().collect(Collectors.minBy(Comparator.comparingInt(Employee::getYearOfJoining)));
        System.out.println("Who has the most working experience in the organization? "+employeeWithMaxExp.get().toString());

        //How many male and female employees are there in the sales and marketing team?
        Map<String, Long> salesAndMarketingDemographics = employeeList.stream().filter(employee -> employee.getDepartment().equals("Sales And Marketing")).collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("How many male and female employees are there in the sales and marketing team? "+salesAndMarketingDemographics.toString());

        //What is the average salary of male and female employees?
        Map<String, Double> avgSalaryByGender = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("What is the average salary of male and female employees? "+avgSalaryByGender.toString());

        //List down the names of all employees in each department?
        Map<String, List<Employee>> empByDept = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println("List down the names of all employees in each department? ");

        //What is the average salary and total salary of the whole organization?
        DoubleSummaryStatistics salaryStats = employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("What is the average salary and total salary of the whole organization? "+salaryStats.getAverage()+" "+salaryStats.getSum());

        //Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
        Map<Boolean, List<Employee>> partitionedByAge = employeeList.stream().collect(Collectors.partitioningBy(employee -> employee.getAge() <= 25));
        System.out.println("Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years. "+partitionedByAge.toString());
        
        //Who is the oldest employee in the organization? What is his age and which department he belongs to?
        Optional<Employee> oldestEmployee = employeeList.stream().collect(Collectors.maxBy(Comparator.comparingInt(Employee::getAge)));
        System.out.println("Who is the oldest employee in the organization? What is his age and which department he belongs to? "+oldestEmployee.get().toString());
    }
}
