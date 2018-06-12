package pl.devfoundry.querydemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.devfoundry.querydemo.domain.Employee;
import pl.devfoundry.querydemo.domain.repository.EmployeeRepository;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class DataLoader {

    @Autowired
    EmployeeRepository employeeRepository;

    @PostConstruct
    public void init() {
        System.out.println("Database operations");
        employeeRepository.save(new Employee("Pawel", 32));

        find();
    }

    private void find() {
        List<Employee> pawels = employeeRepository.findByFirstLetter("P");

        pawels.forEach(System.out::println);
    }

}