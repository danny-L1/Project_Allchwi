package com.jhta.allchwi.service.location;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.allchwi.dao.location.SmallLocationDAO;
import com.jhta.allchwi.vo.admin.SmallCategoryVO;
import com.jhta.allchwi.vo.location.SmallLocationVO;

@Service
public class SmallLocationService {
	@Autowired
	private SmallLocationDAO dao;
	
	public int insert(SmallLocationVO slocVo) {
		return dao.insert(slocVo);
	}
	
	public List<SmallLocationVO> slocList(int bloc_num){
		return dao.slocList(bloc_num);
	}
}
