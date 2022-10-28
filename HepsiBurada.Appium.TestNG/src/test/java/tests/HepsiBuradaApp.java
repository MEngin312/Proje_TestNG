package tests;
import com.aventstack.extentreports.Status;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.testng.Assert;
import org.testng.annotations.ITestAnnotation;
import org.testng.annotations.Test;
import pages.HepsiBuradaAppScreen;
import utilities.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static utilities.ReusableMethods.*;

public class HepsiBuradaApp extends TestBaseRapor  {


    HepsiBuradaAppScreen hb;
    TouchAction touchAction;
    String  SaticiDosyasi =System.getProperty("user.dir")+ConfigReader.getProperty("saticiDosyasi");
    String  secilenUrunDosyasi =System.getProperty("user.dir")+ConfigReader.getProperty("secilenUrunDosyasi");
    @Test
    public void kullaniciOlarakTest(){
        hb=new HepsiBuradaAppScreen();
        touchAction = new TouchAction(Driver.getAppiumDriver());
        Log.startTestCase("Kullanici Olarak Giris Yapıp Sepeti Dogrulama");

        Driver.getAppiumDriver();

        Log.info("Kullanici HepsiBurada Uygulamasini acar.");

        try {
            if (hb.hesabimEmail.isDisplayed()){
                scrollDown();
            }
        } catch (Exception e) {
        }

        tapOn(hb.hesabim);

        Log.info("Kullanici Hesabim sayfasina Gider.");

        tapOn(hb.hesabimGiris);
        enterText(hb.hesabimEmail,ConfigReader.getProperty("email"));

        tapOn(hb.emailGiris);
        waitJava(3);
        enterText(hb.hesabimSifre,ConfigReader.getProperty("sifre"));
        tapOn(hb.sifreGiris);
        waitJava(3);
        tapOn(hb.tamamButonu);
        Log.info("Kullanici Yonlendirmeler ile Gecerli bilgileri girer.");


        Assert.assertEquals(hb.fullName.getText(),ConfigReader.getProperty("isim"));
        Log.assertLog("Kullanici Giris Isleminin yapildigini Test Eder.");




        tapOn(hb.hesabimEkraniniKapatma);
        tapOn(hb.aramaKutucugu);
        enterText(hb.aramaKutucugu,ConfigReader.getProperty("arananKelime"));
        waitJava(2);
        touchAction.tap(PointOption.point(940,2150)).perform();
        Log.info("Kullanici "+ConfigReader.getProperty("arananKelime")+" Kelimesini aratir.");
        tapOn(hb.ilkUrun);
        Log.info("Kullanici ilk  Urunu secer.");



        WriteToTxt.saveAllData(secilenUrunDosyasi,hb.urunBasligi.getText());
        scrollUp();
        List<String> saticiList=new ArrayList<>();
        saticiList.add(hb.ilkSatici.getText().toLowerCase(Locale.ENGLISH));
        scrollUp();
        scrollUp();

        try {
            if (hb.ikinciSatici.isDisplayed()){
                String ikincisatici=hb.ikinciSatici.getText().toLowerCase(Locale.ENGLISH);
                saticiList.add(ikincisatici);
                tapOn(hb.ikinciUrunSepetEkle);
            }
        } catch (Exception e) {
            System.out.println("ikinci ürün yok");
        }

        WriteToTxt.saveAlldataList(SaticiDosyasi,saticiList);



        tapOn(hb.ilkUrunSepetEkle);
        Log.info("Kullanici Ilk Urunu Sepete Ekler, varsa Farkli Saticidan Ayni Urunu Ekler.");

        try {
            if (hb.sepetGit.isDisplayed()){
                tapOn(hb.sepetGit);
            }
        } catch (Exception e) {

            tapOn(hb.sepetimButonu);

        }

        Log.info("Kullanici Sepetim Sayfasina Gider.");

        List<String> saticiListesi=ReadTxt.getTextList(SaticiDosyasi);
        String secilenUrunBasligi=ReadTxt.getText(secilenUrunDosyasi);

        for (int i = 0; i <hb.saticiList.size() ; i++) {
            Assert.assertEquals(hb.saticiList.get(i).getText().toLowerCase(Locale.ENGLISH),saticiListesi.get(i));
            waitJava(2);
            Assert.assertEquals(hb.sepetimUrunBaslikList.get(i).getText(),secilenUrunBasligi);

        }
        Log.assertLog("Kullanici Secilen Urunleri Sepetim sayfasinda Dogrular.");
        for (int i = 0; i <saticiListesi.size() ; i++) {
            hb.urunKaldirList.click();
            waitJava(1);
        }
        Log.info("Kullanici Ekledigi Urunleri Siler");

        Log.endTestCase("Kullanici Olarak Giris Yapıp Sepeti Dogrulama");

    }







    @Test
    public void kullaniciOlmadanTest(){
        Log.startTestCase("Kullanici  Girisi Yapmadan Sepeti Dogrulama");
        hb=new HepsiBuradaAppScreen();
        touchAction = new TouchAction(Driver.getAppiumDriver());
        Driver.getAppiumDriver();
        Log.info("Kullanici HepsiBurada Uygulamasini acar.");

        try {
            if (hb.hesabimEmail.isDisplayed()){
                scrollDown();
            }
        } catch (Exception e) {

        }


        tapOn(hb.aramaKutucugu);


        enterText(hb.aramaKutucugu,ConfigReader.getProperty("arananKelime"));
        waitJava(4);
        touchAction.tap(PointOption.point(940,2150)).release().perform();
        Log.info("Kullanici "+ConfigReader.getProperty("arananKelime")+" Kelimesini aratir.");


        tapOn(hb.ilkUrun);
        Log.info("Kullanici ilk  Urunu secer.");


        WriteToTxt.saveAllData(secilenUrunDosyasi,hb.urunBasligi.getText());
        scrollUp();
        List<String> saticiList=new ArrayList<>();
        saticiList.add(hb.ilkSatici.getText().toLowerCase(Locale.ENGLISH));
        scrollUp();
        scrollUp();

        try {
            if (hb.ikinciSatici.isDisplayed()){
                saticiList.add(hb.ikinciSatici.getText().toLowerCase(Locale.ENGLISH));
                tapOn(hb.ikinciUrunSepetEkle);
            }
        } catch (Exception e) {
            System.out.println("ikinci ürün yok");
        }

        WriteToTxt.saveAlldataList(SaticiDosyasi,saticiList);
        tapOn(hb.ilkUrunSepetEkle);
        Log.info("Kullanici Ilk Urunu Sepete Ekler, varsa Farkli Saticidan Ayni Urunu Ekler.");


        try {
            if (hb.sepetGit.isDisplayed()){
                tapOn(hb.sepetGit);
            }
        } catch (Exception e) {
            tapOn(hb.sepetimButonu);

        }
        Log.info("Kullanici Sepetim Sayfasina Gider.");


        List<String> saticiListesi=ReadTxt.getTextList(SaticiDosyasi);
        String secilenUrunBasligi=ReadTxt.getText(secilenUrunDosyasi);

        for (int i = 0; i <hb.saticiList.size() ; i++) {
            Assert.assertEquals(hb.saticiList.get(i).getText().toLowerCase(Locale.ENGLISH),saticiListesi.get(i));
            waitJava(2);
            Assert.assertEquals(hb.sepetimUrunBaslikList.get(i).getText(),secilenUrunBasligi);

        }
        Log.assertLog("Kullanici Secilen Urunleri Sepetim sayfasinda Dogrular.");


        for (int i = 0; i <saticiListesi.size() ; i++) {
            hb.urunKaldirList.click();
            waitJava(3);
        }
        Log.info("Kullanici Ekledigi Urunleri Siler");

        Log.endTestCase("Kullanici Olmadan Giris Yapıp Sepeti Dogrulama");
    }

}
