package pages;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import util.EvidenceReport;
import util.TestRule;

public class BasePage {

	protected WebDriver driver = TestRule.getDriver();
	protected ExtentTest extentTest = TestRule.getExtentTest();
	protected Screen sikuli = TestRule.getSikuli();
	

	
	public BasePage() {
		
	}
	
	protected void wait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	protected void waitMilliseconds(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	protected WebElement waitElement(By by, int timeOutInSeconds){
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)  
                .withTimeout(timeOutInSeconds, TimeUnit.SECONDS)
                .pollingEvery(10, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return element;
	}
	
	protected WebElement waitElement(WebElement webElement, int timeOutInSeconds){
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)  
                .withTimeout(timeOutInSeconds, TimeUnit.SECONDS)
                .pollingEvery(10, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementNotVisibleException.class);
		WebElement element = wait.until(ExpectedConditions.visibilityOf(webElement));
		return element;
	}
	
	protected List<WebElement> waitElements(By by, int timeOutInSeconds) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)  
                .withTimeout(timeOutInSeconds, TimeUnit.SECONDS)
                .pollingEvery(10, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
		List<WebElement> element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
		return element;
	}
	
	protected boolean waitNotPresent(By by, int timeOutInSeconds){
		WebDriver driver = TestRule.getDriver();
		
		waitMilliseconds(500);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)  
                .withTimeout(timeOutInSeconds, TimeUnit.SECONDS)
                .pollingEvery(100, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
		boolean isElementInvisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
		return isElementInvisible;
	}
	
	protected void moveToElement(WebElement element){
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	
	protected boolean isElementDisplayed(By by){
		boolean isElementPresent = false;
		boolean isElementDisplayed = false;
		isElementPresent = !driver.findElements(by).isEmpty();
		if (isElementPresent) {
			isElementDisplayed = driver.findElement(by).isDisplayed();
		}
		return isElementPresent && isElementDisplayed;
	}
	
	protected void aguardarLoading(){
		try {
			waitElement(By.id("loadingScreen"), 3);
			waitElement(By.id("loadingNovosExtratos"), 2);			
		} catch (Exception e) {
		}
		waitNotPresent(By.id("loadingScreen"), 50);
		waitNotPresent(By.id("loadingNovosExtratos"), 50);
	}
	
	private String saveScreenshotInRelatoriosPath(String log){
		Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int month = calendar.get(Calendar.MONTH) + 1;
		int year = calendar.get(Calendar.HOUR_OF_DAY);
		int hours = calendar.get(Calendar.HOUR_OF_DAY);
		int minutes = calendar.get(Calendar.MINUTE);
		int seconds = calendar.get(Calendar.SECOND);
		int milliseconds = calendar.get(Calendar.MILLISECOND);
		String datahora = ""+day+month+year+"_"+hours+minutes+seconds+milliseconds;
		int maxLength = log.length() < 35 ? log.length() : 35;
		String screenShotName = log.toLowerCase().replace(" ", "-").replace("/", "-").replace(":", "-").replace("'", "").replace("<", "").replace(">", "").substring(0, maxLength) + "_" + datahora + ".png";
		try {
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("src/test/resources/relatorios/img/" + screenShotName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return screenShotName;
	}
	
	protected void logPrint(String log){
		ExtentTest extentTest = TestRule.getExtentTest();
		EvidenceReport evidenceReport = TestRule.getEvidenceReport();
		String screenShotName = saveScreenshotInRelatoriosPath(log);
		extentTest.log(LogStatus.PASS, log, extentTest.addScreenCapture("../relatorios/img/" + screenShotName));
		evidenceReport.addEvidence(log, driver);
	}
	
	public void logPrintFail(String log){
		ExtentTest extentTest = TestRule.getExtentTest();
		EvidenceReport evidenceReport = TestRule.getEvidenceReport();
		String screenShotName = saveScreenshotInRelatoriosPath(log);
		extentTest.log(LogStatus.FAIL, log, extentTest.addScreenCapture("../relatorios/img/" + screenShotName));
		evidenceReport.addEvidence(log, driver);
	}
	
	protected void logInfo(String log){
		extentTest.log(LogStatus.INFO, log);
	}
	
	protected void logSkip(String log){
		extentTest.log(LogStatus.SKIP, log);
	}
	
	protected void logFail(String log){
		extentTest.log(LogStatus.FAIL, log);
	}
	
	protected void logError(String log){
		extentTest.log(LogStatus.ERROR, log);
	}
	
	protected void logPass(String log){
		extentTest.log(LogStatus.PASS, log);
	}
	
	protected boolean imageExists(String imageFile, float similarity){
		try {
			FileUtils.copyFile(new File(ImagePath.find(imageFile).getPath()), new File("src/test/resources/relatorios/img/" + imageFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		extentTest.log(LogStatus.INFO, "Imagem esperada: " + imageFile, extentTest.addScreenCapture("../relatorios/img/" + imageFile));
		
		Match image = sikuli.exists(new Pattern(imageFile).similar(similarity));
        boolean imageExists = image != null;
        
        if (imageExists) {
        	image.highlight();
        	waitMilliseconds(30);
        	image.highlight();
        	logPass("Imagem encontrada com " + (image.getScore() * 100) + " % de similaridade");
		} else {
			logFail("A imagem " + imageFile + " nao foi encontrada com a similaridade de " + (similarity * 100) + " %");
		}
        return imageExists;
	}
	
	protected int click(String imageFile){
		try {
			return sikuli.click(imageFile);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	protected void multiType(String arg, int count){
		for (int i = 0; i < count; i++) {
			type(arg);
		}
	}
	
	protected int type(String arg){
		return sikuli.type(arg);
	}
	
	protected void multiClick(int clicks, String imageFile){
		try {
			for (int i = 0; i < clicks; i++) {
				sikuli.click(imageFile);
				waitMilliseconds(500);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	protected List<List<String>> htmlRowListToDataTable(List<WebElement> rowList){
		List<List<String>> dataTable = new ArrayList<List<String>>();
		List<String> linhaDataTable = new ArrayList<String>();
		//List<WebElement> tabelaLinhas = rowList.findElements(By.cssSelector("tr"));
		List<WebElement> colunasDaLinha;
		
		for (WebElement linha : rowList) {
			colunasDaLinha = linha.findElements(By.cssSelector("td,th"));	
			for (WebElement coluna : colunasDaLinha) {
				linhaDataTable.add(coluna.getText());
			}
			dataTable.add(linhaDataTable);
			linhaDataTable = new ArrayList<String>();
		}
		return dataTable;
	}
	
	protected List<List<String>> htmlTableToDataTable(WebElement htmlTable){
		List<List<String>> dataTable = new ArrayList<List<String>>();
		List<String> linhaDataTable = new ArrayList<String>();
		List<WebElement> tabelaLinhas = htmlTable.findElements(By.cssSelector("tr"));
		List<WebElement> colunasDaLinha;
		
		for (WebElement linha : tabelaLinhas) {
			colunasDaLinha = linha.findElements(By.cssSelector("td,th"));	
			for (WebElement coluna : colunasDaLinha) {
				linhaDataTable.add(coluna.getText());
			}
			dataTable.add(linhaDataTable);
			linhaDataTable = new ArrayList<String>();
		}
		return dataTable;
	}

	protected boolean areDataTablesEquals(List<List<String>> tabelaResultado, List<List<String>> tabelaEsperada){
		int quantLinhas = tabelaEsperada.size();
		int quantColunas = tabelaEsperada.get(0).size();
		boolean tabelasSaoIguais = true;
		
		for (int i = 0; i < quantLinhas; i++) {
			for (int j = 0; j < quantColunas; j++) {
				
				String valorTabelaResultado = tabelaResultado.get(i).get(j);
				String valorTabelaEsperada = tabelaEsperada.get(i).get(j);
				
				//corrige encoding
				try {
					valorTabelaResultado = new String(valorTabelaResultado.getBytes("iso-8859-1"), "UTF-8");
					valorTabelaResultado = valorTabelaResultado.replace("\n", " "); //corrige quebra de linha <br>
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				
				if (valorTabelaEsperada.equals(valorTabelaResultado.trim())) {
					logPass("O valor <b>" + valorTabelaEsperada + "</b> foi apresentado corretamente. (Lin " + (i+1) + " Col " + (j+1) + ")");
				} else{
					logFail("O valor <b>" + valorTabelaEsperada + "</b> retornou diferente do esperado! Valor retornado: <b>" + valorTabelaResultado + "</b> (Lin " + (i+1) + " Col " + (j+1) + ")");
					tabelasSaoIguais = false;
				}
			}
		}
		return tabelasSaoIguais;
	}
	
}