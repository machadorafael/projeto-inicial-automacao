package steps;

import org.junit.Assert;

import cucumber.api.java.pt.Entao;
import pages.FabricaDeTestesPage;

public class FabricaDeTestesSteps {	
	
	@Entao("deve apresentar pagina com informacoes da fabrica de testes")
	public void validarTituloDaPagina() {
		FabricaDeTestesPage fabricaDeTestesPage = new FabricaDeTestesPage();
		Assert.assertTrue("Titulo exibido esta incorreto!!!", fabricaDeTestesPage.tituloDaPaginaEstaCorreto());
	}
}
