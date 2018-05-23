package com.joylink.userms.vo.client;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class PageVO implements Serializable {
	
	private int pageNum = 1;
	
	private int pageSize = 10;
	
	private long total;
	
	@SuppressWarnings("rawtypes")
	private List list;
	
	public PageVO() {}

	public PageVO(int pageNum2, int pageSize2, long total2) {
		this.pageNum = pageNum2;
		this.pageSize = pageSize2;
		this.total = total2;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	@SuppressWarnings("rawtypes")
	public List getList() {
		return list;
	}

	public void setList(@SuppressWarnings("rawtypes") List list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "PageVO [pageNum=" + pageNum + ", pageSize=" + pageSize + ", total=" + total + "]";
	}
	
}
