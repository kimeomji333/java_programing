package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.ProductController;
import model.dto.ProductDTO;

public class ModifyProductView {
	public ModifyProductView() {
		Scanner sc = new Scanner(System.in);
		ProductController controller = new ProductController();
		
		ArrayList<ProductDTO> list = controller.getList(1, 1);
		
		if(list == null) {
			System.out.println("NOT FOUND PRODUCT");
		} else {
			System.out.println("----- my product list -----");
			for(ProductDTO p : list) {
				System.out.printf("%d. %s : %dwon(amount: %d)\n", p.getProdnum(), p.getProdname(), p.getProdprice(), p.getProdamount());
			}
			System.out.println("--------------------------");
			
			System.out.print("product's number to modify: ");
			int prodnum = sc.nextInt();
			
			System.out.println("1. 가격 수정\n2. 수량 수정\n3. 설명 수정");
			int choice = sc.nextInt();
			
			System.out.print("새로운 정보: ");
			sc = new Scanner(System.in);
			String newData = sc.nextLine();
			
			if(controller.modifyProduct(prodnum, choice, newData)) {
				System.out.println(prodnum + "SUCCESS to modify!");
			} else {
				System.out.println("FAIL to modify! try again!");
			}
		}
	}
}
