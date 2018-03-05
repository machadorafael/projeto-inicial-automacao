package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FabricaDeTestesElementMap extends BasePage {

	@FindBy(xpath = "//h2[@class='section-title service-title']")
	protected WebElement tituloPagina;
}