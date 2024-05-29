/*
 * package com.kakao.app;
 * 
 * import java.io.BufferedReader; import java.io.InputStreamReader; import
 * java.net.HttpURLConnection; import java.net.URL; import java.util.ArrayList;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Service;
 * 
 * import com.google.gson.JsonElement; import com.google.gson.JsonObject; import
 * com.google.gson.JsonParser;
 * 
 * @Service public class KakaoServiceImpl implements KakaoService {
 * 
 * @Autowired KakaoRepository kakaoRepository;
 * 
 * @Override public String getToken(String code) throws Exception { return null;
 * }
 * 
 * public ArrayList<Object> getUserInfo(String access_token) throws Exception {
 * 
 * ArrayList<Object> list = new ArrayList<Object>();
 * 
 * final String requestUrl = "https://kapi.kakao.com/v2/user/me";
 * 
 * URL url = new URL(requestUrl); HttpURLConnection con = (HttpURLConnection)
 * url.openConnection(); con.setRequestMethod("GET");
 * con.setRequestProperty("Authorization", "Bearer " + access_token);
 * 
 * BufferedReader bf = new BufferedReader(new
 * InputStreamReader(con.getInputStream())); String line = ""; String result =
 * "";
 * 
 * while ((line = bf.readLine()) != null) { result +=line; }
 * 
 * JsonParser parser = new JsonParser(); JsonElement element =
 * parser.parse(result);
 * 
 * JsonObject properties =
 * element.getAsJsonObject().get("properties").getAsJsonObject(); JsonObject
 * kakao_account =
 * element.getAsJsonObject().get("kakao_account").getAsJsonObject();
 * 
 * //콘솔창 확인 후 필요한 정보 추출 System.out.println("----------properties"+properties);
 * System.out.println("----------kakao_account"+kakao_account);
 * 
 * String thumbnail_image =
 * properties.getAsJsonObject().get("thumbnail_image").getAsString(); String
 * ninkname = properties.getAsJsonObject().get("nickname").getAsString(); String
 * email = kakao_account.getAsJsonObject().get("email").getAsString(); String
 * gender = kakao_account.getAsJsonObject().get("gender").getAsString(); String
 * birthday = kakao_account.getAsJsonObject().get("birthday").getAsString();
 * 
 * list.add(thumbnail_image); list.add(ninkname); list.add(email);
 * list.add(birthday);
 * 
 * //DB 저장 KakaoUser kakaouser = new
 * KakaoUser(ninkname,"1234",ninkname,email,gender,birthday);
 * kakaoRepository.save(kakaouser);
 * 
 * return list; } }
 */