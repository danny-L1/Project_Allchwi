package com.jhta.allchwi.service.onlineclass;

import java.sql.SQLException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.allchwi.dao.onlineClass.OnlineCheckDAO;
import com.jhta.allchwi.vo.onlineclass.OnlineCheckVO;

@Service
public class OnlineCheckService {
	@Autowired
	private OnlineCheckDAO dao;

	public int select(OnlineCheckVO vo) {
		return dao.select(vo);
	}

	public void insert(OnlineCheckVO vo) throws SQLException{
		dao.insert(vo);
	}

	public int timeSelect(HashMap<String, Object> map) {
		return dao.timeSelect(map);
	}
	
}
