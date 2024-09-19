package com.example.demo.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/*")
public class APIController {
	
	final static String serviceKey = "1zLYbuhO%2BTi%2F0liXt8rEgVtv5faxoVX7J1Ye8%2F0rN4sZ3%2B3Z2mJzBpK0TkHryM%2BMQz%2BooTImU0BFXXki%2FHsHyQ%3D%3D";
	
	@GetMapping("home")
	public void replace() {}
	
	//2. produces : 응답하는 데이터의 형태를 설정, json 형태로 응답해주면 클라이언트 쪽에서 JSON.parse()를 안 해도 된다. 
	@GetMapping(value = "get", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String get(String sidoName) throws Exception { //데이터 이동간에 예외 무조건 발생하니 조치
		String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty?serviceKey="+serviceKey;
		url += "&sidoName="+URLEncoder.encode(sidoName, "UTF-8");
		url += "&returnType=json&numOfRows=100000";
		
		//자바에서 네트워킹 하는 방법
		//단순한 문자열로 정의한 url 변수를 자바에서 네트워킹 할 때 활용할 수 있는 객체로 변환
		URL requestURL = new URI(url).toURL();
		
		//목적지로 향하는 다리 건설
		HttpURLConnection conn = (HttpURLConnection)requestURL.openConnection();
		conn.setRequestMethod("GET");
		
		//응답하는 데이터 읽기. 들어오는 통로가 필요(InputStream)
		InputStream is = conn.getInputStream();
		
		//열려있는 is 통로를 통해 들어오는 데이터를 읽기 위한 리더기(택배차)
		InputStreamReader isr = new InputStreamReader(is);
		
		//리더타입을 쉽게 이용하기 위한 buffer 리더
		BufferedReader br = new BufferedReader(isr);
		
		String result = "";
		String line = "";
		while(true) {
			line = br.readLine();
			if(line == null) { break; }
			result += line;
		}
		System.out.println(result);
		
		return result;
	}
}
