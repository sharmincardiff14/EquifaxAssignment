package test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import main.SampleTestPage;
import Framework.DataProvider;

public class SampleTest extends SeleniumWebTest {
	
	@SuppressWarnings("rawtypes")
	@Test
	public void amazonItemCostAssertion() throws Exception{		
		SampleTestPage samplePage = new SampleTestPage(driver);
		List obj = DataProvider.getExcel("TestData.xls", "UserData");
		String baseUrl = DataProvider.getData(obj, "Login URL", 1);
		samplePage.environmentURL(baseUrl);
		samplePage.searchForABook("qa testing for beginners");
		String cost = samplePage.getFirstItemCost();
		System.out.println("First Item Cost:::   "+ cost);
		String costOnItemPage = samplePage.getCostOnFirstItemSelectionScreen();
		System.out.println("First Item Cost costOnItemPage:::   "+ costOnItemPage);
		assertEquals(cost,costOnItemPage);
		String costOnCart = samplePage.getCostFromCart();
		System.out.println("First Item Cost costOnCart:::   "+ costOnCart);
		assertEquals(cost,costOnItemPage,costOnCart);
	}
	
	
}
