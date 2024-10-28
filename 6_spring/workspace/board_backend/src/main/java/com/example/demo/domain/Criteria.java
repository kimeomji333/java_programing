package com.example.demo.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Data;

//공통 페이징 파라미터 처리 클래스
//@RequestParam으로 일일이 전달받는 방법은 효율적이지 않기 때문에
@Data
public class Criteria {
	private int pagenum;
	private int amount;
	private String type;	//검색키워드
	private String keyword; //검색유형(전체, 제목, 내용, 작성자 등)
	private int startrow;
	
//	기본 페이지를 1페이지에 10개씩 보여준다.
	public Criteria() {
		//this() : 현재 클래스의 생성자
		//this(pagenum, amount);
		this(1,10);
	}
	
//	매개변수로 들어오는 값을 이용하여 조정할 수 있다.
	public Criteria(int pagenum, int amount) {
		this.pagenum = pagenum;
		this.amount = amount;
		this.startrow = (this.pagenum - 1) * this.amount;
	}
	
	
	//1. pagenum이 바뀔 때마다 startrow가 바뀌어야 함
	//2. pagenum이 바뀌려면 setPagenum() 호출해야 함
	//3. 결론 : setPagenum() 에서 startrow도 바꿔주어야 함
	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
		this.startrow = (this.pagenum - 1) * this.amount;
	}
	
////	UriComponentsBuilder를 이용하여 링크 생성
//	public String getListLink() {
//		//															? 앞에 붙는 URI 문자열
//		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
//										.queryParam("pagenum", this.pagenum)
//										.queryParam("amount", this.amount)
//										.queryParam("type", this.type)
//										.queryParam("keyword", this.keyword);
//		//		?pagenum=4&amount=10& ...
//		return builder.toUriString();
//	}
	
//	MyBatis에서 #{typeArr} 사용 가능 - get으로 시작해야 MyBatis에서 찾을 수 있음
	public String[] getTypeArr() {
		return type == null ? new String[] {} : type.split("");
	}
}











