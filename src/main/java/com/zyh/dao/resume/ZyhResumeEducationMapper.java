package com.zyh.dao.resume;

import com.zyh.entity.resume.ZyhResumeEducation;
import com.zyh.entity.resume.ZyhResumeEducationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZyhResumeEducationMapper {
    long countByExample(ZyhResumeEducationExample example);

    int deleteByExample(ZyhResumeEducationExample example);

    int deleteByPrimaryKey(String id);

    int insert(ZyhResumeEducation record);

    int insertSelective(ZyhResumeEducation record);

    List<ZyhResumeEducation> selectByExample(ZyhResumeEducationExample example);

    ZyhResumeEducation selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ZyhResumeEducation record, @Param("example") ZyhResumeEducationExample example);

    int updateByExample(@Param("record") ZyhResumeEducation record, @Param("example") ZyhResumeEducationExample example);

    int updateByPrimaryKeySelective(ZyhResumeEducation record);

    int updateByPrimaryKey(ZyhResumeEducation record);
}