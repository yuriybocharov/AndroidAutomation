import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by User on 22.08.2017.
 */
public class DriverConfig {
    protected AndroidDriver driver;

    @BeforeTest
    protected void runApp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung Galaxy S6");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, "false");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.box.android");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.box.android.activities.login.SplashScreenActivity");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterTest
    protected void tearDown(){
        driver.quit();
    }
}
