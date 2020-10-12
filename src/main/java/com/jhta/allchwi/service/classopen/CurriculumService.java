package com.jhta.allchwi.service.classopen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.allchwi.dao.classopen.CurriculumDAO;
import com.jhta.allchwi.vo.classopen.CurriculumVO;

@Service
public class CurriculumService {
	@Autowired
	private CurriculumDAO dao;
	
	public int insert(CurriculumVO vo) {
		return dao.insert(vo);
	}
}
