package tests;

import org.testng.annotations.Test;
import pages.HepsiBuradaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.Log;
import utilities.TestBaseRapor;

public class HepsiBuradaTest extends TestBaseRapor {

     HepsiBuradaPage hb;

     @Test
    public void girisYaparakTest(){
         hb=new HepsiBuradaPage();
         Log.startTestCase("Kullanici, Giris Yaparak Sepet Dogrulama Testi");

         hb.istenilenSayfayaGitme();
         Log.info("Kullanici "+ConfigReader.getProperty("hepsiUrl")+" sayfasina gider.");

         hb.girisYapma();
         Log.assertLog("Kullanici olarak giris yapma ve dogrulama.");

         hb.aramaYapipUrunSecme();
         Log.info("Kullanici "+ConfigReader.getProperty("arananKelime")+" kelimesini aratir ve urune tiklar.");

         hb.secilenUrunuSepeteEklemevefarkliSaticiEkleme();
         Log.info("Kullanici sectigi urunu sepete ekler ve varsa farkli saticidan ikinci urunu ekler.");

         hb.sepetimGitveSecilenUrunleriDogrulama();
         Log.assertLog("Kullanici sepete gider ve bilgileri dogrular.");

         hb.secilenUrunleriSilme();
         Log.info("Kullanici sectigi urunleri sepetten siler.");
         Log.endTestCase("Kullanici, Giris Yaparak Sepet Dogrulama Testi");
     }



     @Test
     public void girisYapmayarakTest(){
          hb=new HepsiBuradaPage();
          Log.startTestCase("Kullanici, Giris Yapmayarak Sepet Dogrulama Testi");

          hb.istenilenSayfayaGitme();
          Log.info("Kullanici "+ConfigReader.getProperty("hepsiUrl")+" sayfasina gider.");


          hb.aramaYapipUrunSecme();
          Log.info("Kullanici "+ConfigReader.getProperty("arananKelime")+" kelimesini aratir ve urune tiklar.");

          hb.secilenUrunuSepeteEklemevefarkliSaticiEkleme();
          Log.info("Kullanici sectigi urunu sepete ekler ve varsa farkli saticidan ikinci urunu ekler.");

          hb.sepetimGitveSecilenUrunleriDogrulama();
          Log.assertLog("Kullanici sepete gider ve bilgileri dogrular.");

          hb.secilenUrunleriSilme();
          Log.info("Kullanici sectigi urunleri sepetten siler.");
          Log.endTestCase("Kullanici, Giris Yaparak Sepet Dogrulama Testi");
     }


}
