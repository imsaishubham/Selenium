package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class cricbuzz {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.cricbuzz.com/");

		Thread.sleep(5000);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//a[@class='cb-mat-mnu-itm cb-ovr-flo'])[5]")).click();
		driver.findElement(By.xpath("(//a[@class='cb-nav-tab '])[1]")).click();
		// driver.get("https://www.cricbuzz.com/live-cricket-scorecard/30330/mi-vs-csk-1st-match-indian-premier-league-2020");
		Thread.sleep(5000);

		// ******First Team***************
		String Team1 = driver.findElement(By.xpath("//div[@id='innings_1']/div/div/span")).getText().replaceAll("Innings", "");
		System.out.println("-----"+Team1+"Scorecard : First Innings-----");
		WebElement fone = driver.findElement(By.xpath("//div[@id='innings_1']/div"));
		int fcount = fone.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).size();
		int fsum = 0;

		for (int i = 0; i < fcount - 2; i++) 
		{
			String fscore = fone.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText();
			System.out.println("Batsman "+(i+1)+" : "+fscore);
			int fvalue1 = Integer.parseInt(fscore);
			fsum = fsum + fvalue1;
		}
		String fxtras = driver.findElement(By.xpath("(//div[text()='Extras'])/following-sibling::div")).getText();
		System.out.println("Extras : "+fxtras);
		int fvalue2 = Integer.parseInt(fxtras);
		fsum = fsum + fvalue2;
		System.out.println("Calculated first innings total : "+fsum);

		String ftotal = driver.findElement(By.xpath("(//div[text()='Total'])/following-sibling::div")).getText();
		int fvalue3 = Integer.parseInt(ftotal);
		System.out.println("Displayed first innings total : "+fvalue3);

		if (fsum == fvalue3) {
			System.out.println("First innings total is correct");
		} else {
			System.out.println("First innings total is incorrect");
		}

		// **********Second Team*********
		String Team2 = driver.findElement(By.xpath("//div[@id='innings_2']/div/div/span")).getText().replaceAll("Innings", "");
		System.out.println("-----"+Team2+"Scorecard : Second Innings-----");
		WebElement sone = driver.findElement(By.xpath("//div[@id='innings_2']/div"));
		int scount = sone.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).size();
		int ssum = 0;

		for (int i = 0; i < scount - 2; i++) 
		{
			String sscore = sone.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText();
			System.out.println("Batsman "+(i+1)+" : "+sscore);
			int svalue1 = Integer.parseInt(sscore);
			ssum = ssum + svalue1;
		}
		String sxtras = driver.findElement(By.xpath("((//div[text()='Extras'])[2])/following-sibling::div")).getText();
		System.out.println("Extras : "+sxtras);
		int svalue2 = Integer.parseInt(sxtras);
		ssum = ssum + svalue2;
		System.out.println("Calculated second innings total : "+ssum);

		String stotal = driver.findElement(By.xpath("((//div[text()='Total'])[2])/following-sibling::div")).getText();
		int svalue3 = Integer.parseInt(stotal);
		System.out.println("Displayed second innings total : "+svalue3);

		if (ssum == svalue3) {
			System.out.println("Second innings total is correct");
		} else {
			System.out.println("Second innings total is incorrect");
		}

		// ****Result*******
		if (fsum > ssum) {
			System.out.println("*****"+Team1+" won*****");
		} else if (ssum > fsum) {
			System.out.println("*****"+Team2+" won*****");
		} else {
			System.out.println("****Match Tied******");
			System.out.println("****Super Over******");
		}

		driver.close();
	}
}
