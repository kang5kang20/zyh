package com.zyh.dao.classcourse;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zyh.entity.classcourse.ZyhClassCourse;
import com.zyh.entity.classcourse.ZyhClassCourseExample;

public interface ZyhClassCourseMapper {
    long countByExample(ZyhClassCourseExample example);

    int deleteByExample(ZyhClassCourseExample example);

    int deleteByPrimaryKey(String id);

    int insert(ZyhClassCourse record);

    int insertSelective(ZyhClassCourse record);

    List<ZyhClassCourse> selectByExample(ZyhClassCourseExample example);

    ZyhClassCourse selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ZyhClassCourse record, @Param("example") ZyhClassCourseExample example);

    int updateByExample(@Param("record") ZyhClassCourse record, @Param("example") ZyhClassCourseExample example);

    int updateByPrimaryKeySelective(ZyhClassCourse record);

    int updateByPrimaryKey(ZyhClassCourse record);
    
    List<ZyhClassCourse> selectByPageNumSize(
            @Param("example") ZyhClassCourseExample example,
            @Param("pageNumKey") int pageNum, 
            @Param("pageSizeKey") int pageSize);
}