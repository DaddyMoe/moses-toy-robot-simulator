package com.doraventures.zone.robot.console.simulator;

import com.doraventures.zone.robot.console.artifacts.ToyRobot;
import com.doraventures.zone.robot.console.exceptions.ToyRobotSimulatorException;
import org.junit.Test;

/**
 * Toy Simulator Report Test class
 *
 * @author moses@doraventures.com
 */
public class AppSimulatorReportTest {

  private final ToyRobot toyRobot = new ToyRobot();

  @Test(expected = ToyRobotSimulatorException.class)
  public void shouldThrowExceptionWhenAttemptingRotateWithoutAValidPlacedToyRobot() throws ToyRobotSimulatorException {
    // When
    AppSimulator.getReport(toyRobot);
  }
}
