package com.doraventures.zone.robot.console.artifacts;

import com.doraventures.zone.robot.console.exceptions.ToyRobotSimulatorException;
import com.doraventures.zone.robot.console.helpers.Direction;
import lombok.Data;

import java.awt.*;

/**
 * The Toy Robot. Also a Command Receiver for PLACE, MOVE, LEFT AND RIGHT Commands
 *
 * @author moses@doraventures.com
 */
@Data
public class ToyRobot {

  private Point point;
  private Direction direction;

  public void placeRobot(Point point, SquareTable squareTable) throws ToyRobotSimulatorException {
    if (squareTable.isValidPlacement(point.x, point.y)){
      this.setPoint(point);
    }else{
      throw new ToyRobotSimulatorException("InValid Placement");
    }
  }
}
