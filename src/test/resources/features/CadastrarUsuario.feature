# language: pt
Funcionalidade: Cadastrar Usuario

  Contexto: 
    Dado que usuario esta na pagina inicial do site Advantage
    Quando clicar em botao de login
    E clicar em criar conta

  @CriarCadastroComSucesso
  Cenario: Cadastro com sucesso com dados validos
    E insere nome de usuario
    E insere o email
    E insere a senha
    E confirma a senha
    E insere o primeiro nome
    E insere o ultimo nome
    E insere o numero do telefone
    E seleciona o pais
    E insere a cidade
    E insere o endereco
    E insere o estado
    E insere o CEP
    E clicar em aceitar termos
    E clicar em registrar
    Entao usuario cadastrado com sucesso

  @validarBotao
  Cenario: Validar se o botao registrar esta desabilitado sem informacoes preenchidos
    Entao botao esta desabilitado
