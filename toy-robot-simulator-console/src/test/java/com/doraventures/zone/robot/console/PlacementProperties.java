package com.doraventures.zone.robot.console;

import com.doraventures.zone.robot.console.helpers.Direction;
import lombok.Builder;
import lombok.Getter;

/**
 * PlacementProperties holder for test
 *
 * @author moses@doraventures.com
 */
@Builder
@Getter
public class PlacementProperties {
  private int xAxis;
  private int yAxis;
  private Direction direction;
}
