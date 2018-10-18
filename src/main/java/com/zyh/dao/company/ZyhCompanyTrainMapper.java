package com.zyh.dao.company;

import com.zyh.entity.company.ZyhCompanyTrain;
import com.zyh.entity.company.ZyhCompanyTrainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZyhCompanyTrainMapper {
    long countByExample(ZyhCompanyTrainExample example);

    int deleteByExample(ZyhCompanyTrainExample example);

    int deleteByPrimaryKey(String id);

    int insert(ZyhCompanyTrain record);

    int insertSelective(ZyhCompanyTrain record);

    List<ZyhCompanyTrain> selectByExample(ZyhCompanyTrainExample example);

    ZyhCompanyTrain selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ZyhCompanyTrain record, @Param("example") ZyhCompanyTrainExample example);

    int updateByExample(@Param("record") ZyhCompanyTrain record, @Param("example") ZyhCompanyTrainExample example);

    int updateByPrimaryKeySelective(ZyhCompanyTrain record);

    int updateByPrimaryKey(ZyhCompanyTrain record);
}