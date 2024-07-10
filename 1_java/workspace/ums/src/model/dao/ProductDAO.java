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
		//가장 마지막 상품 번호 받아오기
		String lastPK = dbConnection.lastPK();
		//받아온게 없다면
		if(lastPK == null) {
			//첫 등록이라 새로운 번호는 1번
			return 1;
		}
		//받아온게 있다면
		else {
			//그 마지막 번호 + 1 번
			return Integer.parseInt(lastPK)+1;
		}
	}
	public ArrayList<ProductDTO> getList(String userid, int choice, int asc) {
		//choice : 1(prodnum) / 2(prodname) / 3(prodprice) / 4(likecnt)
		//asc : 1(오름차순) / 2(내림차순)
		String[] cols = {"","prodnum","prodname","prodprice","likecnt"};
		String order_col = cols[choice];//정렬 기준이 되는 컬럼 명
//		[
//			{1,"구찌 지우개",1000000,2,"잘 안지워집니다",0,"apple"}
//			{2	구찌 연필	1500000	5	잘 안써집니다	0	apple}
//		]
		//API 활용해서 기준 컬럼으로 검색
		//(6번 컬럼에 userid 값이 있다면 검색하되 order_col 기준으로 asc이 1이면 오름차순 정렬로 검색)
		ArrayList<String[]> result = dbConnection.select_order_by(6,userid,order_col,asc==1);
		//result : 각 상품 정보들이 배열로 묶인 채 List에 추가되어 있는 형태
		//list : 실제 결과물(ProductDTO)들이 담겨있을 리스트
		ArrayList<ProductDTO> list = new ArrayList<>();
		if(result.size() > 0) {
			//검색된 결과에서 한 줄(String[])씩 꺼내오며
			for(String[] line : result) {
				//꺼내진 배열에 있는 정보들로 ProductDTO 객체 생성
				ProductDTO product = new ProductDTO(
						Integer.parseInt(line[0]),
						line[1],
						Integer.parseInt(line[2]),
						Integer.parseInt(line[3]),
						line[4],
						Integer.parseInt(line[5]),
						line[6]
				);
				//생성된 객체를 list에 추가
				list.add(product);
			}
			//그 리스트 리턴
			return list;
		}
		//검색된 결과가 없다면 null을 리턴
		return null;
	}
	public boolean deleteProductByProdnum(int prodnum) {
		return dbConnection.delete(prodnum+"");
	}
	public boolean updateProduct(int prodnum, String col, String newData) {
		return dbConnection.update(prodnum+"", col, newData);
	}
	public ArrayList<ProductDTO> getAllProduct() {
		ArrayList<String[]> list = dbConnection.select();
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
				//생성된 객체를 list에 추가
				result.add(product);
			}
			return result;
		}
		else {
			return null;
		}
	}
	public ProductDTO getProductByProdnum(int prodnum) {
		ArrayList<String[]> result = dbConnection.select(0, prodnum+"");
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
















