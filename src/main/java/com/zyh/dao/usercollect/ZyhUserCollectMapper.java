package com.zyh.dao.usercollect;

import com.zyh.entity.usercollect.ZyhUserCollect;
import com.zyh.entity.usercollect.ZyhUserCollectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZyhUserCollectMapper {
    long countByExample(ZyhUserCollectExample example);

    int deleteByExample(ZyhUserCollectExample example);

    int deleteByPrimaryKey(String id);

    int insert(ZyhUserCollect record);

    int insertSelective(ZyhUserCollect record);

    List<ZyhUserCollect> selectByExample(ZyhUserCollectExample example);

    ZyhUserCollect selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ZyhUserCollect record, @Param("example") ZyhUserCollectExample example);

    int updateByExample(@Param("record") ZyhUserCollect record, @Param("example") ZyhUserCollectExample example);

    int updateByPrimaryKeySelective(ZyhUserCollect record);

    int updateByPrimaryKey(ZyhUserCollect record);
}