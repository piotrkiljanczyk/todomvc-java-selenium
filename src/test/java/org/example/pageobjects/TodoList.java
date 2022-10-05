package org.example.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;

public class TodoList extends PageObject {

    private final By TODOS_LIST = By.cssSelector(".todo-list");
    private final By COMPLETE_TOGGLE = By.cssSelector(".toggle");
    private final By TODO_COMPLETED = By.cssSelector(".todo-list > .completed");
    private final By COMPLETED_TAB = By.cssSelector("[href='#/completed']");
    private final By ACTIVE_TAB = By.cssSelector("[href='#/active']");



    public void checkIfTodoIsDisplayed(String todoName) {
        find(TODOS_LIST).shouldContainText(todoName);
    }

    public void checkIfTodoIsDisplayedInCompletedTab(String name) {
        find(COMPLETED_TAB).click();
        find(TODOS_LIST).shouldContainText(name);
    }

    public void userCompleteTodoTask() {
        find(COMPLETE_TOGGLE).click();
    }

    public void userChecksIsTodoIsMarkedAsCompleted() {
        find(TODO_COMPLETED).shouldBePresent();
    }

    public void userChecksIfCompletedIsNotOnActiveTab(String name) {
        find(ACTIVE_TAB).click();
        find(TODOS_LIST).shouldContainText(name);
    }
}
