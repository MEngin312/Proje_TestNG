package utilities;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tests.HepsiBuradaTest;


public class Log {

    private static Logger log= LoggerFactory.getLogger(Log.class.getName());


    public static void startTestCase(String sTestCaseName){

        log.info("******************         "+sTestCaseName+" Basladı         ******************");


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
