package com.doraventures.zone.robot.console;

import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.lang.System.out;


/**
 * @author moses@doraventures.com
 */
@SpringBootApplication // Same as @SpringBootConfiguration @EnableAutoConfiguration @ComponentScan
public class SpringBootConsoleApp implements CommandLineRunner {

  public static void main(String[] args) throws Exception {

    SpringApplication app = new SpringApplication(SpringBootConsoleApp.class);
    app.setBannerMode(Banner.Mode.OFF);
    app.run(args);
  }

  @Override
  public void run(String... args) throws Exception {
      out.println("Arguments size: " + args.length);
  }
}
