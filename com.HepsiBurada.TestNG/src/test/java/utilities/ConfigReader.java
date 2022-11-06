package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {


//configuration.properties dosyasinda bulanan bilgileri key=value  sistemi icerinde
// key vererek value'sunu istediginiz yere cagirmanizi saglayan classtir


   public static Properties properties;// Properties classında obje olusturulur okunmak istenen dosya yolu verilir o dosyanın okunması saglanir.

   static {
       String dosyaYolu="configuration.properties";

      try {
          FileInputStream fis=new FileInputStream(dosyaYolu);
          properties=new Properties();
          properties.load(fis);
      } catch (IOException e) {
          e.printStackTrace();
      }


   }


    public static String getProperty(String key) {

        return properties.getProperty(key);
    }
}
