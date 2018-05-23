package com.doraventures.zone.robot.console.artifacts;

import lombok.Builder;
import lombok.Getter;
import org.apache.commons.lang3.Validate;

/**
 * Class to represents the Square Table. Also a Command Receiver
 *
 * @author moses@doraventures.com
 */
@Builder
@Getter
public class SquareTable {
  private static final int MAX_LENGTH = 4;
  private static final int START = 0;

  private int side;

  public static SquareTableBuilder builder() {
    return new CustomSquareTableBuilder();
  }

  private static class CustomSquareTableBuilder extends SquareTableBuilder {

    @Override
    public SquareTable build() {
      Validate.inclusiveBetween(START, MAX_LENGTH, super.side, "Side must be between 0 and " + MAX_LENGTH);
      return super.build();
    }
  }

  public boolean isValidPlacement(int xAxisInput, int yAxisInput) {
    return inRange(xAxisInput) && inRange(yAxisInput);
  }

  private boolean inRange(int value) {
    return value >= 0 && value <= side;
  }
}
