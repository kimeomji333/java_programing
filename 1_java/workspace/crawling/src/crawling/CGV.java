package crawling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//정적페이지 가져오기
public class CGV {
	public static void main(String[] args) throws Exception {
		String url = "https://www.cgv.co.kr/movies";
		
		//컨트롤 하기 위한 드라이버
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		//(홈페이지의 특성에 맞게)페이지에 들어가면 '더보기'버튼을 눌러야함 -> By 클래스로 어떤 것으로 찾을 지 선택 가능
		driver.findElement(By.className("btn-more-fontbold")).click();
		Thread.sleep(500); //검색하는게 걸리는 시간이 있으니 잠시 잠재운다.
		
		//만약 btn-more-fontbold이 여러개라면? 더보기 버튼이 하나밖에 없으니 여기선 하나뿐임을 유추할 수 있음
		
		List<WebElement> titleList = driver.findElements(By.className("title")); //리턴타입을 보면, WebElement
		List<WebElement> scoreList = driver.findElements(By.className("score"));
		List<WebElement> txt_info_list = driver.findElements(By.className("txt-info"));
		
		for(int i = 0; i < titleList.size(); i++) {
			//txt_info_list에서 text들(2024.07.24개봉)을 가져와서 10개 잘라 날짜만 가져왔음
			String releaseDate = txt_info_list.get(i).getText().substring(0, 10);
			//포장할 건 아니니, 바로 출력해보겠음
			//class="percent"가 여러개니 리스트에 담아 배열 인덱스 번호(scoreList.get(i))로 가져와서 findElements 에서 찾는다.
			List<WebElement> percents = scoreList.get(i).findElements(By.className("percent"));
			System.out.println("--------------------------");
			System.out.print(titleList.get(i).getText() +  "(");
			System.out.println(releaseDate+ ")");
			System.out.println(percents.get(0).getText()+ "/ 에그스코어: " + percents.get(1).getText());
		}
		
//		driver.close(); //창닫고
		driver.quit(); //나가고
	}
}
