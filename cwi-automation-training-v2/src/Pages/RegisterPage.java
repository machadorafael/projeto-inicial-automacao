package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Setup.Setup;

public class RegisterPage extends Setup {

    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        super();
        this.driver = driver;
    }

    public void efetuarCadastro() {
        waitElement(By.id("email_create"), 10, driver);

        WebElement emailCreate = driver.findElement(By.id("email_create"));
        moveToElement(emailCreate, driver);
        emailCreate.sendKeys("meuteste_00005@gmail.com");

        WebElement submitCreate = driver.findElement(By.id("SubmitCreate"));
        submitCreate.click();

        waitElement(By.id("id_gender1"), 10, driver);

        WebElement gender = driver.findElement(By.id("id_gender1"));
        gender.click();

        WebElement firstName = driver.findElement(By.id("customer_firstname"));
        firstName.sendKeys("Usuario");

        WebElement lastName = driver.findElement(By.id("customer_lastname"));
        lastName.sendKeys("Teste");

        WebElement password = driver.findElement(By.id("passwd"));
        password.sendKeys("abcdefg1");

        WebElement days = driver.findElement(By.id("days"));
        days.sendKeys("1");

        WebElement months = driver.findElement(By.id("months"));
        months.sendKeys("o");

        WebElement years = driver.findElement(By.id("years"));
        years.sendKeys("1990");

        WebElement address = driver.findElement(By.id("address1"));
        address.sendKeys("Rua Teste, 100");

        WebElement city = driver.findElement(By.id("city"));
        city.sendKeys("New York");

        WebElement state = driver.findElement(By.id("id_state"));
        state.sendKeys("New York");

        WebElement postCode = driver.findElement(By.id("postcode"));
        postCode.sendKeys("13467");

        WebElement country = driver.findElement(By.id("id_country"));
        country.sendKeys("United States");

        WebElement phoneMobile = driver.findElement(By.id("phone_mobile"));
        phoneMobile.sendKeys("2124962900");

        WebElement buttonRegister = driver.findElement(By.xpath("//*[@id='submitAccount']/span"));
        buttonRegister.click();

        WebElement myAccount = driver.findElement(By.xpath("//*[@class='info-account']"));

        boolean apareceuTextoEsperado = myAccount.getText().contains("Welcome to your account. Here you can manage all of your personal information and orders.");

        Assert.assertTrue(apareceuTextoEsperado);

    }

}
