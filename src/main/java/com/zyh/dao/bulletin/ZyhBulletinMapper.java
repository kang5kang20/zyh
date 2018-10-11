package com.zyh.dao.bulletin;

import com.zyh.entity.bulletin.ZyhBulletin;
import com.zyh.entity.bulletin.ZyhBulletinExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZyhBulletinMapper {
    long countByExample(ZyhBulletinExample example);

    int deleteByExample(ZyhBulletinExample example);

    int deleteByPrimaryKey(String id);

    int insert(ZyhBulletin record);

    int insertSelective(ZyhBulletin record);

    List<ZyhBulletin> selectByExample(ZyhBulletinExample example);

    ZyhBulletin selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ZyhBulletin record, @Param("example") ZyhBulletinExample example);

    int updateByExample(@Param("record") ZyhBulletin record, @Param("example") ZyhBulletinExample example);

    int updateByPrimaryKeySelective(ZyhBulletin record);

    int updateByPrimaryKey(ZyhBulletin record);
}