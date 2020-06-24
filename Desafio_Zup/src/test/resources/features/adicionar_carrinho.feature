Feature: Adiciona Produtos ao Carrinho
  Como usuario eu quero pesquisar e adicionar produtos ao carrinho.
	
  Scenario Outline: 01 Adicionar Produto ao carrinho
    When pesquiso produto por código "<codProd>"
    Then adiciono produto ao carrinho

    Examples: 
      | codProd 	 |
      | hkd1ga0d44 |
	
  Scenario Outline: 02 Adicionar Produto ao carrinho a partir dos favoritos
    When pesquiso produto por código "<codProd>"
    And adiciono aos favoritos

    Examples: 
      | codProd 				|
      | 155566300 |