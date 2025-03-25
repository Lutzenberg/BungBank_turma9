#language: pt
Funcionalidade: Funcionalidade de login no pugbank
  Cenario: Teste Saldo Inicial 1.000,00
    Dado que eu possua cadastro no pugbank o email: "teste.teste@gmail.com", nome: "Teste" e a senha: "123456"
    E que eu esteja logado no pugbank com email: "teste.teste@gmail.com" e a senha: "123456"
    Quando carregar a homepage
    Entao validar se o saldo é igual: "1.000,00"

