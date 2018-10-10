package com.zyh.service.news;

import java.util.List;
import java.util.Map;

import com.zyh.entity.news.ZyhNews;
import com.zyh.entity.news.ZyhNewsExample;


public interface INewsService {
	
	public void addNews(ZyhNews zyhNews) throws Exception;
	
	public void updateNews(ZyhNews zyhNews) throws Exception;
	
	public void deleteNews(String newsid) throws Exception;
	
	public ZyhNews queryNewsById(String newsid) throws Exception;
	
	public List<ZyhNews> findNewsList(ZyhNewsExample example) throws Exception;
	
	public List<ZyhNews> findNewsListToHome(ZyhNewsExample example) throws Exception;
	
	public Map findNewsListByPage(ZyhNewsExample example,
			int pageNum, int pageSize) throws Exception;
	
	public ZyhNews queryNewsForSave(String newsid) throws Exception;
	
}
