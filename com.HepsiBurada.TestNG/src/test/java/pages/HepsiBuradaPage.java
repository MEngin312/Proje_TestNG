package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HepsiBuradaPage {

    public HepsiBuradaPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
