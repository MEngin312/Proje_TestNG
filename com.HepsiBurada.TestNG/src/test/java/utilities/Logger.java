package utilities;



import org.slf4j.LoggerFactory;
import tests.HepsiBuradaTest;


public class Logger {
    /*
    slf4j  kutuphanesini cagirarak  burda direk kendimiz icin ozel bir log classimizi olusturduk
    test basladi ve bitti gibi  methodlarimiz bulunmakta bunlara ek olarakta logalama icerisine raporlama cagrilarak beraberinde raporda alinmaktadir.
     */

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(Logger.class.getName());


    public static void startTestCase(String sTestCaseName){

        log.info("******************         "+sTestCaseName+" Basladi         ******************");


        HepsiBuradaTest.extentTest = HepsiBuradaTest.extentReports.createTest(sTestCaseName);



    }
  public static void endTestCase(String sTestCaseName){
        log.info("******************         "+sTestCaseName+" bitti         ******************");

      HepsiBuradaTest.extentTest.info(sTestCaseName);
    }


    public static void assertLog(String msg) {

        log.info(msg);
        HepsiBuradaTest.extentTest.pass(msg);

    }


    public static void debug(String message)
    {
        log.debug(message);
        HepsiBuradaTest.extentTest.debug(message);

    }


    public static void error(String message) {
        log.error(message);
        HepsiBuradaTest.extentTest.error(message);

    }

    public static void info(String message) {

        log.info(message);
        HepsiBuradaTest.extentTest.info(message);
    }

    public static void warn(String message) {
        log.warn(message);
        HepsiBuradaTest.extentTest.warning(message);

    }


}
