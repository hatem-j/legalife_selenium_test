package main;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;

public class LegalifeTest {

	WebDriver driver;

	@Before
	public void SetDriver() {
		// déclaration de navigateur (Google chrome)
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Hatem\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		// accéder au site web legalife.fr
		driver.get("https://www.legalife.fr/");
	}

	@Test
	public void verifyButtonInscription() throws InterruptedException {
		// Agrandir la fenétre
		driver.manage().window().maximize();
		Thread.sleep(2000);
		assertTrue(driver.findElement(By.linkText("Inscription")).isDisplayed());
	}

	@Test
	public void verifyEmailInput() throws InterruptedException {
		driver.findElement(By.linkText("Inscription")).click();
		assertTrue(driver.findElements(By.xpath("//input[@placeholder='Votre email' and @type='email']")).get(1)
				.isEnabled());

	}

	@Test
	public void verifyPasswordInput() throws InterruptedException {
		driver.findElement(By.linkText("Inscription")).click();
		AssertJUnit.assertTrue(driver
				.findElement(By.xpath("//input[@placeholder='Votre mot de passe' and @type='password']")).isEnabled());
		// Remplissage du champ Mot de passe avec le jeux de donées Unlatch
		driver.findElement(By.xpath("//input[@placeholder='Votre mot de passe' and @type='password']"))
				.sendKeys("Unlatch");
	}

	@Test
	public void verifyButtonConnexion() throws InterruptedException {
		driver.findElement(By.linkText("Inscription")).click();
		AssertJUnit.assertTrue(driver.findElements(By.xpath("//button[@class='btn btn--default' and @type='submit']"))
				.get(1).isDisplayed());
	}

	@Test
	public void verifySeConnecter() throws InterruptedException {
		driver.findElement(By.linkText("Inscription")).click();
		// Remplissage du champ email avec le jeux de donées hatem.jeridi@epsi.fr
		driver.findElements(By.xpath("//input[@placeholder='Votre email' and @type='email']")).get(1)
				.sendKeys("hatem.jeridi@epsi.fr");
		// Remplissage du champ Mot de passe avec le jeux de donées Unlatch
		driver.findElement(By.xpath("//input[@placeholder='Votre mot de passe' and @type='password']"))
				.sendKeys("Unlatch");
		// Cliquer sur le bouton
		driver.findElements(By.xpath("//button[@class='btn btn--default' and @type='submit']")).get(1).click();
		Thread.sleep(2000);
		assertTrue(driver.getPageSource().contains("Votre combinaison email/mot de passe est incorrecte."));
	}

	@Test
	public void verifyAffichageLienDocuments() throws InterruptedException {
		driver.get("https://www.legalife.fr/");
		AssertJUnit.assertTrue(driver.findElement(By.linkText("Voir tous les documents juridiques")).isDisplayed());
	}

	@After
	public void closedriver() {
		// closes the browser instance
		driver.close();

	}
}
