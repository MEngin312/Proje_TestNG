package tests;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.HepsiBuradaAppScreen;
import utilities.Driver;

import static utilities.ReusableMethods.*;

public class HepsiBuradaApp {

    HepsiBuradaAppScreen hb=new HepsiBuradaAppScreen();
    @Test
    public void KullaniciOlarakTest(){
        Driver.getAppiumDriver();
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

        hb.aramaKutucugu.sendKeys("çorap",Keys.ENTER);



    }

}
