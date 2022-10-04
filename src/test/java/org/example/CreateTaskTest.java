package org.example;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateTaskTest {

    WebDriver browser = new FirefoxDriver();

    @BeforeEach
    public void setup() {
        userOpensTodoMVC();
    }

    @AfterEach
    public void cleanup() {
        browser.close();
    }

    @Test
    public void userCanCreateATodo() {

        var todoName = "To jest moje zadanie";
        userCreatesANewTodo(todoName);
        userChecksIfTodoWasCreated(todoName);
    }

    @Test
    public void userCanCompleteTodo() {
        var todoName = "To jest moje samodzielne zadanie";
        userCreatesANewTodo(todoName);
        userCompleteTodoTask();
        userChecksItTodoIsMarkedAsCompleted();
    }

    private void userChecksItTodoIsMarkedAsCompleted() {
        var todoElement = browser.findElement(By.cssSelector(".todo-list > li"));
        String todoClasses = todoElement.getAttribute("class");
        MatcherAssert.assertThat("Todo should be marked as completed", todoClasses, Matchers.equalTo("completed"));
    }

    private void userCompleteTodoTask() {
        var todosCheck = browser.findElement(By.cssSelector(".toggle"));
        todosCheck.click();
    }

    private void userChecksIfTodoWasCreated(String todoName) {
        var todosList = browser.findElement(By.cssSelector(".todo-list"));
        var todos = todosList.getText();
        MatcherAssert.assertThat("Todo has correct name", todos, Matchers.equalTo(todoName));
    }

    private void userOpensTodoMVC() {
        browser.get("https://todomvc.com/examples/jquery/#/all");
    }


    private void userCreatesANewTodo(String name) {
        var todoInput = browser.findElement(By.cssSelector(".new-todo"));
        todoInput.sendKeys(name);
        todoInput.sendKeys(Keys.RETURN);
    }
}
