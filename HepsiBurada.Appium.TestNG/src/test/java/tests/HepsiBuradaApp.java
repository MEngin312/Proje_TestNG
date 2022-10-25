package tests;



import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HepsiBuradaAppScreen;
import utilities.Driver;
import utilities.ReadTxt;
import utilities.WriteToTxt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static utilities.ReusableMethods.*;

public class HepsiBuradaApp {

    HepsiBuradaAppScreen hb=new HepsiBuradaAppScreen();
   TouchAction touchAction = new TouchAction(Driver.getAppiumDriver());
    String baslikDosyasi =System.getProperty("user.dir")+"\\src\\test\\java\\testData\\baslikYazisi.txt";
    String secilenUrunDosyasi =System.getProperty("user.dir")+"\\src\\test\\java\\testData\\secilenUrunList.txt";
    String fiyatDosyasi=System.getProperty("user.dir")+"\\src\\test\\java\\testData\\urunFiyatList.txt";
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


        WriteToTxt.saveAlldataList(baslikDosyasi,baslikList);
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

            List<String> urunBaslikList=ReadTxt.getIDList(baslikDosyasi);
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
                secilenurunFiyatList.add(hb.urunFiyatlistesi.get(i).getText());
                break;
            }else {
                scrollUp();
            }

        }

        WriteToTxt.saveAlldataList(secilenUrunDosyasi,secilenurunList);
        WriteToTxt.saveAlldataList(fiyatDosyasi,secilenurunFiyatList);

        tapOn(hb.sepetimButonu);






        List<String> secilenUrunbaslikListesi=ReadTxt.getIDList(secilenUrunDosyasi);
        Collections.reverse(secilenUrunbaslikListesi);
        System.out.println(secilenUrunbaslikListesi);
        List<String> secilenUrunFiyatList=ReadTxt.getIDList(fiyatDosyasi);
        Collections.reverse(secilenUrunFiyatList);
        System.out.println(secilenUrunFiyatList);

        for (int i = 0; i <hb.sepetimUrunBaslikList.size() ; i++) {

            Assert.assertEquals(hb.sepetimUrunBaslikList.get(i).getText(),secilenUrunbaslikListesi.get(i));
            Assert.assertEquals(hb.sepetimFiyatList.get(i).getText().replaceAll("\\D",""),secilenUrunFiyatList.get(i));

        }
        for (int i = 0; i <hb.urunKaldirList.size() ; i++) {
            hb.urunKaldirList.get(i).click();
            waitJava(1);
        }
        Driver.quitAppiumDriver();

    }


}
