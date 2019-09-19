import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Child extends Base{

	
		public static void main(String[] args) throws IOException, InterruptedException {
			launch();
		    url("https://www.snapdeal.com/?utm_source=earth_brand_new&utm_campaign=brand_search&utm_medium=brand%20term,1t1&utm_content=homepage&utm_term=b,snapdeal");
		    driver.manage().window().maximize();
		    WebElement finds = driver.findElement(By.xpath("//input[@id='inputValEnter']"));
		    finds.sendKeys(getData(0,0));
		    screenshot("C:\\Users\\SATHISH\\eclipse-workspace\\Snapdeal\\screenshot\\p11.png");
		    WebElement search = driver.findElement(By.xpath("//button[@class='searchformButton col-xs-4 rippleGrey']"));
		    search.click();
		    screenshot("C:\\\\Users\\\\SATHISH\\\\Desktop\\\\p2.png");
		    WebElement item = driver.findElement(By.xpath("(//img[@class='product-image '])[1]"));
		    item.click();
		    screenshot("C:\\\\Users\\\\SATHISH\\\\Desktop\\\\p3.png");
		    String parent = parentwindow();
		    Set<String> allwind = allwind();
		    for (String x : allwind) {
		    	if(!parent.equals(x)) {
		    		driver.switchTo().window(x);
		    	}	
			}
		    WebElement cart = driver.findElement(By.xpath("//div[@id='add-cart-button-id']"));
		    cart.click();
		    screenshot("C:\\\\Users\\\\SATHISH\\\\Desktop\\\\p4.png");
		    Thread.sleep(2000);
		    WebElement clkcart = driver.findElement(By.xpath("//div[@class='cartInner']"));
		    clkcart.click();
		    screenshot("C:\\\\Users\\\\SATHISH\\\\Desktop\\\\p5.png");
		    Thread.sleep(2000);
		    WebElement quantity = driver.findElement(By.xpath("//div[@id='CS1']"));
		    quantity.click();
		    screenshot("C:\\\\Users\\\\SATHISH\\\\Desktop\\\\p6.png");
		    WebElement item2 = driver.findElement(By.xpath("//li[text()='2']"));
		    item2.click();
		    screenshot("C:\\\\Users\\\\SATHISH\\\\Desktop\\\\p7.png");
		    Thread.sleep(1500);
		    WebElement close = driver.findElement(By.xpath("//span[@class='icon-font-grey-size24 close-popup-icon']"));
		    close.click();
		    screenshot("C:\\Users\\SATHISH\\eclipse-workspace\\Snapdeal\\screenshot7.png");
		    WebElement clkcart1 = driver.findElement(By.xpath("//div[@class='cartInner']"));
		    clkcart1.click();
		    screenshot("C:\\\\Users\\\\SATHISH\\\\Desktop\\\\p8.png");
		    Thread.sleep(2000);
		    driver.quit();
			}

		


	}


