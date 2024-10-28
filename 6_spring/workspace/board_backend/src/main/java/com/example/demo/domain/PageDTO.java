package com.example.demo.domain;

import lombok.Data;

//페이징 정보(화면 하단 페이지 번호) 계산용 클래스
@Data
public class PageDTO {
	private int startPage;	//현재 page 그룹의 시작페이지 번호
	private int endPage;	//현재 page 그룹의 끝페이지 번호
	private int realEnd;	//실제 마지막 page 번호. endPage가 realEnd보다 클 수 없으므로 이를 통해 연산
	private long total;		//전체 게시글 수
	private boolean prev, next;
	private Criteria cri;	//현재 페이지 번호와 페이지당 게시글 수를 담고 있다. 
	
	public PageDTO(long total,Criteria cri) {
		this.cri = cri;
		this.total = total;
		
		this.endPage = (int)Math.ceil(cri.getPagenum()/(double)cri.getAmount())*cri.getAmount();
		this.startPage = this.endPage - (cri.getAmount()-1);
		this.realEnd = (int)Math.ceil(total/(double)cri.getAmount());
		//this.realEnd가 0 이라는 뜻은 게시글의 개수가 0이라는 뜻이므로
		//시작 페이지도 1, 마지막 페이지도 1이여야 한다.
		this.realEnd = this.realEnd == 0 ? 1 : this.realEnd;
		//this.realEnd가 this.endPage보다 작다는 뜻은,
		//단순 연산을 통해서 구해진 endPage가 실제 데이터 기반의 realEnd보다 크다는 뜻이다.
		//결국 그 뜻은 허구의 페이지가 만들어져 있다는 뜻이므로,
		//그 경우에는 endPage를 개수 기반의 realEnd값으로 변경해주어야 한다.
		this.endPage = this.endPage > this.realEnd ? this.realEnd : this.endPage; 
		
		this.prev = this.startPage != 1;
		this.next = this.endPage < this.realEnd;	
	}
}













