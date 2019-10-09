package com.hellofresh.challenge;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.hellofresh.basemanager.BaseClass;
import com.hellofresh.pages.AuthPage;
import com.hellofresh.pages.HomePage;
import com.hellofresh.pages.MyAccountPage;
import com.hellofresh.pages.OrderConfirmationPage;
import com.hellofresh.pages.ProcessOrderPage;

public class ShoppingPortalCheckoutTest extends BaseClass {

	HomePage homepage;

	AuthPage authpage;

	MyAccountPage myAccountPage;

	ProcessOrderPage processOrderPage;

	OrderConfirmationPage orderConfirmationPage;

	@Test(dataProvider = "ShoppingPortal", dataProviderClass = BaseClass.class)
	public void orderProcessing_CheckoutTest(String shoppingItem, String quantity, String size, String email,
			String password, String firstName, String lastName) throws InterruptedException, IOException {

		homepage = PageFactory.initElements(getDriver(), HomePage.class);
		homepage.clickSignIn();

		authpage = PageFactory.initElements(getDriver(), AuthPage.class);
		authpage.loginToShoppingPortal(email, password);

		myAccountPage = PageFactory.initElements(getDriver(), MyAccountPage.class);
		myAccountPage.verifyLoginState(firstName, lastName);

		myAccountPage.clickWomenLabel();

		processOrderPage = PageFactory.initElements(getDriver(), ProcessOrderPage.class);
		processOrderPage.processOrder(shoppingItem, quantity, size);

		orderConfirmationPage = PageFactory.initElements(getDriver(), OrderConfirmationPage.class);
		orderConfirmationPage.verifyOrderConfirmation();

	}

	@AfterTest
	public void clickLogout() {

		homepage.clickLogout();
	}

}
