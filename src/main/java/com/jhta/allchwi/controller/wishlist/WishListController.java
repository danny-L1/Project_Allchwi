package com.jhta.allchwi.controller.wishlist;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhta.allchwi.page.util.PageUtil;
import com.jhta.allchwi.service.classopen.ClassInfoService;
import com.jhta.allchwi.service.wishlist.WishListService;
import com.jhta.allchwi.vo.wishlist.WishListJoinVO;
import com.jhta.allchwi.vo.wishlist.WishListVO;

@Controller
public class WishListController {
	@Autowired
	private WishListService wl_service;
	@GetMapping("/class/wishList")
	public String goWishList(HttpSession session,Model model,
						@RequestParam(value="pageNum",defaultValue = "1")int pageNum) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int ml_num = (int)session.getAttribute("ml_num");
		
		int totalRowCount = wl_service.count(ml_num);
		PageUtil pu = new PageUtil(pageNum, totalRowCount, 2, 5);
		map.put("ml_num",ml_num);
		map.put("startRow", pu.getStartRow() - 1);
		
		List<WishListJoinVO> list = wl_service.getWishList(map);
		
		model.addAttribute("list", list);
		model.addAttribute("pu", pu);
		
		return ".wishlist.wishList";
	}
	
	@PostMapping("/class/addWish")
	@ResponseBody
	public String addWish(WishListVO wvo) {
		try {
			wl_service.insertWish(wvo);
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return "success";
	}
	
	@PostMapping("/class/removeWish")
	@ResponseBody
	public String removeWish(WishListVO wvo) {
		try {
			wl_service.deleteWish(wvo);
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return "success";
	}
}
