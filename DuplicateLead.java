package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		driver.findElement(By.linkText("Leads")).click();
		
		driver.findElement(By.linkText("Create Lead")).click();
		
		WebElement coName=driver.findElement(By.id("createLeadForm_companyName"));
		coName.sendKeys("TestLeaf");
		
		WebElement fName=driver.findElement(By.id("createLeadForm_firstName"));
		fName.sendKeys("Rajeswari");
		
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("M");
		
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Raji");
		
		driver.findElement(By.name("departmentName")).sendKeys("Sales");
		
		driver.findElement(By.name("description")).sendKeys("East region");
		
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("abcdef@gmail.com");
		
		WebElement stateSelector = driver.findElement(By.name("generalStateProvinceGeoId"));
		Select ss=new Select(stateSelector);
		ss.selectByVisibleText("New York");
		
		driver.findElement(By.name("submitButton")).click();
		
		String title = driver.getTitle();
		System.out.println(title);
		
		if(title.equals("View Lead | opentaps CRM"))
			System.out.println("Title is matching");
		else
			System.out.println("Title is not matching");
		
				
				/*17. Click on Duplicate button
                  18. Clear the CompanyName Field using .clear() And Enter new CompanyName
                  19.Clear the FirstName Field using .clear() And Enter new FirstName
                  20.Click on Create Lead Button
                  21. Get the Title of Resulting Page(refer the video)  using driver.getTitle()*/
		
		driver.findElement(By.linkText("Duplicate Lead")).click();
		
		WebElement coName1=driver.findElement(By.id("createLeadForm_companyName"));
		coName1.clear();
		coName1.sendKeys("HCL Technologies");
		
		WebElement fName1=driver.findElement(By.id("createLeadForm_firstName"));
		fName1.clear();
		fName1.sendKeys("Eswari");
		
		driver.findElement(By.className("smallSubmit")).click();
		
		String dupTitle = driver.getTitle();
		System.out.println(dupTitle);
		
		if(dupTitle.equals("View Lead | opentaps CRM"))
			System.out.println("Title is matching");
		else
			System.out.println("Title is not matching");
		
	

	}

}
