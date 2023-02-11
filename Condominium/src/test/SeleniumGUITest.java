package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumGUITest {
    private WebDriver driver;

    @Before
    public void setUp() {
        // Impostare il percorso del driver per Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\david\\OneDrive\\Desktop\\progettoFinale.git\\trunk\\Jar\\chromedriver_win32\\chromedriver.exe");
        // Creare un'istanza del browser
        driver = new ChromeDriver();
    }

    @Test
    public void testSearchByText() {
        // Navigare fino al sito web
        driver.get("http://www.google.com");
        // Trovare la casella di ricerca

        WebElement delcineButton = driver.findElement(By.id("W0wltc"));
        if (delcineButton.isDisplayed()) {
            delcineButton.click();
        }

        driver.findElement(By.name("q")).sendKeys("Selenium WebDriver");
        // Inviare la richiesta di ricerca
        driver.findElement(By.name("q")).submit();
        // Verificare che i risultati contengano il testo cercato
        String pageSource = driver.getPageSource();
        assert pageSource.contains("Selenium WebDriver");
    }

    @After
    public void tearDown() {
        // Chiudere il browser
        driver.quit();
    }
}
