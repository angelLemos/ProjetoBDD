# language: pt
Funcionalidade: Pesquisar produto pela lupa

  Contexto: 
    Dado que usuario esta na pagina inicial do site Advantage
    Quando clicar na lupa

  @pesquisarProdutoPelaLupa
  Cenario: Pesquisar produto pela lupa
    E digitar o que deseja na lupa
    E selecionar produto desejado na lista de produtos
    Entao abre a pagina da opcao escolhida

  @pesquisarProdutoInexistente
  Cenario: pesquisar produto inexistente
    E digitar um produto inexistente no site
    Entao constata que o produto nao existe
