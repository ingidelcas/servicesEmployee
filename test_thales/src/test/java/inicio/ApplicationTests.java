package inicio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import model.Employee;
import services.EmployeeService;

@AutoConfigureMockMvc
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class ApplicationTests {
	
	@Autowired
	MockMvc mock;
	
	@Autowired
	EmployeeService service;

	@Test
	@Order(1)
	void getAllEmployees() throws Exception {
		mock.perform(get("/employees")).andDo(print());
	}
	
	@Test
	@Order(2)
	void getEmployeeById()throws Exception {
		mock.perform(get("/employees/1")).andDo(print());
	}
	
	@Test
	@Order(3)
	void getAnualSalary() {
		Employee employee = new Employee(13,"Charde Marshall", 470600, 36, "", 0);
		assertEquals(5647200, service.anualSalary(employee));
    
	}

}
