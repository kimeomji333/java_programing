package controller;

import java.util.ArrayList;

import model.Session;
import model.dao.ProductDAO;
import model.dto.ProductDTO;

public class ProductController {

	public boolean addProduct(ProductDTO product) {
		//매개변수로 받은 product 객체는 가상의 번호와 가상의 유저 아이디를 가지고 있는 상태
		//가상의 번호 대신 실제로 새로운 번호, 가상의 유저 아이디 대신 현재 로그인된 아이디로 바꿔주고
		ProductDAO pdao = new ProductDAO();
		int newNum = pdao.getNewNum();
		String loginUser = (String)Session.getData("loginUser");
		
		product.setProdnum(newNum);
		product.setUserid(loginUser);
		
		//바뀐 정보로 데이터베이스에 삽입
		return pdao.insertProduct(product);
	}

	public ArrayList<ProductDTO> getList(int choice, int asc) {
		//choice : 1(등록) 2(이름) 3(가격) 4(좋아요)
		//asc : 1(오름차순) / 2(내림차순)
		ProductDAO pdao = new ProductDAO();
		String userid = (String)Session.getData("loginUser");
		return pdao.getList(userid,choice,asc);
	}

	public boolean removeProduct(int prodnum) {
		ProductDAO pdao = new ProductDAO();
		return pdao.deleteProductByProdnum(prodnum);
	}

	public boolean modifyProduct(int prodnum, int choice, String newData) {
		//choice : 1(가격 수정) / 2(수량 수정) / 3(설명 수정)
		ProductDAO pdao = new ProductDAO();
		String[] cols = {"","prodprice","prodamount","prodinfo"};
		return pdao.updateProduct(prodnum,cols[choice],newData);
	}

	public ArrayList<ProductDTO> search(String keyword) {
		ProductDAO pdao = new ProductDAO();
		ArrayList<ProductDTO> list = pdao.getAllProduct();
		if(list == null) {
			return null;
		}
		else {
			ArrayList<ProductDTO> result = new ArrayList<>();
			for(ProductDTO product : list) {
				if(product.getProdname().contains(keyword)) {
					result.add(product);
				}
				else if(product.getProdinfo().contains(keyword)) {
					result.add(product);
				}
				else if(isDigit(keyword)) {
					int price = Integer.parseInt(keyword);
					int min = (int)(price*0.9);
					int max = (int)(price*1.1);
					if(product.getProdprice() >= min && product.getProdprice() <= max) {
						result.add(product);
					}
				}
			}
			return result;
		}
	}
	private boolean isDigit(String msg) {						//01a23
		for (int i = 0; i < msg.length(); i++) {
			char ch = msg.charAt(i);
			if(ch < '0' || ch > '9') {
				return false;
			}
		}
		return true;
	}

	public ProductDTO getDetail(int prodnum) {
		ProductDAO pdao = new ProductDAO();
		return pdao.getProductByProdnum(prodnum);
	}

	public void updateLikeCnt(int prodnum) {
		ProductDAO pdao = new ProductDAO();
		int likecnt = pdao.getProductByProdnum(prodnum).getLikecnt();
		pdao.updateProduct(prodnum, "likecnt", likecnt+1+"");
	}

}








