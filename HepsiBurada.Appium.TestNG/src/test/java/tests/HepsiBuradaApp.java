package tests;



import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

import io.appium.java_client.windows.PressesKeyCode;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.HepsiBuradaAppScreen;
import utilities.Driver;
import utilities.WriteToTxt;

import java.time.Duration;

import static utilities.ReusableMethods.*;

public class HepsiBuradaApp {

    HepsiBuradaAppScreen hb=new HepsiBuradaAppScreen();
   TouchAction touchAction = new TouchAction(Driver.getAppiumDriver());
    String filePath=System.getProperty("user.dir")+"\\src\\test\\java\\testData\\baslikYazisi.txt";
    @Test
    public void KullaniciOlarakTest(){
        Driver.getAppiumDriver();
        Driver.getAppiumDriver().getKeyboard();
        tapOn(hb.hesabim);
        tapOn(hb.hesabimGiris);
        enterText(hb.hesabimEmail,"java.team.qa.2022@gmail.com");
        tapOn(hb.emailGiris);
        waitJava(3);
        enterText(hb.hesabimSifre,"123456a.A");
        tapOn(hb.sifreGiris);
        waitJava(3);
        tapOn(hb.tamamButonu);
        assertAll(hb.fullName,"Ayüzbir Harcabitmez");
        tapOn(hb.hesabimEkraniniKapatma);
        tapOn(hb.aramaKutucugu);


        hb.aramaKutucugu.sendKeys("çorap");

        waitJava(10);
        touchAction.tap(PointOption.point(940,2150)).perform();

        for (int i = 0; i <hb.urunBaslikListesi.size() ; i++) {
                WriteToTxt.saveAllData(filePath,hb.urunBaslikListesi.get(i).getText());

        }
        for (int i = 1; i <hb.sepetEkleList.size() ; i++) {
            hb.sepetEkleList.get(0).click();
            if (hb.sepetEkleList.get(i).isDisplayed()){
                hb.sepetEkleList.get(i).click();
                hb.ikinciSepetEklemeAcilanPencere.click();
            }


        }




    }

}
