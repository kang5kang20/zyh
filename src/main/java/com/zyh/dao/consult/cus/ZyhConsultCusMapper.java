package com.zyh.dao.consult.cus;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zyh.entity.consult.ZyhConsult;
import com.zyh.entity.consult.ZyhConsultExample;

public interface ZyhConsultCusMapper {
		 List<ZyhConsult> selectByPageNumSize(
		            @Param("example") ZyhConsultExample example,
		            @Param("pageNumKey") int pageNum, 
		            @Param("pageSizeKey") int pageSize);
}