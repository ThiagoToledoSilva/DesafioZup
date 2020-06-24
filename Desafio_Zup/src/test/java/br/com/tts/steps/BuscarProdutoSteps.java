package br.com.tts.steps;

import static br.com.tts.configs.DriverManager.getDriver;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.tts.pages.HomePage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BuscarProdutoSteps {

	WebDriverWait wait = new WebDriverWait(getDriver(), 20);
	HomePage homePage = new HomePage();
	
	@When("^pesquiso produto por código \"([^\"]*)\"$")
	public void pesquisoProdutoPorCódigo(String arg1) throws Throwable {
		homePage.escreverBusca(arg1);
		homePage.clicarBuscar();

		Assert.assertEquals(arg1, homePage.validaCodBusca());
	}

	@When("^pesquiso produto por nome \"([^\"]*)\"$")
	public void pesquisoProdutoPorNome(String arg1) throws Throwable {
		homePage.escreverBusca(arg1);
		homePage.clicarBuscar();
		
		List<WebElement> resultados = homePage.obterResultBusca();
		String result01 = (resultados.get(0).getText());
		Assert.assertTrue(result01.toLowerCase().contains(arg1.toLowerCase()));
	}

	@When("^pesquiso produto por marca \"([^\"]*)\"$")
	public void pesquisoProdutoPorMarca(String arg1) throws Throwable {
		homePage.escreverBusca(arg1);
		homePage.clicarBuscar();
		
		List<WebElement> resultados = homePage.obterResultBusca();
		String result01 = (resultados.get(0).getText());
		Assert.assertTrue(result01.toLowerCase().contains(arg1.toLowerCase()));
	}
	
	@When("^pesquiso produto inexistente \"([^\"]*)\"$")
	public void pesquisoProdutoInexistente(String arg1) throws Throwable {
		homePage.escreverBusca(arg1);
		homePage.clicarBuscar();
	}
	
	@Then("^exibe mensagem produto inexistente$")
	public void exibeMensagem() throws Throwable {
		Thread.sleep(2000);
		Assert.assertEquals("Nenhum resultado encontrado para a consulta \"non-existent product\"", homePage.obterMsgSemResult());
	}

	@Then("^exibe mensagem busca inválida$")
	public void exibeMensagemBuscaInválida() throws Throwable {
		Thread.sleep(2000);
		Assert.assertEquals("Sua busca por @@@ não encontrou resultado algum :(", homePage.obterMsgmResultInvalido());
	}

}