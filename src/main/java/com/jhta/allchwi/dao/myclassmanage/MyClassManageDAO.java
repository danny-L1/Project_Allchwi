package com.jhta.allchwi.dao.myclassmanage;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.allchwi.vo.classapply.ClassApplyVO;
import com.jhta.allchwi.vo.classopen.ClassInfoVO;
import com.jhta.allchwi.vo.myclassmanage.MyClassManageVO;

@Repository
public class MyClassManageDAO {
	
	@Autowired
	SqlSession session;
	
	private final String NAMESPACE = "com.jhta.mybatis.mapper.MyClassManageMapper";
	
	//a 회원 클래스 신청서 목록 보기 
	public List<MyClassManageVO> searchApply(HashMap<String, Object> hm) {
		return session.selectList(NAMESPACE + ".MyClassManage", hm);
	}
	//a 개설한 강좌번호 및 타이틀 가져오기
	public List<ClassInfoVO> searchMyClass(int ml_num) {
		return session.selectList(NAMESPACE + ".myClass", ml_num);
	}
	//a 신청서 카운팅
	public int applyCounting(HashMap<String, Object> hm) {
		return session.selectOne(NAMESPACE + ".MyClassCounting", hm);
	}
	//a 신청서 넘버로 신청한 회원정보 가져오기
	public ClassApplyVO getApply(int apply_num) {
		return session.selectOne(NAMESPACE + ".getApply", apply_num);
	}
	//a 신청서 넘버로 수업승인 업데이트
	public int updateApply(int apply_num) {
		return session.update(NAMESPACE + ".updateApply", apply_num);
	}
}
