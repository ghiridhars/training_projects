package com.example.demo.dto;

import java.util.List;

public class AjaxResponseBody {

	private String msg;
	private List<EmployeeDto> result;

	public List<EmployeeDto> getResult() {
		return result;
	}

	public void setResult(List<EmployeeDto> result) {
		this.result = result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
