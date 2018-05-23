package com.doraventures.zone.robot.console.command.impl;

import com.doraventures.zone.robot.console.Command;
import com.doraventures.zone.robot.console.artifacts.ToyRobot;
import lombok.Builder;
import lombok.Getter;

/**
 * ReportCommand implementation of Command pattern Interface
 *
 * @author moses@doraventures.com
 */
@Builder
@Getter
public class ReportCommand implements Command {

  private ToyRobot robot;

  /**
   * {@inheritDoc}
   */
  @Override
  public void execute() {
    getRobot().report();
  }
}
