package br.com.cwi.automation_training.steps.login;

import br.com.cwi.automation_training.pages.login.LoginPage;
import br.com.cwi.automation_training.util.TestRule;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

/**
 * 
 * 
 * @author Rafael dos Santos Machado
 *         <ul>
 *         <li><a href="https://www.linkedin.com/in/rafael-machado-0a012937/">https://www.linkedin.com/in/rafael-machado-0a012937/</a></li>
 *         </ul>
 *
 */

public class LoginSteps {

    // final LoginPage loginPage = new LoginPage();

    @Dado("que estou estou na homepage do site \"(.*)\"")
    public void acessarHomePage(String url) {
        TestRule.openApplicationChrome(url);
    }

    @Quando("clico no menu \"Entrar\"")
    public void acessarMenuEntrar() {
        LoginPage loginPage = new LoginPage();
        loginPage.acessarMenuEntrar();
    }

    @E("digito o nome do usuario valido em \"E-MAIL ou CPF/CNPJ\"")
    public void informarUsuario() {
        LoginPage loginPage = new LoginPage();
        loginPage.informarUsuario();
    }

    @E("digito a senha correta em \"SENHA\"")
    public void informarSenha() {
        LoginPage loginPage = new LoginPage();
        loginPage.informarSenha();
    }

    @E("clico no botao \"Entrar\"")
    public void exibeMensagemDeSucesso() {
        LoginPage loginPage = new LoginPage();
        loginPage.acessarBotaoEntrar();
    }

    @E("digito o nome do usuario invalido em \"E-MAIL ou CPF/CNPJ\"")
    public void informarUsuarioInvalido() {
        LoginPage loginPage = new LoginPage();
        loginPage.informarUsuarioInvalido();
    }

    @E("digito a senha incorreta em \"SENHA\"")
    public void informarSenhaIncorreta() {
        LoginPage loginPage = new LoginPage();
        loginPage.informarSenhaIncorreta();
    }

    @Entao("o login deve ser efetuado corretamente")
    public void loginEfetuado() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginEfetuado();
    }

    @Entao("o login nao deve ser efetuado")
    public void loginNaoEfetuado() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginNaoEfetuado();
    }
}