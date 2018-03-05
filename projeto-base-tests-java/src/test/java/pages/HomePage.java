package pages;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import util.TestRule;

public class HomePage extends HomePageElementMap {

	public HomePage() {
		PageFactory.initElements(TestRule.getDriver(), this);
	}

	public void acessarMenuSobreCWIQuemSomos(){
		Actions actions = new Actions(driver);
		actions.moveToElement(menuSobreCWI).perform();		
		submenuQuemSomos.click();
	}
	
	public void acessarMenuServicosFabricaDeTeste(){		
		Actions actions = new Actions(driver);
		actions.moveToElement(menuServicos).perform();
		logPrint("Acessou menu Servicos");
		submenuFabricaDeTestes.click();
		logPrint("Acessou submenu Fabrica de Testes");
	}
	
	public void acessarMenuQualidade(){
		menuQualidade.click();
	}
	
	public void acessarMenuOportunidades(){
		menuOportunidades.click();
	}
}