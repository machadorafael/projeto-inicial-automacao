package steps;

import org.junit.Assert;

import cucumber.api.java.pt.Entao;
import pages.QuemSomosPage;

public class QuemSomosSteps {	
	
	@Entao("deve apresentar pagina com a historia da empresa")
	public void validarTituloDaPagina() {
		QuemSomosPage quemSomosPage = new QuemSomosPage();
		Assert.assertTrue("Titulo exibido esta incorreto!!!", quemSomosPage.tituloDaPaginaEstaCorreto());
	}
}
