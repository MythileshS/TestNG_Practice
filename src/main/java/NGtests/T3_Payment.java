package NGtests;

//import java.util.ArrayList;
//import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import org.openqa.selenium.Keys;

public class T3_Payment extends T2_HomePageCart{

	
	private String orderInfoPath = "//*[text() ='Thank you for your order!']";
	private String firstnamePath = "//*[@name = 'firstName']";
	private String lastnamePath = "//*[@name = 'lastName']";
	private String postcodePath = "//*[@name = 'postalCode']";
	
	private String continueButtonPath = "//*[@name = 'continue']";
	private String checkoutButtonPath = "//*[text() = 'Checkout']";
	private String finishButtonPath = "//*[text() ='Finish']";
	//private String cancelButtonPath = "//*[text() = 'Cancel']";
	
	private String finalOverviewPath = "//*[text() = 'Checkout: Overview']";
	//private String checkOutPagelink = "https://www.saucedemo.com/checkout-step-one.html";

	
	//This method checks for whether given strings contains any digits
	public boolean isDigit(String str) {
		return str != null & str.matches("\\d+");
	}
	
	//This method checks for whether given strings contains any special characters
	public boolean hasSpecialCharacter(String str) {
		String word = str;
		Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
		Matcher matcher = pattern.matcher(word);
		
		if (matcher.find()) {
			return true;
		}
		
		return false;
	}
	
	public void testResult(String username, String firstname, String lastname, String zipcode, boolean overview) {
		
		Integer ziplen = String.valueOf(zipcode).length();
		
		if (overview && !isDigit(firstname) && !isDigit(lastname) && !hasSpecialCharacter(firstname) && !hasSpecialCharacter(lastname) && isDigit(zipcode) && ziplen == 6) {
			StringBuilder sb = new StringBuilder("Test Success: '" + username + "' able to checkout ")
					.append("with following correct values: \n")
					.append("firstname: " + firstname + "\n")
					.append("lastname: " + lastname + "\n")
					.append("zipcode: " + zipcode);
			System.out.println(sb.toString());
		} else {
			StringBuilder sb = new StringBuilder("Test Failed: '" + username + "' able to checkout with ")
					.append("with following incorrect values: \n")
					.append("firstname: " + firstname + "\n")
					.append("lastname: " + lastname + "\n")
					.append("zipcode: " + zipcode);
			System.out.println(sb.toString());
		}
	}
	
	public void checkoutOrderFunction(String username, String[] firstnames, String[] lastnames, String[] zipCodes) throws Exception{
		
		try {
			getXPath(cartPath).click();
			getXPath(checkoutButtonPath).click();
			for (int i = 0; i < firstnames.length; i++) {
				
				for (int j = 0; j < lastnames.length; j++) {
					
					for (int k = 0; k < zipCodes.length; k++) {
						
						try {
							getXPath(firstnamePath).sendKeys(firstnames[i]);
							getXPath(lastnamePath).sendKeys(lastnames[j]);
							getXPath(postcodePath).sendKeys(zipCodes[k]);
							getXPath(continueButtonPath).click();
							boolean overView = getXPath(finalOverviewPath).isDisplayed();
							getXPath(finishButtonPath).click();
							boolean orderInfo = getXPath(orderInfoPath).isDisplayed();
							testResult(username, firstnames[i], lastnames[j], zipCodes[k], overView);
							if (orderInfo) {
								System.out.println("'" + username + "' order Placed\n");
							}
						}
						catch (Exception e) {
							getXPath(cartPath).click();
							//Thread.sleep(1000);
							getXPath(checkoutButtonPath).click();
						}
		
					}
				} 
			
			}
		}
		catch (Exception e) {
			System.out.println("Checkout is not possible for '" + username + "'\n");
		}
	}
		
}
