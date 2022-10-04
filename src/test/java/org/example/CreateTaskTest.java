package org.example;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateTaskTest {

    WebDriver browser = new FirefoxDriver();

    @Test
    public void userCanCreateATodo() throws InterruptedException {

        var todoName = "To jest moje zadanie";
        userOpensTodoMVC();
        userCreatesANewTodo(todoName);
        userChecksIfTodoWasCreated(todoName);
        browser.close();
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
