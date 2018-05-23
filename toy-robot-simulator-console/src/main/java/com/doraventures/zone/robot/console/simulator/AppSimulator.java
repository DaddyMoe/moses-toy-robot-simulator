package com.doraventures.zone.robot.console.simulator;

import com.doraventures.zone.robot.console.artifacts.SquareTable;
import com.doraventures.zone.robot.console.artifacts.ToyRobot;
import com.doraventures.zone.robot.console.command.impl.*;
import com.doraventures.zone.robot.console.exceptions.ToyRobotSimulatorException;
import com.doraventures.zone.robot.console.helpers.Direction;
import com.doraventures.zone.robot.console.helpers.Rotate;

import java.awt.*;

/**
 * The application simulator of a toy robot moving on a square tabletop, of given dimensions and rotation
 *
 * @author moses@doraventures.com
 */
class AppSimulator {

  static void doPlacement(ToyRobot robot, SquareTable table, Point point, Direction direction)
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

  static void doMove(ToyRobot robot, SquareTable table) throws ToyRobotSimulatorException {

    checkPlaceStatus(robot);
    MoveCommand moveCommand = MoveCommand.builder()
        .robot(robot)
        .squareTable(table)
        .build();

    moveCommand.execute();
  }

  static void doRotate(ToyRobot robot, Rotate rotate) throws ToyRobotSimulatorException {

    checkPlaceStatus(robot);
    RotateCommand rotateCommand = RotateCommand.builder()
        .robot(robot)
        .rotate(rotate)
        .build();

    rotateCommand.execute();
  }

  private static void checkPlaceStatus(ToyRobot robot) throws ToyRobotSimulatorException {
    if (!robot.isPlaced()) {
      throw new ToyRobotSimulatorException("Robot has not been placed yet.");
    }
  }

  static String getReport(ToyRobot robot) throws ToyRobotSimulatorException {

    checkPlaceStatus(robot);
    ReportCommand reportCommand = ReportCommand.builder()
        .robot(robot)
        .build();

    reportCommand.execute();
    return robot.getReportMessage();
  }
}
