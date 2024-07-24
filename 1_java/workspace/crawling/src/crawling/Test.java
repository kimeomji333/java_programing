package crawling;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
	public static void main(String[] args) {
		String url = "https://naver.com";
		WebDriver driver = new ChromeDriver();
		
		driver.get(url);
		
	}

}
