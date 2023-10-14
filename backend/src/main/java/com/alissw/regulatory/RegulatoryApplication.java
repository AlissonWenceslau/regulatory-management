package com.alissw.regulatory;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alissw.regulatory.entities.Category;
import com.alissw.regulatory.entities.Employee;
import com.alissw.regulatory.entities.EmployeeTraining;
import com.alissw.regulatory.entities.Position;
import com.alissw.regulatory.entities.Training;
import com.alissw.regulatory.repositories.CategoryRepository;
import com.alissw.regulatory.repositories.EmployeeRepository;
import com.alissw.regulatory.repositories.EmployeeTrainingRepository;
import com.alissw.regulatory.repositories.PositionRepository;
import com.alissw.regulatory.repositories.TrainingRepository;

@SpringBootApplication
public class RegulatoryApplication implements CommandLineRunner{

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private TrainingRepository trainingRepository;
	@Autowired
	private PositionRepository positionRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private EmployeeTrainingRepository employeeTrainingRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(RegulatoryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category c1 = new Category(null, "NR11");
		Category c2 = new Category(null, "NR12");
		
		Training t1 = new Training(null, "Operação de Paleteira Elétrica");
		Training t2 = new Training(null, "Operação de Talha Elétrica");
		Training t3 = new Training(null, "Operação e Manutenção de Máquinas");
		
		c1.getTrainings().addAll(Arrays.asList(t1,t2));
		c2.getTrainings().addAll(Arrays.asList(t3));
		t1.setCategory(c1);
		t2.setCategory(c1);
		t3.setCategory(c2);
		
		categoryRepository.saveAll(Arrays.asList(c1,c2));
		trainingRepository.saveAll(Arrays.asList(t1,t2,t3));
		
		Position p1 = new Position(null, "Supervisor");
		Position p2 = new Position(null, "Preparador");
		Position p3 = new Position(null, "Operador de Manufatura");
		Employee e1 = new Employee(null, 14290L, "Alisson", "Wenceslau", 996872155L, 47, 974327563L);
		Employee e2 = new Employee(null, 13898L, "João", "Silva", 97654345L, 47, 987654321L);
		Employee e3 = new Employee(null, 13520L, "Manuel", "Carvalho", 96321320L, 47, 987654321L);
		Employee e4 = new Employee(null, 22990L, "Fabio", "Constantino", 873450985434L, 48, 98645211L);
		Employee e5 = new Employee(null, 30988L, "Ana", "Domingues", 76459832351L, 47, 96543897L);
		
		p1.getEmployees().addAll(Arrays.asList(e1, e4));
		p2.getEmployees().addAll(Arrays.asList(e2));
		p3.getEmployees().addAll(Arrays.asList(e5));
		e1.setPosition(p1);
		e2.setPosition(p2);
		e2.setManager(e1);
		e3.setPosition(p2);
		e3.setManager(e1);
		e4.setPosition(p1);
		e5.setPosition(p3);
		e5.setManager(e4);
		
		
		positionRepository.saveAll(Arrays.asList(p1, p2, p3));
		employeeRepository.saveAll(Arrays.asList(e1, e2, e3, e4, e5));
		
		//Employee e1
		EmployeeTraining et1 = new EmployeeTraining(e1, t1, Instant.parse("2022-04-03T00:00:00Z"), Instant.parse("2025-04-03T00:00:00Z"));
		EmployeeTraining et2 = new EmployeeTraining(e1, t2, Instant.parse("2022-05-12T00:00:00Z"), Instant.parse("2025-05-12T00:00:00Z"));
		
		//Employee e2
		EmployeeTraining et3 = new EmployeeTraining(e2, t1, Instant.parse("2019-05-12T00:00:00Z"), Instant.parse("2022-05-12T00:00:00Z"));
		EmployeeTraining et4 = new EmployeeTraining(e2, t2, Instant.parse("2023-06-13T00:00:00Z"), Instant.parse("2026-06-13T00:00:00Z"));
		EmployeeTraining et5 = new EmployeeTraining(e2, t3, Instant.parse("2023-07-18T00:00:00Z"), Instant.parse("2026-08-18T00:00:00Z"));
		
		//Employee e3
		EmployeeTraining et6 = new EmployeeTraining(e3, t2, Instant.parse("2023-06-13T00:00:00Z"), Instant.parse("2026-06-13T00:00:00Z"));
		EmployeeTraining et7 = new EmployeeTraining(e3, t3, Instant.parse("2022-05-03T00:00:00Z"), Instant.parse("2025-05-03T00:00:00Z"));
		EmployeeTraining et8 = new EmployeeTraining(e3, t1, Instant.parse("2023-07-18T00:00:00Z"), Instant.parse("2026-07-18T00:00:00Z"));
		
		//Employee 5 (O 4 não tem treinamento)
		EmployeeTraining et9 = new EmployeeTraining(e5, t1, Instant.parse("2023-07-18T00:00:00Z"), Instant.parse("2026-07-18T00:00:00Z"));
		
		e1.getEmployees().addAll(Arrays.asList(et1, et2));
		e2.getEmployees().addAll(Arrays.asList(et3, et4, et5));
		e3.getEmployees().addAll(Arrays.asList(et6, et7, et8));
		e5.getEmployees().addAll(Arrays.asList(et9));
		
		t1.getTrainings().addAll(Arrays.asList(et1, et3, et8, et9));
		t2.getTrainings().addAll(Arrays.asList(et2, et4, et6));
		t3.getTrainings().addAll(Arrays.asList(et5, et7));
		
		employeeTrainingRepository.saveAll(Arrays.asList(et1, et2, et3, et4, et5, et6, et7, et8, et9));
	}

}
