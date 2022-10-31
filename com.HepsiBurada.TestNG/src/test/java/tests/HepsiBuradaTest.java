package tests;

import org.testng.annotations.Test;
import pages.HepsiBuradaPage;
import utilities.ConfigReader;
import utilities.Logger;
import utilities.TestBaseRapor;

public class HepsiBuradaTest extends TestBaseRapor {

     HepsiBuradaPage hb;

     @Test
    public void giris_Yaparak_Test(){
         hb=new HepsiBuradaPage();
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
          hb=new HepsiBuradaPage();
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
