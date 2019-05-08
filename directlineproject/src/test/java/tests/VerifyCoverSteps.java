package tests;

import Pages.InsurancePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VerifyCoverSteps extends Base {

    InsurancePage insuranceObject = new InsurancePage(driver);

    @Given("^I goto dealer portal website$")
    public void iGotoDealerPortalWebsite() {

        insuranceObject.NavigateToPage();
    }

    @When("^I enter (.*) registration number$")
    public void iEnterARegistrationNumber(String number) {

        insuranceObject.enterRegistrationNumber(number);
    }

    @When("^I click on search button$")
    public void clickOnSearchButton() {

        insuranceObject.clickSearchButton();
    }

    @Then("^I should see vehicle details$")
    public void iShouldBeAbleToSeeVehicleDetails() {

        insuranceObject.verifyDetails();
    }

    @Then("^I should be able to see (.*)$")
    public void i_should_be_able_to_see_Expected_message(String message) {

        insuranceObject.verifyErrorMessage(message);
    }

    @Then("^I should see the validation error$")
    public void i_should_see_the_validation_error() {

        insuranceObject.verifyErrorText();
    }

}
