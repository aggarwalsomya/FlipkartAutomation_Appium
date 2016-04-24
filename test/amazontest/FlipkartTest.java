package amazontest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class FlipkartTest {
	WebDriver driver;

	@BeforeClass
	public void setUp() throws MalformedURLException, InterruptedException {
		// Set up desired capabilities and pass the Android app-activity and app-package to Appium
		File app = new File("E:\\EclipseWorkspace\\MobileAppTestProject\\apps", 
				"Flipkart_v4.6_apkpure.com.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("VERSION", "4.4.2");
		capabilities.setCapability("deviceName", "test_cal");
		capabilities.setCapability("platformName", "Android");
		//capabilities.setCapability("noReset","true");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.flipkart.android");
		capabilities.setCapability("appActivity", "com.flipkart.android.SplashActivity");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	@Test
	public void addToCart() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Deny")));
        driver.findElement(By.name("Deny")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.flipkart.android:id/btn_skip")));
        driver.findElement(By.id("com.flipkart.android:id/btn_skip")).click();
  
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(("android.widget.ImageButton"))));
        driver.findElement(By.className(("android.widget.ImageButton"))).click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(("SmartWatches & Wearables"))));
        driver.findElement(By.name(("SmartWatches & Wearables"))).click();
      
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(("Smart Watch"))));
        driver.findElement(By.name(("Smart Watch"))).click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(("Bingo U8 Smartwatch"))));
        driver.findElement(By.name(("Bingo U8 Smartwatch"))).click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(("BUY NOW"))));
        driver.findElement(By.name(("BUY NOW"))).click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(("android.widget.ImageButton"))));
        driver.findElement(By.className("android.widget.ImageButton")).click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(("com.flipkart.android:id/cart_count"))));
        System.out.println("Items in the cart are:"+driver.findElement(By.id("com.flipkart.android:id/cart_count")).getText());
	}
	
	@AfterClass
	public void teardown() {
		// close the app
		driver.quit();
	}

}
