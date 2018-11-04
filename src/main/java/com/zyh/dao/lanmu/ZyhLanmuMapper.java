package com.zyh.dao.lanmu;

import com.zyh.entity.lanmu.ZyhLanmu;
import com.zyh.entity.lanmu.ZyhLanmuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZyhLanmuMapper {
    long countByExample(ZyhLanmuExample example);

    int deleteByExample(ZyhLanmuExample example);

    int deleteByPrimaryKey(String id);

    int insert(ZyhLanmu record);

    int insertSelective(ZyhLanmu record);

    List<ZyhLanmu> selectByExample(ZyhLanmuExample example);

    ZyhLanmu selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ZyhLanmu record, @Param("example") ZyhLanmuExample example);

    int updateByExample(@Param("record") ZyhLanmu record, @Param("example") ZyhLanmuExample example);

    int updateByPrimaryKeySelective(ZyhLanmu record);

    int updateByPrimaryKey(ZyhLanmu record);
}