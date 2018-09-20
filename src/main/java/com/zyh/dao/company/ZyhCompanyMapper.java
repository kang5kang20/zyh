package com.zyh.dao.company;

import com.zyh.entity.company.ZyhCompany;
import com.zyh.entity.company.ZyhCompanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZyhCompanyMapper {
    long countByExample(ZyhCompanyExample example);

    int deleteByExample(ZyhCompanyExample example);

    int deleteByPrimaryKey(String id);

    int insert(ZyhCompany record);

    int insertSelective(ZyhCompany record);

    List<ZyhCompany> selectByExample(ZyhCompanyExample example);

    ZyhCompany selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ZyhCompany record, @Param("example") ZyhCompanyExample example);

    int updateByExample(@Param("record") ZyhCompany record, @Param("example") ZyhCompanyExample example);

    int updateByPrimaryKeySelective(ZyhCompany record);

    int updateByPrimaryKey(ZyhCompany record);
}