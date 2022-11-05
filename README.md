# com.A101.FinalCase
<hr/>


[HepsiBurada](https://www.hepsiburada.com) sitesinin testlerini gerçekleştirdiğimiz bu projemizde,
[TestNG](https://testng.org/doc/documentation-main.html#testng-xml) framework ile çalışıldı.
OOP(object oriented programming) konseptine uyarak  POM(page object model) dizayn modeli kullanılmıştır. Test adımlRI HEM Selenium kullanılarak webden yapıldı hemde Appium kullanılarak [hepsiburada uygulaması](https://play.google.com/store/apps/details?id=com.pozitron.hepsiburada&gl=TR) üzerinden yapıldı. 

## Proje  Tanıtımı
 
- [FrameWorks](#FrameWorks-İçerik)
- [Test Adımları](#Test-Adımları)
- [Selenium Testi](#Selenium-Testi)
- [Appium testi](#Appium-testi)
- [Cihaz Bilgisi](#Cihaz-bilgileri)
 
 
 
 
 <hr/>
 
 ## FrameWorks İçerik
 
![Screenshot_2](https://user-images.githubusercontent.com/101714396/200123138-88df19a1-3f13-4d58-b1df-44e952a68bae.jpg)

<br/>

### [pages dosyası](https://github.com/clgnmmr/com.A101.FinalCase/blob/master/com.HepsiBurada.TestNG/src/test/java/pages/HepsiBuradaPage.java) <br/>
Bu dosyamızda elimizde bulunan sitenin testlerini gerçekleştireceğimiz elemenlerin locatelerini sakladığımız classlarımız bulunmakta.İstediğimiz locate almak için oluşturduğumuz clasın adında constructar oluşturuyoruz ve içine <b> PageFactory </b> clasını çağırıp
içerisine oluşturduğumuz driver çağırıp burada olduğunu belli ettiğimiz <b> this </b> key kullanılır. locatelerimizinde çağırabilinmesi için de <b> FindBy </b> notasyonu ile locatelerimizi oluşturabiliriz.İçerisine istediğimiz fonsiyonları gerçekleştirebilecek methodları oluşturabiliriz.

![Screenshot_5](https://user-images.githubusercontent.com/101714396/200123389-f0b300e6-3040-4097-bc2e-7176a0b510c4.jpg)

### [tests dosyası](https://github.com/clgnmmr/com.A101.FinalCase/blob/master/com.HepsiBurada.TestNG/src/test/java/tests/HepsiBuradaTest.java) <br/>
Burda ise tüm kodlarımızın çalışmasını sağlayan methodlarımızın bulunduğu classlarımız vardır.Locatelerimizi , driverımız buraya çağırarak yapmak istediğimiz adımların kodlarını burda yazıyoruz.
testlerin çalışması için TestNG kütüphanesinden <b> @Test </b> annotation kullanıyoruz.

![Screenshot_6](https://user-images.githubusercontent.com/101714396/200123396-ba4aecc3-9c83-4eae-bf57-18f2f4340cf5.jpg)

 
### [utilities dosyası](https://github.com/clgnmmr/com.A101.FinalCase/tree/master/com.HepsiBurada.TestNG/src/test/java/utilities) <br/>
Yardımcı classımız bu dosyamızda bize sürekli lazım olan classlarımız ve methodlarımız bulunmaktadır. İçerisinde  projemizi daha anlaşılır hale getirecek classlarımız ve methodalrımız vardır bunlar
<b> Driver.class </b> , <b> ConfigReader.class</b> , <b> ReusableMehod.class </b>, <b> Logger.class </b>  vb.  dosyalarımız bulunmaktadır. 

![Screenshot_7](https://user-images.githubusercontent.com/101714396/200123412-c0f90911-d925-40c6-8b6c-bec0d874847d.jpg)

### [resources dosyası](https://github.com/clgnmmr/com.A101.FinalCase/tree/master/com.HepsiBurada.TestNG/src/test/resources) <br/>
Dosyamıızn içerinde Log için aldığımız dataları (html,txt vb) bulunduran <b> log dosyası </b> bulunur. raporlar için <b> rapor dosyası </b> , hata alındığında o locate'in direk screenshotının olduğu <b> screenshot dosyası </b> 
ve  assert edilecek bilgilerin sürekli olarak eklendiği <b> testdata dosyası </b> bulunmaktadır. 

![Screenshot_8](https://user-images.githubusercontent.com/101714396/200123427-2b9d61c2-84d9-4766-af96-a3c175f080ed.jpg)

### <b> [configuration.properties](https://github.com/clgnmmr/com.A101.FinalCase/blob/master/com.HepsiBurada.TestNG/configuration.properties) </b>
properties dosyamızda sürekli kullandığımız variablelarımız bulunmakta , bu veriabları kullanmak için properties dosyası <b> Key  =  value </b> olaraka oluşturulmakta ,burdaki bilgileri başaka classlara çağırabilmek için utilities dosyasından
<b> ConfigReader </b> classı çağırırlara içindeki method saysınde bu bosyada bulunan bilgileri istediğimiz yerlere çağırabiliriz.

## [pom.xml](https://github.com/clgnmmr/com.A101.FinalCase/blob/master/com.HepsiBurada.TestNG/pom.xml)
tüm çalışmlaraımızın ve kodlarımızın bilgilerinin bulunduğu bu dosyada aslında kullanmak istediğimiz kodalrın kütüphanesini  <b> dependencies </b> tagının içerisine yerleştirip güncel bilgilerini sürekli olarak kendimizde tutabiliriz.
burası sayaesinde tüm kodlara erişimi sağlayabiliriz.

<hr/>

## Test Adımları

<br/>

```

1. Kullanıcı girişi yapılarak sepete ürün eklenmesi <br/>
- Kullanıcı Hepsiburada.com sitesini ziyaret eder.
- Kullanıcı giriş işlemi yapılır.Yönlendirmeden sonra anasayfada kullanıcı giriş işleminin yapıldığı doğrulanır
- Kullanıcı, burada satın almak istediği ürün için arama yapacaktır.
- Kullanıcı, Arama sonucunda ekrana gelen ürün listesinden (veya tek bir sonuç da dönmüş olabilir) ürün seçer.
- Seçilen ürün için 2 tane farklı satıcıdan ürün seçilip sepete eklenir.
- Seçilen ürünün doğru olarak eklendiği ‘Sepetim’ sayfasında doğrulanmalıdır.

```


<br/>

```

2. Kullanıcı girişi yapılmadan belirtilen ürünü sepete ekleme <br/>
- Kullanıcı Hepsiburada.com sitesini ziyaret eder.
- Kullanıcı, burada satın almak istediği ürün için arama yapacaktır.
- Kullanıcı, Arama sonucunda ekrana gelen ürün listesinden (veya tek bir sonuç da dönmüş olabilir) ürün seçer.
- Seçilen ürün için 2 tane farklı satıcıdan ürün seçilip sepete eklenir.
- Seçilen ürünün doğru olarak eklendiği ‘Sepetim’ sayfasında doğrulanmalıdır.

```
<hr/>



## Selenium Testi<br/>

Java11  ve Maven projesi oluşturulup TestNg framework kullanılarak oluşturulmuştur.
<br/>

### kütüphane <br/>

- [selenium-java](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java)
- [webdrivermanager](https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager)
- [testng](https://mvnrepository.com/artifact/org.testng/testng)
- [extentreports](https://mvnrepository.com/artifact/com.aventstack/extentreports)
- [slf4j-api](https://mvnrepository.com/artifact/org.slf4j/slf4j-api)
- [slf4j-reload4j](https://mvnrepository.com/artifact/org.slf4j/slf4j-reload4j)

<br/>

![Screenshot_3](https://user-images.githubusercontent.com/101714396/200123206-2f6c3709-79c7-4315-9f0c-fb3eba2ab7dd.jpg)


<a href="https://www.java.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="50" height="50"/> </a>
<a href="https://git-scm.com/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/git-scm/git-scm-icon.svg" alt="git" width="40" height="40"/> </a>
<a href="https://www.selenium.com" target="_blank" rel="noreferrer"> <img src="https://camo.githubusercontent.com/4b95df4d6ca7a01afc25d27159804dc5a7d0df41d8131aaf50c9f84847dfda21/68747470733a2f2f73656c656e69756d2e6465762f696d616765732f73656c656e69756d5f6c6f676f5f7371756172655f677265656e2e706e67" alt="Selenium" width="50" height="50"/> </a>
<a href="https://www.intelj.com" target="_blank" rel="noreferrer"> <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQak-N8W03mK25slV1lwM80i0y1obRPPJOaLA&usqp=CAU" alt="intelj" width="80" height="40"/> </a>
<a href="https://www.maven.com" target="_blank" rel="noreferrer"> <img src="https://koraypeker.com/wp-content/uploads/2018/06/1_xsrKVt69q3JsZzLD-ldekQ.jpeg" alt="git" width="100" height="40"/> </a>

<hr/>

## Appium testi<br/>

Java8  ve Maven projesi oluşturulup TestNG framework kullanılarak oluşturulmuştur. 
<br/>

### kütüphane <br/>

- [io.appium](https://mvnrepository.com/artifact/io.appium/java-client)
- testng
- extentreports
- slf4j-api
- slf4j-reload4j


<br/>

![Screenshot_4](https://user-images.githubusercontent.com/101714396/200123269-ed4a04c2-5416-4656-8862-5f0868cb2859.jpg)


<a href="https://www.java.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="50" height="50"/> </a>
<a href="https://git-scm.com/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/git-scm/git-scm-icon.svg" alt="git" width="40" height="40"/> </a>
<a href="https://www.appium.com" target="_blank" rel="noreferrer"> <img src="https://miro.medium.com/max/698/0*Ar7dArTvLIGrRs2n.png" alt="Selenium" width="100" height="50"/> </a>
<a href="https://www.selenium.com" target="_blank" rel="noreferrer"> <img src="https://camo.githubusercontent.com/4b95df4d6ca7a01afc25d27159804dc5a7d0df41d8131aaf50c9f84847dfda21/68747470733a2f2f73656c656e69756d2e6465762f696d616765732f73656c656e69756d5f6c6f676f5f7371756172655f677265656e2e706e67" alt="Selenium" width="50" height="50"/> </a>
<a href="https://www.intelj.com" target="_blank" rel="noreferrer"> <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQak-N8W03mK25slV1lwM80i0y1obRPPJOaLA&usqp=CAU" alt="intelj" width="80" height="40"/> </a>
<a href="https://www.maven.com" target="_blank" rel="noreferrer"> <img src="https://koraypeker.com/wp-content/uploads/2018/06/1_xsrKVt69q3JsZzLD-ldekQ.jpeg" alt="maven" width="100" height="40"/> </a>

<br/>

### Cihaz bilgileri 
<br/>

GENYMOTİON uygulası kurularak burda <br/>
Samsung Galaxy S10 kuruldu<br/>
özellikler = Android 10(Api29) yüklendi ,   ekran  1440 X 3040  , 560 Dpi <br/>
A101 uygulamsı telefona sürükleyip bırakıldı kurulduktan sonra test işlemleri başlatıldı.<br/>
<b>LÜTFEN BU ÖZELLİKLERE SAHİP TELEFONU KURUP TEST YAPINIZ.</b>

<br/>

![Screenshot_11](https://user-images.githubusercontent.com/101714396/193453938-0b47e3db-66fb-4b47-a868-7014f91fc477.jpg)
![Screenshot_12](https://user-images.githubusercontent.com/101714396/193454042-81b9d8df-b639-47cc-8493-3e085344d838.jpg)


