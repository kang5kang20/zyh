package com.zyh.dao.resume;

import com.zyh.entity.resume.ZyhResumeIntention;
import com.zyh.entity.resume.ZyhResumeIntentionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZyhResumeIntentionMapper {
    long countByExample(ZyhResumeIntentionExample example);

    int deleteByExample(ZyhResumeIntentionExample example);

    int deleteByPrimaryKey(String id);

    int insert(ZyhResumeIntention record);

    int insertSelective(ZyhResumeIntention record);

    List<ZyhResumeIntention> selectByExample(ZyhResumeIntentionExample example);

    ZyhResumeIntention selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ZyhResumeIntention record, @Param("example") ZyhResumeIntentionExample example);

    int updateByExample(@Param("record") ZyhResumeIntention record, @Param("example") ZyhResumeIntentionExample example);

    int updateByPrimaryKeySelective(ZyhResumeIntention record);

    int updateByPrimaryKey(ZyhResumeIntention record);
}