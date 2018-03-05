package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Setup.Setup;

public class HomePage extends Setup {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        super();
        this.driver = driver;
    }

    public DepartamentoPage pesquisarCampoDeBusca(WebDriver driver) {
        WebElement campoBusca = driver.findElement(By.id("search_query_top"));
        campoBusca.sendKeys("Dress");

        WebElement botaoBuscar = driver.findElement(By.name("submit_search"));
        botaoBuscar.click();

        return new DepartamentoPage(driver);
    }

    public void preecherNewsletterComEmailInvalido() {
        WebElement campoNewslatter = driver.findElement(By.id("newsletter-input"));
        campoNewslatter.sendKeys("abcdef");
    }

    public void clicarNoBotaoOK() {
        WebElement botaoOK = driver.findElement(By.name("submitNewsletter"));
        botaoOK.click();
    }

    public void validarEmail() {
        WebElement textoResultado = driver.findElement(By.xpath("//*[@id='columns']/p"));
        boolean apareceuTextoEsperado = textoResultado.getText().contains("Newsletter : Invalid email address.");

        Assert.assertTrue(apareceuTextoEsperado);
    }

    public void acessarMenuWomen() {
        WebElement menuWomen = driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[1]/a"));
        moveToElement(menuWomen, driver);

        waitElement(By.xpath("//*[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul/li[1]/a"), 3, driver);
    }

    public void acessarMenuTShirts() {
        WebElement menuTShirts = driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul/li[1]/a"));

        boolean acessaMenuTShirt = false;
        if (menuTShirts.isEnabled()) {
            acessaMenuTShirt = true;
        }

        menuTShirts.click();

        Assert.assertTrue(acessaMenuTShirt);
    }

    public void acessaSignIn() {
        WebElement menuSigIn = driver.findElement(By.cssSelector(".login"));
        menuSigIn.click();

        RegisterPage register = new RegisterPage(driver);
        register.efetuarCadastro();
    }

}
