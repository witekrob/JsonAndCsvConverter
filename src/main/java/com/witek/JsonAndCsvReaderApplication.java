package com.witek;
import com.witek.model.Employee;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.witek.model.Employee;
import com.witek.service.ConvertJsonToEmployeesList;
import com.witek.service.SumOfWages;

@SpringBootApplication
public class JsonAndCsvReaderApplication {

	public static void main(String[] args) {
		
	ConvertJsonToEmployeesList 	jsonConverter = new ConvertJsonToEmployeesList();
	List<Employee> listOfEmployeesFromJson = jsonConverter.getListFromJson(); 
	SumOfWages getSumOfWages = new SumOfWages();
	
	String position = "Priest";
	
	Double sum = getSumOfWages.sumOfWagesAccordingToPositon(listOfEmployeesFromJson, position);
	System.out.println("Position : " + position + " : " +  sum);
	
	}

}
