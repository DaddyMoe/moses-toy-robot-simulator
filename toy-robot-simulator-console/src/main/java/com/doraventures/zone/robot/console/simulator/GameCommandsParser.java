package com.doraventures.zone.robot.console.simulator;

import com.doraventures.zone.robot.console.artifacts.SquareTable;
import com.doraventures.zone.robot.console.artifacts.ToyRobot;
import com.doraventures.zone.robot.console.exceptions.ToyRobotSimulatorException;
import com.doraventures.zone.robot.console.helpers.Direction;
import com.doraventures.zone.robot.console.helpers.InputCommands;
import com.doraventures.zone.robot.console.helpers.Rotate;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

/**
 * @author moses@doraventures.com
 */
public class GameCommandsParser {

  public static void execute(String inputString, ToyRobot toyRobot, SquareTable squareTable) throws ToyRobotSimulatorException {
    String[] arguments = inputString.split(" ");
    InputCommands inputCommand;

    try {
      inputCommand = InputCommands.valueOf(arguments[0]);
    } catch (IllegalArgumentException e) {
      out.println("-ERROR-: Invalid starting Command token : " + e.getMessage());
      printGuide();
      return;
    }

    if (InputCommands.PLACE.name().equals(inputCommand.name())) {
      if (arguments.length != 2) {
        out.println("-ERROR-: Invalid number of arguments for Place Command");
        return;
      }
      String[] params;
      params = arguments[1].split(",");
      executePlaceCommand(Arrays.asList(params), toyRobot, squareTable);
      return;
    }

    if (InputCommands.MOVE.name().equals(inputCommand.name())) {
      AppSimulator.doMove(toyRobot, squareTable);
    }

    if (InputCommands.REPORT.name().equals(inputCommand.name())) {
      out.println(AppSimulator.getReport(toyRobot));
    }

    if (InputCommands.LEFT.name().equals(inputCommand.name())) {
      AppSimulator.doRotate(toyRobot, Rotate.LEFT);
    }

    if (InputCommands.RIGHT.name().equals(inputCommand.name())) {
      AppSimulator.doRotate(toyRobot, Rotate.RIGHT);
    }
  }


  private static void executePlaceCommand(List<String> params, ToyRobot robot, SquareTable table) {

    out.println("Got Place commands as:" + params.toString());
    if (params.isEmpty() || params.size() != 3) {
      out.println("-ERROR-: PLACE Command parameters are incorrect.  Please try again");
      printGuide();
      return;
    }

    Point point;
    Direction direction;
    try {
      int xAxis = Integer.parseInt(params.get(0));
      int yAxis = Integer.parseInt(params.get(1));
      String directionValue = params.get(2);
      point = new Point(xAxis, yAxis);
      direction = Direction.valueOf(directionValue);
      AppSimulator.doPlacement(robot, table, point, direction);
    } catch (IllegalArgumentException e) {
      out.println("-ERROR-: Invalid PLACE params");
      printGuide();
    } catch (ToyRobotSimulatorException e) {
      out.println("-ERROR-: ToyRobotSimulatorException: " + e.getMessage());
    }
  }

  public static void printGuide() {
    out.println("##### Guide ###################################");
    out.println("###############################################");
    out.println("##### To Place:    Enter   'PLACE 0,0,NORTH'  #");
    out.println("##### To Move:     Enter   'MOVE'             #");
    out.println("##### To Rotate:   Enter   'LEFT/RIGHT        #");
    out.println("##### To Report:   Enter   'REPORT'           #");
  }
}
