package com.jhta.allchwi.service.admin;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.allchwi.dao.admin.confirmClassDAO;
import com.jhta.allchwi.vo.admin.CertiVO;
import com.jhta.allchwi.vo.admin.ClassDetailVO;
import com.jhta.allchwi.vo.admin.ConfirmClassVO;
import com.jhta.allchwi.vo.admin.CurriVO;

@Service
public class confirmClassService {
	@Autowired
	private confirmClassDAO dao;
	
	public List<ConfirmClassVO> confirm_list(HashMap<String, Object> map){
		return dao.confirm_list(map);
	}
	
	public int count(HashMap<String, Object> map) {
		return dao.count(map);
	}
	
	public int acceptClass(int class_num) {
		return dao.acceptClass(class_num);
	}
	
	public int denyClass(int class_num) {
		return dao.denyClass(class_num);
	}
	
	public ClassDetailVO class_detail(int class_num){
		return dao.detail_list(class_num);
	}
	
	public List<CertiVO> certi_list(int class_num) {
		return dao.certi_list(class_num);
	}
	
	
	public List<CurriVO> curri_list(int class_num) {
		return dao.curri_list(class_num);
	}
	
}
