package com.jhta.allchwi.dao.admin;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.allchwi.vo.admin.MemberListVO;

@Repository
public class memberListDAO {
	@Autowired
	private SqlSession session;
	private final String NAMESPACE = "com.jhta.mybatis.mapper.AdminMemberListMapper";	

	public List<MemberListVO> member_list(){
		return session.selectList(NAMESPACE+".member_list");
	}
	
	public int update_mlnum_ml(int ml_num) {
		return session.update(NAMESPACE+".update_mlnum_ml", ml_num);
	}
	
	public int update_mlnum_mi(int ml_num) {
		return session.update(NAMESPACE+".update_mlnum_mi",ml_num);
	}
}