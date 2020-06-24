package br.com.tts.pages;

import static br.com.tts.configs.DriverManager.getDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class ForPages {
	
	/*** Enviar Texto ***/

	public void setText(By by, String texto) {
		
		getDriver().findElement(by).clear();
		getDriver().findElement(by).sendKeys(texto);
	}
	public void setText(String xpath, String texto) {
		setText(By.xpath(xpath), texto);
	}
	
	/*** Obter Texto ***/
	
	public String getText(By by) {
		return getDriver().findElement(by).getText();
	}
	public String getText(String xpath) {
		return getText(By.xpath(xpath));
	}

	public String getTextXpath(String id) {
		return obterTexto(By.id(id));
	}
	
	/*** TextField e TextArea ***/

	public void escrever(By by, String texto) {
		getDriver().findElement(by).clear();
		getDriver().findElement(by).sendKeys(texto);
	}
	public void escrever(String id_campo, String texto) {
		escrever(By.id(id_campo), texto);
	}
	public String obterValorCampo(String id_campo) {
		return getDriver().findElement(By.id(id_campo)).getAttribute("value");
	}
	
	/*** Radio e Check ***/
	
	public void clicarRadio(By by) {
		getDriver().findElement(by).click();
	}
	public void clicarRadio(String id) {
		clicarRadio(By.id(id));
	}
	public boolean isRadioMarcado(String id) {
		return getDriver().findElement(By.id(id)).isSelected();
	}
	public void clicarCheckBox(String id) {
		getDriver().findElement(By.id(id)).click();
	}
	public boolean isCheckBoxMarcado(String id) {
		return getDriver().findElement(By.id(id)).isSelected();
	}
	
	/*** Botao ***/
	
	public void clicarBotao(By by) {
		getDriver().findElement(by).click();
	}
	public void clicarBotaoPorXpath(String xpath) {
		clicarBotao(By.xpath(xpath));
	}
	public void clickButton(String texto) {
		clicarBotao(By.xpath(texto));
	}
	public void clicarBotao(String id) {
		clicarBotao(By.id(id));
	}
	public void clicarBotaoPorTexto(String texto) {
		clicarBotao(By.xpath("//button[.='"+texto+"']"));
	}
	public String obterValueElemento(String id) {
		return getDriver().findElement(By.id(id)).getAttribute("value");
	}
	
	/*** Link ***/
	
	public void clicarLinks(String link) {
		getDriver().findElement(By.linkText(link)).click();
	}
	
	/*** Texto ***/
	
	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}
	public String obterTexto(String id) {
		return obterTexto(By.id(id));
	}
	
	/*** Alerts  ***/
	
	public String alertaObterTexto() {
		Alert alert = getDriver().switchTo().alert();
		return alert.getText();
	}
	public String alertaObterTextoEAceita() {
		Alert alert = getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.accept();
		return valor;
	}
	public String alertaObterTextoENega() {
		Alert alert = getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.dismiss();
		return valor;
	}
	public void alertaEscrever(String valor) {
		Alert alert = getDriver().switchTo().alert();
		alert.sendKeys(valor);
		alert.accept();
	}
	
	/*** Frames e Janelas ***/
	
	public void entrarFrame(String id) {
		getDriver().switchTo().frame(id);		
	}
	public void sairFrame() {
		getDriver().switchTo().defaultContent();		
	}
	public void trocarJanela(String id) {
		getDriver().switchTo().window(id);
	}
	
}
