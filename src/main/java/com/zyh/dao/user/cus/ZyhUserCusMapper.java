package com.zyh.dao.user.cus;

import java.util.List;
import java.util.Map;

import com.zyh.entity.user.ZyhUser;

public interface ZyhUserCusMapper {
	List<ZyhUser> selectUserByExample(Map<String, Object> map);
}
