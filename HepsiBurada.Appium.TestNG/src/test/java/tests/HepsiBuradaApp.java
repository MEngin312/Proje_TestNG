package tests;



import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HepsiBuradaAppScreen;
import utilities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static utilities.ReusableMethods.*;

public class HepsiBuradaApp extends TestBaseRapor {
    HepsiBuradaAppScreen hb;
    TouchAction touchAction;
    String  SaticiDosyasi =System.getProperty("user.dir")+ConfigReader.getProperty("SaticiDosyasi");
    String   secilenUrunDosyasi =System.getProperty("user.dir")+ConfigReader.getProperty("secilenUrunDosyasi");
    @Test
    public void kullaniciOlarakTest(){
        extentTest=extentReports.createTest("TESTCASE01","Kullanici Olarak Giris Yapıp Sepeti Dogrulama");
        hb=new HepsiBuradaAppScreen();
        touchAction = new TouchAction(Driver.getAppiumDriver());
        Driver.getAppiumDriver();
        extentTest.info("Kullanici HepsiBurada Uygulamasini acar.");
        try {
            if (hb.hesabimEmail.isDisplayed()){
                scrollDown();
            }
        } catch (Exception e) {
            System.out.println("hesabim ssayfasina gidiyor.");
        }

        tapOn(hb.hesabim);
        extentTest.info("Kullanici Hesabim sayfasina Gider.");
        tapOn(hb.hesabimGiris);
        enterText(hb.hesabimEmail,ConfigReader.getProperty("email"));
        tapOn(hb.emailGiris);
        waitJava(3);
        enterText(hb.hesabimSifre,ConfigReader.getProperty("sifre"));
        tapOn(hb.sifreGiris);
        waitJava(3);
        tapOn(hb.tamamButonu);
        extentTest.info("Kullanici Yonlendirmeler ile Gecerli bilgileri girer.");
        assertAll(hb.fullName,ConfigReader.getProperty("isim"));
        extentTest.pass("Kullanici Giris Isleminin yapildigini Test Eder.");
        tapOn(hb.hesabimEkraniniKapatma);
        tapOn(hb.aramaKutucugu);


        enterText(hb.aramaKutucugu,ConfigReader.getProperty("arananKelime"));
        waitJava(2);
        touchAction.tap(PointOption.point(940,2150)).perform();
        extentTest.info("Kullanici "+ConfigReader.getProperty("arananKelime")+" Kelimesini aratir.");
        tapOn(hb.ilkUrun);
        extentTest.info("Kullanici ilk  Urunu secer.");
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
        extentTest.info("Kullanici Ilk Urunu Sepete Ekler, varsa Farkli Saticidan Ayni Urunu Ekler.");
        extentTest.log(Status.INFO,"Kullanici Ilk Urunu Sepete Ekler, varsa Farkli Saticidan Ayni Urunu Ekler.");
        try {
            if (hb.sepetGit.isDisplayed()){
                tapOn(hb.sepetGit);
            }
        } catch (Exception e) {
            System.out.println("Sepete git butonu gözükmedi");
            tapOn(hb.sepetimButonu);

        }

        extentTest.info("Kullanici Sepetim Sayfasina Gider.");

        List<String> saticiListesi=ReadTxt.getTextList(SaticiDosyasi);
        String secilenUrunBasligi=ReadTxt.getText(secilenUrunDosyasi);

        for (int i = 0; i <hb.saticiList.size() ; i++) {
            Assert.assertEquals(hb.saticiList.get(i).getText().toLowerCase(Locale.ENGLISH),saticiListesi.get(i));
            Assert.assertEquals(baslikList(secilenUrunBasligi).get(i).getText(),secilenUrunBasligi);

        }
        extentTest.pass("Kullanici Secilen Urunleri Sepetim sayfasinda Dogrular.");
        for (int i = 0; i <saticiListesi.size() ; i++) {
            hb.urunKaldirList.click();
            waitJava(1);
        }
        extentTest.info("Kullanici Ekledigi Urunleri Siler");
        Driver.quitAppiumDriver();
        extentTest.info("Kullanici Uygulamayi Kapatir.");


    }

    @Test
    public void kullaniciOlmadanTest(){
        extentTest=extentReports.createTest("TESTCASE02","Kullanici Olmadan Giris Yapıp Sepeti Dogrulama");
        hb=new HepsiBuradaAppScreen();
        touchAction = new TouchAction(Driver.getAppiumDriver());
        Driver.getAppiumDriver();
        extentTest.info("Kullanici HepsiBurada Uygulamasini acar.");

        try {
            if (hb.hesabimEmail.isDisplayed()){
                scrollDown();
            }
        } catch (Exception e) {
            System.out.println("hesabim ssayfasina gidiyor");
        }

        waitJava(3);
        tapOn(hb.aramaKutucugu);


        enterText(hb.aramaKutucugu,ConfigReader.getProperty("arananKelime"));
        waitJava(4);
        touchAction.tap(PointOption.point(940,2150)).release().perform();
        extentTest.info("Kullanici "+ConfigReader.getProperty("arananKelime")+" Kelimesini aratir.");
        tapOn(hb.ilkUrun);
        extentTest.info("Kullanici ilk  Urunu secer.");
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
        extentTest.info("Kullanici Ilk Urunu Sepete Ekler, varsa Farkli Saticidan Ayni Urunu Ekler.");
        try {
            if (hb.sepetGit.isDisplayed()){
                tapOn(hb.sepetGit);
            }
        } catch (Exception e) {
            System.out.println("Sepete git butonu gözükmedi");
            tapOn(hb.sepetimButonu);

        }
        extentTest.info("Kullanici Sepetim Sayfasina Gider.");
        List<String> saticiListesi=ReadTxt.getTextList(SaticiDosyasi);
        String secilenUrunBasligi=ReadTxt.getText(secilenUrunDosyasi);

        for (int i = 0; i <hb.saticiList.size() ; i++) {
            Assert.assertEquals(hb.saticiList.get(i).getText().toLowerCase(Locale.ENGLISH),saticiListesi.get(i));
            Assert.assertEquals(hb.sepetimUrunBaslikList.get(i).getText(),secilenUrunBasligi);

        }
        extentTest.pass("Kullanici Secilen Urunleri Sepetim sayfasinda Dogrular.");
        for (int i = 0; i <saticiListesi.size() ; i++) {
            hb.urunKaldirList.click();
            waitJava(1);
        }
        extentTest.info("Kullanici Ekledigi Urunleri Siler");
        Driver.quitAppiumDriver();
        extentTest.info("Kullanici Uygulamayi Kapatir.");

    }


































/*
    @Test
    public void KullaniciOlarakTest2(){
        Driver.getAppiumDriver();
        waitJava(2);
        try {
            if (hb.hesabim.isDisplayed()){
                tapOn(hb.hesabim);
                tapOn(hb.hesabimGiris);
            }

        }catch (Exception e){
            System.out.println("Email sayfası açıldı");
        }

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


        hb.aramaKutucugu.sendKeys("şemsiye");

        waitJava(3);
        touchAction.tap(PointOption.point(940,2150)).perform();

        List<String> baslikList=new ArrayList<>();


        for (int i = 0; i < 3; i++) {
            for (int k = 0; k <hb.urunBaslikListesi.size() ; k++) {
                baslikList.add(hb.urunBaslikListesi.get(k).getText());
                waitJava(1);
            }
            scrollUp();
        }


        WriteToTxt.saveAlldataList(ConfigReader.getProperty("baslikDosyasi"),baslikList);
        waitJava(2);
        scrollDown();
        waitJava(2);
       tapOn(hb.basadon);
        waitJava(2);

        List<String> secilenurunList=new ArrayList<>();
        List<String> secilenurunFiyatList=new ArrayList<>();
        tapOn(hb.sepetEkleList.get(0));

        try {
            if (hb.ikinciSepetEklemeAcilanPencere.isDisplayed()){
                tapOn(hb.ikinciSepetEklemeAcilanPencere);
            }

        }catch (Exception e){
            System.out.println("urun direk eklendi");
        }

        secilenurunList.add(hb.urunBaslikListesi.get(0).getText());
        secilenurunFiyatList.add(hb.urunFiyatlistesi.get(0).getText().replaceAll("\\D",""));

        for (int i = 1; i <hb.sepetEkleList.size() ; i++) {

            List<String> urunBaslikList=ReadTxt.getIDList(ConfigReader.getProperty("baslikDosyasi"));
            if (!(ilkKelime(urunBaslikList.get(0)).equals(ilkKelime(urunBaslikList.get(i))))){
                hb.sepetEkleList.get(i).click();
                try {
                    if (hb.ikinciSepetEklemeAcilanPencere.isDisplayed()){
                        hb.ikinciSepetEklemeAcilanPencere.click();
                    }

                }catch (Exception e){
                    System.out.println("urun direk eklendi");
                }
                secilenurunList.add(hb.urunBaslikListesi.get(i).getText());
                secilenurunFiyatList.add(hb.urunFiyatlistesi.get(i).getText().replaceAll("\\D",""));
                break;
            }else {
                scrollUp();
            }

        }

        WriteToTxt.saveAlldataList(ConfigReader.getProperty("secilenUrunDosyasi"),secilenurunList);
        WriteToTxt.saveAlldataList(ConfigReader.getProperty("fiyatDosyasi"),secilenurunFiyatList);

        tapOn(hb.sepetimButonu);






        List<String> secilenUrunbaslikListesi=ReadTxt.getIDList(ConfigReader.getProperty("secilenUrunDosyasi"));
        Collections.reverse(secilenUrunbaslikListesi);
        System.out.println(secilenUrunbaslikListesi);
        List<String> secilenUrunFiyatList=ReadTxt.getIDList(ConfigReader.getProperty("fiyatDosyasi"));
        Collections.reverse(secilenUrunFiyatList);
        System.out.println(secilenUrunFiyatList);

        for (int i = 0; i <hb.sepetimUrunBaslikList.size() ; i++) {

            Assert.assertEquals(hb.sepetimUrunBaslikList.get(i).getText(),secilenUrunbaslikListesi.get(i));
            Assert.assertEquals(hb.sepetimFiyatList.get(i).getText().replaceAll("\\D",""),secilenUrunFiyatList.get(i));

        }
        for (int i = 0; i <secilenurunList.size() ; i++) {
            hb.urunKaldirList.click();
            waitJava(1);
        }
        Driver.quitAppiumDriver();

    }*/


}
