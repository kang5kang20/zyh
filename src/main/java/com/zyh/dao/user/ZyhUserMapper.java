package com.zyh.dao.user;

import com.zyh.entity.user.ZyhUser;
import com.zyh.entity.user.ZyhUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZyhUserMapper {
    long countByExample(ZyhUserExample example);

    int deleteByExample(ZyhUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(ZyhUser record);

    int insertSelective(ZyhUser record);

    List<ZyhUser> selectByExample(ZyhUserExample example);

    ZyhUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ZyhUser record, @Param("example") ZyhUserExample example);

    int updateByExample(@Param("record") ZyhUser record, @Param("example") ZyhUserExample example);

    int updateByPrimaryKeySelective(ZyhUser record);

    int updateByPrimaryKey(ZyhUser record);
}