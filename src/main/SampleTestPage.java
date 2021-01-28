package main;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SampleTestPage extends BasePage {
	

		
		WebDriver driver;
		BasePage base = new BasePage();
		// Constructor
		public SampleTestPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

		
		// Page Constants

		@FindBy(xpath = "//*[@id='nav-link-accountList']") 
		public WebElement signInNavLink;
		
		@FindBy(xpath = "//*[@id='ap_email']") 
		public WebElement txtUserName;
		
		@FindBy(xpath = "//*[@id='ap_password']") 
		public WebElement pwdPassword;
		
		@FindBy(xpath = "//*[@id='signInSubmit']") 
		public WebElement btnSignin;
		
		@FindBy(xpath = "//*[@id='continue']") 
		public WebElement btnContinue;
		
		@FindBy(xpath = "//*[@id='twotabsearchtextbox']") 
		public WebElement searchBox;
		
		@FindBy(xpath = "//*[@id='nav-search-submit-button']") 
		public WebElement searchSubmit;
		
		@FindBy(xpath = "(//*[@class = 'a-section aok-relative s-image-fixed-height'])[1]") 
		public WebElement firstSearchItem;
		
		@FindBy(xpath = "(//*[@class = 'a-price-whole'])[1]") 
		public WebElement firstSearchItemCost;
		
		@FindBy(xpath = "//*[@id='newBuyBoxPrice']") 
		public WebElement costOnItemPage;
		
		@FindBy(xpath = "//*[@id='add-to-cart-button']") 
		public WebElement addToCartBtn;
		
		@FindBy(xpath = "//*[@id='sc-subtotal-amount-buybox']/span") 
		public WebElement cartTotal;
		
		@FindBy(xpath = "//*[@id='hlb-view-cart-announce']") 
		public WebElement viewCart;
		
		@FindBy(xpath = "//*[@id='sc-buy-box-ptc-button']/span/input") 
		public WebElement proceedToCart;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		public void loginAction(String baseUrl, String userName, String password) {
			environmentURL(baseUrl);
			customerLogin(userName, password);
		}

		public void customerLogin(String userName, String password) {
			signInNavLink.click();
			txtUserName.clear();
			txtUserName.sendKeys(userName);
			btnContinue.click();
			pwdPassword.clear();
			pwdPassword.sendKeys(password);
			btnSignin.click();
			explicitWait(30000);
		}

		public void environmentURL(String baseUrl) {
			explicitWait(3000);
			driver.get(baseUrl);
		}
		
		public void explicitWait(int waitTime) {
			// Put in an implicit wait
			try {
				Thread.sleep(waitTime);
			}
			catch(InterruptedException e) {
				//Thread.currentThread().interrupt();
				System.out.println("The sleep function was interupted");
			}
		 }

		public void searchForABook(String string) {
			searchBox.sendKeys(string);
			searchSubmit.click();
			
		}

		public String getFirstItemCost() {
			String cost = firstSearchItemCost.getText();
			firstSearchItem.click();
			return cost;
		}

		public String getCostOnFirstItemSelectionScreen() {
			String cost = costOnItemPage.getText();
			addToCartBtn.click();
			viewCart.click();
			String costAfterRemoving = cost.replaceAll("\\$","" );
			if(costAfterRemoving.contains(".00"))
			{
				String costAfterRemoving00 = costAfterRemoving.replace(".00","" );
				return costAfterRemoving00;
			}else
			{
				return costAfterRemoving;
			}
				
		}
		
		public String getCostFromCart() {
			String cost = cartTotal.getText();
			proceedToCart.click();
			String costAfterRemoving = cost.replaceAll("\\$","" );
			if(costAfterRemoving.contains(".00"))
			{
				String costAfterRemoving00 = costAfterRemoving.replace(".00","" );
				return costAfterRemoving00;
			}else
			{
				return costAfterRemoving;
			}
				
		}
}
