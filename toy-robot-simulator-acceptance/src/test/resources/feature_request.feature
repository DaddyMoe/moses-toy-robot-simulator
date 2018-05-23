Feature: Move Robot within table bounds

  Scenario: Place and move Robot
    Given a robot placement of 0 xAxis, 0 yAxis and facing "NORTH"
    When I MOVE the robot
    Then REPORT should print "Output: 0,1,NORTH"
    And a robot placement of 0 xAxis, 0 yAxis and facing "NORTH"
    When I rotate the robot "LEFT"
    Then REPORT should print "Output: 0,0,WEST"
    And a robot placement of 1 xAxis, 2 yAxis and facing "EAST"
    When I MOVE the robot
    When I MOVE the robot
    When I rotate the robot "LEFT"
    When I MOVE the robot
    Then REPORT should print "Output: 3,3,NORTH"
