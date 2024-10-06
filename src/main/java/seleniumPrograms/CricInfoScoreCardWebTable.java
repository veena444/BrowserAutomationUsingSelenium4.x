package seleniumPrograms;
/*
 * Handling web table and print the details.
 */
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CricInfoScoreCardWebTable {
	
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get
		("https://www.espncricinfo.com/series/the-hundred-men-s-competition-2024-1417778/manchester-originals-men-vs-oval-invincibles-men-18th-match-1417807/full-scorecard");
		
		System.out.println(getPlayerScoreCard("Dawid Malan")); 
		System.out.println(getWicketTakerName("Dawid Malan"));
		
		System.out.println(getPlayerScoreCard("Tom Curran")); 
		System.out.println(getWicketTakerName("Tom Curran"));
		
		driver.quit();
		
	}
	
	//generic methods
	
	public static List<String> getPlayerScoreCard(String playerName) {
		
	List<WebElement> scoreList = driver.findElements(By.xpath("//span[text()='"+playerName+"']/ancestor::td/following-sibling::td[contains(@class,'ds-text-right')]"));
	List<String> scoreCardList = new ArrayList<String>();
	for(WebElement e: scoreList) {
		String text = e.getText();
		scoreCardList.add(text);
	}
	return scoreCardList;
		
	}
	
	public static String getWicketTakerName(String playerName) {
		return driver.findElement(By.xpath("//span[text()='"+playerName+"']/ancestor::td/following-sibling::td/span")).getText();
	}

}
