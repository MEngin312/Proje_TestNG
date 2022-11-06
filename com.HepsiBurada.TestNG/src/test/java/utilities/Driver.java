package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
    /*
    pom da Driver icin  driver clasından static methodlar kullanarak
    driver olusturup ,ilgili ayarların yapilmasi ve en sonda driverin kapatilmasi tercih edilmistir

    POM de Driver clasindaki getDriver() methoduna obje olusturularak  kullanilmasini engellemek icin
    Singleton pattern benimsenmistir

    Singleton Pattern: tekli kullanım , bir classın farkli classlardan obje olusturularak kullanimini engellemek icin kullanilir

    bunu saglamak icin yapamamiz gereken oldukca basit
    obje olusturmak icin kullanilan constructor ı private yaptiginizda
    baska classlardan driver classında obje oluşturulması engellenmis olur
     */
    private Driver(){

    }

     static WebDriver driver;


    public static  WebDriver getDriver(){

        if (driver == null) {

            //configuration.properties dosyasında belirttigimiz browsera göre  alta ona gore secilen browserin  acilmasini saglar
            switch (ConfigReader.getProperty("browser")){
                case "chrome":
                    ChromeOptions options=new ChromeOptions();
                    options.addArguments("--disable-blink-features");
                    options.addArguments("--disable-blink-features=AutomationControlled");
                    options.addArguments("--disable-extensions");
                    options.addArguments("--disable-notifications");
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(options);
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver=new SafariDriver();
                    break;
                case "firefox":
                    FirefoxOptions options1=new FirefoxOptions();
                    options1.addArguments("--disable-blink-features");
                    options1.addArguments("--disable-blink-features=AutomationControlled");
                    options1.addArguments("--disable-extensions");
                    options1.addArguments("--disable-notifications");
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver(options1);
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver=new EdgeDriver();
                    break;
                case "opera":
                    WebDriverManager.operadriver().setup();
                    driver=new OperaDriver();
                    break;
                case "explorer":
                    WebDriverManager.iedriver().setup();
                    driver=new InternetExplorerDriver();
                    break;
                case "headless-chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        }


     return driver;
    }

    public static void quitDriver(){

        if (driver!=null){
            if(driver.getWindowHandles().size()==2){
                driver.quit();
                driver=null;
            }else {
                driver.close();
                driver=null;
            }

    }

    }
}
