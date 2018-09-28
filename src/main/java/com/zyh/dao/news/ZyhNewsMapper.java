package com.zyh.dao.news;

import com.zyh.entity.news.ZyhNews;
import com.zyh.entity.news.ZyhNewsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZyhNewsMapper {
    long countByExample(ZyhNewsExample example);

    int deleteByExample(ZyhNewsExample example);

    int deleteByPrimaryKey(String id);

    int insert(ZyhNews record);

    int insertSelective(ZyhNews record);

    List<ZyhNews> selectByExample(ZyhNewsExample example);

    ZyhNews selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ZyhNews record, @Param("example") ZyhNewsExample example);

    int updateByExample(@Param("record") ZyhNews record, @Param("example") ZyhNewsExample example);

    int updateByPrimaryKeySelective(ZyhNews record);

    int updateByPrimaryKey(ZyhNews record);
}