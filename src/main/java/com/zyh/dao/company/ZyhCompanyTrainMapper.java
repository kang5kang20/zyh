package com.zyh.dao.company;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zyh.entity.company.ZyhCompanyTrain;
import com.zyh.entity.company.ZyhCompanyTrainExample;

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
    
    List<ZyhCompanyTrain> selectTrainByPage(@Param("example") ZyhCompanyTrainExample example,
			@Param("pageNumKey") int pageNum, @Param("pageSizeKey") int pageSize)throws Exception;
}