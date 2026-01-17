package practiceTests;

import org.testng.annotations.Test;

public class T1_FirstTestCase {
	
	@Test (priority = 1)//Priority
	public void navigate() {
		System.out.println("Navigated to browser");
	}
	
	@Test (priority = 2)
	public void login() {
		System.out.println("Logged in to browser");
	}
	
	@Test (priority = 3)
	public void logout() {
		System.out.println("Logged out from the browser");
	}
	
	@Test (priority = 4)
	public void browserQuit() {
		System.out.println("Browser Quit");
	}

}
