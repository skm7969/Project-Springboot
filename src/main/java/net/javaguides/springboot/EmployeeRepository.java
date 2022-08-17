package net.javaguides.springboot;

import net.javaguides.springboot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository <Employee, Long> {
 //all crud database methods
}



