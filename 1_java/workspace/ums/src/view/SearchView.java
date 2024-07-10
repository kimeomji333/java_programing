package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.ProductController;
import model.dto.ProductDTO;

public class SearchView {
	public SearchView() {
		ProductController controller = new ProductController();
		Scanner sc = new Scanner(System.in);
		System.out.print("검색어를 입력하세요 : ");
		String keyword = sc.nextLine();
		
		ArrayList<ProductDTO> list = controller.search(keyword);
		
		//"지우개" 로 검색된 결과
		System.out.println("\""+keyword+"\" 로 검색된 결과");
		if(list == null) {
			System.out.println("검색된 결과가 없습니다.");
		}
		else {
			for (ProductDTO product : list) {
				System.out.printf("%d. %s : %d원(재고 : %d개) - %s\n",
						product.getProdnum(), product.getProdname(), product.getProdprice(),
						product.getProdamount(), product.getUserid());
			}
			System.out.println("=================================");
			System.out.print("자세히 볼 상품번호(나가시려면 0번을 입력하세요) : ");
			int prodnum = sc.nextInt();
			if(prodnum != 0) {
				new ProductInfoView(prodnum);
			}
		}

	}
}









