package com.zyh.dao.company;

import com.zyh.entity.company.ZyhCompanyPosition;
import com.zyh.entity.company.ZyhCompanyPositionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZyhCompanyPositionMapper {
    long countByExample(ZyhCompanyPositionExample example);

    int deleteByExample(ZyhCompanyPositionExample example);

    int deleteByPrimaryKey(String id);

    int insert(ZyhCompanyPosition record);

    int insertSelective(ZyhCompanyPosition record);

    List<ZyhCompanyPosition> selectByExample(ZyhCompanyPositionExample example);

    ZyhCompanyPosition selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ZyhCompanyPosition record, @Param("example") ZyhCompanyPositionExample example);

    int updateByExample(@Param("record") ZyhCompanyPosition record, @Param("example") ZyhCompanyPositionExample example);

    int updateByPrimaryKeySelective(ZyhCompanyPosition record);

    int updateByPrimaryKey(ZyhCompanyPosition record);
}