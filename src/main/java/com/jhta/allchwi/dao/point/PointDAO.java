package com.jhta.allchwi.dao.point;


import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.allchwi.vo.point.PointListVO;
import com.jhta.allchwi.vo.point.PointVO;

@Repository
public class PointDAO {
	@Autowired
	SqlSession session;
	private final String NAMESPACE = "com.jhta.mybatis.mapper.PointMapper";
	
	//회원가입시 1000 포인트 추가 
	public int insert(PointVO vo) {
		return session.insert(NAMESPACE + ".addPoint",vo);
	}
	//회원번호, 포인트 상태 입력받아 포인트 리스트 출력
	public List<PointListVO> pointList(HashMap<String, Object> hm){
		return session.selectList(NAMESPACE + ".selectPoint", hm);
	}
	//회원의 현재 보유 포인트 계산
	public int getTotal(HashMap<String, Object> hm){
		return session.selectOne(NAMESPACE + ".getTotal", hm);
	}
	//페이징 처리를 위해 포인트 적립/사용 횟수 계산
	public int count(HashMap<String, Object> hm) {
		return session.selectOne(NAMESPACE + ".count", hm);
	}
}
