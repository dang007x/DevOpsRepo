package com.bootcamp.api.output;

import java.util.List;

import com.bootcamp.dto.DepartmentDTO;

public class DepartmentOutput extends BaseOutput<DepartmentDTO>{
	@Override
	public void setListResult(List<DepartmentDTO> listResult) {
		super.setListResult(listResult);
	}
}
