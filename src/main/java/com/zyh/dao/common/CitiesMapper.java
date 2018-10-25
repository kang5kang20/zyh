package com.zyh.dao.common;

import com.zyh.entity.common.Cities;
import com.zyh.entity.common.CitiesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CitiesMapper {
    long countByExample(CitiesExample example);

    int deleteByExample(CitiesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Cities record);

    int insertSelective(Cities record);

    List<Cities> selectByExample(CitiesExample example);

    Cities selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Cities record, @Param("example") CitiesExample example);

    int updateByExample(@Param("record") Cities record, @Param("example") CitiesExample example);

    int updateByPrimaryKeySelective(Cities record);

    int updateByPrimaryKey(Cities record);
}