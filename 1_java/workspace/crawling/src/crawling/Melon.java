package crawling;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Melon {
	public static void main(String[] args) throws Exception {
		String url = "https://www.melon.com/";
		
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		//검색창에 키워드 입력
		Scanner sc = new Scanner(System.in);
		System.out.print("검색어: ");
		String keyword = sc.nextLine();
		
		//검색창을 찾아
		WebElement top_search = driver.findElement(By.id("top_search"));
		top_search.click();
		top_search.sendKeys(keyword); //sendKeys: 검색창에 키워드 넘겨줌
		top_search.sendKeys(Keys.ENTER); //enter까지 보냄
		Thread.sleep(500);
		
		try {
			WebElement frm_searchArtist = driver.findElement(By.id("frm_searchArtist")); //검색 시도 시 찾을 수 없을 때
			
			List<WebElement> numList = frm_searchArtist.findElements(By.className("no"));
			List<WebElement> titleList = frm_searchArtist.findElements(By.className("fc_gray"));
			List<WebElement> artistList = frm_searchArtist.findElements(By.id("artistName"));
			
			for(int i = 0; i < numList.size(); i++) {
				System.out.printf("%s. %s(아티스트: %s)\n", 
						numList.get(i).getText(),
						titleList.get(i).getText(),
						artistList.get(i).getText()
						);
			}
			System.out.print("가사를 볼 노래 번호: ");
			int num = sc.nextInt();
			
			frm_searchArtist.findElements(By.className("btn_icon_detail")).get(num-1).click();
			Thread.sleep(500);
			
			try {
				driver.findElement(By.className("lyric_none"));
				
				try {
					driver.findElement(By.className("adult_register"));
					System.out.println("성인 노래 가사는 열람하실 수 없습니다.");
					//성인인증 로그인 유도 코드 
					
				} catch (Exception e) {
					System.out.println("가사가 없는 곡입니다.");
				}				
				
			} catch (NoSuchElementException e) {
				//가사가 있는 경우, 펼치기 버튼이 있으니 클릭
				driver.findElement(By.className("arrow_d")).click();
				WebElement lyric = driver.findElement(By.className("lyric"));
				System.out.println("-------------------- 가사 --------------------");
				System.out.println(lyric.getText());
				System.out.println("---------------------------------------------");
			}
					
		} catch (NoSuchElementException e) {
			System.out.println("검색 결과가 없습니다.");
		}
		
		driver.quit();
	}
}
