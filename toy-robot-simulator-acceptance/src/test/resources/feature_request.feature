Feature: Move Robot within table bounds

  Scenario: Place and move Robot
    Given a robot placement of 0 xAxis, 0 yAxis and facing "North"
    When I "MOVE" the robot
    Then "REPORT" should print "Output: 0,1,NORTH"
