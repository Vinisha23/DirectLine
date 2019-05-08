package Pages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InsurancePage {

    private WebDriver driver;
    private String baseUrl = "https://covercheck.vwfsinsuranceportal.co.uk/";
    private String regNumber = "OV12UYY";
    private String errorText = "Please enter a valid car registration";

    @FindBy(id = "vehicleReg")
    public WebElement regInputField;

    @FindBy(css = "button[class*='search']")
    public WebElement searchButton;

    @FindBy(css = "div[class='result']")
    public WebElement result;

    @FindBy(css = "div[class='error-required']")
    public WebElement errorMessage;

    @FindBy(css = "#page-container > div:nth-child(4) > div:nth-child(2) > span")
    public WebElement coverStartDate;

    @FindBy(css = "#page-container > div:nth-child(4) > div:nth-child(3) > span")
    public WebElement coverEndDate;


    public InsurancePage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void WaitForElement(WebElement ele) {
       WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(ele));
    }

    private void waitForPageToLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }

    public void NavigateToPage() {

        driver.get(baseUrl);
        waitForPageToLoad(driver);

    }

    public void enterRegistrationNumber(String number) {

        regInputField.clear();
        regInputField.sendKeys(number);
    }

    public void clickSearchButton() {

        searchButton.click();
    }

    public void verifyDetails() {

        WaitForElement(result);
        Assert.assertTrue(result.isDisplayed());
        Assert.assertTrue(result.getText().contains(regNumber));
        Assert.assertTrue(coverStartDate.isDisplayed());
        Assert.assertTrue(coverEndDate.isDisplayed());

    }

    public void verifyErrorMessage(String message) {

        WaitForElement(result);
        Assert.assertTrue(result.getText().contains(message));

    }

    public void verifyErrorText() {

        WaitForElement(errorMessage);
        Assert.assertTrue(errorMessage.getText().contains(errorText));
    }

}
