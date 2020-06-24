Feature: Busca de Produtos
  Como usuario eu quero pesquisar produtos de diferentes formas.
	
  Scenario Outline: 01 Buscar produto disponível por código
    When pesquiso produto por codigo "<codProd>"

    Examples: 
      | codProd    |
      | 708971000  |
      | hj9a86a13a |
	
  Scenario Outline: 02 Buscar produto disponivel por nome
    When pesquiso produto por nome "<nomeProd>"

    Examples: 
      | nomeProd  |
      | relógio |
	
  Scenario Outline: 03 Buscar produto disponivel por marca
    When pesquiso produto por marca "<marcaProd>"

    Examples: 
      | marcaProd |
      | brastemp  |
	
  Scenario: 04 Buscar produto inexixstente
  	When pesquiso produto inexistente "non-existent product"
    Then exibe mensagem produto inexistente
	
  Scenario: 05 Buscar produto invalido
 		When pesquiso produto inexistente "@@@"
    Then exibe mensagem busca invalida
