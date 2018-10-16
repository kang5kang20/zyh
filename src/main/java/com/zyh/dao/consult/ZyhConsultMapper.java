package com.zyh.dao.consult;

import com.zyh.entity.consult.ZyhConsult;
import com.zyh.entity.consult.ZyhConsultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZyhConsultMapper {
    long countByExample(ZyhConsultExample example);

    int deleteByExample(ZyhConsultExample example);

    int deleteByPrimaryKey(String id);

    int insert(ZyhConsult record);

    int insertSelective(ZyhConsult record);

    List<ZyhConsult> selectByExample(ZyhConsultExample example);

    ZyhConsult selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ZyhConsult record, @Param("example") ZyhConsultExample example);

    int updateByExample(@Param("record") ZyhConsult record, @Param("example") ZyhConsultExample example);

    int updateByPrimaryKeySelective(ZyhConsult record);

    int updateByPrimaryKey(ZyhConsult record);
}