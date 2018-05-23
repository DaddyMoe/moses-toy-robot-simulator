package com.doraventures.zone.robot.console.setup;

import com.doraventures.zone.robot.SquareTable;
import org.junit.Test;

import static com.doraventures.zone.robot.SquareTable.builder;
import static org.assertj.core.api.BDDAssertions.then;

/**
 *
 * @author moses@doraventures.com
 */
public class SquareTableTest {

  @Test
  public void shouldHaveDimensionsAsExpected() {

    // Given
    int xAxis = 5;
    int yAxis = 5;

    // When
    SquareTable squareTable = builder().xAxis(xAxis).yAxis(yAxis).build();

    then(squareTable.getXAxis()).isEqualTo(xAxis);
    then(squareTable.getYAxis()).isEqualTo(yAxis);
  }
}
