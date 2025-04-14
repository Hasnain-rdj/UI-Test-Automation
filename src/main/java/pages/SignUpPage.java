package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SignUpPage {
    WebDriver driver;
    WebDriverWait wait;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Locators
    By firstNameField = By.xpath("//input[@name='firstname']");
    By surnameField = By.xpath("//input[@name='lastname']");
    By dayDropdown = By.xpath("//select[@name='birthday_day']");
    By monthDropdown = By.xpath("//select[@name='birthday_month']");
    By yearDropdown = By.xpath("//select[@name='birthday_year']");
    By genderFemale = By.xpath("//input[@value='1']"); // Assuming '1' is for Female
    By genderMale = By.xpath("//input[@value='2']");   // Assuming '2' is for Male
    By genderCustom = By.xpath("//input[@value='-1']"); // Assuming '-1' is for Custom
    By mobileOrEmailField = By.xpath("//input[@name='reg_email__']");
    By passwordField = By.xpath("//input[@name='reg_passwd__']");
    By signUpButton = By.xpath("//button[@name='websubmit']");

    // Actions
    public void enterFirstName(String firstName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterSurname(String surname) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(surnameField));
        driver.findElement(surnameField).sendKeys(surname);
    }

    public void selectDay(String day) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(dayDropdown));
        Select selectDay = new Select(driver.findElement(dayDropdown));
        selectDay.selectByVisibleText(day);
    }

    public void selectMonth(String month) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(monthDropdown));
        Select selectMonth = new Select(driver.findElement(monthDropdown));
        selectMonth.selectByVisibleText(month);
    }

    public void selectYear(String year) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(yearDropdown));
        Select selectYear = new Select(driver.findElement(yearDropdown));
        selectYear.selectByVisibleText(year);
    }

    public void selectGender(String gender) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(genderFemale));
        switch (gender.toLowerCase()) {
            case "female":
                driver.findElement(genderFemale).click();
                break;
            case "male":
                driver.findElement(genderMale).click();
                break;
            case "custom":
                driver.findElement(genderCustom).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid gender: " + gender);
        }
    }

    public void enterMobileOrEmail(String contactInfo) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(mobileOrEmailField));
        driver.findElement(mobileOrEmailField).sendKeys(contactInfo);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSignUp() {
        wait.until(ExpectedConditions.elementToBeClickable(signUpButton));
        driver.findElement(signUpButton).click();
    }
}
