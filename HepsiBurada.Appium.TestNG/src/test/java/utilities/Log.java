package utilities;


import org.apache.log4j.Logger;
import tests.HepsiBuradaApp;


public class Log  {

    private static final Logger log=Logger.getLogger(Log.class.getName());


    public static void startTestCase(String sTestCaseName){

        log.info("******************         "+sTestCaseName+" Basladı         ******************");


        HepsiBuradaApp.extentTest = HepsiBuradaApp.extentReports.createTest(sTestCaseName);



    }
  public static void endTestCase(String sTestCaseName){
        log.info("******************         "+sTestCaseName+" bitti         ******************");

        HepsiBuradaApp.extentTest.info(sTestCaseName);
    }


    public static void assertLog(boolean assertion, String msg) {

        log.assertLog(assertion, msg);
        HepsiBuradaApp.extentTest.pass(msg);

    }


    public static void debug(String message)
    {
        log.debug(message);
        HepsiBuradaApp.extentTest.debug(message);

    }


    public static void error(String message) {
        log.error(message);
        HepsiBuradaApp.extentTest.error(message);

    }


    public static void fatal(String message)
    {
        log.fatal(message);
        HepsiBuradaApp.extentTest.fatal(message);
    }


    public static void info(String message) {

        log.info(message);
        HepsiBuradaApp.extentTest.info(message);
    }

    public static void warn(String message) {
        log.warn(message);
        HepsiBuradaApp.extentTest.warning(message);

    }


}
