package com.doraventures.zone.robot;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * @author moses@doraventures.com
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources",
    plugin = { "pretty", "html:target/cucumber-reports" })
public class CucumberIntegrationTest {
}

