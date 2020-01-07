package angel_co;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;

public class angel 
{
	public static void main(String[] args) throws Exception 
	{
		WebDriver driver = null;
		System.setProperty("webdriver.chrome.driver", "D:\\Jar Files\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.get("https://angel.co/");    

		File file = new File("E:\\Download\\SCH\\ReadData.xlsx"); 
		FileInputStream iFile = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(iFile);      
		XSSFSheet sheet = wb.getSheet("Sheet1"); 
		String location = sheet.getRow(0).getCell(0).getStringCellValue();
		
		
		Thread.sleep(1000);
		WebElement search=driver.findElement(By.name("search"));
		search.sendKeys(location);
		
		Thread.sleep(8000);
		List<WebElement> listOfOptions = driver.findElements(By.xpath("//*[contains (text(), 'SHC Technologies')]"));
		for(WebElement listOfOption :listOfOptions ){
		System.out.println(listOfOption.getText());
		}
		
		Screen sc=new Screen();
		sc.click("E:\\Download\\SCH\\SHC.PNG");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[contains (@title, 'Jobs')]")).click();
		
		/* job title.*/
		Thread.sleep(5000);
		List<WebElement> title = driver.findElements(By.xpath("//*[@id=\"main\"]/div[1]/div[4]/div/div/div[1]/div/section/div[2]/div[1]/ul[1]/li"));
	    System.out.println(title);

	    for (WebElement element: title) 
	    {
	        System.out.println(element.getText()); 
	    }	
	    
	    /*  job location.*/
	    Thread.sleep(5000);
		List<WebElement> jlocation = driver.findElements(By.xpath("//*[@id=\"main\"]/div[1]/div[4]/div/div/div[1]/div/section/div[2]/div[1]/ul[2]/li"));
	    System.out.println(jlocation);

	    for (WebElement element: jlocation) 
	    {
	        System.out.println(element.getText()); 
	    }
	    
	    /*  job type */
	    Thread.sleep(5000);
		List<WebElement> type = driver.findElements(By.xpath("//*[@id=\"main\"]/div[1]/div[4]/div/div/div[1]/div/section/div[2]/div[1]/ul[3]/li"));
	    System.out.println(type);

	    for (WebElement element: type) 
	    {
	        System.out.println(element.getText()); 
	    }
	    
		driver.close();
	}

}
