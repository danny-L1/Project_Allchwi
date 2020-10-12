package com.jhta.allchwi.service.receiveTuition;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jhta.allchwi.dao.receiveTuition.ReceiptDAO;
import com.jhta.allchwi.vo.receiveTuition.InsertRemitVO;
import com.jhta.allchwi.vo.receiveTuition.ReceiptVO;

@Service
public class ReceiptService {
	@Autowired
	private ReceiptDAO dao;
	
	public List<ReceiptVO> receipt_list(HashMap<String, Object>map){
		return dao.receipt_list(map);
	}
	
	public int count() {
		return dao.count();
	}
	
	@Transactional
	public int insertUpdateRecipt(InsertRemitVO vo,int pay_num) throws Exception {
		dao.insertRemit(vo);			//remit테이블에 insert		
		dao.updateRemit(pay_num);		//payment테이블 class_finish=2로 update
		return 1;
	}
}
