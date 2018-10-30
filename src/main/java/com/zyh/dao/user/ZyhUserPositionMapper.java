package com.zyh.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zyh.controller.user.vo.UserPostVO;
import com.zyh.entity.user.ZyhUserPosition;
import com.zyh.entity.user.ZyhUserPositionExample;

public interface ZyhUserPositionMapper {
    long countByExample(ZyhUserPositionExample example);

    int deleteByExample(ZyhUserPositionExample example);

    int deleteByPrimaryKey(String id);

    int insert(ZyhUserPosition record);

    int insertSelective(ZyhUserPosition record);

    List<ZyhUserPosition> selectByExample(ZyhUserPositionExample example);

    ZyhUserPosition selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ZyhUserPosition record, @Param("example") ZyhUserPositionExample example);

    int updateByExample(@Param("record") ZyhUserPosition record, @Param("example") ZyhUserPositionExample example);

    int updateByPrimaryKeySelective(ZyhUserPosition record);

    int updateByPrimaryKey(ZyhUserPosition record);
    
    List<ZyhUserPosition> selectUserPostByPage(@Param("example") ZyhUserPositionExample example,
			@Param("pageNumKey") int pageNum, @Param("pageSizeKey") int pageSize)throws Exception;
    
    
    List<UserPostVO> selectUserPostPositionByPage(@Param("example") ZyhUserPositionExample example,
			@Param("pageNumKey") int pageNum, @Param("pageSizeKey") int pageSize)throws Exception;
    
    List<UserPostVO> selectUserPostTrainByPage(@Param("example") ZyhUserPositionExample example,
			@Param("pageNumKey") int pageNum, @Param("pageSizeKey") int pageSize)throws Exception;
    
    
}