package cn.zcj.newsssm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.zcj.newsssm.dao.CmenuDao;
import cn.zcj.newsssm.entity.Cmenu;

@Service
public class MenuSvc {
	
	@Resource
	private CmenuDao dao;
	
	public List<Cmenu> listMenu(int pid){
		return dao.list2(pid);
	}

}
