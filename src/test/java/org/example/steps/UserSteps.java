package org.example.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.example.pageobjects.TodoInput;
import org.example.pageobjects.TodoList;
import org.example.pageobjects.TodoMVCapp;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class UserSteps {

    @Steps
    TodoInput todoInput;

    @Steps
    TodoList todoList;

    @Steps
    TodoMVCapp todoMVCapp;




    @Step
    public void userChecksIsTodoIsMarkedAsCompleted() {
        todoList.userChecksIsTodoIsMarkedAsCompleted();
    }

    @Step
    public void userChecksIfCompletedIsNotOnActiveTab(String name) {
        todoList.userChecksIfCompletedIsNotOnActiveTab(name);
    }

    @Step
    public void userChecksIfCompletedIsOnCompletedTab(String name) {
        todoList.checkIfTodoIsDisplayedInCompletedTab(name);
    }

    @Step
    public void userCompleteTodoTask() {
        todoList.userCompleteTodoTask();
    }

    @Step
    public void userChecksIfTodoWasCreated(String todoName) {
        todoList.checkIfTodoIsDisplayed(todoName);
    }

    @Step
    public void userOpenTodoMVC() {
        todoMVCapp.openApp();
    }

    @Step
    public void userCreatesANewTodo(String name) {
        todoInput.addTodo(name);

    }
}
