package com.doraventures.zone.robot;

import com.doraventures.zone.robot.console.artifacts.SquareTable;
import com.doraventures.zone.robot.console.artifacts.ToyRobot;
import com.doraventures.zone.robot.console.helpers.Direction;
import com.doraventures.zone.robot.console.simulator.AppSimulator;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;

import static com.doraventures.zone.robot.console.artifacts.SquareTable.builder;
import static org.assertj.core.api.BDDAssertions.then;


/**
 * @author moses@doraventures.com
 */
@Slf4j
public class StepDefinitions extends SpringIntegrationBase {

  private static final int SIDE = 4;
  ToyRobot toyRobot;
  SquareTable squareTable;

  @Given("^a robot placement of (\\d+) xAxis, (\\d+) yAxis and facing \"([^\"]*)\"$")
  public void theSuppliedReferenceData(Integer xAxis, Integer yAxis, String directionValue) throws Throwable {
    log.info("Placing robot at [{}]xAxis [{}]yAxis facing [{}]", xAxis, yAxis, directionValue);
    toyRobot = new ToyRobot();
    squareTable = builder().side(SIDE).build();
    Point point = new Point(xAxis, yAxis);
    Direction direction = Direction.valueOf(directionValue);

    // When
    AppSimulator.doPlacement(toyRobot, squareTable, point, direction);
  }

  @When("^I MOVE the robot$")
  public void iTheRobot() throws Throwable {
    AppSimulator.doMove(toyRobot, squareTable);
    log.info("Moved Robot");
  }

  @When("^I rotate the robot \"([^\"]*)\"$")
  public void iRotateTheRobot(String rotateValue) throws Throwable {
    AppSimulator.doRotate(toyRobot, com.doraventures.zone.robot.console.helpers.Rotate.valueOf(rotateValue));
  }

  @Then("^REPORT should print \"([^\"]*)\"$")
  public void shouldPrint(String expectedOutput) throws Throwable {
    final String actualReport = AppSimulator.getReport(toyRobot);
    log.info("Robot actual report is [{}]", actualReport);
    log.info("Robot expect report is [{}]", expectedOutput);
    then(actualReport).isEqualTo(expectedOutput);
  }
}
