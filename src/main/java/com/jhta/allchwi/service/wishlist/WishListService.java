package com.jhta.allchwi.service.wishlist;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.allchwi.dao.wishlist.WishListDAO;
import com.jhta.allchwi.vo.wishlist.WishListJoinVO;
import com.jhta.allchwi.vo.wishlist.WishListVO;
@Service
public class WishListService {
@Autowired private WishListDAO dao;
	public int insertWish(WishListVO vo) {
		return dao.insertWish(vo);
	}
	public int deleteWish(WishListVO vo) {
		return dao.deleteWish(vo);
	}
	public WishListVO getWish(HashMap<String, Object> map) {
		return dao.getWish(map);
	}
	public List<WishListJoinVO> getWishList(HashMap<String, Object> map) {
		return dao.getWishList(map);
	}
	public int count(int ml_num) {
		return dao.count(ml_num);
	}

}
