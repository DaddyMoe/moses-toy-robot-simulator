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
 * Toy Simulator Move Tests
 *
 * @author moses@doraventures.com
 */
public class AppSimulatorMoveTest {

  private static final int SIDE = 4;
  private final SquareTable squareTable = builder().side(SIDE).build();
  private final ToyRobot toyRobot =new ToyRobot();

  @Test
  public void shouldMoveToyRobotToNextUnitInNorthFacingDirection() throws ToyRobotSimulatorException {

    // Given
    Point point = new Point(0, 0);
    Direction direction = Direction.valueOf("NORTH");
    AppSimulator.doPlacement(toyRobot, squareTable, point, direction);
    AppSimulator.doMove(toyRobot, squareTable);

    // When
    then(toyRobot.getPoint().x).isEqualTo(0);
    then(toyRobot.getPoint().y).isEqualTo(1);
  }

  @Test
  public void shouldMoveToyRobotToNextUnitInEastFacingDirection() throws ToyRobotSimulatorException {

    // Given
    Point point = new Point(0, 0);
    Direction direction = Direction.EAST;
    AppSimulator.doPlacement(toyRobot, squareTable, point, direction);
    AppSimulator.doMove(toyRobot, squareTable);

    // When
    then(toyRobot.getPoint().x).isEqualTo(1);
    then(toyRobot.getPoint().y).isEqualTo(0);
  }


  @Test(expected = ToyRobotSimulatorException.class)
  public void shouldIgnoreInvalidMoveRequestsWhilstFaceEastAtMaxUnit() throws ToyRobotSimulatorException {

    // Given
    Point point = new Point(4, 3);
    Direction direction = Direction.EAST;
    AppSimulator.doPlacement(toyRobot, squareTable, point, direction);

    // When
    AppSimulator.doMove(toyRobot, squareTable);
  }

  @Test(expected = ToyRobotSimulatorException.class)
  public void shouldIgnoreInvalidMoveRequestsWhilstFaceWestAtOrigin() throws ToyRobotSimulatorException {

    // Given
    Point point = new Point(0, 3);
    Direction direction = Direction.WEST;
    AppSimulator.doPlacement(toyRobot, squareTable, point, direction);

    // When
    AppSimulator.doMove(toyRobot, squareTable);
  }

  @Test(expected = ToyRobotSimulatorException.class)
  public void shouldIgnoreInvalidMoveRequestsWhilstFacingNorthAtMaxUnit() throws ToyRobotSimulatorException {

    // Given
    Point point = new Point(2, 4);
    Direction direction = Direction.NORTH;
    AppSimulator.doPlacement(toyRobot, squareTable, point, direction);

    // When
    AppSimulator.doMove(toyRobot, squareTable);
  }

  @Test(expected = ToyRobotSimulatorException.class)
  public void shouldIgnoreInvalidMoveRequestsWhilstFacingSouthAtOrigin() throws ToyRobotSimulatorException {

    // Given
    Point point = new Point(2, 0);
    Direction direction = Direction.SOUTH;
    AppSimulator.doPlacement(toyRobot, squareTable, point, direction);

    // When
    AppSimulator.doMove(toyRobot, squareTable);
  }

  @Test(expected = ToyRobotSimulatorException.class)
  public void shouldThrowExceptionWhenMoveWithoutAValidPlacedToyRobot() throws ToyRobotSimulatorException {
    // When
    AppSimulator.doMove(toyRobot, squareTable);
  }
}
