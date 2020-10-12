package com.jhta.allchwi.dao.location;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.allchwi.vo.location.BigLocationVO;

@Repository
public class BigLocationDAO {
	@Autowired
	private SqlSession session;
	private final String NAMESPACE = "com.jhta.mybatis.mapper.BigLocationMapper";
	
	public int insert(BigLocationVO vo) {
		return session.insert(NAMESPACE + ".insert",vo);
	}
	
	public List<BigLocationVO> blocList(){
		return session.selectList(NAMESPACE + ".list");
	}
}
