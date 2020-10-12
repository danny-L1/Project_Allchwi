package com.jhta.allchwi.service.login;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class KakaoLoginService {
	// accessToken 받아오기
	public String getAccessToken(String authorize_code) {
		String access_Token = "";
		String refresh_Token = "";
		String reqURL = "https://kauth.kakao.com/oauth/token";
		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			// POST 요청을 위해 기본값이 false인 setDoOutput을 true로
			conn.setRequestMethod("POST");
			conn.setDoOutput(true); 

			// POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			StringBuilder sb = new StringBuilder();
			sb.append("grant_type=authorization_code");
			sb.append("&client_id=4f883a7141cac9d993029eba73513c89");
			//나스
			//sb.append("&redirect_uri=http://pakye.synology.me:7070/login/kakaologin");
			//규진
			//sb.append("&redirect_uri=http://192.168.0.29:8091/login/kakaologin");
			//본인서버
			//sb.append("&redirect_uri=http://localhost:8091/login/kakaologin");
			//도메인
			sb.append("&redirect_uri=http://www.allchwi.com/login/kakaologin");
			sb.append("&code=" + authorize_code);
			bw.write(sb.toString());
			bw.flush();

			// a 결과 코드가 200이라면 성공
			int responseCode = conn.getResponseCode();

			// a 요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = "";
			String result = "";

			while ((line = br.readLine()) != null) {
				result += line;
			}
			System.out.println("response body : " + result);

			// Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(result);

			access_Token = element.getAsJsonObject().get("access_token").getAsString();
			refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();

			System.out.println("access_token : " + access_Token);
			System.out.println("refresh_token : " + refresh_Token);

			br.close();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return access_Token;
	}

	// a 카카오 회원정보 얻어오기
	public HashMap<String, Object> getUserInfo(String access_Token) {
		// 요청하는 클라이언트마다 가진 정보가 다를 수 있기에 HashMap타입으로 선언
		HashMap<String, Object> userInfo = new HashMap<>();
		String reqURL = "https://kapi.kakao.com/v2/user/me";
		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");

			// 요청에 필요한 Header에 포함될 내용
			conn.setRequestProperty("Authorization", "Bearer " + access_Token);

			int responseCode = conn.getResponseCode();
			System.out.println("responseCode : " + responseCode);

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String line = "";
			String result = "";

			while ((line = br.readLine()) != null) {
				result += line;
			}
			System.out.println("response body : " + result);

			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(result);
			JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
			JsonObject kakao_account = element.getAsJsonObject().get("kakao_account").getAsJsonObject();
			//카카오 유저 구분을 위해 고유아이디값을 출력
			String kakaoId = element.getAsJsonObject().get("id").getAsString();
			//별명의 경우 필수 동의 이므로 가져올수 있음. 
			String nickname = properties.getAsJsonObject().get("nickname").getAsString();
			//이메일은 선택 동의 이므로 동의를 하지 않을 경우가 있을 수 있으므로 
			String email = "";
			//json의 이메일 정보가 담겨있는지 확인 후 담겨있을 경우
			if(kakao_account.getAsJsonObject().get("email") != null) {
				email = kakao_account.getAsJsonObject().get("email").getAsString();
			//이메일 정보가 없을 경우
			} else {
				email = "";
			}
			//map에 담아줌
			userInfo.put("nickname", nickname);
			userInfo.put("email", email);
			userInfo.put("kakaoUser", kakaoId);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userInfo;
	}
}
