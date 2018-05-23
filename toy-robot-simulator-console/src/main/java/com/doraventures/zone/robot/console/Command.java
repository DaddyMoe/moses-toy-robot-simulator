package com.doraventures.zone.robot.console;

import com.doraventures.zone.robot.console.exceptions.ToyRobotSimulatorException;

/**
 * Command Pattern contract
 *
 * @author moses@doraventures.com
 */
public interface Command {

  public void execute() throws ToyRobotSimulatorException;

}
