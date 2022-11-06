package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.*;

import java.util.*;

public class HepsiBuradaPage {

    public HepsiBuradaPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    /*
    Tum test casede bulunan sayfalarin locateleri her sayfa icin ayrilarak yapilir ama bu testcase kucuk bir parca oldugu icin
     bende tum locateleri buraya aldim,Locatelerimi @FindBy annotation kullanarak aldim. Locateleri gorebilmek icin ustte olusturulan
     constructor icerisine PageFactory classında methodlar cagirarak ,driveri buraya cagiriyoruz
     */

    @FindBy(xpath = "//div[@id='myAccount']")
    private WebElement girisButonu;
    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    private WebElement cerez;
    @FindBy(xpath = "//a[@title='Giriş yap']")
    private WebElement girisYapButonu;
    @FindBy(xpath = "//input[@id='txtUserName']")
    private WebElement email;
    @FindBy(xpath = "//input[@id='txtPassword']")
    private WebElement sifre;
    @FindBy(xpath = "//button[@id='btnLogin']")
    private WebElement emailGiris;
    @FindBy(xpath = "//button[@id='btnEmailSelect']")
    private WebElement sifreGiris;
    @FindBy(xpath = "//span[@class='sf-OldMyAccount-sS_G2sunmDtZl9Tld5PR']")
    private WebElement kullaniciIsmi;
    @FindBy(xpath = "(//input[@type='text'])[1]")
    private WebElement aramaKutucugu;
    @FindBy(xpath = "(//ul[@id='1']/li)[1]")
    private WebElement arananUrun;
    @FindBy(xpath = "//h1[@id='product-name']")
    private WebElement secilenUrunBaslik;
    @FindBy(xpath = "//span[@class='seller']//span//a")
    private WebElement ilkSatici;
    @FindBy(xpath = "//button[@id='addToCart']")
    private WebElement ilkSaticiSepetEkle;
    @FindBy(xpath = "(//a[@class='merchantStore small'])[1]")
    private WebElement ikinciSatici;
    @FindBy(xpath = "(//button[@class='add-to-basket button small'])[1]")
    private WebElement ikinciSaticiSepetEkle;
    @FindBy(xpath = "//h1//a")
    private WebElement sepetGitKapatma;
    @FindBy(xpath = "//span[@id='shoppingCart']")
    private WebElement sepetim;
    @FindBy(className = "merchantLink_2Ii8s")
    private List<WebElement> saticiListesi;
    @FindBy(xpath = "//div[@class='product_name_3Lh3t']//a")
    private List<WebElement> sepetimUrunBaslikListesi;
    @FindBy(xpath = "(//a[@class='product_delete_1zR-0'])[1]")
    private WebElement urunSilme;


    /*
    Ustteki kodlarda locate alarak  asagida her fonksiyon icin birer method urettim, methodlar static olmadigi icin direk icerisine locateleri çagırabiliyorum
    */


    private  String ilkWindowDegeri;
    private final String  saticiDosyasi =System.getProperty("user.dir")+ConfigReader.getProperty("saticiDosyasi");
    private final String  secilenUrunDosyasi =System.getProperty("user.dir")+ConfigReader.getProperty("secilenUrunDosyasi");

    // verdiginiz url'e gore siteye gider ve cerez var ise onu handle eder
    public void istenilen_Siteye_Git(String url){
        Driver.getDriver().get(url);
        cerez.click();
    }

    // cagirdiginiz yerde giris yapmak icin tiklama yapar ve gerekli bilgileri girerek giris yapmanizi saglar.
    public  void giris_Yap(){

        girisButonu.click();
        girisYapButonu.click();
        email.sendKeys(ConfigReader.getProperty("email"));
        emailGiris.click();
        sifre.sendKeys(ConfigReader.getProperty("sifre"));
        sifreGiris.click();
        Assert.assertEquals(kullaniciIsmi.getText(),ConfigReader.getProperty("isim"));
        ilkWindowDegeri=Driver.getDriver().getWindowHandle();
    }

    // siteye girdikten sonra arama yapmak istediginiz kelimeyi configuration.properties dosyasindan alarak arama yapar ,
    public  void arama_Yap_Urun_Sec(){

        aramaKutucugu.sendKeys(ConfigReader.getProperty("arananKelime"), Keys.ENTER);
        arananUrun.click();

    }

    // gelen urunlerden ilk urunu secer ve ikinci bir pencere acildiginda oraya gecer.
    // secilen ilk urunun bilgilerini WriteTxt classi ile locale kayit eder ve varsa farkli saticininda bilgilerini alir.
    // secilen urunu sepete ekler  eger varsa farkli saticidanda urun ekler
    public  void secilen_Urunu_Sepete_Ekle_ve_farkli_Saticidan_Ekle(){

        acilan_ikinci_Pencereye_Gec(ilkWindowDegeri);

        WriteToTxt.saveAllData(secilenUrunDosyasi,secilenUrunBaslik.getText());
        List<String> saticiList=new ArrayList<>();
        ReusableMethods.waitForVisibility(ilkSatici,15);
        saticiList.add(ilkSatici.getText().toLowerCase(Locale.ENGLISH));
        ReusableMethods.hooverByJS(ilkSaticiSepetEkle);
        try {
            ReusableMethods.waitForClickablility(sepetGitKapatma,10);
            if (sepetGitKapatma.isDisplayed()) {
                sepetGitKapatma.click();
            }
        } catch (Exception e) {

        }

        ReusableMethods.pageDown();

        try {
            if (ikinciSatici.isDisplayed()){
                saticiList.add(ikinciSatici.getText().toLowerCase(Locale.ENGLISH));
                ikinciSaticiSepetEkle.click();
                try {
                    ReusableMethods.waitForClickablility(sepetGitKapatma,10);
                    if (sepetGitKapatma.isDisplayed()) {
                        sepetGitKapatma.click();
                    }
                } catch (Exception e) {

                }
            }
        } catch (Exception e) {

        }

        WriteToTxt.saveAlldataList(saticiDosyasi,saticiList);

    }

    // sepetim sayfasında bulunan urunleri seuilen urunler ile dogrulugunu Assertions classi ile dogrular
    // secilen urunlerin bilgilerini  ReadTxt classi ile okur ve alir ondan sonra sepetteki urunlerin bilgilerini alır ve assert eder
    public void sepetim_Git_ve_Secilen_Urunleri_Dogrula(){
        ReusableMethods.pageUp();
        sepetim.click();
        String secilenUrunYazisi=ReadTxt.getText(secilenUrunDosyasi);
        List<String> secilenSaticilar=ReadTxt.getTextList(saticiDosyasi);
        Collections.reverse(secilenSaticilar);

        for (int i = 0; i <secilenSaticilar.size() ; i++) {
            Assert.assertEquals(saticiListesi.get(i).getText().toLowerCase(Locale.ENGLISH),secilenSaticilar.get(i));
            Assert.assertEquals(sepetimUrunBaslikListesi.get(i).getText(),secilenUrunYazisi);
        }



    }
    // dorulamalar bittikten sonra ve tüm işlemler bittikten sonra sepeteki urunleri sepetimden kaldirir.
    public void secilen_Urunleri_Sil(){
        int sayi=ReadTxt.getTextList(saticiDosyasi).size();
        for (int i = 0; i <sayi ; i++) {
            ReusableMethods.waitFor(3);
           urunSilme.click();
        }

    }

    // ilk acilan pencerenin windowHandle degerini alir ve acilan ikinci sayfanin window handle degerini bulur ve driver 'i ikinci window'a gecirir.
    public  void acilan_ikinci_Pencereye_Gec(String window){

        Set<String> windowsSet=Driver.getDriver().getWindowHandles();
        for (String each:windowsSet) {
            if (!each.equalsIgnoreCase(ilkWindowDegeri)){
                Driver.getDriver().switchTo().window(each);
            }

        }

    }




}
