package utilities;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;


public class ReusableMethods {
    public static String getScreenshot(String name) throws IOException {
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot) Driver.getAppiumDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/src/test/resources/screenShots/ " + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }

         public static void tapOnElementWithText(String text) {
            List<MobileElement> mobileElementList = Driver.getAppiumDriver().findElementsByClassName("android.widget.TextView");
            for (MobileElement page: mobileElementList) {
                if (page.getText().equals(text)){
                    page.click();
                }else{
                    scrollWithUiScrollableClick(text);
                }
                break;
            }
        }

//ikinci alternatif bir method
        public static void clickOnElementWithText(String elementText) throws InterruptedException {
            Thread.sleep(4000);
            List<MobileElement> mobileElementList = Driver.getAppiumDriver().findElementsByXPath("//android.widget.TextView[@text='"+elementText+"']");
            if (mobileElementList.size()>0){
                mobileElementList.get(0).click();
            }else scrollWithUiScrollableClick(elementText);
        }


    public static boolean isElementPresent(String text) {
        boolean elementFound = false;
        List<MobileElement> mobileElementList = Driver.getAppiumDriver().findElementsByXPath("//android.widget.TextView[@text='" + text + "']");
        for (MobileElement el : mobileElementList) {
            if (el.getText().equals(text)) {
                waitToBeVisible(el, 10);
                if (el.isDisplayed()) {
                    elementFound = true;
                }
            }
        }
        return elementFound;
    }

    public static void waitJava(int second) {
        try {
            Thread.sleep(second * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void tapOn(MobileElement element) {
       // waitToBeClickable(element, 15);
        element.click();
    }
    public static void tapOnText(String text) {
        waitToBeClickable((MobileElement) Driver.getAppiumDriver().findElementByXPath("//android.widget.TextView[@text='" + text + "']"), 10);
        Driver.getAppiumDriver().findElementByXPath("//android.widget.TextView[@text='" + text + "']").click();
    }



    public static void enterText(MobileElement element, String text) {
        //waitToBeClickable(element, 15);
        element.sendKeys(text);
    }


    public static void enterText(MobileElement element, String text, boolean needClear) {
       // waitToBeClickable(element, 15);
        if (needClear) {
            element.clear();
        }
        element.sendKeys(text);
    }

    public static boolean isElementPresent(MobileElement mobileElement) {
        boolean elementFound = false;
        waitToBeVisible(mobileElement, 10);
        if (mobileElement.isDisplayed()) {
            elementFound = true;
        }
        return elementFound;
    }

    public static void waitToBeVisible(MobileElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getAppiumDriver(), timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitToBeClickable(MobileElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getAppiumDriver(),timeout);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }





    public static void scrollWithUiScrollableClick(String elementText) {
        AndroidDriver<MobileElement> driver = (AndroidDriver) Driver.getAppiumDriver();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+elementText+"\"))");
        tapOn(driver.findElementByXPath("//android.widget.TextView[@text='" + elementText + "']"));
    }

    public static void scrollWithUiScrollable(String elementText) {
        AndroidDriver<MobileElement> driver = (AndroidDriver) Driver.getAppiumDriver();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+elementText+"\"))");
    }

    public static void scrollUp() {
        Dimension dimension= Driver.getAppiumDriver().manage().window().getSize();

        int start_x= (int) (dimension.width*0.5);
        int start_y= (int) (dimension.height*0.75);

        int end_x= (int) (dimension.width*0.5);
        int end_y= (int) (dimension.height*0.25);
        TouchAction touchAction=new TouchAction<>(Driver.getAppiumDriver());
        touchAction.press(PointOption.point(start_x,start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(end_x,end_y)).release().perform();

    }

    public static void scrollDown() {
        Dimension dimension= Driver.getAppiumDriver().manage().window().getSize();

        int start_x= (int) (dimension.width*0.5);
        int start_y= (int) (dimension.height*0.2);

        int end_x= (int) (dimension.width*0.5);
        int end_y= (int) (dimension.height*0.8);
        TouchAction touchAction=new TouchAction<>(Driver.getAppiumDriver());
        touchAction.press(PointOption.point(start_x,start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(end_x,end_y)).release().perform();

    }

    public static void pageAfter(){

        try {
            Driver.getAppiumDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(10)"));
        } catch (InvalidSelectorException e) {
            // ignore
        }

    }




    public static void assertAll(MobileElement element,String text){
        Assert.assertTrue(element.getText().contains(text));
    }

    public static String ilkKelime(String text){
        String ilkKelime="";
        int ilkbosluk=text.indexOf(" ");
        ilkKelime=text.substring(0,ilkbosluk);
         return ilkKelime;
    }

    public static List<MobileElement> baslikList(String text){

        List<MobileElement> sepetimBaslik=Driver.getAppiumDriver().findElementsByXPath("//android.widget.TextView[@text='"+text+"']");
   return sepetimBaslik;
    }
}
