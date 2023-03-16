

package com.ecommerce.common.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 分页工具类
 */
public class PageUtils implements Serializable {
	private static final long serialVersionUID = 1L;
	private int total;
	private int pageSize;
	private int totalPage;
	private int current;
	private List<?> list;
	public PageUtils(List<?> list, int totalCount, int pageSize, int currPage) {
		this.list = list;
		this.total = totalCount;
		this.pageSize = pageSize;
		this.current = currPage;
		this.totalPage = (int)Math.ceil((double)totalCount/pageSize);
	}
	public PageUtils(IPage<?> page) {
		this.list = page.getRecords();
		this.total = (int)page.getTotal();
		this.pageSize = (int)page.getSize();
		this.current = (int)page.getCurrent();
		this.totalPage = (int)page.getPages();
	}

	public static void fontEndToBackendFormat(Map<String, Object> params) {
		if (params.containsKey("current")) {
			params.put("curPage", params.get("current"));
		}
		if (params.containsKey("pageSize")) {
			params.put("limit", params.get("pageSize"));
		}
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}
	
}
