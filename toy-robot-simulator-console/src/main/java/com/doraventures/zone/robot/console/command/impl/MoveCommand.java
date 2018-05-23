package com.doraventures.zone.robot.console.command.impl;

import com.doraventures.zone.robot.console.Command;
import com.doraventures.zone.robot.console.artifacts.SquareTable;
import com.doraventures.zone.robot.console.artifacts.ToyRobot;
import com.doraventures.zone.robot.console.exceptions.ToyRobotSimulatorException;
import lombok.Builder;
import lombok.Getter;

/**
 * PlaceCommand implementation of Command pattern Interface
 *
 * @author moses@doraventures.com
 */
@Builder
@Getter
public class MoveCommand implements Command {

  private ToyRobot robot;
  private SquareTable squareTable;

  /**
   * {@inheritDoc}
   */
  @Override
  public void execute() throws ToyRobotSimulatorException {
    getRobot().move(getSquareTable());
  }
}
