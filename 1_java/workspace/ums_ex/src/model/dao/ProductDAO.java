package model.dao;

import java.util.ArrayList;

import model.dto.ProductDTO;
import model2.DBConnection;

public class ProductDAO {
	DBConnection connection;
	
	public ProductDAO() {
		connection = new DBConnection("ProductTable.txt");
	}

	public int getNewNum() {
		String lastPK = connection.lastPK();
		if(lastPK == null) {
			return 	1;
		} else {
			return Integer.parseInt(lastPK) + 1;
		}
	}

	public boolean insertProduct(ProductDTO product) {
		String data = String.format("%d\t%s\t%d\t%d\t%s\t%d\t%s",product.getProdnum(),product.getProdname(),
				product.getProdprice(),product.getProdamount(),product.getProdinfo(),0,product.getUserid());
		return connection.insert(data);
	}

	public ArrayList<ProductDTO> getList(String userid, int choice, int asc) {
		//choice : 1(prodnum) / 2(prodname) / 3(prodprice) / 4(likecnt)
		String[] cols = {"", "prodnum", "prodname", "prodprice", "likecnt"};
		String order_col = cols[choice];
		
		ArrayList<String[]> result = connection.select_order_by(6, userid, order_col, asc==1);
		ArrayList<ProductDTO> list = new ArrayList<>();
		if(result.size() > 0) {
			for(String[] line : result) {
				ProductDTO dto = new ProductDTO(
						Integer.parseInt(line[0]),
						line[1],
						Integer.parseInt(line[2]),
						Integer.parseInt(line[3]),
						line[4],
						Integer.parseInt(line[5]),
						line[6]
				);
				list.add(dto);
			}
			return list;
		}
		return null;
	}

	public boolean deleteProductByProdnum(int prodnum) {
		return connection.delete(prodnum+"");
	}

	public boolean updateProduct(int prodnum, String col, String newData) {
		return connection.update(prodnum+"", col, newData);
	}

	public ArrayList<ProductDTO> getAllProduct() {
		ArrayList<String[]> list = connection.select();
		ArrayList<ProductDTO> result = new ArrayList<>();
		if(list.size() > 0) {
			for(String[] line : list) {
				ProductDTO product = new ProductDTO(
						Integer.parseInt(line[0]),
						line[1],
						Integer.parseInt(line[2]),
						Integer.parseInt(line[3]),
						line[4],
						Integer.parseInt(line[5]),
						line[6]
					);
				result.add(product);
			}
			return result;
		} else {
			return null;
		}
	}

	public ProductDTO getProductByProdnum(int prodnum) {
		ArrayList<String[]> result = connection.select(0, prodnum+"");
		String[] line = result.get(0);
		ProductDTO product = new ProductDTO(
				Integer.parseInt(line[0]),
				line[1],
				Integer.parseInt(line[2]),
				Integer.parseInt(line[3]),
				line[4],
				Integer.parseInt(line[5]),
				line[6]
		);
		return product;
	}
	
}
