package com.zyh.service.news.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyh.dao.news.ZyhNewsMapper;
import com.zyh.dao.util.UUidUtil;
import com.zyh.entity.common.Page;
import com.zyh.entity.news.ZyhNews;
import com.zyh.entity.news.ZyhNewsExample;
import com.zyh.service.news.INewsService;

@Service("newsService")
public class NewsServiceImpl implements INewsService {
	
	@Autowired
	private ZyhNewsMapper zyhNewsMapper;

	@Override
	public void addNews(ZyhNews zyhNews) throws Exception {
		if (null ==zyhNews.getId()||"".equals(zyhNews.getId())) {
			String id = UUidUtil.getUUid();
			zyhNews.setId(id);
		}
		zyhNewsMapper.insertSelective(zyhNews);
	}

	@Override
	public void updateNews(ZyhNews zyhNews) throws Exception {
		zyhNewsMapper.updateByPrimaryKeySelective(zyhNews);
	}

	@Override
	public void deleteNews(String newsid) throws Exception {
		zyhNewsMapper.deleteByPrimaryKey(newsid);
	}

	@Override
	public ZyhNews queryNewsById(String newsid) throws Exception {
		//记录点击次数
		ZyhNews news = zyhNewsMapper.selectByPrimaryKey(newsid);
		if(null == news || "0".equals(news.getIfground())){
			return null;
		}
		news.setReadcount(news.getReadcount()+1);
		zyhNewsMapper.updateByPrimaryKeySelective(news);
		return news;
	}

	@Override
	public List<ZyhNews> findNewsList(ZyhNewsExample example) throws Exception {
		return zyhNewsMapper.selectByExample(example);
	}

	@Override
	public List<ZyhNews> findNewsListToHome(ZyhNewsExample example) throws Exception {
		return zyhNewsMapper.selectByExample(example);
	}

	@Override
	public Map findNewsListByPage(ZyhNewsExample example,
			int pageNum, int pageSize) throws Exception {
		Map map = new HashMap();
		map.put("retlist", zyhNewsMapper.selectByPageNumSize(example, pageNum, pageSize));
		Page page = new Page();
		page.setPageNum(pageNum);
		page.setTotalRowCount(zyhNewsMapper.countByExample(example));
		map.put("page", page);
		return map;
	}

	@Override
	public ZyhNews queryNewsForSave(String newsid) throws Exception {
		return zyhNewsMapper.selectByPrimaryKey(newsid);
	}
	
}
