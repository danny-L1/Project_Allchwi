package com.jhta.allchwi.dao.admin;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.allchwi.vo.admin.AdminRemitVO;
import com.jhta.allchwi.vo.admin.SalesVO;

@Repository
public class AdminRemitDAO {
	@Autowired
	private SqlSession session;
	private final String NAMESPACE = "com.jhta.mybatis.mapper.AdminRemitMapper";	
	
	public List<AdminRemitVO> remit_list(HashMap<String, Object> map){
		return session.selectList(NAMESPACE+".remit_list",map);
	}
	
	public int count(HashMap<String, Object> map) {
		return session.selectOne(NAMESPACE+".count",map);
	}
	
	public int accpet(int pay_num) {
		return session.update(NAMESPACE+".accept", pay_num);
	}
	
	public int insertSales(SalesVO vo) {
		return session.insert(NAMESPACE+".insertSales",vo );
	}
	
}
