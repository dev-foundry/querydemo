package pl.devfoundry.querydemo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.devfoundry.querydemo.domain.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByName(String name);


    @Query("Select e from Employee e WHERE e.name like CONCAT(:firstLetter,'%')")
    List<Employee> findByFirstLetter(@Param("firstLetter") String letter);

}
