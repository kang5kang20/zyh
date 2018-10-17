package com.zyh.dao.ad;

import com.zyh.entity.ad.ZyhAd;
import com.zyh.entity.ad.ZyhAdExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZyhAdMapper {
    long countByExample(ZyhAdExample example);

    int deleteByExample(ZyhAdExample example);

    int deleteByPrimaryKey(String id);

    int insert(ZyhAd record);

    int insertSelective(ZyhAd record);

    List<ZyhAd> selectByExample(ZyhAdExample example);

    ZyhAd selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ZyhAd record, @Param("example") ZyhAdExample example);

    int updateByExample(@Param("record") ZyhAd record, @Param("example") ZyhAdExample example);

    int updateByPrimaryKeySelective(ZyhAd record);

    int updateByPrimaryKey(ZyhAd record);
}