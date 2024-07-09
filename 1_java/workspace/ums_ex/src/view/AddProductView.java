package view;

import java.util.Scanner;

import controller.ProductController;
import model.dto.ProductDTO;

public class AddProductView {
	public AddProductView() {
		Scanner sc = new Scanner(System.in);
		ProductController controller = new ProductController();
		
		//상품 이름, 가격, 수량, 설명 입력
		System.out.print("product name: ");
		String prodname = sc.nextLine();
		System.out.print("product price: ");
		String prodprice = sc.nextLine();
		System.out.print("product amount: ");
		String prodamount = sc.nextLine();
		System.out.print("product info: ");
		String prodinfo = sc.nextLine();
		
		//처리
		ProductDTO product = new ProductDTO(0, prodname, Integer.parseInt(prodprice), Integer.parseInt(prodamount), prodinfo, 0, null);
		
		//출력
		if(controller.addProduct(product)) {
			System.out.println("success to add Product!");
		} else {
			System.out.println("fail to add Product. try again!");
		}

	}
}
