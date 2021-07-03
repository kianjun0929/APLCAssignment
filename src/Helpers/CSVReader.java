/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import Classes.Accommodation;
import Classes.CountrySpecificTourismCharacteristicGoods;
import Classes.CountrySpecificTourismCharacteristics;
import Classes.CulturalSportsAndRecreational;
import Classes.FoodAndBeverage;
import Classes.PassengerTransport;
import Classes.Services;
import Classes.TravelAgenciesAndOtherReservation;
import com.opencsv.CSVReaderBuilder;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javafx.util.Pair;


/**
 *
 * @author kianjun
 */
public class CSVReader {

    private String filePath;

    public CSVReader(String filePath) {
        this.filePath = filePath;
    }    
    
    private List<String> removeComma(String[] data) {
        List<String> record = new ArrayList();
        Stream.of(data).forEach(elem -> record.add(elem.replace(",", "")));
        return record;
    }
    
    public List<Services> getRecords () {
        List<Services> listServices = new ArrayList();
        try {
            com.opencsv.CSVReader csvReader = new CSVReaderBuilder(new FileReader(this.filePath)).withSkipLines(1).build();
            csvReader.readAll().stream().map(record -> {
                List<String> rec = removeComma(record);
                add(listServices, new Accommodation(new Pair<>(rec.get(0), rec.get(1))));
                add(listServices, new FoodAndBeverage(new Pair<>(rec.get(0), rec.get(2))));
                add(listServices, new PassengerTransport(new Pair<>(rec.get(0), rec.get(3))));
                add(listServices, new TravelAgenciesAndOtherReservation(new Pair<>(rec.get(0), rec.get(4))));
                add(listServices, new CulturalSportsAndRecreational(new Pair<>(rec.get(0), rec.get(5))));
                add(listServices, new CountrySpecificTourismCharacteristicGoods(new Pair<>(rec.get(0), rec.get(6))));
                add(listServices, new CountrySpecificTourismCharacteristics(new Pair<>(rec.get(0), rec.get(7))));
                return record;
            }).collect(Collectors.toList());
        } catch (Exception e) {
        }
        return listServices;
    }
    
    private static void add(List <? super Services> listServices, Services services) {
        listServices.add(services);
    }
}
