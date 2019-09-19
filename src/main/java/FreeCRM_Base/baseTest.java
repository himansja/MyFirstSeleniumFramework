package FreeCRM_Base;



import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.ExcelReading;

public class baseTest {
	public  WebDriver driver;
	public static  String Projectpath;
	public static  configFileReader config;
	public static ExcelReading excel;
	protected static String currentDateTime;
	public static String dirStruct;
	public static String htmlReportName;




	static {
		Calendar calendar= Calendar.getInstance(); 
		SimpleDateFormat formater= new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		currentDateTime=formater.format(calendar.getTime());
		System.out.println(currentDateTime);
		Projectpath= System.getProperty("user.dir");  /**Setting up user directory path*/
		config = new configFileReader(Projectpath);
		config.loadPropertiesFile();	
		String filename = config.getInputDataFile();
		excel = new ExcelReading();
		excel.excelReading(Projectpath,filename);
		dirStruct =CreateDirectoryStructure.getReportingDirectory(config.getApplicationName(), Projectpath, currentDateTime);
		htmlReportName = dirStruct + config.getApplicationName() + ".html";
		System.out.println(htmlReportName);
		ExtentManager.createInstance(htmlReportName, config.getApplicationName(),"QA");
	}

	@BeforeMethod 
	public void invokeBrowser() throws InterruptedException {


		System.out.println(Projectpath);  
		String DriverPath= Projectpath+"/driver/chromedriver.exe" ;   /**Setting up driver directory path */
		System.out.println(DriverPath);              

		System.setProperty("webdriver.chrome.driver", DriverPath);    /** Setting up chromediver path as a environment varaialble*/

		//new DesiredCapabilities();
		driver = new ChromeDriver();    /** Creating object of Webdriver interface with refernece of ChromeDriver class*/
		//DesiredCapabilities dc = DesiredCapabilities.chrome();
		//RemoteWebDriver driver;
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("disable-infobars");
		//dc.setCapability(ChromeOptions.CAPABILITY, options);
		//driver = new RemoteWebDriver(new URL("http://192.168.1.15:4444/wd/hub"),dc);
		driver.get(config.getUrl());
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(5000);


	}

	@DataProvider(name = "inputdata")
	public static Object[][] data(Method m){

		/**using reflexion api to read sheetname from parameter level*/
		String sheetname = m.getAnnotation(Test.class).description();
		LinkedHashMap<String, LinkedHashMap<String, String>> sheetdateMap=excel.getValueBySheetName(sheetname);
		//System.out.println(sheetdateMap);

		Object[][] data= new Object[sheetdateMap.size()][2];

		Iterator<String> itr=sheetdateMap.keySet().iterator();

		int counter=0;
		while(itr.hasNext()) {
			String TC_ID=itr.next();
			data[counter][0]=TC_ID;
			data[counter][1]=sheetdateMap.get(TC_ID);
			counter++;
		}

		return data;

	}


	@AfterMethod
	public void quitBrowser() {
		ExtentManager.getInstance().flush();
		driver.quit();
	}


}
