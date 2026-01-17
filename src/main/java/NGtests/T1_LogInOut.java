package NGtests;



//import java.util.ArrayList;
//import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import DriverUtils.Web_Driver;

public class T1_LogInOut extends Web_Driver{
	
	public String[] usernames = {"standard_user", "locked_out_user", "problem_user", "performance_glitch_user",
			"error_user", "visual_user"};
	public String password = "secret_sauce";
	
	public String[] wrongUserNames = {"","st@ndard_user", "123456789", "@@#@$$###$", "l0ckedout usere"}; // Invalid usernames
	public String[] wrongPasscodes = {"","sauce_secret", "secret_s@uce", "123354588", "&*((*&&^%$$^^"}; // Invalid passwords
	public String mainMenuPath = "//button[text() = 'Open Menu']";
	public String productsInfoPath = "//*[text() = 'Products']";
	public String homePagePath = "//*[text() = 'All Items']";
	
	private String webSite = "https://www.saucedemo.com";
	private String logInPath = "//input[@name = 'user-name']";
	private String passwordPath = "//input[@name = 'password']";
	private String logInButtonPath = "//input[@name = 'login-button']";
	private String logOutButtonPath = "//a[text() = 'Logout']";
	
	
	public WebElement getXPath(String path) {
		
		return getDriver().findElement(By.xpath(path));
	}
	
	@BeforeMethod
	public void navigate() {
		getDriver().get(webSite);
		getDriver().manage().window().maximize();
	}
	
	public boolean getProducts() {
		try {
			return getXPath(productsInfoPath).isDisplayed();
		} catch (Exception e) {
			return "unable to get products page" != null;
		}
	}
	
	public void logIn(String username, String password) {
		//navigate();
		
		try {
			getXPath(logInPath).sendKeys(username);
			getXPath(passwordPath).sendKeys(password);
			getXPath(logInButtonPath).click();
			
			boolean productsPage = getXPath(productsInfoPath).isDisplayed();
			if (productsPage) {
				System.out.println("'" + username + "'  able to login");
				
			}
		}
		catch (Exception e) {
			System.out.println("'" + username + "' unable to login with password '" + password + "'");
			navigate();
		}
		
	}
	
	//@AfterMethod
	public void logOut() {
		
		try {
			getXPath(mainMenuPath).click();
			getXPath(logOutButtonPath).click();
			System.out.println("\nlogged out");
		}
		catch (Exception e) {
			navigate();
		}
	}
}
