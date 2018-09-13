package com.zyh.dao.util;

import java.util.UUID;

public class UUidUtil {
	
	public static String getUUid(){
		UUID uuid = UUID.randomUUID();
		String id = uuid.toString().replaceAll("-", "");
		return id;
	}
}
