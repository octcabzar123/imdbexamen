package com.imdb.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/java/com/imdb/cucumber/Registrar.feature" }, strict = false)
public class CucumberRunner {
}
