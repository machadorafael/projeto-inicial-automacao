#language: pt
#encoding: iso-8859-1
Funcionalidade: Login 

@login 
Cenario: Realizar Login com Dados Invalidos 
Dado que estou estou na homepage do site "http://light-layout.gpa.digital/#/" 
Quando clico no menu "Entrar" 
E digito o nome do usuario invalido em "E-MAIL ou CPF/CNPJ" 
E digito a senha incorreta em "SENHA" 
E clico no botao "Entrar" 
Entao o login nao deve ser efetuado 

@login 
Cenario: Realizar Login com Dados Validos 
Dado que estou estou na homepage do site "http://light-layout.gpa.digital/#/" 
Quando clico no menu "Entrar" 
E digito o nome do usuario valido em "E-MAIL ou CPF/CNPJ" 
E digito a senha correta em "SENHA" 
E clico no botao "Entrar" 
Entao o login deve ser efetuado corretamente