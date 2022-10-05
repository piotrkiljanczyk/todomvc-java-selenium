package org.example.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class TodoInput extends PageObject {

    private final By TODO_INPUT = By.cssSelector(".new-todo");

    public void addTodo(String name) {
        find(TODO_INPUT).typeAndEnter(name);
    }
}
