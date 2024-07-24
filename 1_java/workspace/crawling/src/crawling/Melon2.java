package crawling;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Melon2 {
	public static void main(String[] args) throws Exception {
		String url = "https://www.melon.com/";
		
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		Scanner sc = new Scanner(System.in);
		System.out.print("검색하실 가수 이름을 입력하세요: ");
		String keyword = sc.nextLine();
		
		//검색창 -> 키워드 보내기
		WebElement top_search = driver.findElement(By.id("top_search"));
		top_search.sendKeys(keyword);
		top_search.sendKeys(Keys.ENTER);
		Thread.sleep(500);
		
		try {
			//찾는게 뭐야. 뭘 출력할꺼야. 번호. 노래제목(아티스트: 아티스트이름)
			//번호, 노래제목, 아티스트이름
			WebElement frm_searchArtist = driver.findElement(By.id("frm_searchArtist"));
			
			List<WebElement> numList = frm_searchArtist.findElements(By.className("no"));
			List<WebElement> titleList = frm_searchArtist.findElements(By.className("fc_gray"));
			List<WebElement> artistName = frm_searchArtist.findElements(By.id("artistName"));
			
			for(int i = 0; i < numList.size(); i++) {
				System.out.printf("%s. %s(아티스트: %s)\n", 
						numList.get(i).getText(),
						titleList.get(i).getText(),
						artistName.get(i).getText()
						);
			}
			
			//노래 가사까지 출력해보자.
			System.out.print("가사를 볼 노래 번호를 입력해주세요: ");
			int num = sc.nextInt();
			
			frm_searchArtist.findElements(By.className("btn_icon_detail")).get(num-1).click();
			Thread.sleep(500);
			
			try {
				//가사가 없는 경우
				driver.findElement(By.className("lyric_none"));
				
				//성인인증이 필요할 경우
				try {
					driver.findElement(By.className("adult_register"));
					System.out.println("성인 노래 가사는 열람하실 수 없습니다.");
				} catch (Exception e) {
					//클래식처럼 가사가 없는 경우
					System.out.println("가사가 없는 곡입니다.");
				}
				
			} catch (NoSuchElementException e) {
				// 가사가 있는 경우, 펼치기 버튼이 있으니 클릭
				driver.findElement(By.className("arrow_d")).click();
				WebElement lyric = driver.findElement(By.className("lyric"));
				System.out.println("-----------------");
				System.out.println(lyric.getText());
				System.out.println("-----------------");
			}
			
		} catch (NoSuchElementException e) {
			System.out.println("검색 결과가 없습니다.");
		}
		
		driver.quit();
	}
}
