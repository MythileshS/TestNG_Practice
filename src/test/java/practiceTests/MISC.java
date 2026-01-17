package practiceTests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MISC {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		
		
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@placeholder = 'Username']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@placeholder = 'Password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@name = 'login-button']")).click();
		String cartCheck = driver.findElement(By.xpath("//a[@class = 'shopping_cart_link']")).getText();
		System.out.println("Before adding: " + cartCheck + "-> " + cartCheck.getClass().getSimpleName());
		Thread.sleep(2000);
		
		if (cartCheck.isEmpty()) {
			System.out.println("cart is empty");
		} else {
			System.out.println("Cart is not empty");
		}
		
		//Add items to cart
		
		List<WebElement> elementsAdd = driver.findElements(By.xpath("//*[text() = 'Add to cart']"));
		List<String> classNamesAdd = new ArrayList<>();
		
		for (WebElement element: elementsAdd) {
			String className = element.getAttribute("name");
			classNamesAdd.add(className);
		}
		/*
		String classType = classNames.get(0).getClass().getSimpleName();
		System.out.println(classType);
		System.out.println(classNames);*/
		
		
		//Add items to cart
		for (String item: classNamesAdd) {
			driver.findElement(By.name(item)).click();
		}
			
		driver.findElement(By.xpath("//a[@class = 'shopping_cart_link']")).click();
		

		//Remove items from cart
		List<WebElement> elementsRemove = driver.findElements(By.xpath("//*[text() = 'Remove']"));
		List<String> classNamesRemove = new ArrayList<>();
		
		for (WebElement element: elementsRemove) {
			String className = element.getAttribute("name");
			classNamesRemove.add(className);
		}
		//Remove items from cart
		for (String item: classNamesRemove) {
			driver.findElement(By.name(item)).click();
		}
		
		//Clear Cart
		/*try {
			String cartCheck = driver.findElement(By.xpath("//a[@class = 'shopping_cart_link']")).getText();
			
			boolean itemsInCart = 
		}*/
		
		
		
		//System.out.println("After adding: " + cartCheck + "-> " + cartCheck.getClass().getSimpleName());
		
		
		
		Thread.sleep(5000);
		driver.quit();
	}
	
}
