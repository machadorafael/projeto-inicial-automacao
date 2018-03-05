package Tests;

import org.junit.Test;

import Pages.DepartamentoPage;
import Pages.HomePage;
import Setup.Setup;

public class Treinamento extends Setup {

    @Test
    public void test1() {
        HomePage homePage = new HomePage(getDriver());
        DepartamentoPage departamentoPage = homePage.pesquisarCampoDeBusca(getDriver());
        departamentoPage.validaAcessoAPageDepartamentos();
    }

    @Test
    public void test2() {
        HomePage homePage = new HomePage(getDriver());
        homePage.preecherNewsletterComEmailInvalido();
        homePage.clicarNoBotaoOK();
        homePage.validarEmail();
    }

    @Test
    public void test3() {
        HomePage homePage = new HomePage(getDriver());
        homePage.acessarMenuWomen();
        homePage.acessarMenuTShirts();
    }

    // Exercícios - Tema de Casa
    @Test
    public void efetuarCadastroTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.acessaSignIn();

    }

}