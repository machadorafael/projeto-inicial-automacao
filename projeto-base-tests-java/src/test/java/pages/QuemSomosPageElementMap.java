package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QuemSomosPageElementMap extends BasePage {

	@FindBy(xpath = "//h2[@class='section-title']")
	protected WebElement tituloPagina;
}