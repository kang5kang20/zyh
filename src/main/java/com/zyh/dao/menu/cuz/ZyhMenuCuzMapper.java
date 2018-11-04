package com.zyh.dao.menu.cuz;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zyh.entity.menu.ZyhMenu;
import com.zyh.entity.menu.ZyhMenuExample;

public interface ZyhMenuCuzMapper {
	 List<ZyhMenu> selectByPageNumSize(
	            @Param("example") ZyhMenuExample example,
	            @Param("pageNumKey") int pageNum, 
	            @Param("pageSizeKey") int pageSize);
}