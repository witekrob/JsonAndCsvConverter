package com.witek.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.witek.model.Employee;

public class ConvertJsonToEmployeesList {
			
		JSONParser parser = new JSONParser();
		JSONObject object = null;
		Employee employee = new Employee();
		List<Employee> employeesList = new ArrayList<Employee>();

		public List<Employee> getListFromJson() { 
		
		JSONObject fromParser = new JSONObject();
		try {
			fromParser = (JSONObject) parser.parse(new FileReader("employees.json"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONArray employees = (JSONArray) fromParser.get("employees");

		for (Object o : employees) {
			object = (JSONObject) o;
			String name = (String) object.get("name");
			String surname = (String) object.get("surname");
			String job = (String) object.get("job");
			String salaryAsString = (String) object.get("salary");
			String formattedSalary = salaryAsString.replaceAll(",", ".");

			float salary = 0;
			try {
				salary = Float.parseFloat(formattedSalary);
			} catch (NumberFormatException nfe) {
				nfe.printStackTrace();
			}

			employee = new Employee(name, surname, job, salary);
			employeesList.add(employee);
			
		}
		System.out.println(employeesList);
		return employeesList;
	}
}