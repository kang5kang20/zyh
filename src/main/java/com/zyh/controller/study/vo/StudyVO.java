package com.zyh.controller.study.vo;

import java.util.List;

import com.zyh.entity.lanmu.ZyhLanmu;
import com.zyh.entity.menu.ZyhMenu;

public class StudyVO {
	private ZyhMenu menu;
	
	private List<ZyhLanmu> lanmulist;

	public ZyhMenu getMenu() {
		return menu;
	}

	public void setMenu(ZyhMenu menu) {
		this.menu = menu;
	}

	public List<ZyhLanmu> getLanmulist() {
		return lanmulist;
	}

	public void setLanmulist(List<ZyhLanmu> lanmulist) {
		this.lanmulist = lanmulist;
	}
	
	
}
