package com.zyh.dao.menu;

import com.zyh.entity.menu.ZyhMenu;
import com.zyh.entity.menu.ZyhMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZyhMenuMapper {
    long countByExample(ZyhMenuExample example);

    int deleteByExample(ZyhMenuExample example);

    int deleteByPrimaryKey(String id);

    int insert(ZyhMenu record);

    int insertSelective(ZyhMenu record);

    List<ZyhMenu> selectByExample(ZyhMenuExample example);

    ZyhMenu selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ZyhMenu record, @Param("example") ZyhMenuExample example);

    int updateByExample(@Param("record") ZyhMenu record, @Param("example") ZyhMenuExample example);

    int updateByPrimaryKeySelective(ZyhMenu record);

    int updateByPrimaryKey(ZyhMenu record);
}