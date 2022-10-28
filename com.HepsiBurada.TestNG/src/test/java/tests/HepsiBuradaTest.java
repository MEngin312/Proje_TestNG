package tests;

import utilities.ConfigReader;
import utilities.TestBaseRapor;

public class HepsiBuradaTest extends TestBaseRapor {

    String  SaticiDosyasi =System.getProperty("user.dir")+ ConfigReader.getProperty("saticiDosyasi");
    String  secilenUrunDosyasi =System.getProperty("user.dir")+ConfigReader.getProperty("secilenUrunDosyasi");
}
