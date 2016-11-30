import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

public class TestRunner {

    protected WebDriver driver;

    @BeforeClass
    public void setUpDriver() {

        final String driverPath = "src/test/resources/drivers/";
        System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");

        driver = new ChromeDriver();
        driver
                .manage()
                .timeouts()
                .implicitlyWait(30, TimeUnit.SECONDS);
        driver
                .manage()
                .window()
                .maximize();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){ 
        driver.quit();
    }
    
}

