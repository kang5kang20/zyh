package com.zyh.service.study;

import java.util.List;
import java.util.Map;

import com.zyh.entity.menu.ZyhMenu;
import com.zyh.entity.menu.ZyhMenuExample;



public interface IMenuService {
	
	public void addMenu(ZyhMenu zyhMenu) throws Exception;
	
	public void updateMenu(ZyhMenu zyhMenu) throws Exception;
	
	public void deleteMenu(String menuid) throws Exception;
	
	public ZyhMenu findMenuById(String menuid) throws Exception;
	
	public List<ZyhMenu> findmenuList(ZyhMenuExample example) throws Exception;
	
	public Map findmenuListByPage(ZyhMenuExample example,
			int pageNum, int pageSize) throws Exception;
	
}
