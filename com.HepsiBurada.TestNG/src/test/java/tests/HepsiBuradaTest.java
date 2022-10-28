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
    public void kullaniciOlarakTest(){
         hb=new HepsiBuradaPage();
         Log.startTestCase("Kullanici Olarak Test");
         hb.istenilenSayfayaGitme();
         Log.info("Kullanici "+ConfigReader.getProperty("hepsiUrl")+" sayfasina gider.");
         hb.girisYapma();
         Log.assertLog("Kullanici olarak giris yapma ve dogrulama.");
         hb.aramaYapipUrunSecme();
         Log.info("Kullanici "+ConfigReader.getProperty("arananKelime")+" kelimesini aratır ve urune tıklar.");
         hb.secilenUrunuSepeteEklemevefarkliSaticiEkleme();
         Log.info("Kullanici sectigi urunu sepete ekler ve varsa farklı satıcıdan ikinci urunu ekler.");
         hb.sepetimGitveSecilenUrunleriDogrulama();
         Log.assertLog("Kullanici sepete gider ve bilgileri dogrular.");
         hb.secilenUrunleriSilme();
         Log.info("Kullanici sectigi urunleri sepetten siler.");
         Log.endTestCase("Kullanici Olarak Test");
     }




}
