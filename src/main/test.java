package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {
	public static void main(String[] args) throws InterruptedException {
		// déclaration de navigateur (Google chrome)
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Hatem\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// accéder au site web legalife.fr
		driver.get("https://www.legalife.fr/");
		// Agrandir la fenétre
		driver.manage().window().maximize();
		Thread.sleep(2000);
		// Cliquer sur inscription
		driver.findElement(By.linkText("Inscription")).click();
		// Saisir les jeux de données (email : hatem.jeridi@epsi.fr mot de passe :
		// Unlatch)
		driver.findElements(By.xpath("//input[@placeholder='Votre email' and @type='email']")).get(1)
				.sendKeys("hatem.jeridi@epsi.fr");
		driver.findElement(By.xpath("//input[@placeholder='Votre mot de passe' and @type='password']"))
				.sendKeys("Unlatch");
		driver.findElements(By.xpath("//button[@class='btn btn--default' and @type='submit']")).get(1).click();
		Thread.sleep(2000);
		// Retour à la page principale
		driver.get("https://www.legalife.fr/");
		Thread.sleep(2000);
		// cliquer sur le bouton voir tout les documents juridiques
		driver.findElement(By.linkText("Voir tous les documents juridiques")).click();
		// Saisir le jeux de donées (Rechercher un document : Attestation d'embauche)
		driver.findElement(By.xpath("//input[@placeholder='Rechercher un document' and @type='text']"))
				.sendKeys("Attestation d'embauche ");
		//Cliquer sur le bouton RERCHERCHER
		driver.findElement(By.cssSelector("button[class='btn btn--default']")).click();
		// Afficher un message test réussi
		System.out.println("test réussi");

	}
}
