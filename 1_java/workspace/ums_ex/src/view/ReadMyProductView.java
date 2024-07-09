package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.ProductController;
import model.dto.ProductDTO;

public class ReadMyProductView {
	public ReadMyProductView() {
		Scanner sc = new Scanner(System.in);
		ProductController controller = new ProductController();
		System.out.println("1. 등록 순으로 보기\n2. 이름 순으로 보기\n3. 가격 순으로 보기\n4. 좋아요 순으로 보기");
		int choice = sc.nextInt();
		
		System.out.println("1. 오름차순으로 보기\n2. 내림차순으로 보기");
		int asc = sc.nextInt();
		
		ArrayList<ProductDTO> list = controller.getList(choice, asc);
		
		if(list == null) {
			System.out.println("NOT FOUND PRODUCT!");
		} else {
			System.out.println("----- my product list -----");
			for(ProductDTO p : list) {
				System.out.printf("%d. %s : %dwon(amount: %d)\n", p.getProdnum(), p.getProdname(), p.getProdprice(), p.getProdamount());
			}
			System.out.println("--------------------------");
		}
	}
}
