package br.com.cwi.automation_training.pages.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.cwi.automation_training.pages.BasePage;

public class LoginElementMap extends BasePage {

    protected WebElement search_query_top;

    @FindBy(xpath = "//*[@id=\"light-header\"]/div[3]/div/div[4]/ul/li[2]/a")
    protected WebElement menuEntrar;

    @FindBy(xpath = "(//input[@name=\"username\"])[2]")
    protected WebElement username;

    @FindBy(xpath = "(//input[@name=\"password\"])[2]")
    protected WebElement password;

    @FindBy(xpath = "//*[@id=\"loginPopover\"]/form/button")
    protected WebElement btnEntrar;

    @FindBy(xpath = "//*[@id=\"light-header\"]/div[3]/div/div[4]/ul/li[2]/a/span[2]")
    protected WebElement userMenu;

    @FindBy(xpath = "//*[@id=\"light-header\"]/div[3]/div/div[4]/ul/li[2]/a/span[2]")
    protected WebElement loginEfetuado;

    @FindBy(id = "loading-bar")
    protected WebElement loginNaoEfetuado;
}