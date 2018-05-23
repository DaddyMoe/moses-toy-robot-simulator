package com.doraventures.zone.robot.console.artifacts;

import com.doraventures.zone.robot.console.exceptions.ToyRobotSimulatorException;
import com.doraventures.zone.robot.console.helpers.Direction;
import com.doraventures.zone.robot.console.helpers.Rotate;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.awt.*;

import static com.doraventures.zone.robot.console.helpers.ApplicationConstants.OUTPUT_TEMPLATE;

/**
 * The Toy Robot. Also a Command Receiver for PLACE, MOVE, LEFT AND RIGHT Commands
 *
 * @author moses@doraventures.com
 */
@Data
@Component
public class ToyRobot {

  private static final int STEP = 1;
  private Point point;
  private Direction direction;
  private boolean placed = false;
  private String reportMessage;

  /**
   * Place command Receiver.
   */
  public void placeRobot(Point point, SquareTable squareTable) throws ToyRobotSimulatorException {
    if (squareTable.isValidPlacement(point.x, point.y)) {
      this.setPoint(point);
      setPlaced(true);
    } else {
      throw new ToyRobotSimulatorException("InValid position coordinates");
    }
  }

  /**
   * Move command Receiver.
   */
  public void move(SquareTable squareTable) throws ToyRobotSimulatorException {

    Point proposedPoint = getProposedPoint(direction, point);
    placeRobot(proposedPoint, squareTable);
  }

  /**
   * Rotate command Receiver.
   */
  public void rotate(Rotate rotate) {

    switch (direction) {
      case NORTH:
        doRotationFromNorth(rotate);
        break;
      case EAST:
        doRotationFromEast(rotate);
        break;
      case SOUTH:
        doRotationFromSouth(rotate);
        break;
      case WEST:
        doRotationFromWest(rotate);
        break;
    }
  }

  /**
   * Report command Receiver.
   */
  public void report() {
    reportMessage = String.format(OUTPUT_TEMPLATE,
        this.getPoint().x,
        this.getPoint().y,
        this.getDirection().name());
  }

  private static Point getProposedPoint(Direction direction, Point point) {
    Point proposedPoint;
    switch (direction) {
      case NORTH:
        proposedPoint = new Point(point.x, point.y + STEP);
        break;
      case SOUTH:
        proposedPoint = new Point(point.x, point.y - STEP);
        break;
      case EAST:
        proposedPoint = new Point(point.x + STEP, point.y);
        break;
      case WEST:
        proposedPoint = new Point(point.x - STEP, point.y);
        break;
      default:
        proposedPoint = point; //should not be reached
        break;
    }
    return proposedPoint;
  }

  private void doRotationFromNorth(Rotate rotate) {
    if (Rotate.RIGHT.equals(rotate)) {
      direction = Direction.EAST;
    }
    if (Rotate.LEFT.equals(rotate)) {
      direction = Direction.WEST;
    }
  }

  private void doRotationFromEast(Rotate rotate) {
    if (Rotate.RIGHT.equals(rotate)) {
      direction = Direction.SOUTH;
    }
    if (Rotate.LEFT.equals(rotate)) {
      direction = Direction.NORTH;
    }
  }

  private void doRotationFromSouth(Rotate rotate) {
    if (Rotate.RIGHT.equals(rotate)) {
      direction = Direction.WEST;
    }
    if (Rotate.LEFT.equals(rotate)) {
      direction = Direction.EAST;
    }
  }

  private void doRotationFromWest(Rotate rotate) {
    if (Rotate.RIGHT.equals(rotate)) {
      direction = Direction.NORTH;
    }
    if (Rotate.LEFT.equals(rotate)) {
      direction = Direction.SOUTH;
    }
  }
}
