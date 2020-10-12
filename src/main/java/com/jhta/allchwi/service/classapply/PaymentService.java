package com.jhta.allchwi.service.classapply;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.allchwi.dao.classapply.PaymentDAO;
import com.jhta.allchwi.vo.classapply.PaymentVO;

@Service
public class PaymentService {
	@Autowired private PaymentDAO dao;
	
	public int insert(PaymentVO vo) {
		return dao.insert(vo);
	}

	public int finishUpdate(HashMap<String, Object> map)throws Exception {
		return dao.finishUpdate(map);
	}
	public PaymentVO getFinished(HashMap<String, Object> map) {
		return dao.getFinished(map);
	}
}
