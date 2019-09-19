import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	static WebDriver driver; 
	public static WebDriver launch() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SATHISH\\eclipse-workspace\\Snapdeal\\Driver\\chromedriver.exe");
		driver= new ChromeDriver();
		return driver;
		}
	public static void url(String ur) {
		driver.get(ur);
	}
	public static void find(WebElement e,String path) {
		e.sendKeys(path);
	}
	public static void btnclick(WebElement e) {
		e.click();

	}
	public static String parentwindow() {
		String parent = driver.getWindowHandle();
		return parent;
		
	}
    
	public static Set<String> allwind() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
		}
	public static File screenshot(String path) throws IOException {
		TakesScreenshot tk=(TakesScreenshot)driver;
		File source = tk.getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		FileUtils.copyFile(source, dest);
		return dest;
		
		
		

	}
	public static String getData(int rowno,int cellno) throws IOException {
		
	File loc = new File("C:\\Users\\SATHISH\\eclipse-workspace\\Maven\\TestData\\Student.xlsx");
	FileInputStream stream= new FileInputStream(loc);
	Workbook w = new XSSFWorkbook(stream);
    Sheet s = w.getSheet("Sheet1");
    Row r = s.getRow(rowno);
    Cell cell = r.getCell(cellno);
    int cellType = cell.getCellType();
    
    String name=null;
    
    if(cellType==1) {
    	name = cell.getStringCellValue();
    	}
    if(cellType==0) {
    	if(DateUtil.isCellDateFormatted(cell)) {
    		new SimpleDateFormat("dd-mmm-yy").format(cell.getDateCellValue());
    	}
    	else {
    	   double numericCellValue = cell.getNumericCellValue();
    	   long l= (long)numericCellValue;
    	   String v = String.valueOf(l);
    	}
    }
    return name;
	}
}


