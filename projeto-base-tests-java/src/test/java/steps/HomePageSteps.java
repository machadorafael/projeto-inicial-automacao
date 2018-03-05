package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Quando;
import pages.HomePage;
import util.TestRule;
import util.Utils;

public class HomePageSteps {
	@Dado("que estou na HomePage do site da CWI")
	public void acessarHomePageCWI() {

		TestRule.openChrome(Utils.getTestProperty("test.base_url"));		
	}	
	
	@Quando("acesso o menu Sobre a CWI - Quem Somos")
	public void acessarMenuSobreCWI_QuemSomos() {
		HomePage homePage = new HomePage();
		homePage.acessarMenuSobreCWIQuemSomos();
	}
	
	@Quando("acesso o menu Servicos - Fabrica de Testes")
	public void acessarMenuServicos_FabricaDeTestes() {
		HomePage homePage = new HomePage();
		homePage.acessarMenuServicosFabricaDeTeste();
	}
	
	@Quando("acesso o menu Qualidade")
	public void acessarMenuQualidade() {
		HomePage homePage = new HomePage();
		homePage.acessarMenuQualidade();
	}
	
	@Quando("acesso o menu Oportunidades")
	public void acessarMenuOportunidades() {
		HomePage homePage = new HomePage();
		homePage.acessarMenuOportunidades();
	}
}
