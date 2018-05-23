package com.doraventures.zone.robot.console.simulator;

import com.doraventures.zone.robot.console.PlacementProperties;
import com.doraventures.zone.robot.console.artifacts.SquareTable;
import com.doraventures.zone.robot.console.artifacts.ToyRobot;
import com.doraventures.zone.robot.console.exceptions.ToyRobotSimulatorException;
import com.doraventures.zone.robot.console.helpers.Direction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.awt.*;
import java.util.Arrays;
import java.util.Collection;

import static com.doraventures.zone.robot.console.artifacts.SquareTable.builder;
import static com.doraventures.zone.robot.console.helpers.ApplicationConstants.OUTPUT_TEMPLATE;
import static com.doraventures.zone.robot.console.simulator.AppSimulator.getReport;
import static org.assertj.core.api.BDDAssertions.then;

/**
 * Toy Simulator Report Parameterised Tests
 *
 * @author moses@doraventures.com
 */
@RunWith(Parameterized.class)
public class AppSimulatorReportParameterisedTest {

  private static final int SIDE = 4;
  private final SquareTable squareTable = builder().side(SIDE).build();
  private final ToyRobot toyRobot = new ToyRobot();

  // variable labels from junit v4.12
  @Parameterized.Parameters(name = "{index}: Move({0}) expected report to be: {1}")
  public static Collection<Object[]> data() {

    // The Test data
    final PlacementProperties placementSample1 = PlacementProperties.builder()
        .xAxis(0).yAxis(0).direction(Direction.NORTH).build();

    final PlacementProperties placementSample2 = PlacementProperties.builder()
        .xAxis(2).yAxis(4).direction(Direction.WEST).build();

    final PlacementProperties placementSample3 = PlacementProperties.builder()
        .xAxis(2).yAxis(2).direction(Direction.SOUTH).build();

    final PlacementProperties placementSample4 = PlacementProperties.builder()
        .xAxis(4).yAxis(3).direction(Direction.EAST).build();

    return Arrays.asList(new Object[][]{
        // {INPUT, EXPECTED_RESULT}
        {placementSample1, placementSample1},
        {placementSample2, placementSample2},
        {placementSample3, placementSample3},
        {placementSample4, placementSample4},
    });
  }


  private PlacementProperties inputData;

  private PlacementProperties expectedData;

  public AppSimulatorReportParameterisedTest(PlacementProperties input, PlacementProperties expected) {
    inputData = input;
    expectedData = expected;
  }

  @Test
  public void shouldReportTheCurrentStatusOfRobotAsExpected() throws ToyRobotSimulatorException {

    // Given
    Point point = new Point(inputData.getXAxis(), inputData.getYAxis());
    Direction direction = inputData.getDirection();
    AppSimulator.doPlacement(toyRobot, squareTable, point, direction);
    String expectedReport = String.format(OUTPUT_TEMPLATE,
        expectedData.getXAxis(),
        expectedData.getYAxis(),
        expectedData.getDirection().name());

    // When
    String actualReport = getReport(toyRobot);

    then(actualReport).isEqualTo(expectedReport);
  }
}
