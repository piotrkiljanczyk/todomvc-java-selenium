package org.example;

import org.example.steps.UserSteps;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateTaskTest extends BaseSetup {


    @Test
    public void userCanCreateATodo() {

        var todoName = "To jest moje zadanie";
        step.userCreatesANewTodo(todoName);
        step.userChecksIfTodoWasCreated(todoName);
    }
}
