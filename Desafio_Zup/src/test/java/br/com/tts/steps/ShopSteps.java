package br.com.tts.steps;

import static br.com.tts.configs.DriverManager.getDriver;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.tts.pages.HomePage;
import br.com.tts.pages.OrderPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ShopSteps {

	WebDriverWait wait = new WebDriverWait(getDriver(), 20);
	HomePage homePage = new HomePage();
	OrderPage orderPage = new OrderPage();
	
	@Then("^adiciono produto ao carrinho$")
	public void adicionoAoCarrinho() throws Throwable {
		homePage.clicarProduto();
		orderPage.clicarAdicionarAoCarrinho();
		Assert.assertEquals("Relógio Smartwatch Feminino Masculino Pulseira Simples Preto - Prime", 
				getDriver().findElement(By.cssSelector(".BasketItemProduct-info>a:first-child>p")).getText());
	}
	
	@When("^adiciono aos favoritos$")
	public void adicionoAosFavoritos() throws Throwable {
		orderPage.clicarAdicionarAosFavoritos();
		Thread.sleep(10000);
		orderPage.voltaHome();
		orderPage.selecionarFavoritos();		
		orderPage.clicarProdutoEmFavoritos();
		orderPage.clicarAdicionarAoCarrinho();
		orderPage.clicarContinuar();
		
		Assert.assertEquals("Código do produto: 155566300", getDriver().findElement(By.xpath("//p[@class='BasketItemProduct-info-sku']")).getText());
		
	}
}