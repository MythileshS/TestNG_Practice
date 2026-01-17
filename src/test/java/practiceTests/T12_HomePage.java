package practiceTests;

//import java.util.List;

import org.testng.annotations.Test;

//import NGtests.T1_LogInOut;
import NGtests.T2_HomePageCart;

public class T12_HomePage extends T2_HomePageCart{
	

	//Test - 5 Adding items to and Remove items from Cart
	@Test (priority = 1)
	public void addRemoveCart() throws Exception {
		
		System.out.println("		Test 5 - Add and Remove from Cart\n");
		for (String user: usernames) {
			logIn(user, password);
			Thread.sleep(2000);
			clearCart();
			Thread.sleep(2000);
			addItemsToCart(user);
			Thread.sleep(2000);
			//logOut();
		}
	}
	
	//Test 6 - Drop down Functionality
	@Test (priority = 2)
	public void filters() throws Exception {
		
		System.out.println("		Test 6 - Drop down Functionality\n");
		for (String user: usernames) {
			logIn(user, password);
			Thread.sleep(2000);
			filterFunction(user);
			Thread.sleep(1000);
			//logOut();
		}
		
	}
	
}
