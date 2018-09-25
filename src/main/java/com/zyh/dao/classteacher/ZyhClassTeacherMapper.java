package com.zyh.dao.classteacher;

import com.zyh.entity.classteacher.ZyhClassTeacher;
import com.zyh.entity.classteacher.ZyhClassTeacherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZyhClassTeacherMapper {
    long countByExample(ZyhClassTeacherExample example);

    int deleteByExample(ZyhClassTeacherExample example);

    int deleteByPrimaryKey(String id);

    int insert(ZyhClassTeacher record);

    int insertSelective(ZyhClassTeacher record);

    List<ZyhClassTeacher> selectByExample(ZyhClassTeacherExample example);

    ZyhClassTeacher selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ZyhClassTeacher record, @Param("example") ZyhClassTeacherExample example);

    int updateByExample(@Param("record") ZyhClassTeacher record, @Param("example") ZyhClassTeacherExample example);

    int updateByPrimaryKeySelective(ZyhClassTeacher record);

    int updateByPrimaryKey(ZyhClassTeacher record);
}