package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


import java.util.List;


public class HepsiBuradaAppScreen {
    public HepsiBuradaAppScreen(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAppiumDriver()),this);
    }

    @AndroidFindBy(accessibility = "Hesabım")
    public MobileElement hesabim;

    @AndroidFindBy(xpath = "(//android.widget.Button)[2]")
    public MobileElement hesabimGiris;
    @AndroidFindBy(className = "android.widget.EditText")
    public MobileElement hesabimEmail;
    @AndroidFindBy(xpath = "(//android.widget.Button)[1]")
    public MobileElement emailGiris;
    @AndroidFindBy(className = "android.widget.EditText")
    public MobileElement hesabimSifre;
    @AndroidFindBy(xpath = "(//android.widget.Button)[1]")
    public MobileElement sifreGiris;
    @AndroidFindBy(className = "android.widget.Button")
    public MobileElement tamamButonu;
    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/tvUserNameFull")
    public MobileElement fullName;
    @AndroidFindBy(accessibility = "Hesabım ekranını kapat")
    public MobileElement hesabimEkraniniKapatma;
    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/etSearchBox")
    public MobileElement aramaKutucugu;




}
