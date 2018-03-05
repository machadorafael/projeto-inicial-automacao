package util;

import java.net.URL;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Screen;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.NetworkMode;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import pages.BasePage;

public class TestRule extends TestWatcher {

	private static WebDriver driver;
	private static Screen sikuli;
	private static EvidenceReport evidenceReport;
	private static ExtentReports extentReport;
	private static Scenario scenario;
	private static ExtentTest extentTest;
	
    public TestRule() {
		super();
	}

	@Override
	protected void starting(Description description) {
		super.starting(description);

		//EXTENTREPORT
		extentReport = new ExtentReports("src/test/resources/relatorios/" + description.getDisplayName().replace("tests.", "") + ".html", true, NetworkMode.ONLINE);
	}

	@Before
	public void beforeCenario(Scenario scenario) {
	    this.scenario = scenario;
	    
		//INICIA EVIDENCIAS
		evidenceReport = new EvidenceReport();
		
		//INICIA EXTENTTEST
	    extentTest = extentReport.startTest("Cenario: " + scenario.getName(), scenario.getName());
	    
	    //INICIA SIKULI //TODO: buscar todas as pastas com imagens automaticamente:
        sikuli = new Screen();
        for (String directory : Utils.getSubDirectoriesNames("src/test/resources/sikuli_images/")) {
        	ImagePath.add("src/test/resources/sikuli_images/" + directory);
		}
	}
	
	@After
	public void afterCenario(){
    	if(scenario.isFailed()){
    		BasePage basePage = new BasePage();
    		basePage.logPrintFail("O teste falhou");
    	}
		
    	//FINALIZA EVIDENCIAS
		evidenceReport.generateEvidenceReport(evidenceReport.getEvidenceReport(), scenario.getName(), "CWI Software", scenario.getName());
		
		//FINALIZA EXTENT REPORT
    	extentReport.endTest(extentTest);
    	extentReport.flush();
    	
		//FINALIZA DRIVER caso esteja sendo usado
    	if (driver != null) {
    		driver.close();
    		driver.quit();
		}
	}
	
	@Override
	protected void finished(Description description) {
		super.finished(description);
	}

	public static WebDriver getDriver() {
		return driver;
	}
	
	public static ExtentTest getExtentTest() {
		return extentTest;
	}
	
	public static Scenario getScenario() {
		return scenario;
	}
	
	public static EvidenceReport getEvidenceReport() {
		return evidenceReport;
	}
	
	public static Screen getSikuli() {
		return sikuli;
	}
	
	public static void openChrome(String url){
		if (System.getProperty("os.name").contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		}
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(url);
	}
	
	public static void openApplication(String applicationPath){
		try {
			DesktopOptions options = new DesktopOptions();
			options.setApplicationPath(applicationPath);
			driver = new WiniumDriver(new URL("http://localhost:9999"), options);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}