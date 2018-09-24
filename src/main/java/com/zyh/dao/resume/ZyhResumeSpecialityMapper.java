package com.zyh.dao.resume;

import com.zyh.entity.resume.ZyhResumeSpeciality;
import com.zyh.entity.resume.ZyhResumeSpecialityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZyhResumeSpecialityMapper {
    long countByExample(ZyhResumeSpecialityExample example);

    int deleteByExample(ZyhResumeSpecialityExample example);

    int deleteByPrimaryKey(String id);

    int insert(ZyhResumeSpeciality record);

    int insertSelective(ZyhResumeSpeciality record);

    List<ZyhResumeSpeciality> selectByExample(ZyhResumeSpecialityExample example);

    ZyhResumeSpeciality selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ZyhResumeSpeciality record, @Param("example") ZyhResumeSpecialityExample example);

    int updateByExample(@Param("record") ZyhResumeSpeciality record, @Param("example") ZyhResumeSpecialityExample example);

    int updateByPrimaryKeySelective(ZyhResumeSpeciality record);

    int updateByPrimaryKey(ZyhResumeSpeciality record);
}