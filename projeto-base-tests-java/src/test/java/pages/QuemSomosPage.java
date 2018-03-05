package pages;

import org.openqa.selenium.support.PageFactory;

import util.TestRule;

public class QuemSomosPage extends QuemSomosPageElementMap {

	public QuemSomosPage() {
		PageFactory.initElements(TestRule.getDriver(), this);
	}	

	public boolean tituloDaPaginaEstaCorreto() {		
		return tituloPagina.getText().equals("O software que voc� procura talvez n�o exista, mas a empresa que ir� fabric�-lo sim.");
	}
}