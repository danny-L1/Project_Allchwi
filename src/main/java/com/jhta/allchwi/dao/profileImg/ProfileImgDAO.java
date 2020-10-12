package com.jhta.allchwi.dao.profileImg;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.allchwi.vo.profileImg.ProfileImgVO;

@Repository
public class ProfileImgDAO {
	@Autowired
	SqlSession session;
	private final String NAMESPACE = "com.jhta.mybatis.mapper.ProfileImgMapper";
	
	public int insert(ProfileImgVO vo) {
		return session.insert(NAMESPACE + ".insert",vo);
	}
	//a 회원정보의 pro_num 및 객체들을 ProfileImgVO 에 담아 업데이트
	public int updateImg(ProfileImgVO piv) {
		return session.update(NAMESPACE + ".updateImg", piv);
	}
	
	//이미지 출력
	public ProfileImgVO getImg(int pro_num) {
		return session.selectOne(NAMESPACE+".imgSelect", pro_num);
	}

}
