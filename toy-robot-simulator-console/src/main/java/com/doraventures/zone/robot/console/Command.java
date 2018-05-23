package com.doraventures.zone.robot.console;

import com.doraventures.zone.robot.console.exceptions.ToyRobotSimulatorException;

/**
 * Command Pattern contract
 *
 * @author moses@doraventures.com
 */
public interface Command {

  /**
   * Delegate Command to referenced Object (toy in this case to carry out command)
   *
   * @throws ToyRobotSimulatorException
   */
  void execute() throws ToyRobotSimulatorException;

}
