package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumAPITest {
    public static void main(String[] args) {
        // Impostare il percorso del driver di Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\david\\OneDrive\\Desktop\\progettoFinale.git\\trunk\\Jar\\chromedriver_win32\\chromedriver.exe");

        // Creare un'istanza di ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigare verso una pagina Web
        driver.get("https://www.google.com");

        // Chiudere la scheda per accettare o rifiutare i cookie
        WebElement delcineButton = driver.findElement(By.id("W0wltc"));
        if (delcineButton.isDisplayed()) {
            delcineButton.click();
        }

        // Chiudere il browser
        driver.quit();
    }
}
