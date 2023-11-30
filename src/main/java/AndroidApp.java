import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.List;

public class AndroidApp {

    String userName = "rao";
    String accessKey = "CEPVvcooucduSfH1HgroWrwfPXSpUHpVZevjYeOlRxhCd0HqeS";
    //String app_id = System.getenv("LT_APP_ID") == null ? "lt://APP10160241051701359108526404" : System.getenv("LT_APP_ID");      //Enter your LambdaTest App ID at the place of lt://proverbial-android
    String grid_url = "mobile-hub.lambdatest.com";
 
    AppiumDriver driver;

    @Test
    @org.testng.annotations.Parameters(value = {"device", "version", "platform"})
    public void AndroidApp1(String device, String version, String platform) {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("build", "Java TestNG");
            capabilities.setCapability("name", platform + " " + device + " " + version);
            capabilities.setCapability("deviceName", device);
            capabilities.setCapability("platformVersion", version);
            capabilities.setCapability("platformName", platform);
            capabilities.setCapability("isRealMobile", true);
            //AppURL (Create from Wikipedia.apk sample in project)
            capabilities.setCapability("app", "lt://APP10160241051701359108526404"); //Enter your app url
            //capabilities.setCapability("deviceOrientation", "PORTRAIT");
            capabilities.setCapability("network", false);
            capabilities.setCapability("visual", true);
            capabilities.setCapability("devicelog", true);
            capabilities.setCapability("autoGrantPermissions", true);

            //capabilities.setCapability("geoLocation", "HK");
            
            String hub = "https://" + userName + ":" + accessKey + "@" + grid_url + "/wd/hub";
            driver = new AppiumDriver(new URL(hub), capabilities);

			/*
			 * MobileElement color = (MobileElement)
			 * driver.findElementById("com.lambdatest.proverbial:id/color"); //Changes color
			 * to pink color.click(); Thread.sleep(1000); //Back to orginal color
			 * color.click();
			 * 
			 * MobileElement text = (MobileElement)
			 * driver.findElementById("com.lambdatest.proverbial:id/Text"); //Changes the
			 * text to "Proverbial" text.click();
			 * 
			 * //toast will be visible MobileElement toast = (MobileElement)
			 * driver.findElementById("com.lambdatest.proverbial:id/toast"); toast.click();
			 * 
			 * //notification will be visible MobileElement notification = (MobileElement)
			 * driver.findElementById("com.lambdatest.proverbial:id/notification");
			 * notification.click(); Thread.sleep(2000);
			 * 
			 * //Opens the geolocation page MobileElement geo = (MobileElement)
			 * driver.findElementById("com.lambdatest.proverbial:id/geoLocation");
			 * geo.click(); Thread.sleep(5000);
			 * 
			 * //takes back to home page MobileElement home = (MobileElement)
			 * driver.findElementByAccessibilityId("Home"); home.click();
			 * 
			 * //Takes to speed test page MobileElement speedtest = (MobileElement)
			 * driver.findElementById("com.lambdatest.proverbial:id/speedTest");
			 * speedtest.click(); Thread.sleep(5000);
			 * 
			 * MobileElement Home = (MobileElement)
			 * driver.findElementByAccessibilityId("Home"); Home.click();
			 * 
			 * //Opens the browser MobileElement browser = (MobileElement)
			 * driver.findElementByAccessibilityId("Browser"); browser.click();
			 */

            MobileElement RuserName = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@resource-id=\"email\"]");
            RuserName.sendKeys("rao@rallyhood.com");
            
            MobileElement RPsw = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@resource-id=\"password\"]");
            RPsw.sendKeys("Test12345");

            MobileElement login = (MobileElement) driver.findElementByXPath("//android.widget.Button[@text=\"LOG IN\"]");
            login.click();
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
