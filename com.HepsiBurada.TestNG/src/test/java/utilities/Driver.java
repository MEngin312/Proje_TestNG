package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
    /*
    pom da Driver icin  TestBase clasına extend etmk yerine driver clasından static methodlar kullanarak
    driver oluşturup ,ilgili ayarların yapilmasi ve en sonda driverın kapatılması tercih edilmiştir

    POM de Driver clasındaki getDriver() methoduna obje oluşturularak  kullanılmasını engellemek icin
    Singleton pattern benimsenmiştir

    Singleton Pattern: tekli kullanım , bir classın farklı classlardan obje oluşturularak kullanımını engellemek için kullanılır

    nunu sağlamak icin yapamamız gereken oldukça basit
    obje oluşturmak icin kullanılan constructor ı private yaptığınızda
    başka classlardan driver classında obje oluşturulması engellenmiş olur
     */
    private Driver(){

    }

     static WebDriver driver;


    public static  WebDriver getDriver(){

        if (driver == null) {

            switch (ConfigReader.getProperty("browser")){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver=new SafariDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
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

    public static void closeDriver(){

        if (driver!=null){
      driver.close();
      driver=null;
    }

    }
}
