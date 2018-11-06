package com.zyh.service.study;

import java.util.List;

import com.zyh.entity.lanmu.ZyhLanmu;
import com.zyh.entity.lanmu.ZyhLanmuExample;


public interface ILanmuService {
	public void addLanmu(ZyhLanmu zyhLanmu) throws Exception;
	
	public void updateLanmu(ZyhLanmu zyhLanmu) throws Exception;
	
	public void deleteLanmu(String lanmuid) throws Exception;
	
	public ZyhLanmu findLanmuById(String lanmuid) throws Exception;
	
	public List<ZyhLanmu> findLanmuList(ZyhLanmuExample example) throws Exception;
}
