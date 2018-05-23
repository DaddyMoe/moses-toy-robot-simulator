package com.doraventures.zone.robot.console.command.impl;

import com.doraventures.zone.robot.console.Command;
import com.doraventures.zone.robot.console.exceptions.ToyRobotSimulatorException;
import lombok.Builder;

/**
 * Command Invoker
 *
 * @author moses@doraventures.com
 */
@Builder
public class InvokeCommand {

  private Command command;

  public void invoke() throws ToyRobotSimulatorException {
    command.execute();
  }
}
