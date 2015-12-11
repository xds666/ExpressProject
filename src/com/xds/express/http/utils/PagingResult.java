package com.xds.express.http.utils;

import java.io.Serializable;

/*
 * 分页请求类
 */

public class PagingResult implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int allPageNum;		//总页数
	private int currentPageNum;	//当前页码
	private int totalCount;		//总记录数
	
	
	public int getAllPageNum() {
		return allPageNum;
	}
	public void setAllPageNum(int allPageNum) {
		this.allPageNum = allPageNum;
	}
	public int getCurrentPageNum() {
		return currentPageNum;
	}
	public void setCurrentPageNum(int currentPageNum) {
		this.currentPageNum = currentPageNum;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	public boolean hasNextPage(){
		return currentPageNum < allPageNum;
	}
}
