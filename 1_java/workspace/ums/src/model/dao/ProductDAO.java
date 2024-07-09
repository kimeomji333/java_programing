package model.dao;

import java.util.ArrayList;

import model.DBConnection;
import model.dto.ProductDTO;

public class ProductDAO {
	DBConnection dbConnection;
	public ProductDAO() {
		dbConnection = new DBConnection("ProductTable.txt");
	}
	public boolean insertProduct(ProductDTO product) {
		//prodnum	prodname	prodprice	prodamount	prodinfo	likecnt	userid
		String data = String.format("%d\t%s\t%d\t%d\t%s\t%d\t%s",product.getProdnum(),product.getProdname(),
				product.getProdprice(),product.getProdamount(),product.getProdinfo(),0,product.getUserid());
		return dbConnection.insert(data);
	}
	public int getNewNum() {
		String lastPK = dbConnection.lastPK();
		if(lastPK == null) {
			return 1;
		}
		else {
			return Integer.parseInt(lastPK)+1;
		}
	}
	public ArrayList<ProductDTO> getList(String userid, int choice, int asc) {
		//choice : 1(prodnum) / 2(prodname) / 3(prodprice) / 4(likecnt)
		String[] cols = {"","prodnum","prodname","prodprice","likecnt"};
		String order_col = cols[choice];//정렬 기준이 되는 컬럼 명
//		[
//			{1,"구찌 지우개",1000000,2,"잘 안지워집니다",0,"apple"}
//			{2	구찌 연필	1500000	5	잘 안써집니다	0	apple}
//		]
		ArrayList<String[]> result = dbConnection.select_order_by(6,userid,order_col,asc==1);
		ArrayList<ProductDTO> list = new ArrayList<>();
		if(result.size() > 0) {
			for(String[] line : result) {
				ProductDTO product = new ProductDTO(
						Integer.parseInt(line[0]),
						line[1],
						Integer.parseInt(line[2]),
						Integer.parseInt(line[3]),
						line[4],
						Integer.parseInt(line[5]),
						line[6]
				);
				list.add(product);
			}
			return list;
		}
		return null;
	}
	
	public boolean deleteProductByProdnum(int prodnum) {
		return dbConnection.delete(prodnum+"");
	}
	
	public boolean updateProduct(int prodnum, String col, String newData) {
		return dbConnection.update(prodnum+"", col, newData);
	}
}
















