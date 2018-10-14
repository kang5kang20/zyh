package com.zyh.dao.policy;

import com.zyh.entity.policy.ZyhPolicy;
import com.zyh.entity.policy.ZyhPolicyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZyhPolicyMapper {
    long countByExample(ZyhPolicyExample example);

    int deleteByExample(ZyhPolicyExample example);

    int deleteByPrimaryKey(String id);

    int insert(ZyhPolicy record);

    int insertSelective(ZyhPolicy record);

    List<ZyhPolicy> selectByExample(ZyhPolicyExample example);

    ZyhPolicy selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ZyhPolicy record, @Param("example") ZyhPolicyExample example);

    int updateByExample(@Param("record") ZyhPolicy record, @Param("example") ZyhPolicyExample example);

    int updateByPrimaryKeySelective(ZyhPolicy record);

    int updateByPrimaryKey(ZyhPolicy record);
    
    List<ZyhPolicy> selectByPageNumSize(
            @Param("example") ZyhPolicyExample example,
            @Param("pageNumKey") int pageNum, 
            @Param("pageSizeKey") int pageSize);
}