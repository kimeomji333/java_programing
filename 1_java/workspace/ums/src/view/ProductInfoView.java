package view;

import java.util.Scanner;

import controller.ProductController;
import model.dto.ProductDTO;

public class ProductInfoView {
	public ProductInfoView(int prodnum) {
		Scanner sc = new Scanner(System.in);
		ProductController controller = new ProductController();
		while(true) {
			ProductDTO product = controller.getDetail(prodnum);
			
			System.out.println("==============="+product.getProdnum()+"번 상품==============");
			System.out.println("상품명 : "+product.getProdname()+" | ♥ "+product.getLikecnt());
			System.out.println("판매자 : "+product.getUserid());
			System.out.println("가격 : "+product.getProdprice());
			System.out.println("남은 수량 : "+product.getProdamount());
			System.out.println("상세 설명\n"+product.getProdinfo());
			System.out.println("=====================================");
			System.out.println("1. 좋아요 누르기\n2. 판매자와 연락하기\n3. 뒤로가기");
			int choice = sc.nextInt();
			if(choice == 1) {
				controller.updateLikeCnt(product.getProdnum());
			}
			else if(choice == 2) {
				
			}
			else if(choice == 3) {
				break;
			}
		}
	}
}











