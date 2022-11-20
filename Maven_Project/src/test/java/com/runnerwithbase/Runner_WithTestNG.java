package com.runnerwithbase;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.baseclass.Page_Object_Manager;
import com.baseclass.Pom_Utility_Book;
import com.baseclass.Pom_Utility_Hotelsearch;
import com.baseclass.Pom_Utility_Login;
import com.baseclass.Pom_Utility_Logout;
import com.baseclass.Utility_Files;

public class Runner_WithTestNG extends Utility_Files {

	public static WebDriver driver = browser_Config("Edge");
	public static Page_Object_Manager manager = new Page_Object_Manager(driver);

	@Test(priority = -1)
	private void url() {
		getUrl("https://adactinhotelapp.com/");
		maximize();
	}

	@Test(priority = 0)
	private void login() throws InvalidFormatException, IOException {
		Pom_Utility_Login log = new Pom_Utility_Login(driver);
		sendKey(manager.getLog().getUname(),
				particular_Cell_Data("C:\\Users\\User\\eclipse-workspace\\Maven_Project\\TestCases.xlsx", 0, 2, 5));// data
																													// from
																													// excel
		sendKey(manager.getLog().getPword(),
				particular_Cell_Data("C:\\Users\\User\\eclipse-workspace\\Maven_Project\\TestCases.xlsx", 0, 3, 5));// data
																													// from
																													// excel
		click_On_Element(manager.getLog().getLogin());

	}

	@Test(priority = 1)
	private void hotelsearch() {
		Pom_Utility_Hotelsearch search = new Pom_Utility_Hotelsearch(driver);
		selectByIndex(manager.getSearch().getLocation(), 2);
		selectByIndex(manager.getSearch().getHotels(), 2);
		selectByIndex(manager.getSearch().getRoomnos(), 2);
		selectByIndex(manager.getSearch().getRoomtype(), 2);
		// selectByIndex(search.getCheckin(), 0);
		// selectByIndex(search.getCheckout(), 0);
		selectByIndex(manager.getSearch().getAdultroom(), 2);
		selectByIndex(manager.getSearch().getChildroom(), 2);
		click_On_Element(manager.getSearch().getSubmit_btn());
		// Pom_Utility_Select slt = new Pom_Utility_Select(driver);
		click_On_Element(manager.getSlt().getRadio_Btn());
		click_On_Element(manager.getSlt().getContinue_Btn());

	}

	@Test(priority = 2)
	private void hotelbook() {
		Pom_Utility_Book book = new Pom_Utility_Book(driver);
		sendKey(manager.getBook().getFirstname(), "Anbu");
		sendKey(manager.getBook().getLastname(), "M");
		sendKey(manager.getBook().getAddress(), "4/300");
		sendKey(manager.getBook().getCcnum(), "0000000000000000");
		selectByIndex(manager.getBook().getCctype(), 2);
		selectByIndex(manager.getBook().getCcexpmonth(), 2);
		selectByIndex(manager.getBook().getCcexpyear(), 2);
		sendKey(manager.getBook().getCccvv(), "123");
		click_On_Element(manager.getBook().getBooknow());

	}

	@Test(priority = 3)
	private void logout() throws InterruptedException {

		Pom_Utility_Logout logout = new Pom_Utility_Logout(driver);
		sleep(5000);
		click_On_Element(manager.getLogout().getLogout());

	}

}
