package controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import Dto.GetAllEmployeeResponseDto;
import Dto.GetEmployeeIdResponse;
import model.Employee;
import services.EmployeeService;



@RestController
public class EmployeeController {
	
	@Autowired
	RestTemplate template;
	
	@Autowired
	EmployeeService service;
	
	String urlJWT = "http://localhost:8080/";
	String urlService = "http://dummy.restapiexample.com/api/v1/";
	String user = "admin";
	String pwd = "admin";
	String token;
	HttpHeaders headers=new HttpHeaders();
	
	/*@PostConstruct
	public void autenticar() {
		token=template.postForObject(urlJWT+"/login?user="+user+"&pwd="+pwd, null, String.class);
		headers.add("Authorization", "Bearer "+token);
		System.out.println(token);
	}*/
	
	@GetMapping(value = "/employees",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getAllEmployees(){
		
		GetAllEmployeeResponseDto rp = template.getForObject(urlService+"/employees",GetAllEmployeeResponseDto.class);
		Employee[] employees = rp.getData();
		return Arrays.stream(employees)
				.peek((e)-> {
					e.setEmployee_anual_salary(service.anualSalary(e));
				})
				.collect(Collectors.toList());
				
		
	}
	
	@GetMapping(value = "/employee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee serchEmployeeById(@PathVariable("id") int id){
		
		GetEmployeeIdResponse  rp = template.getForObject(urlService+"/employee/"+ id,GetEmployeeIdResponse.class);
		rp.getData().setEmployee_anual_salary(service.anualSalary(rp.getData()));
		return rp.getData(); 
	}

}
