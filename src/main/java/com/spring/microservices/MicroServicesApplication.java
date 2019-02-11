package com.spring.microservices;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.kafka.core.KafkaTemplate;
import com.spring.microservices.entities.DepartmentEntity;
import com.spring.microservices.entities.EmployeeEntity;
import com.spring.microservices.entities.RoleEntity;
import com.spring.microservices.entities.UserEntity;
import com.spring.microservices.operations.CommonOperation;
import com.spring.microservices.repositories.EmployeeRepo;
import com.spring.microservices.repositories.UserRepository;
import com.spring.microservices.services.EmployeeService;
import com.spring.microservices.services.UserService;

/**
 * @author sunilsingh
 */
@SpringBootApplication
// @EnableAspectJAutoProxy
public class MicroServicesApplication implements CommandLineRunner {

	@Autowired
	UserService userService;
	@Autowired
	UserRepository userRepository;
	int count = 0;
	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Autowired
	CommonOperation commonOperation;

	public static void main(String[] args) {
		SpringApplication.run(MicroServicesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Set<RoleEntity> userRole = new HashSet<>();
		Set<UserEntity> userSet = new HashSet<>();

		UserEntity userEntity = new UserEntity();
		userEntity.setEnabled('T');
		userEntity.setUserName("Sunil");
		userEntity.setPassword("Sunil@1234");
		userSet.add(userEntity);

		RoleEntity roleEntity = new RoleEntity();
		roleEntity.setRoleName("ADMIN");
		roleEntity.setUserEntity(userSet);

		userRole.add(roleEntity);
		userEntity.setRole(userRole);

		// userService.saveUser(userEntity);

		// userService.deleteUser(userService.findUserById(5));

		// System.out.println(userRepository.isUserExist("Sunil", "Sunil@1234"));

		// ExecutorService executor = Executors.newFixedThreadPool(4);
		//
		// for (EmployeeEntity employee : getAllEmployeeInfo()) {
		// Runnable worker = new EmployeeTask(employee, employeeService);
		// executor.execute(worker);
		// }
		// executor.shutdown();
		// // Wait until all threads are finish
		// while (!executor.isTerminated()) {
		//
		// }
		// System.out.println("\nFinished all threads");
		//
		// List<EmployeeEntity> employeeList =
		// employeeRepo.findEmployeeByName("ANDERSON");
		// employeeList.forEach(emp -> System.out.println(emp.getEmpName() + "\t" +
		// emp.getJobTitle() + "\t"
		// + emp.getDepartment().getDeptName() + "\t" +
		// emp.getDepartment().getAnnualSalary()));
		//
		// // POLICE
		//
		// List<DepartmentEntity> deptList =
		// commonOperation.findDepartmentByName("POLICE");
		// deptList.forEach(dept -> System.out
		// .println(dept.getDeptName() + "\t" + dept.getAnnualSalary() + "\t" +
		// dept.getEmployee().getEmpName()));

		System.out.println(employeeRepo.jobTitleById(1575));

		List<Object[]> values = employeeRepo.getEmployeeNameAndDeptNameById(1575);
		for (Object[] str : values) {
			System.out.println((String) str[0]);
			System.out.println((String) str[1]);
		}

	}

	public List<EmployeeEntity> getAllEmployeeInfo() throws IOException {

		List<EmployeeEntity> employeeList = new ArrayList<>();
		Files.lines(Paths.get("D:/workspace/nous-documents/Employees.csv"), StandardCharsets.UTF_8).forEach(s -> {
			System.out.println(s);
			String employeeRecord[] = s.split(",");
			String empName;
			String jobTitle;
			String deptName;
			String annualSalary;
			String estAnnSalMinusFur;

			if (count != 0) {
				try {
					if (employeeRecord.length == 8) {
						empName = employeeRecord[0].substring(1)
								+ employeeRecord[1].substring(0, employeeRecord[1].length() - 1);
						jobTitle = employeeRecord[2];
						deptName = employeeRecord[3];
						annualSalary = employeeRecord[4].substring(1)
								+ employeeRecord[5].substring(0, employeeRecord[5].length() - 1);
						estAnnSalMinusFur = employeeRecord[6].substring(1)
								+ employeeRecord[7].substring(0, employeeRecord[7].length() - 1);

					} else if (employeeRecord.length == 7) {
						empName = employeeRecord[0].substring(1);
						jobTitle = employeeRecord[1];
						deptName = employeeRecord[2];
						annualSalary = employeeRecord[3].substring(1)
								+ employeeRecord[4].substring(0, employeeRecord[4].length() - 1);
						estAnnSalMinusFur = employeeRecord[5].substring(1)
								+ employeeRecord[6].substring(0, employeeRecord[6].length() - 1);
					} else {
						empName = employeeRecord[0].substring(1);
						jobTitle = employeeRecord[1];
						deptName = employeeRecord[2];
						annualSalary = employeeRecord[3].substring(1, employeeRecord[3].length() - 1);
						estAnnSalMinusFur = employeeRecord[4].substring(1, employeeRecord[4].length() - 1);
					}

					EmployeeEntity employee = new EmployeeEntity();
					DepartmentEntity department = new DepartmentEntity();
					employee.setEmpName(empName);
					employee.setJobTitle(jobTitle);
					department.setDeptName(deptName);
					department.setAnnualSalary(annualSalary);
					department.setEstAnnualSalMinusFur(estAnnSalMinusFur);
					employee.setDepartment(department);
					employeeList.add(employee);
				} catch (Exception e) {
					// TODO: handle exception
				}
			} else {
				count++;
			}
		});

		return employeeList;

	}

}
