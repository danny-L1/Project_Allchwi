package com.jhta.allchwi.service.admin;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.allchwi.dao.admin.StatisticDAO;
import com.jhta.allchwi.vo.admin.Statistic1VO;
import com.jhta.allchwi.vo.admin.Statistic2VO;
import com.jhta.allchwi.vo.admin.Statistic3VO;

@Service
public class AdminStatisticService {
	@Autowired
	private StatisticDAO dao;
	
	public List<Statistic1VO> list(int thisyear, int nextyear) {
		return dao.list(thisyear, nextyear);
	}
	
	public List<Statistic2VO> top_statlist(){
		return dao.top_statlist();
	}
	
	
	public List<Statistic3VO> cate_statlist(){
		return dao.cate_statlist();
	}
	
	
	
	
}
