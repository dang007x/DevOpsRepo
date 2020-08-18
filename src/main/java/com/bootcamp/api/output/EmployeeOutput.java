package com.bootcamp.api.output;


import java.util.List;

import com.bootcamp.dto.EmployeeDTO;

public class EmployeeOutput extends BaseOutput<EmployeeDTO>{
	@Override
	public void setListResult(List<EmployeeDTO> listResult) {
		super.setListResult(listResult);
	}
}
