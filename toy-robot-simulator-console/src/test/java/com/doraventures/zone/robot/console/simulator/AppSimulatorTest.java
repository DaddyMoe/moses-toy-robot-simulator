package com.doraventures.zone.robot.console.simulator;

import com.doraventures.zone.robot.console.artifacts.SquareTable;
import com.doraventures.zone.robot.console.artifacts.ToyRobot;
import com.doraventures.zone.robot.console.exceptions.ToyRobotSimulatorException;
import com.doraventures.zone.robot.console.helpers.Direction;
import org.junit.Test;

import java.awt.*;

import static com.doraventures.zone.robot.console.artifacts.SquareTable.builder;
import static org.assertj.core.api.BDDAssertions.then;

/**
 * AppSimulator Test class
 *
 * @author moses@doraventures.com
 */
public class AppSimulatorTest {
  private static final int SIDE = 4;

  @Test(expected = ToyRobotSimulatorException.class)
  public void shouldThrowExceptionForInvalidPlacementCoordinate() throws ToyRobotSimulatorException {

    // Given
    ToyRobot toyRobot = new ToyRobot();
    SquareTable squareTable = builder().side(SIDE).build();
    Point point = new Point(0, 5);
    Direction direction = Direction.valueOf("EAST");

    // When
    AppSimulator.doPlacement(toyRobot, squareTable, point, direction);
  }

  @Test
  public void shouldPlaceToyRobotInExpectedCoordinate() throws ToyRobotSimulatorException {

    // Given
    ToyRobot toyRobot = new ToyRobot();
    SquareTable squareTable = builder().side(SIDE).build();
    Point point = new Point(0, 4);
    Direction direction = Direction.valueOf("NORTH");

    // When
    AppSimulator.doPlacement(toyRobot, squareTable, point, direction);
    then(toyRobot.getPoint().x).isEqualTo(0);
    then(toyRobot.getPoint().y).isEqualTo(4);
  }

  @Test
  public void shouldPlaceToyRobotInExpectedCoordinateAndFacingDirection() throws ToyRobotSimulatorException {

    // Given
    ToyRobot toyRobot = new ToyRobot();
    SquareTable squareTable = builder().side(SIDE).build();
    Point point = new Point(3, 1);
    Direction direction = Direction.valueOf("NORTH");

    // When
    AppSimulator.doPlacement(toyRobot, squareTable, point, direction);
    then(toyRobot.getPoint().x).isEqualTo(3);
    then(toyRobot.getPoint().y).isEqualTo(1);
    then(toyRobot.getDirection()).isEqualTo(Direction.NORTH);
  }
}