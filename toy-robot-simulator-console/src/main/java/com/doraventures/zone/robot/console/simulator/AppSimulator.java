package com.doraventures.zone.robot.console.simulator;

import com.doraventures.zone.robot.console.artifacts.SquareTable;
import com.doraventures.zone.robot.console.artifacts.ToyRobot;
import com.doraventures.zone.robot.console.command.impl.InvokeCommand;
import com.doraventures.zone.robot.console.command.impl.MoveCommand;
import com.doraventures.zone.robot.console.command.impl.PlaceCommand;
import com.doraventures.zone.robot.console.exceptions.ToyRobotSimulatorException;
import com.doraventures.zone.robot.console.helpers.Direction;

import java.awt.*;

/**
 * The application simulator of a toy robot moving on a square tabletop, of given dimensions
 *
 * @author moses@doraventures.com
 */
public class AppSimulator {

  public static void doPlacement(ToyRobot robot, SquareTable table, Point point, Direction direction)
      throws ToyRobotSimulatorException {

    PlaceCommand placeCommand = PlaceCommand.builder()
        .robot(robot)
        .squareTable(table)
        .point(point)
        .direction(direction)
        .build();

    InvokeCommand invokeCommand = InvokeCommand.builder().command(placeCommand).build();
    invokeCommand.invoke();
  }

  public static void doMove(ToyRobot robot, SquareTable table) throws ToyRobotSimulatorException {

    if (!robot.isPlaced()) {
      throw new ToyRobotSimulatorException("Robot has not been placed yet.");
    }

    MoveCommand moveCommand = MoveCommand.builder()
        .robot(robot)
        .squareTable(table)
        .build();

    moveCommand.execute();
  }
}
