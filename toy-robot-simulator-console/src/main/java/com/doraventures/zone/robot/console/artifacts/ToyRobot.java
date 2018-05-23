package com.doraventures.zone.robot.console.artifacts;

import com.doraventures.zone.robot.console.exceptions.ToyRobotSimulatorException;
import com.doraventures.zone.robot.console.helpers.Direction;
import com.doraventures.zone.robot.console.helpers.Rotate;
import lombok.Data;

import java.awt.*;

/**
 * The Toy Robot. Also a Command Receiver for PLACE, MOVE, LEFT AND RIGHT Commands
 *
 * @author moses@doraventures.com
 */
@Data
public class ToyRobot {

  private static final int STEP = 1;
  private Point point;
  private Direction direction;
  private boolean placed = false;

  public void placeRobot(Point point, SquareTable squareTable) throws ToyRobotSimulatorException {
    if (squareTable.isValidPlacement(point.x, point.y)) {
      this.setPoint(point);
      placed = true;
    } else {
      throw new ToyRobotSimulatorException("InValid position coordinates");
    }
  }

  public void move(SquareTable squareTable) throws ToyRobotSimulatorException {

    Point proposedPoint = getProposedPoint(direction, point);
    placeRobot(proposedPoint, squareTable);
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

  public void rotate(SquareTable squareTable, Rotate rotate) {
    throw new RuntimeException("Not yet implemented");
  }
}
