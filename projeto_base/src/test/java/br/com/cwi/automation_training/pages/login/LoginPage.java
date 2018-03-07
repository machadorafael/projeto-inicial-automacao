package br.com.cwi.automation_training.pages.login;

import org.openqa.selenium.support.PageFactory;

import br.com.cwi.automation_training.util.TestRule;

public class LoginPage extends LoginElementMap {

	public LoginPage() {
		PageFactory.initElements(TestRule.getDriver(), this);
	}

	public void acessarMenuEntrar() {
		waitElement(menuEntrar, 10);
		menuEntrar.click();

		logPrint("Acessou o menu 'Entrar'");
	}

	// Efetuar Login com dados válidos

	public void informarUsuario() {
		waitElement(username, 5);
		moveToElement(username);
		username.sendKeys("dgelsiogym@gmail.com");
		logPrint("Informou o usuário");
	}

	public void informarSenha() {
		waitElement(password, 5);
		moveToElement(password);
		password.sendKeys("abcdefg1");
		logPrint("Informou a senha");
	}

	public void acessarBotaoEntrar() {
		btnEntrar.click();
		logPrint("Clicou no botão 'Entrar'");
	}

	public void loginEfetuado() {
		waitElement(loginEfetuado, 10);
		logPrint("Login efetuado corretamente");
	}

	// Efetuar Login com dados inválidos

	public void informarUsuarioInvalido() {
		waitElement(username, 5);
		moveToElement(username);
		username.sendKeys("a@b.c");
		logPrint("Informou o usuário inválido");
	}

	public void informarSenhaIncorreta() {
		waitElement(password, 5);
		moveToElement(password);
		password.sendKeys("abcde123");
		logPrint("Informou a senha incorreta");
	}

	public void loginNaoEfetuado() {
		waitElement(loginNaoEfetuado, 5);
		logPrint("Login não efetuado. Dados inválidos");
	}

}