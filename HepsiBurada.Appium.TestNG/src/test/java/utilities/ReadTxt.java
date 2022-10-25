package utilities;



import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadTxt {

    public static String getIDs(String dataFile) {
        String id ="";
        try {
            FileReader fileReader = new FileReader(dataFile);

            BufferedReader br = new BufferedReader(fileReader);

            String line = br.readLine();

            while (line != null) {

                String readId = line.split(",")[0];
                id=readId;
                line = br.readLine();

            }

        } catch (Exception e) {

            e.printStackTrace();

        }
        return id;
    }
    public static List<String> getIDList(String dataFile) {
        List<String> idList =new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(dataFile);

            BufferedReader br = new BufferedReader(fileReader);

            String line = br.readLine();

            while (line != null) {

                String readId = line.split(",")[0];
                idList.add(readId);
                line = br.readLine();

            }

        } catch (Exception e) {

            e.printStackTrace();

        }
        return idList;
    }


}
