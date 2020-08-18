package com.bootcamp.api.output;

import java.util.List;

import com.bootcamp.dto.EmployeeLiteDTO;

public class EmployeeLiteOutput extends BaseOutput<EmployeeLiteDTO>{
	@Override
	public void setListResult(List<EmployeeLiteDTO> listResult) {
		super.setListResult(listResult);
	}
}
