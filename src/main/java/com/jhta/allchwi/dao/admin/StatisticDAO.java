package com.jhta.allchwi.dao.admin;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.allchwi.vo.admin.Statistic1VO;
import com.jhta.allchwi.vo.admin.Statistic2VO;
import com.jhta.allchwi.vo.admin.Statistic3VO;

@Repository
public class StatisticDAO {
	@Autowired
	private SqlSession session;
	private final String NAMESPACE = "com.jhta.mybatis.mapper.AdminStatisticMapper";	
															
	public List<Statistic1VO> list(int thisyear, int nextyear){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("thisyear",thisyear);
		map.put("nextyear",nextyear);
	
		return session.selectList(NAMESPACE+".list",map);
	}
	
	public List<Statistic2VO> top_statlist(){
		return session.selectList(NAMESPACE+".top_statlist");
	}
	
	
	
	public List<Statistic3VO> cate_statlist(){
		return session.selectList(NAMESPACE+".cate_statlist");
	}
	
	
	
	
}
