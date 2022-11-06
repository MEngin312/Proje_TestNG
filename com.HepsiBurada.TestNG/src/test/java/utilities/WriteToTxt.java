package utilities;




import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class WriteToTxt {


    // saklanmak isteyen bir string alır ve verdiginiz uzantiya gore onu oraya kayit eder.
    // static olduğu icin class ismi ile cagrilir.
    public static void saveAllData(String filename,String text){

        try {
            FileWriter fileWriter = new FileWriter(filename, false);//burası false oldugunda verilen son bilgiyi sadece saklar,true olsaydi verilen tum bilgileri alt alta saklardi.


            BufferedWriter writer = new BufferedWriter(fileWriter);

            writer.append(text+ ", \n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // saklanmak isteyen bir list alır ve verdiginiz uzantiya gore onu oraya kayit eder.
    // static oldugu icin class ismi ile cagrilir.
    public static void saveAlldataList(String filename, List<String> baslik){


        try {
            FileWriter fileWriter = new FileWriter(filename, false);//burası false oldugunda verilen son bilgiyi sadece saklar,true olsaydı verilen tum bilgileri alt alta saklardi.


            BufferedWriter writer = new BufferedWriter(fileWriter);

            for (int i = 0; i <baslik.size() ; i++) {
                writer.append(baslik.get(i)+ ", \n");

            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}