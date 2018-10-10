package com.zyh.entity.common;


public class Page {
	/**
	 * 数据总条数
	 */
	private long totalRowCount;
	/**
	 * 当前页码
	 */
	private int pageNum ;


	public long getTotalRowCount() {
		return totalRowCount;
	}

	public void setTotalRowCount(long totalRowCount) {
		this.totalRowCount = totalRowCount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}


}
