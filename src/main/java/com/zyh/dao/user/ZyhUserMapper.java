package com.zyh.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zyh.entity.user.ZyhUser;
import com.zyh.entity.user.ZyhUserExample;

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
    
    List<ZyhUser> selectUserByPage(@Param("example") ZyhUserExample example,
			@Param("pageNumKey") int pageNum, @Param("pageSizeKey") int pageSize)throws Exception;
}