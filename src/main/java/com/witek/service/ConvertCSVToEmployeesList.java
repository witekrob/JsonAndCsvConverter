package com.witek.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.witek.model.Employee;

public class ConvertCSVToEmployeesList {
	
	
public List<Employee> convertCSVtoEmployeesList () { 	
	String file = "employees.csv";

	
BufferedReader br;
try {
	br = new BufferedReader(new FileReader(file));


CSVReader cRead = new CSVReader(br);
cRead.readNext();
List<String[]> ss = cRead.readAll();

for (String[] s : ss) {
for (int i=0;i<ss.get(0).length;i++) {
	System.out.println(ss.get(i)[0]);
}

}
}catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

br.close();
}
}
}
}