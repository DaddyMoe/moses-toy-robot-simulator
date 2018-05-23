package com.doraventures.zone.robot.console;

import com.doraventures.zone.robot.console.artifacts.SquareTable;
import com.doraventures.zone.robot.console.artifacts.ToyRobot;
import com.doraventures.zone.robot.console.exceptions.ToyRobotSimulatorException;
import com.doraventures.zone.robot.console.simulator.GameCommandsParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.Console;

import static com.doraventures.zone.robot.console.simulator.GameCommandsParser.printGuide;
import static java.lang.System.err;
import static java.lang.System.out;


/**
 * @author moses@doraventures.com
 */
@SpringBootApplication // Same as @SpringBootConfiguration @EnableAutoConfiguration @ComponentScan
public class SpringBootConsoleApp implements CommandLineRunner {

  @Autowired
  private ToyRobot toyRobot;

  @Value("${toy.robot.simulator.max:4}")
  private int maxSize;

  private static Console console = System.console();


  public static void main(String[] args) throws Exception {

    SpringApplication app = new SpringApplication(SpringBootConsoleApp.class);
    app.setBannerMode(Banner.Mode.OFF);

    if (console == null) {
      err.println("Missing console in running environment. Exiting");
      System.exit(1);
    }
    app.run(args);
  }

  @Override
  public void run(String... args) {
    SquareTable squareTable = SquareTable.builder().side(maxSize).build();
    boolean active = true;

    out.println("Moses' Toy Robot Simulation");
    out.println("Welcome");
    printGuide();

    while (active) {
      String inputString = console.readLine("Please Enter Command: ");
      try {
        GameCommandsParser.execute(inputString, toyRobot, squareTable);
      } catch (ToyRobotSimulatorException e) {
        out.println("Error: " + e.getMessage());
      }
    }
  }
}
