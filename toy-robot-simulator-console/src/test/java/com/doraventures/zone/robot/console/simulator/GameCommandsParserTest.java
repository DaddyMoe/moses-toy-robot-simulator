package com.doraventures.zone.robot.console.simulator;

import com.doraventures.zone.robot.console.artifacts.SquareTable;
import com.doraventures.zone.robot.console.artifacts.ToyRobot;
import com.doraventures.zone.robot.console.exceptions.ToyRobotSimulatorException;
import com.doraventures.zone.robot.console.helpers.Direction;
import org.junit.Test;

import static com.doraventures.zone.robot.console.artifacts.SquareTable.builder;
import static org.assertj.core.api.BDDAssertions.then;


/**
 * Game Commands Parser Test
 *
 * @author moses@doraventures.com
 */
public class GameCommandsParserTest {

  private static final int SIDE = 4;

  @Test
  public void shouldApplyArgumentCommandsForPlacement() throws ToyRobotSimulatorException {

    // Given
    ToyRobot toyRobot = new ToyRobot();
    SquareTable squareTable = builder().side(SIDE).build();

    // When
    GameCommandsParser.execute("PLACE 0,0,NORTH", toyRobot, squareTable);

    then(toyRobot.getDirection()).isEqualTo(Direction.NORTH);
    then(toyRobot.getPoint().x).isEqualTo(0);
    then(toyRobot.getPoint().y).isEqualTo(0);
  }

  @Test
  public void shouldApplyArgumentCommandsForPlacementAndMove() throws ToyRobotSimulatorException {

    // Given
    ToyRobot toyRobot = new ToyRobot();
    SquareTable squareTable = builder().side(SIDE).build();

    // When
    GameCommandsParser.execute("PLACE 2,2,SOUTH", toyRobot, squareTable);
    GameCommandsParser.execute("MOVE", toyRobot, squareTable);

    then(toyRobot.getDirection()).isEqualTo(Direction.SOUTH);
    then(toyRobot.getPoint().x).isEqualTo(2);
    then(toyRobot.getPoint().y).isEqualTo(1);
  }

  @Test
  public void shouldApplyArgumentCommandsForPlacement_Move_and_RotateLeft() throws ToyRobotSimulatorException {

    // Given
    ToyRobot toyRobot = new ToyRobot();
    SquareTable squareTable = builder().side(SIDE).build();

    // When
    GameCommandsParser.execute("PLACE 3,2,EAST", toyRobot, squareTable);
    GameCommandsParser.execute("MOVE", toyRobot, squareTable);
    GameCommandsParser.execute("LEFT", toyRobot, squareTable);

    then(toyRobot.getDirection()).isEqualTo(Direction.NORTH);
    then(toyRobot.getPoint().x).isEqualTo(4);
    then(toyRobot.getPoint().y).isEqualTo(2);
  }

  @Test
  public void shouldApplyArgumentCommandsForPlacement_Report_and_RotateRight() throws ToyRobotSimulatorException {

    // Given
    ToyRobot toyRobot = new ToyRobot();
    SquareTable squareTable = builder().side(SIDE).build();

    // When
    GameCommandsParser.execute("PLACE 1,2,WEST", toyRobot, squareTable);
    GameCommandsParser.execute("REPORT", toyRobot, squareTable);
    GameCommandsParser.execute("RIGHT", toyRobot, squareTable);

    then(toyRobot.getDirection()).isEqualTo(Direction.NORTH);
    then(toyRobot.getPoint().x).isEqualTo(1);
    then(toyRobot.getPoint().y).isEqualTo(2);
  }


  @Test
  public void shouldNotApplyArgumentCommandsForInvalidStartCommand() throws ToyRobotSimulatorException {

    // Given
    ToyRobot toyRobot = new ToyRobot();
    SquareTable squareTable = builder().side(SIDE).build();

    // When
    GameCommandsParser.execute("INVALID 1,2,WEST", toyRobot, squareTable);

    then(toyRobot.getDirection()).isNull();
    then(toyRobot.getPoint()).isNull();
  }

  @Test
  public void shouldNotApplyArgumentCommandsForInvalidPLACECommandParams() throws ToyRobotSimulatorException {

    // Given
    ToyRobot toyRobot = new ToyRobot();
    SquareTable squareTable = builder().side(SIDE).build();

    // When
    GameCommandsParser.execute("PLACE 1,WEST", toyRobot, squareTable);

    then(toyRobot.getDirection()).isNull();
    then(toyRobot.getPoint()).isNull();
  }

  @Test
  public void shouldNotApplyPLACECommandsForTooManyCommandArgumentSize() throws ToyRobotSimulatorException {

    // Given
    ToyRobot toyRobot = new ToyRobot();
    SquareTable squareTable = builder().side(SIDE).build();

    // When
    GameCommandsParser.execute("PLACE 1,2,WEST, Extra", toyRobot, squareTable);

    then(toyRobot.getDirection()).isNull();
    then(toyRobot.getPoint()).isNull();
  }

  @Test
  public void shouldNotApplyPLACECommandsForTooFewCommandArgumentSize() throws ToyRobotSimulatorException {

    // Given
    ToyRobot toyRobot = new ToyRobot();
    SquareTable squareTable = builder().side(SIDE).build();

    // When
    GameCommandsParser.execute("PLACE", toyRobot, squareTable);

    then(toyRobot.getDirection()).isNull();
    then(toyRobot.getPoint()).isNull();
  }

  @Test
  public void shouldNotApplyPLACECommandsForIlligalCommandParametersForPosition() throws ToyRobotSimulatorException {

    // Given
    ToyRobot toyRobot = new ToyRobot();
    SquareTable squareTable = builder().side(SIDE).build();

    // When
    GameCommandsParser.execute("PLACE w,e,WEST", toyRobot, squareTable);

    then(toyRobot.getDirection()).isNull();
    then(toyRobot.getPoint()).isNull();
  }

  @Test
  public void shouldNotApplyPLACECommandsForPositionsBeyondTheTable() throws ToyRobotSimulatorException {

    // Given
    ToyRobot toyRobot = new ToyRobot();
    SquareTable squareTable = builder().side(SIDE).build();

    // When
    GameCommandsParser.execute("PLACE 5,5,WEST", toyRobot, squareTable);

    then(toyRobot.getDirection()).isNull();
    then(toyRobot.getPoint()).isNull();
  }
}