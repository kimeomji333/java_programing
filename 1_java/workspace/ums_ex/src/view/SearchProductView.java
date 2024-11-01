package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.ProductController;
import model.dto.ProductDTO;

public class SearchProductView {
	public SearchProductView() {
		Scanner sc = new Scanner(System.in);
		ProductController controller = new ProductController();
		
		System.out.print("input the keyword: ");
		String keyword = sc.nextLine();
		ArrayList<ProductDTO> list = controller.search(keyword);

		System.out.println("-----" + keyword + "로 찾은 검색 결과입니다-----");
		if(list == null) {
			System.out.println("NOT FOUND PRODUCT");
		} else {
			for(ProductDTO product : list) {
				System.out.printf("%d. %s : %d원(재고 : %d개) - %s\n",
						product.getProdnum(), product.getProdname(), product.getProdprice(),
						product.getProdamount(), product.getUserid());
			}
			System.out.println("---------------------------------");
			System.out.print("watch the detail product info(if you want to exit, input the no. 0): ");
			int prodnum = sc.nextInt();
			if(prodnum != 0) {
				new ProductInfoView(prodnum);
			}
			
		}
	}

}
