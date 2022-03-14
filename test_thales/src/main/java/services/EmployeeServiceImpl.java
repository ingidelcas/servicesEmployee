package services;

import org.springframework.stereotype.Service;

import model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public long anualSalary(Employee employee) {
		return employee.getEmployee_salary()*12;
	}
	
	

}
