package com.doraventures.zone.robot.console.artifacts;

import org.junit.Test;

import static com.doraventures.zone.robot.console.artifacts.SquareTable.builder;
import static org.assertj.core.api.BDDAssertions.then;

/**
 *
 * @author moses@doraventures.com
 */
public class SquareTableTest {

  @Test
  public void shouldHaveDimensionsAsExpected() {

    // Given
    int side = 4;

    // When
    SquareTable squareTable = builder().side(side).build();

    then(squareTable.getSide()).isEqualTo(side);
  }

 @Test(expected = IllegalArgumentException.class)
  public void shouldRejectTableCreationWithDimensionBeyondMaxLength() {

    // Given
    int side = 5;

    // When
    builder().side(side).build();
  }

  @Test
  public void shouldAcceptPlaceAbleCoordinates() {

    // Given
    int side = 4;
    SquareTable squareTable = builder().side(side).build();

    // When then
    then(squareTable.isValidPlacement(4, 3)).isTrue();
    then(squareTable.isValidPlacement(0, 4)).isTrue();
    then(squareTable.isValidPlacement(2, 3)).isTrue();
    then(squareTable.isValidPlacement(4, 0)).isTrue();
  }

  @Test
  public void shouldRejectNonPlaceAbleCoordinates() {

    // Given
    int side = 4;
    SquareTable squareTable = builder().side(side).build();

    // When then
    then(squareTable.isValidPlacement(2, 5)).isFalse();
    then(squareTable.isValidPlacement(0, 5)).isFalse();
    then(squareTable.isValidPlacement(5, 0)).isFalse();
  }
}
