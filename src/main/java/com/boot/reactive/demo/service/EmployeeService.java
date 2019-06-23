package com.boot.reactive.demo.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.boot.reactive.demo.dao.EmployeeDAO;
import com.boot.reactive.demo.entity.EmployeeBean;
import com.boot.reactive.demo.model.EmployeeModel;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDAO;

	private static final ModelMapper modelMapper = new ModelMapper();

	public EmployeeModel getEmployeeRecord(Integer i) throws IOException {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		return modelMapper.map(employeeDAO.findEmployeeById(i), EmployeeModel.class);
	}

	public List<EmployeeModel> getAllEmployeeRecords() throws IOException {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		List<EmployeeModel> employeesList = new ArrayList<EmployeeModel>();
		List<EmployeeBean> results = employeeDAO.findAllEmployees();
		for(EmployeeBean record : results) {
			employeesList.add(modelMapper.map(record, EmployeeModel.class));
		}
		return employeesList;
	}
	
	public ResponseEntity<byte[]> getUnusedEmployeeRecord(Integer i) throws IOException {

		EmployeeBean employeeRecord = employeeDAO.findEmployeeById(i);
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<byte[]>(employeeRecord.toString().getBytes(), headers, HttpStatus.OK);
		
	}
}
