package com.jhta.allchwi.controller.classdetail;

import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jhta.allchwi.page.util.PageUtil;
import com.jhta.allchwi.service.classapply.PaymentService;
import com.jhta.allchwi.service.classdetail.ClassDetailService;
import com.jhta.allchwi.service.classdetail.ClassReviewService;
import com.jhta.allchwi.service.classopen.ClassDateService;
import com.jhta.allchwi.service.classopen.ClassInfoService;
import com.jhta.allchwi.service.login.MemberInfoService;
import com.jhta.allchwi.service.wishlist.WishListService;
import com.jhta.allchwi.vo.classapply.PaymentVO;
import com.jhta.allchwi.vo.classdetail.ClassDetailVO;
import com.jhta.allchwi.vo.classdetail.ClassReviewVO;
import com.jhta.allchwi.vo.classopen.ClassDateVO;
import com.jhta.allchwi.vo.classopen.ClassInfoVO;
import com.jhta.allchwi.vo.login.ProfileVO;

@Controller
public class ClassDetailController {
	@Autowired
	private ClassDetailService cds;
	@Autowired
	private ClassDateService dates;
	@Autowired
	private ClassReviewService crs;
	@Autowired
	private WishListService wls;
	@Autowired
	private PaymentService ps;

	@GetMapping("/classDetail/detail")
	public ModelAndView detail(int class_num, HttpSession session,
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNum) {
		ModelAndView mv = new ModelAndView(".classDetail.detail");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("class_num", class_num);
		if(session.getAttribute("ml_num")!=null) {
			int ml_num = (int) session.getAttribute("ml_num");
			// 로그인한 아이디의 wish상태
			map.put("ml_num", ml_num);
			if (wls.getWish(map) != null) {
				mv.addObject("wstatus", true);
			}
			// 수업완료여부(리뷰작성권한)
			if(ps.getFinished(map) != null) {
				int finished = ps.getFinished(map).getClass_finish();
				mv.addObject("finished", finished);
			}
			mv.addObject("ml_num", ml_num);
		}
		
	
		// getdetail
		ClassDetailVO cdv = cds.getDetail(map);
		// 날짜시간
		
		
		List<ClassDateVO> dlist = dates.select(class_num);
		
		// 리뷰리스트,페이징
		map.put("class_num", class_num);
		int totalRowCount = crs.rcount(map);
		PageUtil pu = new PageUtil(pageNum, totalRowCount, 4, 5);
		int startRow = pu.getStartRow() - 1;
		map.put("startRow", startRow);
		List<ClassReviewVO> rlist = crs.reviewList(map);
		if(crs.rate_avg(class_num)!=null) {
			ClassReviewVO rating= crs.rate_avg(class_num);
			mv.addObject("rating", rating);
		}

		mv.addObject("cdv", cdv);
		mv.addObject("dlist", dlist);
		mv.addObject("rlist", rlist);
		mv.addObject("rpu", pu);
		mv.addObject("class_num", class_num);
		
		return mv;
	}

	// 인표 상세페이지 이동 detail2
	@GetMapping("/classDetail/detail2")
	public ModelAndView detail2(int class_num, HttpSession session,
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNum) {
		ModelAndView mv = new ModelAndView("/classDetail/detail");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("class_num", class_num);
		if(session.getAttribute("ml_num")!=null) {
			int ml_num = (int) session.getAttribute("ml_num");
			// 로그인한 아이디의 wish상태
			map.put("ml_num", ml_num);
			if (wls.getWish(map) != null) {
				mv.addObject("wstatus", true);
			}
			// 수업완료여부(리뷰작성권한)
			if(ps.getFinished(map) != null) {
				int finished = ps.getFinished(map).getClass_finish();
				mv.addObject("finished", finished);
			}
			mv.addObject("ml_num", ml_num);
		}
		
	
		// getdetail
		ClassDetailVO cdv = cds.getDetail(map);
		// 날짜시간
		
		
		List<ClassDateVO> dlist = dates.select(class_num);
		
		// 리뷰리스트,페이징
		map.put("class_num", class_num);
		int totalRowCount = crs.rcount(map);
		PageUtil pu = new PageUtil(pageNum, totalRowCount, 4, 5);
		int startRow = pu.getStartRow() - 1;
		map.put("startRow", startRow);
		List<ClassReviewVO> rlist = crs.reviewList(map);
		if(crs.rate_avg(class_num)!=null) {
			ClassReviewVO rating= crs.rate_avg(class_num);
			mv.addObject("rating", rating);
		}

		mv.addObject("cdv", cdv);
		mv.addObject("dlist", dlist);
		mv.addObject("rlist", rlist);
		mv.addObject("rpu", pu);
		mv.addObject("class_num", class_num);
		
		return mv;
	}
}
