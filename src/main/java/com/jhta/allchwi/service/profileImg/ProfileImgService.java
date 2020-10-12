package com.jhta.allchwi.service.profileImg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.allchwi.dao.profileImg.ProfileImgDAO;
import com.jhta.allchwi.vo.profileImg.ProfileImgVO;

@Service
public class ProfileImgService {
	@Autowired
	private ProfileImgDAO dao;
	
	public int insert(ProfileImgVO vo) {
		return dao.insert(vo);
	}
	
	public ProfileImgVO getImg(int pro_num) {
		return dao.getImg(pro_num);
	}
}
