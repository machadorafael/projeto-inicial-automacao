package pages;

import org.openqa.selenium.support.PageFactory;

import util.TestRule;

public class FabricaDeTestesPage extends FabricaDeTestesElementMap {

	public FabricaDeTestesPage() {
		PageFactory.initElements(TestRule.getDriver(), this);
	}	

	public boolean tituloDaPaginaEstaCorreto() {		
		logPrint("Validou titulo exibido na pagina");
		return tituloPagina.getText().equals("Testes especializados para melhorar a qualidade dos requisitos do seu software.");
	}
}