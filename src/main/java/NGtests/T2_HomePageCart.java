package NGtests;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class T2_HomePageCart extends T1_LogInOut{
	
	public String cartPath = "//a[@class='shopping_cart_link']";
	public String productsInfoPath = "//*[text() = 'Products']";
	
	
	private String addToCartItemsPath = "//*[text() = 'Add to cart']";
	private String removeCartItemsPath = "//*[text() = 'Remove']";
	private String fullCartPath = "//*[text()='6']";
	private String selectPath = "//select";
	private String optionsPath = "//option";
	private String productsPath = "//div[@data-test='inventory-item-name']";
	private String pricesPath = "//div[@data-test='inventory-item-price']";
	
	public List<String> getElementsTextList(String xpath){
		return getDriver().findElements(By.xpath(xpath)).stream().map(WebElement:: getText).collect(Collectors.toList());
	}
	
	public List<String> getAttributesList(String xpath, String attribute){
		List<WebElement> elements = getDriver().findElements(By.xpath(xpath));
		List<String> items = new ArrayList<>();
		
		for (WebElement element: elements) {
			String item = element.getAttribute(attribute);
			items.add(item);
		}
		
		return items;
	}
	
	public void clearCart() {
		
		try {
			String cartCheck = getXPath(cartPath).getText();
			if (!cartCheck.isEmpty()) {
				getXPath(cartPath).click();
				List<String> removeItems = getAttributesList(removeCartItemsPath, "name");
				for (int i = 0; i < removeItems.size(); i++) {
					getXPath(removeCartItemsPath).click();
				}
				System.out.println("Now Cart is empty");
				getXPath(mainMenuPath).click();
				getXPath(homePagePath).click();
				
			} else {
				System.out.println("Cart is empty");
			}
		} catch (Exception e){
			navigate();
		}
	}
	
	public void addItemsToCart(String username) {
		
		try {
			boolean infoProducts = getXPath(productsInfoPath).isDisplayed();
			if (infoProducts) {
				List<String> addToCartItems = getAttributesList(addToCartItemsPath, "name");
				for (int i = 0; i < addToCartItems.size(); i++) {
					getXPath(addToCartItemsPath).click();
				}
				
				boolean fullCart = getXPath(fullCartPath).isDisplayed();
				
				if (fullCart) {
					System.out.println("All items were added to cart for '" + username + "'\n");
				}
			}
			
			
		} catch (Exception e) {
			System.out.println("Unable to add all items to '" + username + "' cart\n");
		}
	}
	
	public void filterFunction(String username) throws Exception {

		try {
			List<String> dropDownList = getElementsTextList(optionsPath);
			WebElement dropdown = getXPath(selectPath);
			Select select = new Select(dropdown);
			for (int i = 0; i < dropDownList.size(); i++) {
				Thread.sleep(1000);
				String filter = dropDownList.get(i);
				System.out.println("\n"+filter+": ");
				
				select.selectByIndex(i);
				List<String> products = getElementsTextList(productsPath);
				List<String> prices = getElementsTextList(pricesPath);
				
				StringBuilder sb = new StringBuilder("Following are the products and prices when " + filter + " applied:\n")
						.append("Products" + products + "\n")
						.append("Prices" + prices + "\n");
				
				System.out.println(sb.toString());
			}
		}
		catch (Exception e) {
			System.out.println("Unable to get Products and Prices for '" + username + "'\n");
			//logOut();
		}
	}
}
