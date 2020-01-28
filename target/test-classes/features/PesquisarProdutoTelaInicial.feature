# language: pt
Funcionalidade: Pesquisar produto tela inicial

Contexto: 
    Dado que usuario esta na pagina inicial do site Advantage
    Quando clicar na opcao desejada na tela home
    
    @pesquisarProdutoPelaHome
    Cenario: Pesquisar produto pela tela home
    E escolher produto desejado na lista de produtos
    Entao estou na tela da opcao escolhida
    
    @validarAberturaProdutoErrado
    Cenario: Certifica abertura de produto diferente
    E escolhe produto na tela inicial
    Entao abre produto diferente do que consta na  tela inicial
    
    


