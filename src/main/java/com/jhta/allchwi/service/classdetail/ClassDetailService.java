package com.jhta.allchwi.service.classdetail;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.allchwi.dao.classdetail.ClassDetailDAO;
import com.jhta.allchwi.vo.classdetail.ClassDetailVO;
import com.jhta.allchwi.vo.wishlist.WishListVO;
@Service
public class ClassDetailService {
	@Autowired private ClassDetailDAO  dao;
	public ClassDetailVO getDetail(HashMap<String, Object> map) {
		return dao.getDetail(map);
	}
	
	public List<ClassDetailVO> topFive() {
		return dao.topFive();
	}
}
