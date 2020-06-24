# DesafioZup - Thiago Toledo

Testes Automatizados Web no Portal Magazine Luiza.

## Início

Para executar o projeto é necessário:

- 1o Importar o Projeto (MAVEN) e executar a classe "/src/test/java/br/com/tts/runners/Runner.java" como JUnit Test no Eclipse:

	Eclipse IDE for Java Developers Version: 2020-03 (4.15.0).

- 2o Clonar Repositório Remoto (Github https://github.com/ThiagoToledoSilva/DesafioZup.git) para Repositório Local.

	Executar por terminal (CMD) com os comandos:
	cd C:\Users\User1\git\DesafioZup\Desafio_Zup (acessa diretório no repositório local onde está o arquivo POM.xml)
	MVN CLEAN COMPILE
	MVN TEST

## Cenários de Teste

Feature 01: Busca de Produtos
  Como usuario eu quero pesquisar produtos de diferentes formas.

	Scenario: 01 Buscar produto disponível por código
	Scenario: 02 Buscar produto disponivel por nome
	Scenario: 03 Buscar produto disponivel por marca
	Scenario: 04 Buscar produto inexixstente
	Scenario: 05 Buscar produto invalido

Feature 02: Adiciona Produtos ao Carrinho
  Como usuario eu quero pesquisar e adicionar produtos ao carrinho.

	Scenario Outline: 01 Adicionar Produto ao carrinho
	Scenario Outline: 02 Adicionar Produto ao carrinho a partir dos favoritos

## Evidências dos Testes

C:\Users\User1\git\DesafioZup\Desafio_Zup\target\Evidencias dos Testes
C:\Users\User1\git\DesafioZup\Desafio_Zup\target\Relatório dos Testes




