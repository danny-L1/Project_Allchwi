package com.jhta.allchwi.dao.community;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.allchwi.vo.community.AssignDataVO;
import com.jhta.allchwi.vo.community.AssignSubmitVO;

@Repository
public class AssignDataDAO {
	@Autowired private SqlSession session;
	private final String NAMESPACE="com.jhta.mybatis.mapper.AssignDataMapper";
	
	public int insert(AssignDataVO vo) {
		return session.insert(NAMESPACE+".insert",vo);
	}
	
	public List<AssignDataVO> data_list(int sub_num){
		return session.selectList(NAMESPACE+".list",sub_num);
	}
	
	public AssignDataVO saveFilename(int assigndata_num) {
		return session.selectOne(NAMESPACE+".getSaveFileName", assigndata_num);
	}
}
