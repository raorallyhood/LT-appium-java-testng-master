import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

import org.testng.annotations.Test;

public class iOSApp {

	String userName = "rao";
	String accessKey = "CEPVvcooucduSfH1HgroWrwfPXSpUHpVZevjYeOlRxhCd0HqeS";
	//String app_id = System.getenv("LT_APP_ID") == null ? "lt://APP10160241051701359108526404" : System.getenv("LT_APP_ID");      //Enter your LambdaTest App ID at the place of lt://proverbial-android
	String grid_url = "mobile-hub.lambdatest.com";
	    
    AppiumDriver driver;

    @Test
    @org.testng.annotations.Parameters(value = {"device", "version", "platform"})
    public void iOSApp1(String device, String version, String platform) {

        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("build", "Java TestNG");
            capabilities.setCapability("name", platform + " " + device + " " + version);
            capabilities.setCapability("deviceName", device);
            capabilities.setCapability("platformVersion", version);
            capabilities.setCapability("platformName", platform);
            capabilities.setCapability("isRealMobile", true);
            capabilities.setCapability("app", "lt://APP1016033381701883711615702"); //Enter your app url
            capabilities.setCapability("network", false);
            capabilities.setCapability("visual", true);
            capabilities.setCapability("devicelog", true);
            //capabilities.setCapability("geoLocation", "HK");

            String hub = "https://" + userName + ":" + accessKey + "@" + grid_url + "/wd/hub";
            driver = new AppiumDriver(new URL(hub), capabilities);

            WebDriverWait Wait = new WebDriverWait(driver, 30);
            
            MobileElement RuserName = (MobileElement) driver.findElementByXPath("//XCUIElementTypeTextField");
            RuserName.sendKeys("rao@rallyhood.com");
            
            MobileElement RPsw = (MobileElement) driver.findElementByXPath("//XCUIElementTypeSecureTextField");
            RPsw.sendKeys("Test12345");

            MobileElement login = (MobileElement) driver.findElementByXPath("//XCUIElementTypeButton[@name=\"LOG IN\"]");
            login.click();
            driver.quit();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
