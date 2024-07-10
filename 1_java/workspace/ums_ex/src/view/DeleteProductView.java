package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.ProductController;
import model.dto.ProductDTO;

public class DeleteProductView {
	public DeleteProductView() {
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
			
			System.out.print("product's number to delete: ");
			int prodnum = sc.nextInt();
			
			if(controller.deleteProduct(prodnum)) {
				System.out.println(prodnum + ", SUCCESS to delete!");
			} else {
				System.out.println("FAIL to delete! try again!");
			}
		}
	}

}
