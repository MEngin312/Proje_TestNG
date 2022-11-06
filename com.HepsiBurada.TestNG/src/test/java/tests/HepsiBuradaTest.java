package tests;

import org.testng.annotations.Test;
import pages.HepsiBuradaPage;
import utilities.ConfigReader;
import utilities.Logger;
import utilities.TestBaseRapor;

public class HepsiBuradaTest extends TestBaseRapor {
     /*
     Bu test class'imizda gerceklestirilen iki testimiz vardir
     1.Test --> giris yaparak sepetimi dogrulama
     2.Test --> giris yapmadan sepetimi dogrulama

     burda Page clasimizin objesini olusturarak kod tekrarini onlemek adina  olusturdugumuz methodlari sirasi ile cagirarak islemlerimizi gerceklestirebiliyoruz

     eger iki testin icine bakarsaniz ikisinin tek farkı giris_yap() methodunun olup olmamasi farklilik gosteriyor yani bu sayede dahapratik testler yazilabiliyor.

     ve bu classimizda Loglama yapilmakta herhangi bir hata alindiginda hatanin nerde oldugunu anlamamizi saglayacak bir classimidir.Bununla birlikte
     loglama ile Testrapor birlestirildi ve loglama yapilirken raporda beraberinde alinmaktadir.
      */

     HepsiBuradaPage hb; // page sayfasindan olusturulan objemiz yani koyteyner olusturulur her atamasi olusturulan her method icinde yapilir.

     // TestNg ile @Test annotation kullanilarak direk kodların calismasini saglayabilmekteyiz bu sayede main method cagirmamiz gerekmiyor.
     @Test
    public void giris_Yaparak_Test(){
         hb=new HepsiBuradaPage();// koyteyner atamasi method icinde  yapildi
         Logger.startTestCase("Kullanici, Giris Yaparak Sepet Dogrulama Testi");

         hb.istenilen_Siteye_Git(ConfigReader.getProperty("hepsiUrl"));
         Logger.info("Kullanici "+ConfigReader.getProperty("hepsiUrl")+" sayfasina gider.");

         hb.giris_Yap();
         Logger.assertLog("Kullanici olarak giris yapma ve dogrulama.");

         hb.arama_Yap_Urun_Sec();
         Logger.info("Kullanici "+ConfigReader.getProperty("arananKelime")+" kelimesini aratir ve urune tiklar.");

         hb.secilen_Urunu_Sepete_Ekle_ve_farkli_Saticidan_Ekle();
         Logger.info("Kullanici sectigi urunu sepete ekler ve varsa farkli saticidan ikinci urunu ekler.");

         hb.sepetim_Git_ve_Secilen_Urunleri_Dogrula();
         Logger.assertLog("Kullanici sepete gider ve bilgileri dogrular.");

         hb.secilen_Urunleri_Sil();
         Logger.info("Kullanici sectigi urunleri sepetten siler.");
         Logger.endTestCase("Kullanici, Giris Yaparak Sepet Dogrulama Testi");
     }



     @Test
     public void giris_Yapmadan_Test(){
          hb=new HepsiBuradaPage();// koyteyner atamasi method icinde  yapildi
          Logger.startTestCase("Kullanici, Giris Yapmayarak Sepet Dogrulama Testi");

          hb.istenilen_Siteye_Git(ConfigReader.getProperty("hepsiUrl"));
          Logger.info("Kullanici "+ConfigReader.getProperty("hepsiUrl")+" sayfasina gider.");


          hb.arama_Yap_Urun_Sec();
          Logger.info("Kullanici "+ConfigReader.getProperty("arananKelime")+" kelimesini aratir ve urune tiklar.");

          hb.secilen_Urunu_Sepete_Ekle_ve_farkli_Saticidan_Ekle();
          Logger.info("Kullanici sectigi urunu sepete ekler ve varsa farkli saticidan ikinci urunu ekler.");

          hb.sepetim_Git_ve_Secilen_Urunleri_Dogrula();
          Logger.assertLog("Kullanici sepete gider ve bilgileri dogrular.");

          hb.secilen_Urunleri_Sil();
          Logger.info("Kullanici sectigi urunleri sepetten siler.");
          Logger.endTestCase("Kullanici, Giris Yaparak Sepet Dogrulama Testi");
     }


}
