package org.example;

import org.example.steps.UserSteps;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CompleteTaskTest extends BaseSetup {

    @Test
    public void userCanCompleteTodo() {
        var todoName = "To jest moje samodzielne zadanie";
        step.userCreatesANewTodo(todoName);
        step.userCompleteTodoTask();
        step.userChecksIsTodoIsMarkedAsCompleted();
    }

    @Test
    public void userCheckIfCompletedIsNotOnActiveTab() {
        var todoName = "To jest moje samodzielne zadanie";
        step.userCreatesANewTodo(todoName);
        step.userCompleteTodoTask();
        step.userChecksIfCompletedIsNotOnActiveTab(todoName);
    }

    @Test
    public void userCheckIfCompletedIsOnCompletedTab() {
        var todoName = "To jest moje samodzielne zadanie";
        step.userCreatesANewTodo(todoName);
        step.userCompleteTodoTask();
        step.userChecksIfCompletedIsOnCompletedTab(todoName);
    }
}
