package br.com.tts.pages;

import static br.com.tts.configs.DriverManager.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {

	ForPages forPage = new ForPages();
	WebDriverWait wait = new WebDriverWait(getDriver(), 20);

	public void clicarAdicionarAoCarrinho() throws InterruptedException {
		Thread.sleep(3000);
		forPage.clicarBotaoPorXpath(("(//*[starts-with(@class,'button')])[1]/span"));
	}
	public void clicarAdicionarAosFavoritos() {
		forPage.clicarBotao((By.cssSelector(".wishlist__favorite-icon.js-add-wishlist")));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(("#wishListCount"))));
	}
	public void selecionarFavoritos() {
		wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("(//*[@class=\"container-wishlist\"])[1]"))));
		forPage.clicarBotao((By.xpath("(//*[@class=\"container-wishlist\"])[1]")));
	}
	public void clicarProdutoEmFavoritos() {
		wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//h3[@class='productTitle']"))));
		forPage.clicarBotao((By.xpath("//h3[@class='productTitle']")));
	}
	public void clicarContinuar() {
		forPage.clicarBotao((By.xpath("//a[contains(string(), \"continuar\")]")));
	}
	public void voltaHome() {
		forPage.clicarBotao((By.xpath("//strong[@class='header-logo hide-text']")));
	}
}
