package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


import java.util.List;

public class HepsiBuradaChromiumScreen {
    public HepsiBuradaChromiumScreen(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getBrowserDriver()),this);

    }


}
