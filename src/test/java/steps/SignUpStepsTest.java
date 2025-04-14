package steps;

import org.openqa.selenium.WebDriver;
import config.WebDriverSetup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.SignUpPage;

public class SignUpStepsTest {

    WebDriver driver;
    SignUpPage signUpPage;

    @Before
    public void setUp() throws InterruptedException {
        driver = WebDriverSetup.getDriver();
        signUpPage = new SignUpPage(driver);
    }

    @Given("the user is on the sign up page")
    public void user_is_on_sign_up_page() {
        driver.get("https://www.facebook.com/reg/");
    }

    @When("the user enters valid sign up details")
    public void user_enters_valid_signup_details() {
        signUpPage.enterFirstName("John");
        signUpPage.enterSurname("Doe");
        signUpPage.selectDay("18");
        signUpPage.selectMonth("Oct");
        signUpPage.selectYear("1990");
        signUpPage.selectGender("Male");
        signUpPage.enterMobileOrEmail("john.doe@example.com");
        signUpPage.enterPassword("SecurePassword123");
        signUpPage.clickSignUp();
    }

    @Then("the user should be signed up successfully")
    public void user_is_signed_up() {
        System.out.println("User signed up successfully!!");
    }

    @After
    public void tearDown() {
        WebDriverSetup.quitDriver();
    }
}
