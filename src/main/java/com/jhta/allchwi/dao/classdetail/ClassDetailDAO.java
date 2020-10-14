package com.jhta.allchwi.dao.classdetail;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.allchwi.vo.classdetail.ClassDetailVO;
import com.jhta.allchwi.vo.wishlist.WishListVO;

@Repository
public class ClassDetailDAO {
	@Autowired
	private SqlSession session;
	private final String NAMESPACE = "com.jhta.mybatis.mapper.ClassDetailMapper";	
	public ClassDetailVO getDetail(HashMap<String, Object> map) {
		return session.selectOne(NAMESPACE+".getDetail", map);
	}
	
	
	public List<ClassDetailVO> topFive() {
		return session.selectList(NAMESPACE+".topFive");
	}
}
