package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AjaxResponseBody;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import com.example.demo.exception.EmployeeException;
import com.example.demo.service.EmployeeService;

@RestController
public class AjaxController {

	@Autowired
	private EmployeeService empService;

	@PostMapping("/api/search")
    public ResponseEntity<?> getSearchResultViaAjax() {

        AjaxResponseBody result = new AjaxResponseBody();

//        //If error, just return a 400 bad request, along with the error message
//        if (errors.hasErrors()) {
//
//            return ResponseEntity.badRequest().body(result);
//
//        }

        List<EmployeeDto> employees = empService.getAllEmployees();
        if (employees.isEmpty()) {
            result.setMsg("no user found!");
        } else {
            result.setMsg("success");
        }
        result.setResult(employees);

        return ResponseEntity.ok(result);
    }

}
