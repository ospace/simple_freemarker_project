package com.tistory.ospace.simplefreemarker.repository;

public class PaginationDto {
	private int pageNo = 1;
	private int size = 10;
	private int limit = 10;
	private int total;
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTotalPage() {
		return (int) Math.ceil((double)getTotal()/(double)getLimit());
	}
	public int getIndexPage() {
		return (getPageNo() - 1)/getSize();
	}
	public int getStartPage() {
		return getIndexPage() * getSize() + 1;
	}
	public int getEndPage() {
		return Math.min((getIndexPage()+1)*getSize(), getTotalPage());
	}
	public int getOffset() {
		return (getPageNo() - 1) * getLimit();
	}
}
