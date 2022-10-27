package utilities;

import org.apache.log4j.Logger;

public class Log extends TestBaseRapor  {


    private static Logger log=Logger.getLogger(Log.class.getName());


    public static void startTestCase(String sTestCaseName){
        log.info("******************         "+sTestCaseName+" Basladı         ******************");

        extentTest.createNode(sTestCaseName);
    }
  public static void endTestCase(String sTestCaseName){
        log.info("******************         "+sTestCaseName+" bitti         ******************");
       extentTest.info(sTestCaseName);
    }


    public static void assertLog(boolean assertion, String msg) {

        log.assertLog(assertion, msg);
        extentTest.pass(msg);
    }


    public static void debug(String message)
    {
        log.debug(message);
        extentTest.debug( message);
    }


    public static void error(String message) {
        log.error(message);
        extentTest.error(message);
    }


    public static void fatal(String message)
    {
        log.fatal(message);
        extentTest.fatal(message);
    }


    public static void info(String message) {

        log.info(message);
        extentTest.info(message);
    }

    public static void warn(String message) {
        log.warn(message);
        extentTest.warning(message);
    }
}
