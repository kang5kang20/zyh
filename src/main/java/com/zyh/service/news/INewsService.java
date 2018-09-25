package com.zyh.service.news;

import java.util.List;

import com.zyh.entity.news.ZyhNews;
import com.zyh.entity.news.ZyhNewsExample;

public interface INewsService {
	
	public void addNews(ZyhNews zyhNews) throws Exception;
	
	public void updateNews(ZyhNews zyhNews) throws Exception;
	
	public void deleteNews(String newsid) throws Exception;
	
	public ZyhNews findNewsById(String newsid) throws Exception;
	
	public List<ZyhNews> findNewsList(ZyhNewsExample example) throws Exception;
	
	public List<ZyhNews> findNewsListToHome(ZyhNewsExample example) throws Exception;
	
}
