package com.zyh.dao.resume;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zyh.entity.resume.ZyhResumeBase;
import com.zyh.entity.resume.ZyhResumeBaseExample;

public interface ZyhResumeBaseMapper {
    long countByExample(ZyhResumeBaseExample example);

    int deleteByExample(ZyhResumeBaseExample example);

    int deleteByPrimaryKey(String id);

    int insert(ZyhResumeBase record);

    int insertSelective(ZyhResumeBase record);

    List<ZyhResumeBase> selectByExample(ZyhResumeBaseExample example);

    ZyhResumeBase selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ZyhResumeBase record, @Param("example") ZyhResumeBaseExample example);

    int updateByExample(@Param("record") ZyhResumeBase record, @Param("example") ZyhResumeBaseExample example);

    int updateByPrimaryKeySelective(ZyhResumeBase record);

    int updateByPrimaryKey(ZyhResumeBase record);
    
    List<ZyhResumeBase> selectResumeBasePage(@Param("example") ZyhResumeBaseExample example,
			@Param("pageNumKey") int pageNum, @Param("pageSizeKey") int pageSize)throws Exception;
}