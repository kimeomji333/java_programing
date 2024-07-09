package controller;

import java.util.ArrayList;

import model.dao.ProductDAO;
import model.dto.ProductDTO;
import model2.Session;

public class ProductController {

	public boolean addProduct(ProductDTO product) {
		ProductDAO pdao = new ProductDAO();
		int newNum = pdao.getNewNum();
		String loginUser = (String)Session.getData("loginUser");
		
		product.setProdnum(newNum);
		product.setUserid(loginUser);
		
		return pdao.insertProduct(product);
	}

	public ArrayList<ProductDTO> getList(int choice, int asc) {
		ProductDAO pdao = new ProductDAO();
		String userid = (String)Session.getData("loginUser");
		return pdao.getList(userid, choice, asc);
	}

	public boolean deleteProduct(int prodnum) {
		ProductDAO pdao = new ProductDAO();
		return pdao.deleteProductByProdnum(prodnum);
	}

	public boolean modifyProduct(int prodnum, int choice, String newData) {
		ProductDAO pdao = new ProductDAO();
		String[] cols = {"", "prodprice", "prodamount", "prodinfo"};
		return pdao.updateProduct(prodnum, cols[choice], newData);
	}
}
