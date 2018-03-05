package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DepartamentoPage {

    WebDriver driver;

    public DepartamentoPage(WebDriver driver) {
        super();
        this.driver = driver;
    }

    public void validaAcessoAPageDepartamentos() {
        WebElement textoResultado = driver.findElement(By.cssSelector(".lighter"));
        boolean apareceuTextoExperado = textoResultado.getText().contains("DRESS");

        Assert.assertTrue(apareceuTextoExperado);
    }

}
