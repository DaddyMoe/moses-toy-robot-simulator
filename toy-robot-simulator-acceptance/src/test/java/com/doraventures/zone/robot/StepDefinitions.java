package com.doraventures.zone.robot;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author moses@doraventures.com
 */
public class StepDefinitions extends SpringIntegrationBase {

//  Given("^a robot placement of (\\d+) xAxis, (\\d+) yAxis and facing \"([^\"]*)\"$", (Integer xAxis, Integer yAxis, String reportExpected) -> {
  @Given("^a robot placement of (\\d+) xAxis, (\\d+) yAxis and facing \"([^\"]*)\"$")
    public void theSuppliedReferenceData(Integer xAxis, Integer yAxis, String reportExpected) throws Throwable {

    System.out.println(xAxis);
    System.out.println(yAxis);
    System.out.println(reportExpected);
    throw new PendingException();
  }

  @When("^I \"([^\"]*)\" the robot$")
  public void iTheRobot(String moveCommand) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    System.out.println(moveCommand);
    throw new PendingException();
  }

  @Then("^\"([^\"]*)\" should print \"([^\"]*)\"$")
  public void shouldPrint(String reportCommand, String expectedOutput) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    System.out.println(reportCommand + " - " + expectedOutput);
    throw new PendingException();
  }
}
