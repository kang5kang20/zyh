package com.zyh.dao.ad.cus;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zyh.entity.ad.ZyhAd;
import com.zyh.entity.ad.ZyhAdExample;

public interface ZyhAdCusMapper {
		 List<ZyhAd> selectByPageNumSize(
		            @Param("example") ZyhAdExample example,
		            @Param("pageNumKey") int pageNum, 
		            @Param("pageSizeKey") int pageSize);
}