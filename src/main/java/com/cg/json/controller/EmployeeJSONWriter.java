package com.cg.json.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.Scanner;

import javax.json.Json;
import javax.json.stream.JsonGenerator;

import com.cg.json.pojo.Employee;

public class EmployeeJSONWriter {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of records required");
		int noOfEntries = scanner.nextInt();
		scanner.close();
		
		OutputStream fos = new FileOutputStream("employee.json"); 
		
		//Create generator instance
		JsonGenerator jsonGenerator = Json.createGenerator(fos);
		jsonGenerator.writeStartArray();
				
		for(int i = 1;i <= noOfEntries;i++) {
		Employee emp = createEmployee(i);  //Generate employee details for each employee
		
		jsonGenerator.writeStartObject();  //Write employee details into a json object
		jsonGenerator.write("id", emp.getEmpId()); 
		jsonGenerator.write("Fname", emp.getFname());
		jsonGenerator.write("Mname", emp.getMname());
		jsonGenerator.write("Lname", emp.getLname());
		jsonGenerator.write("doj", emp.getTimestamp());
		jsonGenerator.writeEnd();

		}
		
		jsonGenerator.writeEnd();
		jsonGenerator.close();
		System.out.println("File Successfully Created with "+noOfEntries+" records.");
	}

	public static Employee createEmployee(int i) {

		//To randomly generate timestamp between specified dates
		long offset = Timestamp.valueOf("2017-01-01 00:00:00").getTime();
		long end = Timestamp.valueOf("2019-01-01 00:00:00").getTime();
		long diff = end - offset + 1;

		Employee emp = new Employee();
		emp.setEmpId(i);
		emp.setFname("A"+i);
		emp.setMname("B"+i);
		emp.setLname("C"+i);
		Timestamp timestamp = new Timestamp(offset + (long) (Math.random() * diff));
		emp.setTimestamp(timestamp+"");
		return emp;
	}

}