package Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import org.openqa.selenium.phantomjs.PhantomJSDriver;
//import org.openqa.selenium.phantomjs.PhantomJSDriverService;


/**
 * Created by vsushelski on 2/20/2017.
 */
public class Driver {

    public static WebDriver driver = null;
    protected Driver(){

    }
    public static WebDriver getDriver(){

        if(driver==null){
            System.setProperty("webdriver.chrome.driver", "src/main/java/drivers/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }
    public static void closeDriver(){
        driver.quit();
        driver=null;
    }

    public static void setDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/java/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
//    public static void setPhantomDriver(){
//        String agent = "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36";
//        Capabilities caps = new DesiredCapabilities();
//        ((DesiredCapabilities) caps).setJavascriptEnabled(true);
//        ((DesiredCapabilities)caps).setCapability(PhantomJSDriverService.PHANTOMJS_PAGE_SETTINGS_PREFIX + "userAgent", agent);
//        ((DesiredCapabilities) caps).setCapability("takesScreenshot", true);
//        ((DesiredCapabilities) caps).setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, "--webdriver-loglevel=ERROR");
//        ((DesiredCapabilities) caps).setCapability(
//                PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
//                "src/main/java/drivers/phantomjs.exe"
//        );
//        ((DesiredCapabilities) caps).setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS,new String[]{"--web-security=no", "--ignore-ssl-errors=yes"});
//        driver = new PhantomJSDriver(caps);
//        driver.manage().window().maximize();
//    }

}
