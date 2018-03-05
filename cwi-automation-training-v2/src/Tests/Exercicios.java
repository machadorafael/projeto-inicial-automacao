package Tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Exercicios {

    WebDriver driver;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com");
    }

    @Test
    public void realizarPesquisa() {
        WebElement campoBusca = driver.findElement(By.id("search_query_top"));
        campoBusca.sendKeys("Dress");

        WebElement botaoBuscar = driver.findElement(By.name("submit_search"));
        botaoBuscar.click();

        WebElement textoResultadosEncontrados = driver.findElement(By.cssSelector(".heading-counter"));
        // WebElement textoResultadosEncontrados = waitElement(By.cssSelector(".heading-counter"), 10);

        Assert.assertTrue(textoResultadosEncontrados.getText().contains("results have been found"));
    }

    @Test
    public void informarEmailInvalido() {

    }

    @Test
    public void acessarMenu() {

    }

    @After
    public void after() {
        driver.quit();
    }

    private WebElement waitElement(By by, int timeOutInSeconds) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(timeOutInSeconds, TimeUnit.SECONDS)
                .pollingEvery(200, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return element;
    }

    private void moveToElement(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

}
