package br.com.tts.pages;

import static br.com.tts.configs.DriverManager.getDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	ForPages forPage = new ForPages();
	WebDriverWait wait = new WebDriverWait(getDriver(), 20);
	
	public void escreverBusca(String texto) {
		forPage.setText("//input[@id='inpHeaderSearch'][1]", texto);
	}
	public void clicarBuscar() {
		forPage.clickButton("//span[@id='btnHeaderSearch']");
	}
	public String validaCodBusca() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(((By.xpath("//h2[@class='nm-product-name']")))));
		return forPage.getText("//h1[@id='main-title']//strong");
	}
	public List<WebElement> obterResultBusca() {
		wait.until(ExpectedConditions.elementToBeClickable(((By.xpath("//h2[@class='nm-product-name']")))));
		return getDriver().findElements(By.cssSelector(".nm-product-name"));
	}
	public String obterMsgSemResult() {
		wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//p[@class='message1']"))));
		return forPage.getText((By.xpath("//p[@class='message1']")));
	}
	public String obterMsgmResultInvalido() {
		wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//div[@class='nm-not-found-message1']"))));
		return forPage.getText((By.xpath("//div[@class='nm-not-found-message1']")));
	}
	public void clicarProduto() {
		wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//div[@id='powered-by-neemu']//span"))));
		forPage.clicarBotao((By.cssSelector(".nm-product-name")));
	}
}