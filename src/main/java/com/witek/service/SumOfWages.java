package com.witek.service;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.type.MapType;
import com.witek.model.Employee;


public class SumOfWages {

public double sumOfWagesAccordingToPositon(List<Employee> employees, String position ) {
double sum;	
sum = employees.stream().filter(x->x.getJob().equals(position)).mapToDouble(Employee::getSalary).sum();

return sum;	
}
	
}
