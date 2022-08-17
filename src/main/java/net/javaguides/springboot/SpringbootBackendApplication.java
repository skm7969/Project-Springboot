package net.javaguides.springboot;

import net.javaguides.springboot.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
		Employee employee = new Employee();
		employee.setFirstname("Subrat");
		employee.setLastname("Mishra");
		employee.setEmailid("subrat@gmail.com");
		employeeRepository.save(employee);

		Employee employee1 = new Employee();
		employee.setFirstname("John");
		employee.setLastname("Cena");
		employee.setEmailid("cena@gmail.com");
		employeeRepository.save(employee1);
	}

}
