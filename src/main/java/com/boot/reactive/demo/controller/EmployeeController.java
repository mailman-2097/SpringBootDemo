package com.boot.reactive.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.reactive.demo.model.EmployeeModel;
import com.boot.reactive.demo.service.EmployeeService;

@RestController
public class EmployeeController
{

	@Autowired
	private EmployeeService employeeService;
	
	
	///get-emp?reqId=1
	@RequestMapping(value = "/get-emp", params = "reqId", method = RequestMethod.GET)
	public List<EmployeeModel> getEmployee(@RequestParam String reqId) throws IOException
	{
		List<EmployeeModel> employeesList = new ArrayList<EmployeeModel>();
		employeesList.add(employeeService.getEmployeeRecord(new Integer(reqId)));
		return employeesList;
	}

//	///get-emp?reqId=1
//	@RequestMapping(value = "/get-emp", params = "reqId", method = RequestMethod.GET)
//	public ResponseEntity<byte[]> getEmployee(@RequestParam String reqId) throws IOException
//	{
//
//		ResponseEntity<byte[]> responseEntity = employeeService.getEmployeeRecord(new Integer(reqId));
//		return responseEntity;
//	}
	
	@RequestMapping("/list")
	public List<EmployeeModel> getAllEmployees() throws IOException
	{
		return employeeService.getAllEmployeeRecords();
	}
	
}	
