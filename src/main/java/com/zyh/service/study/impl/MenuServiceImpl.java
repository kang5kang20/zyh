package com.zyh.service.study.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyh.dao.menu.ZyhMenuMapper;
import com.zyh.dao.menu.cuz.ZyhMenuCuzMapper;
import com.zyh.dao.util.UUidUtil;
import com.zyh.entity.common.Page;
import com.zyh.entity.menu.ZyhMenu;
import com.zyh.entity.menu.ZyhMenuExample;
import com.zyh.service.study.IMenuService;

@Service("menuService")
public class MenuServiceImpl implements IMenuService{
	
	@Autowired
	private ZyhMenuMapper zyhMenuMapper;
	
	@Autowired
	private ZyhMenuCuzMapper zyhMenuCuzMapper;

	@Override
	public void addMenu(ZyhMenu zyhMenu) throws Exception {
		if (null ==zyhMenu.getId()||"".equals(zyhMenu.getId())) {
			String id = UUidUtil.getUUid();
			zyhMenu.setId(id);
		}
		zyhMenuMapper.insertSelective(zyhMenu);
	}

	@Override
	public void updateMenu(ZyhMenu zyhMenu) throws Exception {
		zyhMenuMapper.updateByPrimaryKeySelective(zyhMenu);
	}

	@Override
	public void deleteMenu(String menuid) throws Exception {
		zyhMenuMapper.deleteByPrimaryKey(menuid);
	}

	@Override
	public ZyhMenu findMenuById(String menuid) throws Exception {
		return zyhMenuMapper.selectByPrimaryKey(menuid);
	}

	@Override
	public List<ZyhMenu> findmenuList(ZyhMenuExample example) throws Exception {
		return zyhMenuMapper.selectByExample(example);
	}

	@Override
	public Map findmenuListByPage(ZyhMenuExample example, int pageNum,
			int pageSize) throws Exception {
		Map map = new HashMap();
		map.put("retlist", zyhMenuCuzMapper.selectByPageNumSize(example, pageNum, pageSize));
		Page page = new Page();
		page.setPageNum(pageNum);
		page.setTotalRowCount(zyhMenuMapper.countByExample(example));
		map.put("page", page);
		return map;
	}

}
