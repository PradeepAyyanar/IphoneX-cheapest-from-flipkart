package asdf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\pradeep\\selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String baseUrl = "http://flipkart.com";
        driver.get(baseUrl);
        driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
        driver.findElement(By.xpath("//input[@title='Search for products, brands and more']")).sendKeys("Iphonex");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        WebElement eleWin = driver.findElement(By.xpath("//div[@class='_1HmYoV _35HD7C'][2]"));
        eleWin.click();
        List<String> cost = new ArrayList<String>();
        List<WebElement> elem = driver.findElements(By.xpath("//div[@class='_1vC4OE _2rQ-NK']"));
        for(WebElement ele : elem){
        	String txt = ele.getText().replaceAll("\\D", "");
        	cost.add(txt);
        }
        Collections.sort(cost);
        driver.close();
        System.out.println("The cheapest IphoneX available in Flipkart now is for Rs."+cost.get(0));

	}

}
