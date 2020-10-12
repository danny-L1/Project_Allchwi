package com.jhta.allchwi.service.admin;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jhta.allchwi.dao.admin.ChangePicsDAO;
import com.jhta.allchwi.vo.admin.MainPicsVO;
import com.jhta.allchwi.vo.admin.PicsListVO;

@Service
public class ChangePicsService {
	@Autowired
	private ChangePicsDAO dao;
	
	public int picsInsert(MainPicsVO vo) {
		return dao.picsInsert(vo);
	}
	
	public List<PicsListVO> pics_list(HashMap<String, Object> map){
		return dao.pics_list(map);
	}
	
	public int count() {
		return dao.count();
	}
	
	public List<String> banner_list(){
		return dao.banner_list();
	}
	
	
	@Transactional
	public int confirmPics(HashMap<String, Object> map) throws Exception {
		dao.reset();
		dao.confirmPics1((String)map.get("firstPic"));
		dao.confirmPics2((String)map.get("secondPic"));
		dao.confirmPics3((String)map.get("thirdPic"));
		return 1;
	}
	
}
