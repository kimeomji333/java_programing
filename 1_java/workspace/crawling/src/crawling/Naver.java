package crawling;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Naver {
	public static void main(String[] args) throws Exception {
		String url = "https://naver.com/";
		
		WebDriver driver = new ChromeDriver();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("검색어를 입력해주세요: ");
		String keyword = sc.nextLine();
		
		//검색창 찾기
		WebElement search_input = driver.findElement(By.id("query"));
		search_input.click();
		search_input.sendKeys(keyword);
		search_input.sendKeys(Keys.ENTER);
		Thread.sleep(500);
		
		try {
			//검색한 결과: 영화 //뭘 보여줄꺼야?
			//정적 페이지 : List 1. 영화이름, 장르, 개봉일자, 평점
			//반복문을 돌면서 card_item에서 하나씩 위의 요소를 출력한다. 
			WebElement card_item = driver.findElement(By.className("card_item"));
			
			List<WebElement> movieName = card_item.findElements(By.className("title"));
			List<WebElement> genre = card_item.findElements(By.className("info_group")); //info_group.get(0).getText().substring(개요 잘라내기)
			List<WebElement> releaseDate = card_item.findElements(By.className(""));
			
			//info_group이 여러개니 배열 인덱스 번호로 가져와서 findElements로 찾는다.
			//장르인 경우, info_group.get(
			
			
			//영화 이름 검색 시 뭘 보여줄꺼야?
			//영화이름, 개요, 개봉, 평점, 관객수, 한줄평, 예매하기 버튼?
			
			
			
		} catch (NoSuchElementException e) {
			System.out.println("검색 결과가 없습니다.");
		}
		
		
		
		
	}
}
