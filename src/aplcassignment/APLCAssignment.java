/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplcassignment;

import Classes.Main;
import GUI.Home;
import Helpers.CSVReader;
//import com.opencsv.CSVReader;

/**
 *
 * @author kianjun
 */
public class APLCAssignment {
    public static void main(String[] args) throws Exception {
        CSVReader csvReader = new CSVReader("outbound-tourism-expenditure-of-visitors-by-products-rm-million.csv");
        Main.setListServices(csvReader.getRecords());
        
        Home home = new Home();
        home.setVisible(true);
    }
}
