package com.zyh.dao.user;

import com.zyh.entity.company.ZyhCompanyTrainExample;
import com.zyh.entity.user.ZyhUserPosition;
import com.zyh.entity.user.ZyhUserPositionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZyhUserPositionMapper {
    long countByExample(ZyhUserPositionExample example);

    int deleteByExample(ZyhUserPositionExample example);

    int deleteByPrimaryKey(String id);

    int insert(ZyhUserPosition record);

    int insertSelective(ZyhUserPosition record);

    List<ZyhUserPosition> selectByExample(ZyhUserPositionExample example);

    ZyhUserPosition selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ZyhUserPosition record, @Param("example") ZyhUserPositionExample example);

    int updateByExample(@Param("record") ZyhUserPosition record, @Param("example") ZyhUserPositionExample example);

    int updateByPrimaryKeySelective(ZyhUserPosition record);

    int updateByPrimaryKey(ZyhUserPosition record);
    
    List<ZyhUserPosition> selectUserPostByPage(@Param("example") ZyhUserPositionExample example,
			@Param("pageNumKey") int pageNum, @Param("pageSizeKey") int pageSize)throws Exception;
}