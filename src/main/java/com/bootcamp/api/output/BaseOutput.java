package com.bootcamp.api.output;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseOutput<T> {
	private int currentPage;
	private int totalPage;
	private List<T> listResult = new ArrayList<T>();
	
	
	public int getCurrentPage() {
		return currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public List<T> getListResult() {
		return listResult;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public void setListResult(List<T> listResult) {
		this.listResult = listResult;
	}
	
}
