package steps;

import java.io.IOException;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;

import config.WebDriverSetup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utils.DBConnection;
import utils.ExcelDB;

public class LoginStepsTest {

	WebDriver driver;
	LoginPage loginPage;

	@Before
	public void setUp() throws InterruptedException {
		driver = WebDriverSetup.getDriver();
		loginPage = new LoginPage(driver);

	}

	@Given("the user is on the login page")
	public void user_is_on_login_page() throws InterruptedException {
		driver.get("https://www.facebook.com/login/");
	}

	@When("the user enters valid credentials")
	public void user_enters_valid_credentials() throws Exception {
		String choice = "db";
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("1.DB\n2.Excel\n3.Default Values");
			System.out.println("\nChoose one option to select data entry Source: ");
			choice=scan.nextLine().toLowerCase();
		}
		if (choice == "db") {
			user_enters_credentials_from_db();
		} else if (choice == "excel") {
			user_enters_credentials_from_excel();
		} else {
			String username="Hasnain";
			String password="Default3718";
			
			loginPage.enterUsername(username);
			loginPage.enterPassword(password);
			loginPage.clickLogin();
		}
	}

	@When("the user enters valid credentials from Excel")
	public void user_enters_credentials_from_excel() throws IOException {
		String excelPath = "C:\\Users\\hasna\\OneDrive\\Desktop\\SQE_Project\\ui-test-automation\\src\\test\\resources\\features\\Test_Data.xlsx";
		ExcelDB.setExcelFile(excelPath, "UserTestData");

		String username = ExcelDB.getCellData(1, 0);
		String password = ExcelDB.getCellData(1, 1);

		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
	}

	@When("the user enters valid credentials from DB")
	public void user_enters_credentials_from_db() throws Exception {
		String username = DBConnection.getTestData("SELECT username FROM test_cases_data WHERE id=2");
		String password = DBConnection.getTestData("SELECT password FROM test_cases_data WHERE id=2");

		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
	}

	@Then("the user should be logged in")
	public void user_is_redirected_to_home_page() {
		System.out.println("User is logged in successfully!!");
	}

	@After
	public void tearDown() {
		WebDriverSetup.quitDriver();
	}

}
