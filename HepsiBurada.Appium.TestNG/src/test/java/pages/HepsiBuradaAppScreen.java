package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


import java.util.List;


public class HepsiBuradaAppScreen {
    public HepsiBuradaAppScreen(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAppiumDriver()),this);
    }

    @AndroidFindBy(accessibility = "Hesabım")
    public MobileElement hesabim;

    @AndroidFindBy(xpath = "(//android.widget.Button)[2]")
    public MobileElement hesabimGiris;
    @AndroidFindBy(className = "android.widget.EditText")
    public MobileElement hesabimEmail;
    @AndroidFindBy(xpath = "(//android.widget.Button)[1]")
    public MobileElement emailGiris;
    @AndroidFindBy(className = "android.widget.EditText")
    public MobileElement hesabimSifre;
    @AndroidFindBy(xpath = "(//android.widget.Button)[1]")
    public MobileElement sifreGiris;
    @AndroidFindBy(className = "android.widget.Button")
    public MobileElement tamamButonu;
    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/tvUserNameFull")
    public MobileElement fullName;
    @AndroidFindBy(accessibility = "Hesabım ekranını kapat")
    public MobileElement hesabimEkraniniKapatma;
    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/etSearchBox")
    public MobileElement aramaKutucugu;
    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@resource-id='com.pozitron.hepsiburada:id/view_product'])[1]")
    public MobileElement ilkUrun;
    @AndroidFindBy(xpath="//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.TextView")
    public MobileElement urunBasligi;

    @AndroidFindBy(id="com.pozitron.hepsiburada:id/hb_product_detail_merchant_name")
    public MobileElement ilkSatici;
    @AndroidFindBy(id="com.pozitron.hepsiburada:id/price")
    public MobileElement ilkUrunFiyat;
    @AndroidFindBy(id="com.pozitron.hepsiburada:id/product_detail_add_to_cart_text")
    public MobileElement ilkUrunSepetEkle;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id='com.pozitron.hepsiburada:id/merchantName'])[1]")
    public MobileElement ikinciSatici;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id='com.pozitron.hepsiburada:id/lastPrice'])[1]")
    public MobileElement ikinciUrunFiyati;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id='com.pozitron.hepsiburada:id/addToCartText'])[1]")
    public MobileElement ikinciUrunSepetEkle;
    @AndroidFindBy(id="com.pozitron.hepsiburada:id/toolbarCart")
    public MobileElement sepetimButonu;

    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/goBasketTxt")
    public MobileElement sepetGit;

    @AndroidFindBy(xpath = "//android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View/android.widget.TextView")
    public List<MobileElement> saticiList;
    @AndroidFindBy(xpath = "//android.widget.ListView/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]/android.widget.TextView[3]")
    public List<MobileElement> sepetimFiyatList;
    @AndroidFindBy(xpath = "//android.widget.ListView/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View/android.widget.TextView")
    public List<MobileElement> sepetimUrunBaslikList;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Ürünü Kaldır']")
    public MobileElement urunKaldirList;

    /*
    @AndroidFindBy(id="com.pozitron.hepsiburada:id/tv_product_list_item_name")
    public List<MobileElement> urunBaslikListesi;

    @AndroidFindBy(id="com.pozitron.hepsiburada:id/atcb_product_list_item_add_to_cart")
    public List<MobileElement> sepetEkleList;
    @AndroidFindBy(id="com.pozitron.hepsiburada:id/atcb_product_variant")
    public MobileElement ikinciSepetEklemeAcilanPencere;
    @AndroidFindBy(id="com.pozitron.hepsiburada:id/tvPrice")
    public List<MobileElement> urunFiyatlistesi;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Başa dön']")
    public MobileElement basadon;
    @AndroidFindBy(id="com.pozitron.hepsiburada:id/nav_graph_cart")
    public MobileElement sepetimButonu;





    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Ürünü Kaldır']")
    public MobileElement urunKaldirList;

*/



}
