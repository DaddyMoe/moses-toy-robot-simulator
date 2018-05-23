package com.doraventures.zone.robot.console.command.impl;

import com.doraventures.zone.robot.console.Command;
import com.doraventures.zone.robot.console.artifacts.ToyRobot;
import com.doraventures.zone.robot.console.helpers.Rotate;
import lombok.Builder;
import lombok.Getter;

/**
 * RotateCommand implementation of Command pattern Interface
 *
 * @author moses@doraventures.com
 */
@Builder
@Getter
public class RotateCommand implements Command {

  private ToyRobot robot;
  private Rotate rotate;

  /**
   * {@inheritDoc}
   */
  @Override
  public void execute() {
    getRobot().rotate(getRotate());
  }
}
