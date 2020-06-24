package br.com.tts.steps;

import static br.com.tts.configs.DriverManager.getDriver;
import static br.com.tts.configs.DriverManager.killDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.com.tts.configs.DriverManager;
import br.com.tts.configs.Properties;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class AfterBeforeSteps { 

	@Before
	public void inicializa() {
		DriverManager.getDriver().get("http://www.magazineluiza.com.br/");
		getDriver().manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);
	}

	@After
	public void screenshot(Scenario cenario) {
		File file = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("target/Evidencias dos Testes/"+cenario.getId()+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	if(Properties.FECHAR_BROWSER)	{
		killDriver();
		}
	}
}


