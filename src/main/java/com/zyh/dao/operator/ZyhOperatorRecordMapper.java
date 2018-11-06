package com.zyh.dao.operator;

import com.zyh.entity.operator.ZyhOperatorRecord;
import com.zyh.entity.operator.ZyhOperatorRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZyhOperatorRecordMapper {
    long countByExample(ZyhOperatorRecordExample example);

    int deleteByExample(ZyhOperatorRecordExample example);

    int deleteByPrimaryKey(String id);

    int insert(ZyhOperatorRecord record);

    int insertSelective(ZyhOperatorRecord record);

    List<ZyhOperatorRecord> selectByExample(ZyhOperatorRecordExample example);

    ZyhOperatorRecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ZyhOperatorRecord record, @Param("example") ZyhOperatorRecordExample example);

    int updateByExample(@Param("record") ZyhOperatorRecord record, @Param("example") ZyhOperatorRecordExample example);

    int updateByPrimaryKeySelective(ZyhOperatorRecord record);

    int updateByPrimaryKey(ZyhOperatorRecord record);
}