package com.doraventures.zone.robot;

import lombok.Builder;
import lombok.Data;

/**
 * POJO to represents the Square Table
 *
 * @author moses@doraventures.com
 */
@Builder
@Data
public class SquareTable {

  private int xAxis;
  private int yAxis;
}
