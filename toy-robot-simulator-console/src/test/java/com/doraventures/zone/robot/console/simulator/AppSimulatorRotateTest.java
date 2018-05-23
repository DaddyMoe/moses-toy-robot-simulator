package com.doraventures.zone.robot.console.simulator;

import com.doraventures.zone.robot.console.artifacts.SquareTable;
import com.doraventures.zone.robot.console.artifacts.ToyRobot;
import com.doraventures.zone.robot.console.exceptions.ToyRobotSimulatorException;
import com.doraventures.zone.robot.console.helpers.Direction;
import com.doraventures.zone.robot.console.helpers.Rotate;
import org.junit.Test;

import java.awt.*;

import static com.doraventures.zone.robot.console.artifacts.SquareTable.builder;
import static org.assertj.core.api.BDDAssertions.then;

/**
 * Toy Simulator Move Tests
 *
 * @author moses@doraventures.com
 */
public class AppSimulatorRotateTest {

  private static final int SIDE = 4;
  private final SquareTable squareTable = builder().side(SIDE).build();
  private final ToyRobot toyRobot = new ToyRobot();

  @Test
  public void shouldRotateNorthFacingToyRobot90DegreesLeftWithoutChangingPosition() throws ToyRobotSimulatorException {

    // Given
    Point point = new Point(0, 0);
    Direction direction = Direction.valueOf("NORTH");
    AppSimulator.doPlacement(toyRobot, squareTable, point, direction);
    AppSimulator.doRotate(toyRobot, squareTable, Rotate.LEFT);

    // When
    then(toyRobot.getPoint().x).isEqualTo(0);
    then(toyRobot.getPoint().y).isEqualTo(0);
    then(toyRobot.getDirection()).isEqualTo(Direction.WEST);
  }

  @Test
  public void shouldRotateNorthFacingToyRobot90DegreesRightWithoutChangingPosition() throws ToyRobotSimulatorException {

    // Given
    Point point = new Point(3, 2);
    Direction direction = Direction.valueOf("NORTH");
    AppSimulator.doPlacement(toyRobot, squareTable, point, direction);
    AppSimulator.doRotate(toyRobot, squareTable, Rotate.RIGHT);

    // When
    then(toyRobot.getPoint().x).isEqualTo(3);
    then(toyRobot.getPoint().y).isEqualTo(2);
    then(toyRobot.getDirection()).isEqualTo(Direction.EAST);
  }

  @Test
  public void shouldRotateSouthFacingToyRobot90DegreesLeftWithoutChangingPosition() throws ToyRobotSimulatorException {

    // Given
    Point point = new Point(2, 3);
    Direction direction = Direction.SOUTH;
    AppSimulator.doPlacement(toyRobot, squareTable, point, direction);
    AppSimulator.doRotate(toyRobot, squareTable, Rotate.LEFT);

    // When
    then(toyRobot.getPoint().x).isEqualTo(2);
    then(toyRobot.getPoint().y).isEqualTo(3);
    then(toyRobot.getDirection()).isEqualTo(Direction.WEST);
  }

  @Test
  public void shouldRotateSouthFacingToyRobot90DegreesRightWithoutChangingPosition() throws ToyRobotSimulatorException {

    // Given
    Point point = new Point(1, 1);
    Direction direction = Direction.SOUTH;
    AppSimulator.doPlacement(toyRobot, squareTable, point, direction);
    AppSimulator.doRotate(toyRobot, squareTable, Rotate.RIGHT);

    // When
    then(toyRobot.getPoint().x).isEqualTo(1);
    then(toyRobot.getPoint().y).isEqualTo(1);
    then(toyRobot.getDirection()).isEqualTo(Direction.EAST);
  }

  @Test
  public void shouldRotateWestFacingToyRobot90DegreesLeftWithoutChangingPosition() throws ToyRobotSimulatorException {

    // Given
    Point point = new Point(2, 3);
    Direction direction = Direction.WEST;
    AppSimulator.doPlacement(toyRobot, squareTable, point, direction);
    AppSimulator.doRotate(toyRobot, squareTable, Rotate.LEFT);

    // When
    then(toyRobot.getPoint().x).isEqualTo(2);
    then(toyRobot.getPoint().y).isEqualTo(3);
    then(toyRobot.getDirection()).isEqualTo(Direction.SOUTH);
  }

  @Test
  public void shouldRotateWestFacingToyRobot90DegreesRightWithoutChangingPosition() throws ToyRobotSimulatorException {

    // Given
    Point point = new Point(1, 1);
    Direction direction = Direction.WEST;
    AppSimulator.doPlacement(toyRobot, squareTable, point, direction);
    AppSimulator.doRotate(toyRobot, squareTable, Rotate.RIGHT);

    // When
    then(toyRobot.getPoint().x).isEqualTo(1);
    then(toyRobot.getPoint().y).isEqualTo(1);
    then(toyRobot.getDirection()).isEqualTo(Direction.NORTH);
  }

  @Test
  public void shouldRotateEastFacingToyRobot90DegreesLeftWithoutChangingPosition() throws ToyRobotSimulatorException {

    // Given
    Point point = new Point(2, 3);
    Direction direction = Direction.EAST;
    AppSimulator.doPlacement(toyRobot, squareTable, point, direction);
    AppSimulator.doRotate(toyRobot, squareTable, Rotate.LEFT);

    // When
    then(toyRobot.getPoint().x).isEqualTo(2);
    then(toyRobot.getPoint().y).isEqualTo(3);
    then(toyRobot.getDirection()).isEqualTo(Direction.NORTH);
  }

  @Test
  public void shouldRotateEastFacingToyRobot90DegreesRightWithoutChangingPosition() throws ToyRobotSimulatorException {

    // Given
    Point point = new Point(1, 1);
    Direction direction = Direction.EAST;
    AppSimulator.doPlacement(toyRobot, squareTable, point, direction);
    AppSimulator.doRotate(toyRobot, squareTable, Rotate.RIGHT);

    // When
    then(toyRobot.getPoint().x).isEqualTo(1);
    then(toyRobot.getPoint().y).isEqualTo(1);
    then(toyRobot.getDirection()).isEqualTo(Direction.SOUTH);
  }

  @Test(expected = ToyRobotSimulatorException.class)
  public void shouldThrowExceptionWhenAttemptingRotateWithoutAValidPlacedToyRobot() throws ToyRobotSimulatorException {
    // When
    AppSimulator.doRotate(toyRobot, squareTable, Rotate.RIGHT);
  }
}
