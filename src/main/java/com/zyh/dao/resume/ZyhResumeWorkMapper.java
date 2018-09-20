package com.zyh.dao.resume;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zyh.entity.resume.ZyhResumeWork;
import com.zyh.entity.resume.ZyhResumeWorkExample;

public interface ZyhResumeWorkMapper {
    long countByExample(ZyhResumeWorkExample example);

    int deleteByExample(ZyhResumeWorkExample example);

    int deleteByPrimaryKey(String id);

    int insert(ZyhResumeWork record);

    int insertSelective(ZyhResumeWork record);

    List<ZyhResumeWork> selectByExample(ZyhResumeWorkExample example);

    ZyhResumeWork selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ZyhResumeWork record, @Param("example") ZyhResumeWorkExample example);

    int updateByExample(@Param("record") ZyhResumeWork record, @Param("example") ZyhResumeWorkExample example);

    int updateByPrimaryKeySelective(ZyhResumeWork record);

    int updateByPrimaryKey(ZyhResumeWork record);
}