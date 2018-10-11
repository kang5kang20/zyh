package com.zyh.dao.bulletin.cus;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zyh.entity.bulletin.ZyhBulletin;
import com.zyh.entity.bulletin.ZyhBulletinExample;

public interface ZyhBulletinCusMapper {
	 List<ZyhBulletin> selectByPageNumSize(
	            @Param("example") ZyhBulletinExample example,
	            @Param("pageNumKey") int pageNum, 
	            @Param("pageSizeKey") int pageSize);
}