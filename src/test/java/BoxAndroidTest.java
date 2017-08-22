import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class BoxAndroidTest {
    AppiumDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "AndroidTestDevice");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @AfterMethod
    public void setDown() {
        //driver.quit();
    }

    public static void sleep(int time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public boolean elementIsPresent(By by) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        } finally {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }

    @Test
    public void Vk_Login(){
        elementIsPresent(By.xpath("//android.widget.EditText[@text='E-mail or login']"));
        driver.findElement(By.xpath("//android.widget.EditText[@text='E-mail or login']"));
        WebElement email_input = driver.findElement(By.xpath("//android.widget.EditText[@text='E-mail or login']"));
        email_input.sendKeys("LIvan@rambler.com");
        WebElement password = driver.findElement(By.xpath("//android.widget.EditText[@index='0']"));
        password.sendKeys("75556053ivlihoy");
        sleep(3);
        driver.findElement(By.xpath("//android.widget.Button[@text='Log in']")).click();
        sleep(8);
    }
}
