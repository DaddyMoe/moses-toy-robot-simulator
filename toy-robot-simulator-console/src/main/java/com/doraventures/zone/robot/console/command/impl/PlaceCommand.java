package com.doraventures.zone.robot.console.command.impl;

import com.doraventures.zone.robot.console.Command;
import com.doraventures.zone.robot.console.artifacts.SquareTable;
import com.doraventures.zone.robot.console.artifacts.ToyRobot;
import com.doraventures.zone.robot.console.exceptions.ToyRobotSimulatorException;
import com.doraventures.zone.robot.console.helpers.Direction;
import lombok.Builder;
import lombok.Getter;

import java.awt.*;

/**
 * PlaceCommand implementation of Command pattern Interface
 *
 * @author moses@doraventures.com
 */
@Builder
@Getter
public class PlaceCommand implements Command {

  private ToyRobot robot;
  private SquareTable squareTable;
  private Point point;
  private Direction direction;

  /**
   * {@inheritDoc}
   */
  @Override
  public void execute() throws ToyRobotSimulatorException {

    getRobot().placeRobot(getPoint(), getSquareTable());
    getRobot().setDirection(getDirection());
  }
}
