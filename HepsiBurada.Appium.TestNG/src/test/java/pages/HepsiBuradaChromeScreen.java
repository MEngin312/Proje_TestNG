package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverChrome;


import java.util.List;

public class HepsiBuradaChromeScreen {

    public HepsiBuradaChromeScreen(){
        PageFactory.initElements(new AppiumFieldDecorator(DriverChrome.getChromeDriver()),this);
    }








}
