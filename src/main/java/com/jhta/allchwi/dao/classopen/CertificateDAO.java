package com.jhta.allchwi.dao.classopen;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.allchwi.vo.classopen.CertificateVO;
import com.jhta.allchwi.vo.classopen.ClassImgVO;

@Repository
public class CertificateDAO {
	@Autowired
	private SqlSession session;
	private final String NAMESPACE = "com.jhta.mybatis.mapper.CertificateMapper";
	
	public int insert(CertificateVO vo) {
		return session.insert(NAMESPACE + ".insert",vo);
	}

	public int delete(int cert_num) {
		return session.delete(NAMESPACE + ".delete", cert_num);
	}
	
	public CertificateVO getImg(int certif_num) {
		return session.selectOne(NAMESPACE + ".imgList", certif_num);
	}

}
