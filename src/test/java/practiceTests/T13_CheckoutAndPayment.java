package practiceTests;

import org.testng.annotations.Test;

import NGtests.T3_Payment;

public class T13_CheckoutAndPayment extends T3_Payment{
	
	private String[] fnames = {"", "123", "Jaya", "#@$###", "DSSSSSSSDDDDDDDDDDDDDsssss"}; // Input first name list
	private String[] lnames = {"", "456", "Krishna", "(*()()DK", "dddddddddddddddddddddddddddddddd"}; // Input last name list
	private String[] zipcodes = {"", "1", "5150010", "515001", "1234567890", "*((&^&"}; // Input zipcodes list
	
	//Test 7 - Checkout Functionality
	@Test
	public void checkout() throws Exception{
		
		System.out.println("\n		Test 7 - Checkout Functionality");
		
		for (String user: usernames) {
			
			logIn(user, "secret_sauce");
			Thread.sleep(2000);
			clearCart();
			Thread.sleep(2000);
			addItemsToCart(user);
			Thread.sleep(2000);
			checkoutOrderFunction(user, fnames, lnames, zipcodes);
			//logOut();
		}
		
	}
	
	
	
}
